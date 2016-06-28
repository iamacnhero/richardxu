容器中数据管理主要有两种方式：
- 数据卷（Data Volumes）
- 数据卷容器（Data Volume Containers）

## 6.1 数据卷 
数据卷是一个可供容器使用的特殊目录，它绕过文件系统，可以提供很多有用的特性：
- 数据卷可以在容器之间共享和重用
- 对数据卷的修改会立马生效
- 对数据卷的更新，不会影响镜像
- 卷会一直存在，直到没有容器使用

数据卷的使用，类似于Linux下对目录或文件进行mount操作。

**在容器内创建一个数据卷**

在用docker run的时候，使用-v标记可以在容器内创建一个数据卷。多次使用-v标记可以创建多个数据卷。
```
➜  docker run -d -P --name web -v /webapp centos:6.7
3db4a088a9d77e1a282f9b8fe821590a4b7e6a2c6ecd90198afc15bedc092030
➜  docker ps -a
CONTAINER ID        IMAGE               COMMAND             CREATED             STATUS                      PORTS               NAMES
3db4a088a9d7        centos:6.7          "/bin/bash"         1 seconds ago       Exited (0) 4 seconds ago                        web
9cdb66bcd71c        centos:6.7          "/bin/bash"         29 minutes ago      Exited (0) 29 minutes ago                       agitated_bardeen
```

**挂载一个主机目录作为数据卷**
使用-v标记也可以指定挂载一个本地的已有目录到容器中去作为数据卷：

## 6.2 数据卷容器
如果用户需要在容器间共享一些持续更新的数据，最简单的方式是使用数据卷容器。数据卷容器其实就是一个普通的容器，专门用它提供数据卷供其他容器挂载。示例：
```
# 创建一个数据卷容器dbdata，并在其中创建一个数据卷挂载到/dbdata
➜  docker run -it -v /dbdata --name dbdata centos:6.7
# 然后可以在其他容器中使用 --volumes-from 来挂载dbdata容器中的数据卷
➜  docker run -it --volumes-from dbdata --name db1 centos:6.7
➜  docker run -it --volumes-from dbdata --name db2 centos:6.7
# 此时，容器db1和db2都挂载同一个数据卷到相同的/dbdata目录。三个容器任何一方在该目录下的写入，其他容器都可以看到。
```

