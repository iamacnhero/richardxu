package com.richardxu.algorithm.sort;

/**
 * 在算法执行的时候，最大的数据项总是“冒泡”到数组的顶端，故称为“冒泡”排序。
 * 冒泡的方法是从前往后的冒泡，越大的值越往后；也可以从后向前冒泡，把越小的值冒泡到前面。
 * @author xufeng
 */
public class BubbleSort {
	public static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public static void print(int[] a) {
		StringBuilder sb = new StringBuilder("");
		for (int i : a) {
			sb.append(i + ", ");
		}
		int len = sb.length();
		sb.delete(len-2, len);
		System.out.println(sb.toString());
	}
	
	public static int[] sort(int[] array) {	// 顺序, 向后冒泡
		boolean flag = true;
		int length = array.length;
		while (flag) {
			flag = false;
			for (int i = 0; i < length - 1; i++) {	// 用length-1，如果用length, 下面的length+1会溢出
				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
					flag = true;
				}
			}
		}
		return array;
	}
	
	public static int[] forwardSort(int[] array) {	// 顺序, 向前冒泡
		boolean flag = true;
		int length = array.length;
		while (flag) {
			flag = false;
			for (int i = length-2; i >= 0; i--) {	// 用length-1，如果用length, 下面的length+1会溢出
				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
					flag = true;
				}
			}
		}
		return array;
	}
	
	public static int[] descendingSort(int[] a) {	// 倒序, 向后冒泡
		boolean flag = true;
		int len = a.length;
		while (flag) {
			flag = false;
			for (int i=1; i<len; i++) {
				if (a[i-1]<a[i]) {
					swap(a, i, i-1);
					flag = true;
				}
			}
		}
		return a;
	}	
	
	public static void main(String[] args) {
		int a[] = {2, 1, 3, 4, 9, 10, 7, 8, 13, 12};
		print(sort(a));
//		print(forwardSort(a));
		print(descendingSort(a));
	}

}
