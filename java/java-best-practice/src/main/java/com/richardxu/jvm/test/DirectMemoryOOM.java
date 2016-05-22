package com.richardxu.jvm.test;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * Exception in thread "main" java.lang.OutOfMemoryError  demo
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * DirectMemory容量可通过 -XX:MaxDirectMemorySize指定，如果不指定，则默认与Java堆
 * 最大值(-Xmx)一样。
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年5月9日 上午12:36:31
 */
public class DirectMemoryOOM {
	private static final int _1MB = 1024 * 1024;
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Field unsafeFiled = Unsafe.class.getDeclaredFields()[0];
		unsafeFiled.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeFiled.get(null);
		while (true) {
			unsafe.allocateMemory(_1MB);
		}
	}
}
