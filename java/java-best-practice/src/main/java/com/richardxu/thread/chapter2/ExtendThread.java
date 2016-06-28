package com.richardxu.thread.chapter2;

import java.util.concurrent.TimeUnit;

/**
 * 第一种创建线程的方式是extends Thread, 然后覆盖run()方法
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年6月27日
 */
public class ExtendThread extends Thread {
	public void run() {
		super.run();
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Thread A");
	}
}