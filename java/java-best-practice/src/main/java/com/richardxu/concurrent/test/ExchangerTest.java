package com.richardxu.concurrent.test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 进行数据交换
 */
public class ExchangerTest {
	private static void exchangeData(ExecutorService service, final Exchanger<String> change, final String data) {
		service.submit(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName() + " is exchanging data: " + data);
					Thread.sleep(1000);
					String data2 = change.exchange(data, 1000, TimeUnit.MILLISECONDS);
					System.out.println(Thread.currentThread().getName() + " get data: " + data2);
				} catch (Exception e) {
					// 
				}
			}
		});
	}
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final Exchanger<String> change = new Exchanger<>();
		exchangeData(service, change, "a");
		exchangeData(service, change, "b");
		exchangeData(service, change, "c");
		exchangeData(service, change, "d");
		service.shutdown();
	}
}
