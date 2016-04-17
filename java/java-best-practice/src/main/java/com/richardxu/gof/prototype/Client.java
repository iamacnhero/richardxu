package com.richardxu.gof.prototype;

/**
 * 使用原型的客户端 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月18日 上午12:11:18
 */
public class Client {
	/**
	 * 持有需要使用的原型接口对象
	 */
	private Prototype prototype;
	
	public Client(Prototype prototype) {
		this.prototype = prototype;
	}
	
	/**
	 * 示意方法，执行某个功能操作
	 */
	public void operation() {
		// 需要创建原型接口的对象
		@SuppressWarnings("unused")
		Prototype newPrototype = prototype.clone();
	}
}
