package com.xufeng.hdfs;

import org.apache.hadoop.conf.Configuration;

public class ReadConfig {
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.addResource("cor-site.xml");
		conf.addResource("hdfs-site.xml");
		System.out.println(conf.get("fs.default.name"));
		System.out.println(conf.get("dfs.replication"));
		System.out.println(conf.getInt("dfs.replication", 0));	
	}
}
