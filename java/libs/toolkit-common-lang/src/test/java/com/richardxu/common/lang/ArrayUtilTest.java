package com.richardxu.common.lang;

import static com.richardxu.common.lang.AssertPrimitiveArraysTestHelper.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.richardxu.common.lang.ArrayUtil;

public class ArrayUtilTest {

	int[] x;
	int[] y;

	Long[] xx;
	Long[] yy;

	@Before
	public void setUp() throws Exception {
		x = new int[5];
		xx = new Long[5];
		for (int i = 0; i < x.length; i++) {
			x[i] = i + 1;
			xx[i] = Long.valueOf(x[i]);
		}
		y = new int[3];
		yy = new Long[3];
		for (int i = 0; i < y.length; i++) {
			y[i] = 11 + i;
			yy[i] = Long.valueOf(y[i]);
		}
	}

	@Test
	public void testJoin() {
		assertEquals(new int[] { 1, 2, 3, 4, 5, 11, 12, 13 },
				ArrayUtil.addAll(x, y));
		assertEquals(new long[] { 1, 2, 3, 4, 5, 11, 12, 13 },
				ArrayUtil.values(ArrayUtil.addAll(xx, yy)));
	}

	@Test
	public void testMerge() {
		assertEquals(new int[] { 1, 2, 3, 4, 5, 11, 12, 13 },
				ArrayUtil.merge(x, y));
		assertEquals(new long[] { 1, 2, 3, 4, 5, 11, 12, 13 },
				ArrayUtil.values(ArrayUtil.merge(xx, yy)));
		assertEquals(new int[] { 1, 2, 3, 4, 5, 11, 12, 13, 11, 12, 13 },
				ArrayUtil.merge(x, y, y));
		assertEquals(new long[] { 1, 2, 3, 4, 5, 11, 12, 13, 11, 12, 13 },
				ArrayUtil.values(ArrayUtil.merge(xx, yy, yy)));
	}

	@Test
	public void testAppend() {
		assertEquals(new int[] { 1, 2, 3, 4, 5, 100 }, ArrayUtil.add(x, 100));
		assertEquals(new long[] { 1, 2, 3, 4, 5, 100 },
				ArrayUtil.values(ArrayUtil.add(xx, Long.valueOf(100))));
	}

	@Test
	public void testResize() {
		assertEquals(new int[] { 1, 2, 3 }, ArrayUtil.resize(x, 3));
		assertEquals(new long[] { 1, 2, 3 },
				ArrayUtil.values(ArrayUtil.resize(xx, 3)));
		assertEquals(new int[] { 1, 2, 3, 4, 5, 0, 0 }, ArrayUtil.resize(x, 7));
		assertEquals(new long[] { 1, 2, 3, 4, 5, 0, 0 },
				ArrayUtil.values(ArrayUtil.resize(xx, 7)));
		assertEquals(new int[] {}, ArrayUtil.resize(x, 0));
	}

	@Test
	public void testSub() {
		assertEquals(new int[] { 2, 3, 4 }, ArrayUtil.subarrayTo(x, 1, 3));
		assertEquals(new long[] { 2, 3, 4 },
				ArrayUtil.values(ArrayUtil.subarrayTo(xx, 1, 3)));
	}

	@Test
	public void testInsert() {
		assertEquals(new int[] { 1, 2, 3, 11, 12, 13, 4, 5 },
				ArrayUtil.insert(x, y, 3));
		assertEquals(new int[] { 11, 12, 13, 1, 2, 3, 4, 5 },
				ArrayUtil.insert(x, y, 0));
		assertEquals(new int[] { 1, 2, 3, 4, 5, 11, 12, 13 },
				ArrayUtil.insert(x, y, 5));

		assertEquals(new int[] { 1, 2, 3, 173, 4, 5 },
				ArrayUtil.insert(x, 173, 3));
		assertEquals(new int[] { 173, 1, 2, 3, 4, 5 },
				ArrayUtil.insert(x, 173, 0));
		assertEquals(new int[] { 1, 2, 3, 4, 5, 173 },
				ArrayUtil.insert(x, 173, 5));
	}

