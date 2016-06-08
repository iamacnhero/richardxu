package com.richardxu.threadgof;

/**
 * 非线程安全的计数器
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年6月7日
 */
public class NonThreadSafeCounter {
	private int counter = 0;

	public void increment() {
		counter++;
	}

	public int get() {
		return counter;
	}
}
