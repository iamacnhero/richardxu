package com.richardxu.thread.chapter2;

import java.util.concurrent.TimeUnit;

public class ThreadInterruptDemo implements Runnable {

	@Override
	public void run() {
		boolean stop = false;
		while (!stop) {
			System.out.println("Thread is running...");
			try {
				Thread.sleep(3L);
			} catch (InterruptedException e) {		// catch InterruptedException异常，对interrupted状态进行处理，否则线程不会结束
				break;
			}
		}
		System.out.println("Thread exiting under request...");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new ThreadInterruptDemo(), "InterruptDemo Thread");
		System.out.println("Starting thread...");
		thread.start();
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Interrupting thread....");
		thread.interrupt();
		System.out.println("线程是否中断：" + thread.isInterrupted());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Stopping app...");
	}

}
