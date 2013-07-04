#!/bin/bash

# compile and run java program
# usage: ./run fileName

JAVA_FILE=$1
HADOOP_CORE=/opt/hadoop-1.0.4/*
MYSQL_LIB=/opt/hive-0.10.0/lib/mysql-connector-java-5.1.10.jar 
HIVE_LIB=/opt/hive-0.10.0/lib/*

javac -verbose -cp $HADOOP_CORE:$MYSQL_LIB:$HIVE_LIB $JAVA_FILE.java 
jar cvf program.jar *.class
hadoop jar program.jar $JAVA_FILE
