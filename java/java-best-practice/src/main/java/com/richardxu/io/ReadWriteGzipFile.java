package com.richardxu.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;


/**
 * 使用Java默认的压缩库ZLIB 生成压缩数据文件和解压数据文件
 * @author xufeng
 *
 */
public class ReadWriteGzipFile {
	public static void main(String[] args) {
		DataInputStream dis = null;
		DataOutputStream dos;
		String f = "d:/data.dat";
		
		double data[] = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
		// open the output file
		try {
			dos = new DataOutputStream(
					new DeflaterOutputStream(
							new FileOutputStream(f)));
		} catch (FileNotFoundException e) {
			System.out.println("Error Opening Output file.");
			return;
		}
		
		// 使用 ZLIB 压缩数据
		try {
			dos.writeInt(data.length);	// DeflaterOutputStream 将会自动压缩数据
			for (double d : data) {
				dos.writeDouble(d);
			}
		} catch (IOException e) {
			System.out.println("Compressed file error");
		}
		
		try {
			dos.close();
		} catch (IOException e) {
			System.out.println("Error closing output file");
		}

		try {
			dis = new DataInputStream(
					new InflaterInputStream(
							new FileInputStream(f)));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
		// 解压并显示文件
		try {
			int num = dis.readInt();
			double sum = 0.0;
			double d;
			System.out.println("Data: ");
			// 读取数据
			for (int i = 0; i < num; i++) {
				d = dis.readDouble();
				sum += d;
				System.out.println(d + " ");
			}
			System.out.println("\nAverage is " + sum / num);
		} catch (Exception e) {
			System.out.println("Error reading input file.");
		}
		
		try {	// 关闭文件
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
