package com.richardxu.gof.singleton;

/**
 * 懒加载单例实现: 体现了缓存的思想
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月16日
 */
public class SingletonLazy {
	
	/**
	 * 定义一个变量来存储创建好的类实例
	 */
	private static SingletonLazy instance = null;
	
	private SingletonLazy() {
	}
	
	/**
	 * 需要使用synchronized，不然就是不是线程安全的
	 * @return
	 */
	public static synchronized SingletonLazy getInstance() {
		if (instance == null) {
			instance = new SingletonLazy();
		}
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