	@Test
	public void testInsertAt() {
		assertEquals(new int[] { 1, 2, 3, 11, 12, 13, 5 },
				ArrayUtil.insertAt(x, y, 3));
		assertEquals(new int[] { 11, 12, 13, 2, 3, 4, 5 },
				ArrayUtil.insertAt(x, y, 0));
		assertEquals(new int[] { 1, 2, 3, 4, 11, 12, 13 },
				ArrayUtil.insertAt(x, y, 4));
	}

	@Test
	public void testIndexOf() {
		Assert.assertEquals(0, ArrayUtil.indexOf(x, 1));
		Assert.assertEquals(1, ArrayUtil.indexOf(x, 2));
		Assert.assertEquals(4, ArrayUtil.indexOf(x, 5));
		Assert.assertEquals(-1, ArrayUtil.indexOf(x, 6));
		Assert.assertEquals(1, ArrayUtil.indexOf(xx, Long.valueOf(2)));
		Assert.assertEquals(-1, ArrayUtil.indexOf(xx, Long.valueOf(12)));
		Assert.assertEquals(1, ArrayUtil.indexOf(yy, Long.valueOf(12)));
		Assert.assertEquals(-1, ArrayUtil.indexOf(yy, Long.valueOf(12), 2));
	}

	@Test
	public void testIndexOf2() {
		Assert.assertEquals(0, ArrayUtil.indexOf(x, new int[] {}));
		Assert.assertEquals(0, ArrayUtil.indexOf(x, new int[] { 1, 2, 3 }));
		Assert.assertEquals(-1, ArrayUtil.indexOf(x, new int[] { 1, 2, 3, 7 }));

		Assert.assertEquals(1, ArrayUtil.indexOf(x, new int[] { 2, 3 }));
		Assert.assertEquals(4, ArrayUtil.indexOf(x, new int[] { 5 }));
	}

	@Test
	public void testContains() {
		assertTrue(ArrayUtil.contains(x, 1));
		assertTrue(ArrayUtil.contains(x, 2));
		assertTrue(ArrayUtil.contains(x, 5));
		assertFalse(ArrayUtil.contains(x, 6));
		assertTrue(ArrayUtil.contains(xx, Long.valueOf(3)));
		assertFalse(ArrayUtil.contains(xx, Long.valueOf(13)));
		assertTrue(ArrayUtil.contains(yy, Long.valueOf(13)));
		assertFalse(ArrayUtil.contains(yy, Long.valueOf(13), 3));
	}

	@Test
	public void testContains2() {
		assertTrue(ArrayUtil.contains(x, new int[] {}));
		assertTrue(ArrayUtil.contains(x, new int[] { 1, 2, 3 }));
		assertFalse(ArrayUtil.contains(x, new int[] { 1, 2, 3, 7 }));

		assertTrue(ArrayUtil.contains(x, new int[] { 2, 3 }));
		assertTrue(ArrayUtil.contains(x, new int[] { 5 }));
	}

	@Test
	public void testConvert() {
		Integer[] src = new Integer[] { Integer.valueOf(1), null,
				Integer.valueOf(3) };
		int[] dest = ArrayUtil.values(src);
		Assert.assertEquals(3, dest.length);
		Assert.assertEquals(1, dest[0]);
		Assert.assertEquals(0, dest[1]);
		Assert.assertEquals(3, dest[2]);

		src = ArrayUtil.valuesOf(dest);
		Assert.assertEquals(3, src.length);
		Assert.assertEquals(1, src[0].intValue());
		Assert.assertEquals(0, src[1].intValue());
		Assert.assertEquals(3, src[2].intValue());

	}

	@Test
	public void testToString() {
		Assert.assertEquals("1, 2, 3",
				ArrayUtil.toString(new int[] { 1, 2, 3 }));
		Assert.assertEquals("1, null, 3.1",
				ArrayUtil.toString(new Object[] { 1, null, 3.1 }));
		Assert.assertEquals(null, ArrayUtil.toString((long[]) null));
	}

	@Test
	public void testRemove() {
		assertEquals(new int[] { 1, 2, 5 }, ArrayUtil.remove(x, 2, 2));
		assertEquals(new int[] { 1 }, ArrayUtil.remove(x, 1, 4));
		assertEquals(new long[] { 1, 3, 4, 5 },
				ArrayUtil.values(ArrayUtil.remove(xx, 1, 1)));
	}

}
