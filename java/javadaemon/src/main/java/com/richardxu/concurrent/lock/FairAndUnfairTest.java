package com.richardxu.concurrent.lock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class FairAndUnfairTest {
	private static Lock fairLock = new ReentrantLock2(true);
	private static Lock unfairLock = new ReentrantLock2(false);
	
	@SuppressWarnings("serial")
	private static class ReentrantLock2 extends ReentrantLock {
		public ReentrantLock2(boolean fair) {
			super(fair);
		}
		public Collection<Thread> getQueuedThreads() {
			List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
			Collections.reverse(arrayList);
			return arrayList;
		}
	}
	
	@Test
	public void fair() {
		testLock(fairLock);
	}
	
	@Test
	public void unfair() {
		testLock(unfairLock);
	}
	
	private void testLock(Lock lock) {
		// 启动5个Job
		for (int i = 0; i < 10; i++) {
			new Job(lock).start();
		}
	}
	
	private static class Job extends Thread {
		@SuppressWarnings("unused")
		private Lock lock;
		public Job(Lock lock) {
			this.setLock(lock);
		}
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}
		public void setLock(Lock lock) {
			this.lock = lock;
		}
	}
}
