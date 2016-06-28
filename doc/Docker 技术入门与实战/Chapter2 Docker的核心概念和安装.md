## 2.1 核心概念
**Docker 镜像(Image)**
> 类似于虚拟机镜像，可以将它理解为一个面向Docker引擎的只读模板，包含了文件系统。

**Docker 容器(Container)***
> 类似于一个轻量级的沙箱，Docker利用容器来运行和隔离应用。容器是从镜像创建的应用运行实例，可以将其启动、开始、停止、删除，而这些容器都是相互隔离、互不可见的。

> 镜像本身是只读的。容器从镜像启动的时候，Docker会在镜像的最上层创建一个可写层，镜像本身将保持不变。

**Docker 仓库(Repository)**
> 类似于代码仓库，是Docker集中存放镜像文件的场所。根据所存储的镜像公开分享与否，Docker仓库可分为公开仓库和私有仓库。目前，最大的公开仓库是Docker Hub。国内的公开仓库包括Docker Pool等。

## 安装Docker
安装见：
> https://docs.docker.com/docker-for-mac/

Run these commands to test if your versions of docker, docker-compose, and docker-machine are up-to-date and compatible with Docker.app
```bash
➜  docker --version
Docker version 1.12.0-rc2, build 906eacd, experimental
➜  docker-compose --version
docker-compose version 1.8.0-rc1, build 9bf6bc6
➜  docker-machine --version
docker-machine version 0.8.0-rc1, build fffa6c9
```
