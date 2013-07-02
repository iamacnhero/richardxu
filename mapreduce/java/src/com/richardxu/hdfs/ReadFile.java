package com.richardxu.hdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * 读取HDFS上的文件
 * @author xufeng
 *
 */
public class ReadFile {
	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();
		FileSystem hdfs = FileSystem.get(conf);
		
		Path file = new Path("/tmp/xufeng/test.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(hdfs.open(file)));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}
}
