package com.richardxu.gof.mediator;

/**
 * 中介者，定义各个同事对象通信的接口 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月20日 上午2:13:05
 */
public interface Mediator {

	/**
	 * 同事对象在自身改变的时候来通知中介者的方法，
	 * 让中介者去负责相应的与其他同事对象的交互
	 * @param colleague
	 */
	void changed(Colleague colleague);

}
