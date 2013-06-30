package com.xufeng.example.thread.producerconsumer;

public class Consumer implements Runnable { // 定义消费者线程
	private Info info = null;

	public Consumer(Info info) {
		this.info = info;
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			info.get();
		}
	}
}
