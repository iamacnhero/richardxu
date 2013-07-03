package com.xufeng.example.thread;

class MyThread implements Runnable {
	private boolean flag = true; // 定义标志位

	public void run() {
		int i = 0;
		while (this.flag) {
			while (true) {
				System.out.println(Thread.currentThread().getName()
						+ " is running, i = " + (i++));
			}
		}
	}

	/**
	 * 如何停止一个线程的执行呢？在多线程的开发中可以通过设置标志位的方式停止一个线程的运行
	 */
	public void stop() { // 编写停止方法
		this.flag = false; // 修改标志位
	}
}

public class StopThread {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		Thread t = new Thread(mt, "Thread");
		t.start(); // 启动线程
		mt.stop(); // 线程停止，修改标志位

	}

}
