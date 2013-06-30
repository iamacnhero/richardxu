package com.xufeng.example.file;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class FileOperation {
	
	/**
	 * 显示文件各种属性
	 * @param name
	 * @throws IOException 
	 */
	public static void showAttributes(String name) {
		File f;
		f = new File(name);
		if (!f.exists()) {	// 文件是否存在
			System.out.println("File not found!");
			return;
		}
		
		System.out.println("File Attributes: ");	// 文件属性
		System.out.println(f.getName());	// 获取文件名
		if (f.canRead()) System.out.println("  Readable");
		if (f.canWrite()) System.out.println("  Writable");
		if (f.isDirectory()) System.out.println("  is a Directory");
		if (f.isFile()) System.out.println("  is a File");
		if (f.isHidden()) System.out.println("  is Hidden");	// 判断文件是否是隐藏文件
		if (f.canExecute()) System.out.println("  is Executable");
		System.out.println("Last modified on" + new Date(f.lastModified()));
		System.out.println(f.getAbsolutePath());	// 文件绝对路径
		System.out.println(f.length());	// 获取文件长度
	}
	
	public static void setAttributes(String name) {
		File f;
		f = new File(name);
		if (!f.exists()) {	// 文件是否存在
			System.out.println("File not found!");
			return;
		}
		
		// Update the time stamp.
		long t = Calendar.getInstance().getTimeInMillis();
		if (!f.setLastModified(t))
			System.out.println("Can't set time.");
		
		// 设置成只读
		if (!f.setReadOnly())
			System.out.println("Can't set to read-only.");
		
		// Return to read/write status
		if (!f.setWritable(true, false))
			System.out.println("Can't return to read/write.");
			
	}
	
	public static void main(String[] args) {
		String f = "D:/test.txt";
		showAttributes(f);
		setAttributes(f);
		
	}

}
