package com.richardxu.reflection;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 使用反射操作数组
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年6月5日
 */
public class ReflectArray {
	
	public static void useArray() {
		String[] names = (String[]) Array.newInstance(String.class, 10);
		names[0] = "Hello";
		Array.set(names, 1, "World");
		String str = (String) Array.get(names, 0);
		System.out.println(str);
		
		int[][][] matrix1 = (int[][][]) Array.newInstance(int.class, 3, 3, 3);
		matrix1[0][0][0] = 1;
		System.out.println(Arrays.deepToString(matrix1));
		
		int[][][] matrix2 = (int[][][]) Array.newInstance(int[].class, 3, 4);
		matrix2[0][0] = new int[10];
		matrix2[0][1] = new int[3];
		matrix2[0][0][1] = 1;
		System.out.println(Arrays.deepToString(matrix2));
	}
	
	public static void main(String[] args) {
		useArray();
	}
}