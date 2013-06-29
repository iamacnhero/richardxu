package com.xufeng.hdfs;


import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class RenameFile {
	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();
		FileSystem hdfs = FileSystem.get(conf);
		Path src = new Path("/tmp/xufeng/test.txt");
		Path dst = new Path("/tmp/xufeng/test2.txt");
		boolean isRename = hdfs.rename(src, dst);
		System.out.println(isRename);
	}
}
