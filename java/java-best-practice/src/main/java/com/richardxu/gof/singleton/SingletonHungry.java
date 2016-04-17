package com.richardxu.gof.singleton;

/**
 * 饥饿加载单例实现 
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月16日
 */
public class SingletonHungry {
	
	/**
	 * 定义一个变量来存储创建好的类实例
	 */
	private static SingletonHungry instance = new SingletonHungry();
	
	private SingletonHungry() {
	}
	
	public static SingletonHungry getInstance() {
		return instance;
	}
	
	/**
	 * 示意方法：单例可以有自己的操作
	 */
	public void singletonOperation() {
		// 
	}
	
	private String singletonData;	// 示意属性：单例可以有自己的属性
	
	public String getSingletonData() {
		return singletonData;
	}
	
}