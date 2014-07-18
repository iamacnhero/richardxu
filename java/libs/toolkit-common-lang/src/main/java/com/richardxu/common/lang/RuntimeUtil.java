/**
 *
 */
package com.richardxu.common.lang;

/**
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * 
 * @version create on 2012-9-17 下午4:43:52
 */
public class RuntimeUtil {

	private static final Runtime RUNTIME = Runtime.getRuntime();

	public static String currentClassMethod() {
		StackTraceElement[] ste = new Exception().getStackTrace();
		int ndx = (ste.length > 1) ? 1 : 0;
		return new Exception().getStackTrace()[ndx].toString();
	}

	public static String currentMethodName() {
		StackTraceElement[] ste = new Exception().getStackTrace();
		int ndx = (ste.length > 1) ? 1 : 0;
		return new Exception().getStackTrace()[ndx].getMethodName();
	}

	public static String currentClassName() {
		StackTraceElement[] ste = new Exception().getStackTrace();
		int ndx = (ste.length > 1) ? 1 : 0;
		return new Exception().getStackTrace()[ndx].getClassName();
	}

	public static String currentNamespace() {
		StackTraceElement[] ste = new Exception().getStackTrace();
		int ndx = (ste.length > 1) ? 1 : 0;
		StackTraceElement current = new Exception().getStackTrace()[ndx];
		return current.getClassName() + "." + current.getMethodName();
	}

	public static long availableMemory() {
		return RUNTIME.freeMemory()
				+ (RUNTIME.maxMemory() - RUNTIME.totalMemory());
	}

	public static float availableMemoryPercent() {
		return availableMemory() * 100.0f / RUNTIME.maxMemory();
	}

	public static void compactMemory() {
		try {
			final byte[][] unused = new byte[128][];
			for (int i = unused.length; i-- != 0;) {
				unused[i] = new byte[2000000000];
			}
		} catch (OutOfMemoryError ignore) {
		}
		System.gc();
	}

	public static String classLocation(Class<?> clazz) {
		if (clazz == null) {
			return null;
		}
		return clazz.getProtectionDomain().getCodeSource().getLocation()
				.getPath();
	}

	public static String classLocation() {
		return classLocation(RuntimeUtil.class);
	}

}
