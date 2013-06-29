package com.xufeng.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class FileOperation  {
	private Configuration conf = new Configuration(); 
	private FileSystem hdfs = FileSystem.get(conf);
	
	public FileOperation() throws IOException {
	}
	
    public void createFile(String fileNameWithPath) throws IOException {
    	Path dfs = new Path(fileNameWithPath);
		FSDataOutputStream outputStream = hdfs.create(dfs);
		outputStream.close();
    }
    
    public static void main(String[] args) {
		String f = "/tmp/xufeng/heaven.txt";
		try {
			FileOperation fo = new FileOperation();
			fo.createFile(f);
		} catch (Exception e) {
			
		}
	}
}