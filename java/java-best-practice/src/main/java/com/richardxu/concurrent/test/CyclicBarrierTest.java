package com.richardxu.concurrent.test;

import java.util.concurrent.CyclicBarrier;

/**
 * 
 * {@link CyclicBarrier} 的字面意思是可循环使用的屏障。它要做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，
 * 直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续运行
 * 
 * CyclicBarrier 默认的构造方法是CyclicBarrier(int parties)，其参数表示屏障拦截的线程数量，每个线程调用await方法告诉
 * CyclicBarrier我已经到达了屏障，然后当前线程被阻塞。
 * 
 * CyclicBarrier 可用于多线程计算数据，最后合并计算结果的场景。
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2015年11月13日
 */
public class CyclicBarrierTest {
	public static void main(String[] args) {
		// CyclicBarrier(int parties, Runnable barrierAction) 构造，
		// 用于在线程到达屏障时，优先执行barrierAction，方便处理更复杂的业务场景
		final CyclicBarrier c = new CyclicBarrier(2, new A());
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					c.await();
				} catch (Exception e) {
				}
				System.out.println(1);
			}
		}).start();
		
		try {
			c.await();
		} catch (Exception e) {
		}
		System.out.println(2);
	}
	
	static class A implements Runnable {
		@Override
		public void run() {
			System.out.println(3);
		}
	}
}