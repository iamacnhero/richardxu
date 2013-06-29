package com.xufeng.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

/**
 * 显示HDFS文件系统中一组路径的文件信息
 * @author xufeng
 *
 */
public class ListFileStatus {
	public static void main(String[] args) throws IOException {
		String[] uri = {"/tmp", "/user"};
		Configuration conf = new Configuration();
		FileSystem hdfs = FileSystem.get(conf);	
		
		Path[] paths = new Path[uri.length];
		for (int i = 0; i < paths.length; i++) {
			paths[i] = new Path(uri[i]);
		}
		
		FileStatus[] status = hdfs.listStatus(paths);
		Path[] listedPaths = FileUtil.stat2Paths(status);
		for (Path p : listedPaths) {
			FileStatus stat = hdfs.getFileStatus(p);
			System.out.println(p);
			System.out.println(stat.getBlockSize() + stat.getOwner() + stat.getPath() + stat.getReplication());
		}
	}
}
