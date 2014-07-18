package com.richardxu.common.lang;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.richardxu.common.lang.MathUtil;

public class MathUtilTest {

	@Test
	public void testOddEven() {
		assertTrue(MathUtil.isEven(0));
		assertTrue(MathUtil.isOdd(1));
		assertTrue(MathUtil.isOdd(-1));
		assertTrue(MathUtil.isEven(2));
		assertTrue(MathUtil.isEven(-2));
	}

	@Test
	public void testFactorial() {
		assertEquals(0, MathUtil.factorial(-1));
		assertEquals(1, MathUtil.factorial(0));
		assertEquals(1, MathUtil.factorial(1));
		assertEquals(2, MathUtil.factorial(2));
		assertEquals(6, MathUtil.factorial(3));
		assertEquals(3628800, MathUtil.factorial(10));
		assertEquals(1307674368000L, MathUtil.factorial(15));
	}

	@Test
	public void testParseDigit() {
		assertEquals(0, MathUtil.parseDigit('0'));
		assertEquals(1, MathUtil.parseDigit('1'));
		assertEquals(8, MathUtil.parseDigit('8'));
		assertEquals(9, MathUtil.parseDigit('9'));
		assertEquals(10, MathUtil.parseDigit('A'));
		assertEquals(10, MathUtil.parseDigit('a'));
		assertEquals(15, MathUtil.parseDigit('F'));
		assertEquals(15, MathUtil.parseDigit('f'));
	}
}
