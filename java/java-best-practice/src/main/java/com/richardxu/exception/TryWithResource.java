package com.richardxu.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * JDK7 Coin
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年2月28日
 */
public class TryWithResource {
	
	/**
	 * try-with-resource 语句
	 * 能够被try语句所管理的资源只需要满足一个条件，即该类实现了AutoCloseable接口
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String readFile(String path) throws FileNotFoundException, IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			 StringBuilder builder = new StringBuilder();
			 String line = null;
			 while ((line = reader.readLine()) != null) {
				 builder.append(line);
				 builder.append(String.format("%n"));
			 }
			 return builder.toString();
		}		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println(readFile("/Users/xu/antx.properties"));
	}
	
}
