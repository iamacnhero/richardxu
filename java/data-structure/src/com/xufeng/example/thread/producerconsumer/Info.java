package com.xufeng.example.thread.producerconsumer;

/**
 * 定义生产消费的信息类
 * @author xufeng
 *
 */
public class Info {
	private String name = "Xufeng";
	private String content = "Teacher";
	private boolean flag = false; // 设置标志位

	public synchronized void set(String name, String content) {
		if (!flag) {
			try {
				super.wait(); // 等待消费者取走
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.setName(name);
		try {
			Thread.sleep(100); // 加入延迟
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setContent(content);
		flag = false;
		super.notify(); // 唤醒等待线程
	}

	public synchronized void get() {
		if (flag) {
			try {
				super.wait(); // 等待生产者生产
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(100); // 加入延迟
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(this.getName() + " ==> " + this.getContent()); // 取出信息
		flag = true;
		super.notify();
	}

	// set, get
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
