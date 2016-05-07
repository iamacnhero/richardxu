package com.richardxu.io.mmap;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.commons.io.IOUtils;

public class FileUtils {
	
	public static void writeFileWithMmap(String fileName, byte[] data) throws IOException {
		RandomAccessFile memMappedFile = new RandomAccessFile(fileName, "rw");
		MappedByteBuffer out = memMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, data.length);
		out.put(data);
		memMappedFile.close();
	}
	
	public static void writeFile(String fileName, byte[] data) throws IOException {
		File f = new File(fileName);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
		IOUtils.write(data, bos);
		bos.flush();
		bos.close();
	}
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 1000; i++) {
			sb.append(i);
		}
		
		byte[] data = sb.toString().getBytes();
		String fileName = "largeFile.dat";
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			writeFile(fileName, data);
		}
		long cost = System.currentTimeMillis() - start;
		System.out.println("write consume: " + cost + "ms");
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			writeFileWithMmap(fileName, data);
		}
		cost = System.currentTimeMillis() - start;
		System.out.println("write with mmap consume: " + cost + "ms");
	}
	
//	public static void readFileWithMmap(String fileName) throws IOException {
//        FileChannel fileChannel = new RandomAccessFile(fileName, "r").getChannel();
//         
//        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
//        System.out.println(buffer.isLoaded());  // prints false
//        System.out.println(buffer.capacity());  // Get the size based on content size of file
//         
//        // You can read the file from this buffer the way you like.
//        for (int i = 0; i < buffer.limit(); i++) {
//            System.out.print((char) buffer.get()); //Print the content of file
//        }
//        fileChannel.close();
//	}

}