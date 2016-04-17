package com.richardxu.gof.factory;

/**
 * 创建器，声明工厂方法
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月17日 下午10:19:52
 */
public abstract class Creator {
	/**
	 * 创建Product的工厂方法
	 * @return
	 */
	protected abstract Product factoryMethod();
	
	/**
	 * 示意方法，实现某些功能的方法
	 */
	public void someOperation() {
		// 通常在这些方法实现中需要调用工厂方法来获取Product对象
		Product product = factoryMethod();
		System.out.println(product);
	}
}
