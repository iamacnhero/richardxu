package com.xufeng.example.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 读取字符文件
 * @author xufeng
 *
 */
public class ReadFile {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		String f = "D:/test.txt";
		
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		String s;
		try {
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("Error Closing file!");
			e.printStackTrace();
		}		

	}

}
