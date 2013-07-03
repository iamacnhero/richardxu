package com.xufeng.example.thread.producerconsumer;

/*
 * Object类是所有类的父类，在此类中有以下几种方法是对线程操作有所支持的：
   1. public final void wait() throws InterruptedException: 线程等待
   2. public final void wait(long timeout) throws InterruptedException: 线程等待，并指定等待的最长时间，以毫秒为单位
   3. public final void wait(long timeout, int nanos) throws Interrupted Exception: 线程等待，并指定等待的最长毫秒及纳秒
   4. public final void notify(): 唤醒第1个等待的线程
   5. public final void notifyAll(): 唤醒全部等待的线程
 *
*/

public class Test {
	public static void main(String[] args) throws Exception {
		Info i = new Info();
		Producer p = new Producer(i);
		Consumer c = new Consumer(i);
		new Thread(p).start();
		new Thread(c).start();
	}
}
