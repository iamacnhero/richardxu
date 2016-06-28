## 4.1 创建容器

** 新建容器 **
可以使用 **docker create** 新建一个容器。
```
➜  docker create -it centos:6.7
b411c11bd11a5735468702098c93750fea360774d7853911ffc493ba8309ba2e
```
使用 **docker create** 新建的容器处于停止状态，可以使用 **docker start** 来启动它。

**新建并启动容器**
主要命令为 **docker run**，丢价于先执行docker create，再执行docker start。

下面的命令输出一个"Hello"，之后容器自动终止：
```
➜  docker run centos:6.7 /bin/echo 'Hello'
```  

当利用docker run来创建并启动容器时，Docker在后台运行的标准操作包括：
- 检查本地是否存在指定的镜像，不存在就从公共仓库下载
- 利用镜像创建并启动一个容器
- 分配一个文件系统，并在只读的镜像层外面挂载一层可读可写
- 从宿主机配置的网桥接口中桥接一个虚拟接口到容器中去
- 从地址池配置一个IP地址给容器
- 执行用户指定的应用程序
- 执行完毕后容器被终止

下面的命令则启动一个bash终端，允许用户进行交互：
```
➜  docker run -t -i centos:6.7 /bin/bash
```
其中，-t选项让Docker分配一个伪终端（pseudo-tty）并绑定到容器的标准输入上，-i则让容器的标准输入保持打开。

对于创建的bash窗口，当使用exit命令退出之后，该容器就自动处于终止状态了。

### 守护态（Daemonized）运行
用户可以通过添加 -d 参数来实现，如下面的命令会在后台运行容器：
```
➜  docker run -d centos:6.7 /bin/sh -c "while true; do echo hello world; sleep 1; done"
044fe2cfd3f1cc17327977885deedd61be98a744c114ff3336c5f8f8e282b933
➜  docker ps        # 容器启动后会返回一个唯一的ID，可以通过docker ps来查看容器信息
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS               NAMES
044fe2cfd3f1        centos:6.7          "/bin/sh -c 'while tr"   13 seconds ago      Up 14 seconds                           small_cori
➜  docker logs 044fe2cfd3f1    # 要获取容器的输出信息，可以通过 docker logs 命令
hello world
hello world
hello world
... ...
```

## 4.2 终止容器
可以使用docker stop来终止一个运行中的容器，格式为 docker stop [-t|--time[=10]]。它会首先向容器发送SIGTERM信号，等待一段时间后（默认为10秒），再发送SIGKILL信息终止容器。示例：
```
➜  docker stop 044fe2cfd3f1
```

此外，当Docker容器中指定的应用终结时，容器也自动终止。

> 注意：docker kill命令会直接发送 SIGKILL 信号来强行终止容器。

可以通过 **docker ps -a -q** 命令看到处于终止状态的容器的ID信息：
```
➜  docker ps -a -q
044fe2cfd3f1
bcf3fb434670
b411c11bd11a
4c7fd52e114a
```

处于终止状态的容器，可通过docker start来重启启动：
```
➜  docker start 044fe2cfd3f1
```

docker restart 命令会将一个运行态的容器终止，然后再重新启动它：
```
➜  docker restart 044fe2cfd3f1
```

## 4.3 进入容器
### attach 命令
Docker 自带的命令，示例：
```
➜  docker ps -a
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS                            PORTS               NAMES
ad4e94d74a83        centos:6.7          "/bin/bash"              5 seconds ago       Exited (0) 6 seconds ago                              distracted_nobel
ec13f3593b5d        centos:6.7          "/bin/bash"              18 seconds ago      Exited (0) 19 seconds ago                             mad_roentgen
044fe2cfd3f1        centos:6.7          "/bin/sh -c 'while tr"   25 minutes ago      Exited (137) About a minute ago                       small_cori
bcf3fb434670        centos:6.7          "/bin/bash"              31 minutes ago      Exited (0) 27 minutes ago                             fervent_swartz
b411c11bd11a        centos:6.7          "/bin/bash"              36 minutes ago      Created                                               evil_engelbart
4c7fd52e114a        centos:6.7          "/bin/echo Hello"        37 minutes ago      Exited (0) 37 minutes ago                             nostalgic_nobel
➜  docker attach evil_engelbart
You cannot attach to a stopped container, start it first
➜  docker start b411c11bd11a
b411c11bd11a
➜  docker attach b411c11bd11a
```

### exec 命令
exec 可以直接在容器内执行命令：
```
➜  docker exec -ti b411c11bd11a /bin/bash
```

## 4.4 删除容器
可使用 **docker rm** 命令删除处于终止状态的容器。
```
➜  docker ps -a
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS                       PORTS               NAMES
ad4e94d74a83        centos:6.7          "/bin/bash"              5 minutes ago       Exited (0) 5 minutes ago                         distracted_nobel
ec13f3593b5d        centos:6.7          "/bin/bash"              6 minutes ago       Exited (0) 6 minutes ago                         mad_roentgen
044fe2cfd3f1        centos:6.7          "/bin/sh -c 'while tr"   31 minutes ago      Exited (137) 6 minutes ago                       small_cori
bcf3fb434670        centos:6.7          "/bin/bash"              37 minutes ago      Exited (0) 33 minutes ago                        fervent_swartz
b411c11bd11a        centos:6.7          "/bin/bash"              42 minutes ago      Up 5 minutes                                     evil_engelbart
4c7fd52e114a        centos:6.7          "/bin/echo Hello"        43 minutes ago      Exited (0) 43 minutes ago                        nostalgic_nobel
➜  docker rm ad4e94d74a83
ad4e94d74a83
➜  docker rm ec13f3593b5d
ec13f3593b5d
➜  docker rm -f b411c11bd11a   # -f 参数删除一个运行中的容器。Docker会发送SIGKILL信号给容器，终止其中的应用
```

## 4.5 导入和导出容器
### 导出容器
使用 **docker export** 命令，示例：
```
➜  docker ps -a
CONTAINER ID        IMAGE               COMMAND             CREATED             STATUS                     PORTS               NAMES
9cdb66bcd71c        centos:6.7          "/bin/bash"         21 seconds ago      Exited (0) 3 seconds ago                       agitated_bardeen
➜  docker export 9cd > centos_test.tar
➜  ll centos_test.tar
-rw-r--r--  1 xu  staff  197122560  6 27 15:57 centos_test.tar
```

### 导入容器
使用 **docker import** 命令导入，成为镜像。
