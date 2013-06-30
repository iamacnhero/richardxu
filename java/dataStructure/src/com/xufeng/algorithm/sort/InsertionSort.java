package com.xufeng.algorithm.sort;

/**
 * 直接插入排序(Straight Insertion Sort) 的基本操作是将一个记录插入到已经排好序的表序表中，从而得到一个新的、记录数增1的有序表
 * @author xufeng
 */
public class InsertionSort {
	public static void print(int[] a) {
		StringBuilder sb = new StringBuilder("");
		for (int i : a) {
			sb.append(i + ", ");
		}
		int len = sb.length();
		sb.delete(len-2, len);
		System.out.println(sb.toString());
	}
	
	public static int[] sort(int[] array) {
		int length = array.length;
        int in, out;
        for (out = 1; out < length; out++) {          // 外层，out 变量从1开始向右移动，它标记了未排序部分的最左端的数据
        	int temp = array[out];          // removed marked item
        	in = out;      // Start shifts at out
        	while(in>0 && array[in-1] >= temp) {   // in变量从out变量开始，向左移动，直到temp变量小于in所指的数组数据项，或者它已经不能再往左移动为止
        		array[in] = array[in - 1];    // shift item right
        		--in;   // 向左移一步
        	}
        	array[in] = temp;
        }
        return array;
	}
	
	public static int[] descendingSort(int[] array) {	// 倒序
		int length = array.length;
        int in, out;
        for (out = 1; out < length; out++) {          // 外层，out 变量从1开始向右移动，它标记了未排序部分的最左端的数据
        	int temp = array[out];          // removed marked item
        	in = out;      // Start shifts at out
        	while(in>0 && array[in-1] <= temp) {   // in变量从out变量开始，向左移动，直到temp变量小于in所指的数组数据项，或者它已经不能再往左移动为止
        		array[in] = array[in - 1];    // shift item right
        		--in;   // 向左移一步
        	}
        	array[in] = temp;
        }
        return array;
	}

	public static void main(String[] args) {
		int[] a = {15, 3, 2, 1, 10, 4, 9, 13, 3, 5};
		print(sort(a));
		print(descendingSort(a));
	}

}
