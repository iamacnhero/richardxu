《ELK stack 权威指南》 饶琛琳 编著


### 下载安装
**最佳实践**
使用ElasticSearch官方仓库来安装Logstash !

参见官网：[Installing logstash](https://www.elastic.co/guide/en/logstash/current/installing-logstash.html#package-repositories)


#### 安装步骤
1. Download and install the public signing key:
```
sudo -u root rpm --import https://packages.elastic.co/GPG-KEY-elasticsearch
```

2. Add the following in your /etc/yum.repos.d/ directory in a file with a .repo suffix, for example logstash.repo
```
[logstash-2.3]
name=Logstash repository for 2.3.x packages
baseurl=https://packages.elastic.co/logstash/2.3/centos
gpgcheck=1
gpgkey=https://packages.elastic.co/GPG-KEY-elasticsearch
enabled=1
```

3. And your repository is ready for use. You can install it with:
```
sudo -u root yum install logstash
```

### 测试命令行运行
定位Logstash的安装目录：
```
rpm -ql logstash-2.3.2-1.noarch
```

命令行运行：
```
$/opt/logstash/bin/logstash -e 'input{stdin{}}output{stdout{codec=>rubydebug}}'
hello world
Settings: Default pipeline workers: 4
Pipeline main started
{
    "message" => "hello world",
    "@version" => "1",
    "@timestamp" => "2016-06-05T09:25:40.110Z",
    "host" => "e011239160039.et15sqa"
}
```

### 完整示例
通常都是用logstash.conf配置文件的方式来启动，配置示例：
```javascript
input {
    stdin { }
}
output {
    stdout {
        codec => rubydebug { }
    }
    elasticsearch {
        embeded => true
    }
}
```

Logstash 会给事件添加一些额外信息。最重要是@timestamp，用来标记事件的发生时间。

### 推荐的后台运行方式：daemontools
包括 supervisord, ubic, god 等等，以supervisord 为例，在 /etc/supervisord.conf中配置要运行的Logstash进程，然后启动 service supervisord start 即可。Logstash 会以 supervisord 子进程的身份运行。