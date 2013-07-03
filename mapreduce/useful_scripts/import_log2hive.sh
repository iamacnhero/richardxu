#!/bin/bash

# 导入日志数据到Hive

SQOOP=/opt/sqoop-1.4.3.bin__hadoop-1.0.0/bin/sqoop
HOST=192.168.0.1
USER=analyze
PASSWORD=123456
MYSQL_TABLE=access_log4hive
HIVE_TABLE=access_log

$SQOOP import --connect jdbc:mysql://$HOST/guang --username $USER --password $PASSWORD --table $MYSQL_TABLE --hive-import -m 1 --hive-drop-import-delims --hive-table $HIVE_TABLE --append

