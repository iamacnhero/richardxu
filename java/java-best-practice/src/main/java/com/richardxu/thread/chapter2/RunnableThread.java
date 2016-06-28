package com.richardxu.thread.chapter2;

import java.util.concurrent.TimeUnit;

/**
 * 第二种创建线程的方式
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年6月27日
 */
public class RunnableThread implements Runnable {

	@Override
	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread currentThread = Thread.currentThread();
		System.out.println("Thread name: " + currentThread.getName());
		System.out.println("Thread activeCount: " + Thread.activeCount());
		System.out.println("Thread Id: " + currentThread.getId());
		System.out.println("Thread priority: " + currentThread.getPriority());
		System.out.println("Thread state: " + currentThread.getState());
		System.out.println("Thread threadGroup: " + currentThread.getThreadGroup());
		System.out.println("Thread B");
	}
	
}
