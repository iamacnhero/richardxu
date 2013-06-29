#!/bin/bash
# compile and run java program
# usage: ./run fileName

JAVA_FILE=$1
HADOOP_CORE=/opt/hadoop-1.0.4/hadoop-core-1.0.4.jar
                                    
javac -verbose -cp $HADOOP_CORE $JAVA_FILE.java           
jar cvf program.jar *.class
hadoop jar program.jar $JAVA_FILE
