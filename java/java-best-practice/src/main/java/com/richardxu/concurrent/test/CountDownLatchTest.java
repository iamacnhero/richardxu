package com.richardxu.concurrent.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
	public static void main(String[] args) throws InterruptedException {
		// 开始的倒数锁
		final CountDownLatch begin = new CountDownLatch(1);
		// 结束的倒数锁
		final CountDownLatch end = new CountDownLatch(10);
		
		// 十名选手
		final ExecutorService exec = Executors.newFixedThreadPool(10);
		for (int index = 0; index < 10; index++) {
			final int NO = index + 1;
			Thread run = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						begin.await();
						Thread.sleep((long) Math.random() * 1000);
						System.out.println("No. " + NO + " arrived");
					} catch (Exception e) {
					} finally {
						end.countDown();
					}
				}
			});
			exec.submit(run);
		}
		System.out.println("Game start...");
		begin.countDown();
		end.await();
		System.out.println("Game end...");
		exec.shutdown();
	}
}
