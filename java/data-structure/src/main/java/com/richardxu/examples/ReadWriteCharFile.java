package com.richardxu.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 读取写入字符文件流
 * 
 * @author xufeng
 * 
 */
public class ReadWriteCharFile {
	public static void main(String[] args) {
		File f = new File("c:/tmp", "test.txt");
		try {
			FileOutputStream out = new FileOutputStream(f);
			byte buy[] = "I need your passion.".getBytes();// 创建byte型数组
			out.write(buy);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			FileInputStream input = new FileInputStream(f);
			byte buy[] = new byte[1024]; // 创建byte数组
			int len = input.read(buy); // 从文件中读取信息
			System.out.println("File content: " + new String(buy, 0, len)); // 信息输出
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
