package com.richardxu.gof.singleton;

/**
 * 使用静态内部类的方式实现单例：推荐方式，既实现了懒加载，又保证了线程安全 
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月16日
 */
public class SingletonInLine {
	/**
	 * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例没有绑定关系，
	 * 而且只有被调用到时才会装载，从而实现了延迟加载
	 */
	private static class SingletonHolder {
		private static SingletonInLine instance = new SingletonInLine();
	}
	
	private SingletonInLine() {
		
	}
	
	public static SingletonInLine getInstance() {
		return SingletonHolder.instance;
	}
	
}
