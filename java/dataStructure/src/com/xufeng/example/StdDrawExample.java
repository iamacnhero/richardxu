package com.xufeng.example;

import java.util.Arrays;

import com.xufeng.lib.StdDraw;
import com.xufeng.lib.StdRandom;

public class StdDrawExample {
	/**
	 * 函数值
	 */
	public static void function() {	
		int N = 100;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N*N);
		StdDraw.setPenRadius(.01);
		for (int i = 1; i <= N; i++) {
			StdDraw.point(i, i);
			StdDraw.point(i, i*i);
			StdDraw.point(i, i*Math.log(i));
		}
	}
	
	/**
	 * 随机数组
	 */
	public static void randomArray() {
		int N = 50;
		double[] a = new double[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.random();
		}
		for (int i = 0; i < N; i++) {
			double x = 1.0 * i / N;
			double y = a[i] / 2.0;
			double rw = 0.5 / N;
			double rh = a[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
	
	/**
	 * 已排序的随机数组
	 */
	public static void sortedRandomArray() {
		int N = 50;
		double[] a = new double[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.random();
		}
		Arrays.sort(a);
		for (int i = 0; i < N; i++) {
			double x = 1.0 * i / N;
			double y = a[i] / 2.0;
			double rw = 0.5 / N;
			double rh = a[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
	
	public static void main(String[] args) {
		/*function();*/
		/*randomArray();*/
		sortedRandomArray();
	}

}
