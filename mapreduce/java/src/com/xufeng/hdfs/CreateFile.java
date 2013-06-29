package com.xufeng.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class CreateFile {
	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();
		FileSystem hdfs = FileSystem.get(conf);
		Path file = new Path("/tmp/xufeng/test3.txt");
		String text = "test";
		FSDataOutputStream outputStream = hdfs.create(file);
		outputStream.writeUTF(text);
		outputStream.close();
	}
}
