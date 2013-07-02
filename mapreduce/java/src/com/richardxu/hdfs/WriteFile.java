package com.richardxu.hdfs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * 向HDFS上写入文件
 * @author xufeng
 *
 */
public class WriteFile {
	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();
		FileSystem hdfs = FileSystem.get(conf);
		
		String[] content = {"long time no see." , "keep contact!" , "how are you today?"};
		Path file = new Path("/tmp/xufeng/test.txt");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(hdfs.create(file)));
		for (String s : content) {
			bw.write(s);
			bw.newLine();
		}
		bw.close();
		
		
	}
}
