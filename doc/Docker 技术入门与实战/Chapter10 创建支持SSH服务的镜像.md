## 10.1 基于commit命令创建
Docker 提供了docker commit命令，支持用户提供自己对容器的修改，并生成新的镜像。命令格式为docker commit CONTAINER [REPOSITORY[:TAG]]。
```
$ docker run -it centos:6.7 /bin/bash   # 启动容器
# 安装ssh
```

### 保存镜像
将所退出的容器用 docker commit 命令保存为一个新的 sshd:centos 镜像：
```
docker commit pensive_albattani sshd:centos
```
