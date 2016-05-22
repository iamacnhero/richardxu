package com.richardxu.gof.singleton;

/**
 * 使用双重检查机制
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月16日
 */
public class SingletonDoubleCheck {

	/**
	 * 对保存实例的变量添加volatile的修饰
	 */
	private volatile static SingletonDoubleCheck instance = null;
	
	private SingletonDoubleCheck() {
		
	}
	
	/**
	 * 或者使用双重加锁机制：并不是每次进入getInstance方法都需要同步，而是先不同步，进入方法过后，先检查实例是否存在；
	 * 如果不存在才进入下面的同步块，这是第一重检查。进入同步块过后，再次检查实例是否存在，如果不存在，就在同步块的情况下创建一个实例，
	 * 这是第二重检查
	 */
	public static SingletonDoubleCheck getInstance() {
		// 先检查实例是否存在，如果不存在才进入下面的同步块
		if (instance == null) {
			// 同步块，线程安全地创建实例
			synchronized (SingletonDoubleCheck.class) {
				// 再次检查实例是否存在，如果不存在才真正地创建实例
				if (instance == null) {
					instance = new SingletonDoubleCheck();
				}
			}
		}
		return instance;
	}
	
}
