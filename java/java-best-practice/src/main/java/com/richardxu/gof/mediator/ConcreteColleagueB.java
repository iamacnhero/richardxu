package com.richardxu.gof.mediator;

public class ConcreteColleagueB extends Colleague {

	public ConcreteColleagueB(Mediator mediator) {
		super(mediator);
	}
	
	/**
	 * 示意方法，执行某些业务功能
	 */
	public void someOperation() {
		getMediator().changed(this);
	}
	
}
