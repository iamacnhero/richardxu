package com.richardxu.threadgof;

/**
 * 线程安全的计数器
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年6月7日
 */
public class ThreadSafeCounter {
	private int counter = 0;

	public void increment() {
		synchronized (this) {
			counter++;
		}
	}

	public int get() {
		synchronized (this) {
			return counter;
		}
	}
}
