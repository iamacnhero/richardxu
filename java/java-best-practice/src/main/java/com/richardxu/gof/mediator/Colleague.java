package com.richardxu.gof.mediator;

/**
 * 同事类的抽象父类 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月20日 上午2:09:27
 */
public abstract class Colleague {
	/**
	 * 持有中介者对象，每一个同事类都知道它的中介者对象
	 */
	private Mediator mediator;
	
	/**
	 * 构造方法，传入中介者对象
	 * @param mediator
	 */
	public Colleague(Mediator mediator) {
		this.setMediator(mediator);
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	
}