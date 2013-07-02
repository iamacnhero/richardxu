package com.richardxu.hdfs;

import org.apache.hadoop.conf.Configuration;
import java.util.Map.Entry;

/**
 * 读取配置文件
 * @author xufeng
 *
 */
public class ReadConfig {
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.addResource("cor-site.xml");
		conf.addResource("hdfs-site.xml");
		for (Entry<String, String> entry: conf) {
			System.out.printf("%s = %s\n", entry.getKey(), entry.getValue());
		}
	}
}
