package com.richardxu.thread.chapter2;

public class ThreadLocalMain {
	// 1. 通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
		}
	};

	public ThreadLocal<Integer> getThreadLocal() {
		return seqNum;
	}

	// 2. 获取下一个序列值
	public int getNextNum() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}

	private static class TestClient extends Thread {
		private ThreadLocalMain sn;

		public TestClient(ThreadLocalMain sn) {
			this.sn = sn;
		}

		public void run() {
			for (int i = 0; i < 3; i++) {
				// 3. 每个线程打出3个序列值
				System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn[" + sn.getNextNum() + "]");
			}
			sn.getThreadLocal().remove();
		}
	}
	
	public static void main(String[] args) {
		ThreadLocalMain sn = new ThreadLocalMain();
		// 4. 3个线程共享 sn，各自产生序列号
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
		t1.start();
		t2.start();
		t3.start();
	}

}
