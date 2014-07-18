package com.richardxu.common.lang.format;

/**
 * Conversion to and from Roman numbers.
 * 
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * 
 * @version create on 2012-11-5 下午3:41:54
 */
public class RomanNumber {

	private static final int[] VALUES = new int[] { 1000, 900, 500, 400, 100,
			90, 50, 40, 10, 9, 5, 4, 1 };
	private static final String[] LETTERS = new String[] { "M", "CM", "D",
			"CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	/**
	 * Converts to Roman number.
	 */
	public static String convertToRoman(int value) {
		StringBuilder roman = new StringBuilder();
		int n = value;
		for (int i = 0; i < LETTERS.length; i++) {
			while (n >= VALUES[i]) {
				roman.append(LETTERS[i]);
				n -= VALUES[i];
			}
		}
		return roman.toString();
	}

	/**
	 * Converts to Arabic numbers.
	 */
	public static int convertToArabic(String roman) {
		int start = 0, value = 0;
		for (int i = 0; i < LETTERS.length; i++) {
			while (roman.startsWith(LETTERS[i], start)) {
				value += VALUES[i];
				start += LETTERS[i].length();
			}
		}
		return start == roman.length() ? value : -1;
	}

	/**
	 * Checks if some string is valid roman number.
	 */
	public static boolean isValidRomanNumber(String roman) {
		return roman.equals(convertToRoman(convertToArabic(roman)));
	}
}
