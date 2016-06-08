package com.richardxu.threadgof;

public class Test {
	public static void main(String[] args) {
		final ThreadSafeCounter counter = new ThreadSafeCounter();
		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					counter.increment();
				}
			}.start();
		}

		System.out.println(counter.get());

		final NonThreadSafeCounter counter2 = new NonThreadSafeCounter();
		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					counter2.increment();
				}
			}.start();
		}

		System.out.println(counter2.get());
	}
}
