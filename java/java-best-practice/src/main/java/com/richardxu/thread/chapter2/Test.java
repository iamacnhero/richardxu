package com.richardxu.thread.chapter2;

import java.util.concurrent.FutureTask;

public class Test {
	public static void main(String[] args) {
		System.out.println("main thread start");
		ExtendThread t = new ExtendThread();
		t.start();
		
		Thread t2 = new Thread(new RunnableThread());
		t2.start();
		
		CallableThread t3 = new CallableThread();
		FutureTask<String> futureTask = new FutureTask<String>(t3);
		new Thread(futureTask).start();				// 注意启动方式有点不一样
		try {
			System.out.println("Result is: " + futureTask.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("main thread end!");
	}
}
