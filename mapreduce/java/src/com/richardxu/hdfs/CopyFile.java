package com.richardxu.hdfs;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * 上传文件到HDFS( 通过 FileSystem.copyFromLocalFile(Path src, Path dst) )
 * @author xufeng
 */
public class CopyFile {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem. get(conf);
        Path src = new Path( "/Users/xufeng/Test.py");    // 本地文件
        Path dst = new Path( "/tmp/xufeng" );     // 远程目录
//        Path dst = new Path( "hdfs://10.1.2.82:9000/tmp/xufeng" );     // 远程目录
        hdfs.copyFromLocalFile(src, dst);        // 上传文件
        System.out.println( "Upload to " + conf.get("fs.default.name" ));
        FileStatus files[] = hdfs.listStatus(dst);
        for(FileStatus file : files) {    // 列出远程文件列表
            System.out.println(file.getPath());
        }
    }
}