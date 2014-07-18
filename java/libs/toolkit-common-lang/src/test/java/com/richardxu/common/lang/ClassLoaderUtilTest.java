package com.richardxu.common.lang;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.junit.Test;

import com.richardxu.common.lang.ClassLoaderUtil;

public class ClassLoaderUtilTest {

	@Test
	public void testStream() throws IOException {

		InputStream is = ClassLoaderUtil
				.getClassAsStream(ClassLoaderUtilTest.class);
		assertNotNull(is);
		is.close();

		is = ClassLoaderUtil.getClassAsStream(ClassLoaderUtilTest.class);
		assertNotNull(is);
		is.close();

		URL url;
		final String resourceName = "com/iphonele/common/lang/ClassLoaderUtil.class";

		url = ClassLoaderUtil.getResource(resourceName);
		assertNotNull(url);

		is = ClassLoaderUtil.getResourceAsStream(resourceName);
		assertNotNull(is);
		is.close();
	}

	@Test
	public void testClassFileName() {
		assertEquals("com/iphonele/common/lang/ClassLoaderUtilTest.class",
				ClassLoaderUtil.getClassFileName(ClassLoaderUtilTest.class));
		assertEquals("com/iphonele/common/lang/ClassLoaderUtilTest.class",
				ClassLoaderUtil.getClassFileName(ClassLoaderUtilTest[].class));
		assertEquals("com/iphonele/common/lang/ClassLoaderUtilTest$Boo.class",
				ClassLoaderUtil.getClassFileName(Boo.class));

		assertEquals("com/iphonele/common/lang/ClassLoaderUtilTest.class",
				ClassLoaderUtil.getClassFileName(ClassLoaderUtilTest.class
						.getName()));
		assertEquals("com/iphonele/common/lang/ClassLoaderUtilTest$Boo.class",
				ClassLoaderUtil.getClassFileName(Boo.class.getName()));
	}

	public static class Boo {
		int v;
	}

	@Test
	public void testLoadClass() throws ClassNotFoundException {
		try {
			ClassLoaderUtil.loadClass("not.existing.class");
		} catch (ClassNotFoundException cnfex) {
			assertEquals("Class not found: not.existing.class",
					cnfex.getMessage());
		}

		try {
			Class<?> testClass = ClassLoaderUtil
					.loadClass("com.iphonele.common.lang.ClassLoaderUtilTest");
			assertNotNull(testClass);
		} catch (ClassNotFoundException ignore) {
			fail();
		}
		assertEquals(Integer.class,
				ClassLoaderUtil.loadClass("java.lang.Integer"));
		assertEquals(int.class, ClassLoaderUtil.loadClass("int"));
		assertEquals(boolean.class, ClassLoaderUtil.loadClass("boolean"));
		assertEquals(short.class, ClassLoaderUtil.loadClass("short"));
		assertEquals(byte.class, ClassLoaderUtil.loadClass("byte"));
		assertEquals(char.class, ClassLoaderUtil.loadClass("char"));
		assertEquals(double.class, ClassLoaderUtil.loadClass("double"));
		assertEquals(float.class, ClassLoaderUtil.loadClass("float"));
		assertEquals(long.class, ClassLoaderUtil.loadClass("long"));

		assertEquals(Integer[].class,
				ClassLoaderUtil.loadClass("java.lang.Integer[]"));
		assertEquals(int[].class, ClassLoaderUtil.loadClass("int[]"));
		assertEquals(boolean[].class, ClassLoaderUtil.loadClass("boolean[]"));
		assertEquals(short[].class, ClassLoaderUtil.loadClass("short[]"));
		assertEquals(byte[].class, ClassLoaderUtil.loadClass("byte[]"));
		assertEquals(char[].class, ClassLoaderUtil.loadClass("char[]"));
		assertEquals(double[].class, ClassLoaderUtil.loadClass("double[]"));
		assertEquals(float[].class, ClassLoaderUtil.loadClass("float[]"));
		assertEquals(long[].class, ClassLoaderUtil.loadClass("long[]"));

		assertEquals(Integer[][].class,
				ClassLoaderUtil.loadClass("java.lang.Integer[][]"));
		assertEquals(int[][].class, ClassLoaderUtil.loadClass("int[][]"));
	}

}
