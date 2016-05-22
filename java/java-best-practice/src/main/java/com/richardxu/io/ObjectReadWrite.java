package com.richardxu.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 读写序列化对象文件
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年3月7日
 */
public class ObjectReadWrite {
	
    /**
     * 写对象文件
     * @param o
     * @param path
     * @throws IOException
     */
    public static void writeObject(Object o, String path) throws IOException {
        FileOutputStream fs = new FileOutputStream(path);
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(o);
        os.close();
        fs.close();
    }
    
    /**
     * 读对象文件
     * @param path
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object readObject(String path) throws IOException, ClassNotFoundException {
        FileInputStream fs = new FileInputStream(path);
        ObjectInputStream os = new ObjectInputStream(fs);
        Object o = os.readObject();
        os.close();
        fs.close();
        return o;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, IOException {
    	String path = "/Users/xu/Header.ser";
        
//      Header header = new Header();
//      header.setSenderSystem("gotEngine");
//      header.setReceiveSystem("tbusAdaptor");
//      header.setSendMode(SendMode.ASYNC);
//      
//      writeObject(header, path);
      
      
      Date object = (Date) readObject(path);
      System.out.println(object);
	}
    
}
