package com.richardxu.examples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadWriteFileByDataStream {
	public static void main(String[] args) throws IOException {
		String filePath = "D:/test.txt";
		File f = new File(filePath);
		FileOutputStream fo = new FileOutputStream(f); 
		DataOutputStream dos = new DataOutputStream(fo);
		for (int i = 0; i < 10; i++) {
/*			DataOutputStream 类提供了3种写入字符串的方法：
			1. writeBytes(String s)
			2. writeChars(String s)
			3. writeUTF(String s)
*/
			dos.writeBytes("First " + i + System.lineSeparator());
			/*ds.writeUTF("First " + i + System.lineSeparator());*/
		}
		
		dos.close();
		fo.close();
		
		FileInputStream fi = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fi);
		// available stream to be read
        int length = dis.available();
        // create buffer
        byte[] buf = new byte[length];
        // read the full data into the buffer
        dis.readFully(buf);
        
        // for each byte in the buffer
        for (byte b:buf)
        {
           // convert byte to char
           char c = (char)b; 
           
           // prints character
           System.out.print(c);
        }
        
		dis.close();
		fi.close();
		
	}

}

