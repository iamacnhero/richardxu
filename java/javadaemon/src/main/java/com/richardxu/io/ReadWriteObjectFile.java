package com.richardxu.io;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class ComputerBook implements Serializable {
	private static final long serialVersionUID = 1L;
	String name, author;
	double price;

	void show() {
		System.out.println(name + "\t" + price + "\t" + author + "\t");
	}
}

public class ReadWriteObjectFile {
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, IOException {
		ComputerBook b1 = new ComputerBook();
		File f1 = new File("C:/tmp/Book1.txt");
		f1.createNewFile();

		System.out.println("请输入书名: ");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		b1.name = br.readLine();

		System.out.println("请输入价格: ");
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		b1.price = Double.parseDouble(br.readLine()); // parseDouble可将String类型的小数转换成double类型

		System.out.println("请输入作者：");
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		b1.author = br.readLine();

		br.close();
		isr.close();

		System.out.println("写入" + f1.getName() + "...");
		FileOutputStream fos = new FileOutputStream(f1);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(b1);

		oos.close();
		fos.close();

		FileInputStream fis = new FileInputStream(f1);
		ObjectInputStream ois = new ObjectInputStream(fis);
		System.out.println(f1.getName() + "文件内容如下: ");
		System.out.println("------------------------------------");
		try {
			((ComputerBook) ois.readObject()).show(); // 读出来的对象数据为Object,
														// 必须强制转换成ComputerBook类型才可以使用show()方法
		} catch (EOFException e) {
			System.out.println("<<已到文件结尾!>>");
		}
		ois.close();
		fis.close();

		System.exit(0);

	}
}