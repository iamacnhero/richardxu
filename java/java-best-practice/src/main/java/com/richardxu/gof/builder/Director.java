package com.richardxu.gof.builder;

/**
 * 
 * 指导者，指导使用生成器的接口来构建产品的对象
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月16日
 */
public class Director {
	private Builder builder;		// 持有当前需要使用的生成器对象
	
	/**
	 *  构造方法，传入生成器对象
	 */
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	/**
	 * 指导生成器构建最终的产品对象
	 */
	public void construct() {
		builder.buildPart();
	}
}
