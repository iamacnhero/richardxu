## 3.1 获取镜像

可以使用docker pull命令从网络上下载镜像。该命令的格式为docker pull NAME[:TAG]。如果不显式地指定TAG，则默认会选择latest标签，即下载仓库中最新版本的镜像。
```
➜  sudo docker pull centos
Using default tag: latest
latest: Pulling from library/centos

a3ed95caeb02: Pulling fs layer
da71393503ec: Downloading [================>                                  ] 23.77 MB/70.58 MB

➜  docker pull centos:6.7   # 下载6.7标签的CentOS
```

下载镜像到本地后，就可以使用该镜像创建一个容易，在其中运行bash应用：
```

```

## 3.2 查看镜像信息
使用 **docker images** 命令可以列出本机已有的镜像。
```
➜  sudo docker images
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
hello-world         latest              693bce725149        2 weeks ago         967 B
centos              latest              904d6c400333        3 weeks ago         196.8 MB
```

使用 **docker inspect** 命令可以获取镜像的详细信息。
```
➜  ~ docker inspect 904d6c400333
AttachStderr": false,
            "Tty": false,
            "OpenStdin": false,
            "StdinOnce": false,
            "Env": null,
            "Cmd": [
                "/bin/sh",
                "-c",
                "#(nop) CMD [\"/bin/bash\"]"
            ],
            "Image": "ec52f158cf55423c9a8c2f41a72171c38b94dd638d5d4ff05feaad32d3ae6420",
            "Volumes": null,
            "WorkingDir": "",
            "Entrypoint": null,
            "OnBuild": null,
            "Labels": {
                "build-date": "2016-06-02",
                "license": "GPLv2",
                "name": "CentOS Base Image",
                "vendor": "CentOS"
            }
        },
        "DockerVersion": "1.9.1",
        "Author": "The CentOS Project \u003ccloud-ops@centos.org\u003e",
        "Config": {
            "Hostname": "72f3a060e12e",
            "Domainname": "",
            "User": "",
            "AttachStdin": false,
            "AttachStdout": false,
            "AttachStderr": false,
            "Tty": false,
            "OpenStdin": false,
            "StdinOnce": false,
            "Env": null,
            "Cmd": [
                "/bin/bash"
            ],
            "Image": "ec52f158cf55423c9a8c2f41a72171c38b94dd638d5d4ff05feaad32d3ae6420",
            "Volumes": null,
            "WorkingDir": "",
            "Entrypoint": null,
            "OnBuild": null,
            "Labels": {
                "build-date": "2016-06-02",
                "license": "GPLv2",
                "name": "CentOS Base Image",
                "vendor": "CentOS"
            }
        },
        "Architecture": "amd64",
        "Os": "linux",
        "Size": 196750772,
        "VirtualSize": 196750772,
        "GraphDriver": {
            "Name": "aufs",
            "Data": null
        },
        "RootFS": {
            "Type": "layers",
            "Layers": [
                "sha256:5f70bf18a086007016e948b04aed3b82103a36bea41755b6cddfaf10ace3c6ef",
                "sha256:2cca3e821cecb8a7c7e2ebd6cb2210747ada18107b6dedd9400c88c6c55d5749",
                "sha256:5f70bf18a086007016e948b04aed3b82103a36bea41755b6cddfaf10ace3c6ef",
                "sha256:5f70bf18a086007016e948b04aed3b82103a36bea41755b6cddfaf10ace3c6ef"
            ]
        }
    }
]
```

## 3.3 搜寻镜像
使用 **docker search**命令可以搜索远端仓库中共享的镜像，默认搜索Docker Hub官方仓库中的镜像。用法为**docker search TERM**，支持的参数有：
> --no-trunc=false 输出信息不截断显示

> -s, --starts=0 指定仅显示评价为指定星级以上的镜像

示例，搜索带MySQL关键字的镜像：
```
➜  docker search mysql
NAME                       DESCRIPTION                                     STARS     OFFICIAL   AUTOMATED
mysql                      MySQL is a widely used, open-source relati...   2573      [OK]
mysql/mysql-server         Optimized MySQL Server Docker images. Crea...   165                  [OK]
centurylink/mysql          Image containing mysql. Optimized to be li...   45                   [OK]
sameersbn/mysql                                                            36                   [OK]
appcontainers/mysql        Centos/Debian Based Customizable MySQL Con...   8                    [OK]
marvambass/mysql           MySQL Server based on Ubuntu 14.04              6                    [OK]
drupaldocker/mysql         MySQL for Drupal                                2                    [OK]
alterway/mysql             Docker Mysql                                    2                    [OK]
yfix/mysql                 Yfix docker built mysql                         2                    [OK]
azukiapp/mysql             Docker image to run MySQL by Azuki - http:...   2                    [OK]
tetraweb/mysql                                                             1                    [OK]
phpmentors/mysql           MySQL server image                              1                    [OK]
sin30/mysql                MySQL images with my own config files.          1                    [OK]
kaluzki/mysql              mysql                                           1                    [OK]
... ...
```
AUTOMATED 资源则允许用户验证镜像的来源和内容。 

## 3.4 删除镜像
使用 **docker rmi** 命令可以删除镜像，示例：
```
➜  docker images        # 列出镜像
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
hello-world         latest              693bce725149        2 weeks ago         967 B
centos              latest              904d6c400333        3 weeks ago         196.8 MB
➜  docker rmi 693bce725149    # 删除标签为693bce725149的镜像
Untagged: hello-world:latest
Deleted: sha256:693bce72514984f01f217e878d143162b5f4c1b83b018e7e6dc7394f055e7cd5
Deleted: sha256:73136b8e0c4d588d7af58be522344e3cd4d54931a93d9b489d7063e23d30361e
```

## 3.5 创建镜像
创建镜像的方法有三种：
- 基于已有镜像的容器创建
- 基于本地模板导入
- 基于Dockerfile创建

## 3.6 导出和载入镜像
### 导出镜像
使用 **docker save**命令，如：
```
➜  docker images
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
centos              latest              904d6c400333        3 weeks ago         196.8 MB
➜  docker save -o centos.tar centos:latest
➜  ll centos.tar
-rw-------  1 xu  staff  204349952  6 27 14:56 centos.tar
```

### 导入镜像
使用 **docker load**命令，如：
```
➜  docker load --input centos.tar
```

