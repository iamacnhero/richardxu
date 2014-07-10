package com.richardxu.examples;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * 写入字符文件
 * @author xufeng
 *
 */
public class WriteFile {
	public static void main(String[] args) {
		FileWriter fw;
		BufferedWriter bw;
		
		String f = "D:/test.txt";
		String strs[] = {
				"32435 Tom@Herb.com 中国",
				"86754 Mary@Herb.com 美国",
				"35789 TC@Herb.com 日本"
		};
		
		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			
			for (String s : strs) {
				bw.write(s);
				bw.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ;
		}
		
		try {
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("Error Closing file!");
			e.printStackTrace();
		}

	}

}
