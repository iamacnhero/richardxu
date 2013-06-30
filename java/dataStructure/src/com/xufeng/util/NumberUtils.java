package com.xufeng.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

class NumberUtil {
	private static final NumberFormat TWO_DECIMAL_PLACE = new DecimalFormat("0.00");
	
	public static String format(String value) {
		return TWO_DECIMAL_PLACE.format(Double.valueOf(value));
	}

	public static String format(double value) {
		return TWO_DECIMAL_PLACE.format(value);
	}
	
	public static final String getPrice(double value) {
		NumberFormat format = new DecimalFormat("#.##");
		return format.format(value);
	}
	
	public static final String getPrice(String value) {
		NumberFormat format = new DecimalFormat("#.##");
		return format.format(Double.valueOf(value));
	}
	
	/**
	 * 生成某一范围之内的随机数字
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getRandomNumber(int begin, int end) {
		return (int) Math.round(Math.random() * (end - begin) + begin);
	}

	/**
	 * 生成固定长度的数字随机数
	 * 
	 * @param digCount
	 * @return
	 */
	public static String getRandomNumberWithFixLength(int digCount) {
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(digCount);
		for (int i = 0; i < digCount; i++)
			sb.append((char) ('0' + rnd.nextInt(10)));
		return sb.toString();
	}

}