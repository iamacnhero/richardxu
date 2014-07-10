package com.richardxu.algorithm.sort;

/**
 * 选择排序 的基本思想是每一趟在 n-i+1(i=1,2,...,n-1)个记录中选取关键字最小的记录作为有序序列的第i个记录。
 * 简单选择排序法(Simple Selection Sort) 就是通过n-i 次关键字间的比较，从n-i+1个记录中选出关键字最小的记录，
 * 并和第i(1<=i<=n)个记录交换之。(最一步都是找出最小数，然后才交换)
 * @author Administrator
 */
public class SelectionSort {
	public static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public static void print(int[] a) {
		{
			StringBuilder sb = new StringBuilder("");
			for (int i : a) {
				sb.append(i + ", ");
			}
			int len = sb.length();
			sb.delete(len-2, len);
			System.out.println(sb.toString());			
		}
	}	

	public static int[] sort(int[] array) {
		int min;
		for (int i = 0; i < array.length; i++) {
			min = i;	// 将当前下标定义为最小值下标
			for (int j = i+1; j < array.length; j++) {	// 循环之后的数据
				if (array[min] > array[j]) 
					min = j;
			}
			if (i != min) {
				swap(array, i, min);
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		int a[] = {15, 3, 2, 1, 10, 4, 9, 13, 3, 5};
		print(sort(a));
	}
}