package com.richardxu.gof.observer.java;

/**
 * 使用观察者模式 
 */
public class Client {
	public static void main(String[] args) {
		// 创建一张报纸，作为被观察者
		NewsPaper subject = new NewsPaper();
		
		// 创建阅读者，也就是观察者
		Reader reader1 = new Reader();
		reader1.setName("张三");
		
		Reader reader2 = new Reader();
		reader2.setName("李四");
		
		// 注册读者
		subject.addObserver(reader1);
		subject.addObserver(reader2);
		
		// 要出报纸啦
		subject.setContent("本期内容是观察者模式");
	}
}
