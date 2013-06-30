package com.xufeng.example.thread.producerconsumer;

public class Producer implements Runnable {   // 定义生产者线程
	private Info info = null;

	public Producer(Info info) {
		this.info = info;
	}

	public void run() {
		boolean flag = false;		// 定义标记位
		for (int i = 0; i < 50; i++) {		// 循环50次
			if (flag) {		// 如果为true, 则设置1个信息
				info.set("Xufeng", "Teacher");
				flag = false;		// 修改标记位
			} else {		// 如果为false, 则设置第2个信息
				info.set("taobao", "www.taobao.com");
				flag = true;	// 修改标记位
			}
		}
	}
}
