package com.xufeng.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtils {

	/**
	 * 创建文件
	 * @param path
	 * @param fileName
	 * @param deleteIfExist 是否删除标志位
	 * @return
	 */
	public static File createNewFile(String path, String fileName, boolean deleteIfExist) {
		File f = new File(path, fileName);
		if (deleteIfExist) {
			f.delete();
		}
		
		if (f.exists()) {
			System.out.println(fileName + " is exist!");
			return null;
		} else {
			try {
				f.createNewFile();
				return f;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
	/**
	 * 得到目录的文件列表
	 * @param path
	 * @return
	 */
	public static ArrayList<String> getFileList(String path) {
		File dir = new File(path);
		ArrayList<String> fileList = new ArrayList<String>();
		for (File f : dir.listFiles()) {
			fileList.add(f.getAbsolutePath());
		}
		return fileList;
	}
	
	
	/**
	 * 得到目录的文件，必须具有相应的文件后缀名
	 * @param path
	 * @param pattern
	 * @return
	 */
	public static ArrayList<String> getFileList(String path, String pattern) {
		File dir = new File(path);
		ArrayList<String> fileList = new ArrayList<String>();
		for (File f : dir.listFiles()) {
			if (f.getName().indexOf("."+pattern)!=-1) {
				fileList.add(f.getAbsolutePath());
			}
		}
		return fileList;
	}
	
	/**
	 * 递归打印所有文件列表
	 * @param path
	 */
	public static void printFileList(String path) {
		File f= new File(path);
		if (f.isDirectory()) {
			// System.out.println(f.getAbsolutePath());
			for (File i : f.listFiles()) {
				printFileList(i.getAbsolutePath());
			}
		} else {
			System.out.println(f.getAbsolutePath());
		}
	}
}