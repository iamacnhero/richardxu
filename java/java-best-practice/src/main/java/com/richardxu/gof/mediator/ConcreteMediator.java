package com.richardxu.gof.mediator;

public class ConcreteMediator implements Mediator {
	
	/**
	 * 持有并维护同事A
	 */
	private ConcreteColleagueA colleagueA;
	
	/**
	 * 持有并维护同事B
	 */
	private ConcreteColleagueB colleagueB;
	
	@Override
	public void changed(Colleague colleague) {
		// 某个同事类发生了变化，通常需要与其他同事交互，
		// 具体协调相应的同事对象来实现协作行为
	}

	public ConcreteColleagueA getColleagueA() {
		return colleagueA;
	}

	public void setColleagueA(ConcreteColleagueA colleagueA) {
		this.colleagueA = colleagueA;
	}

	public ConcreteColleagueB getColleagueB() {
		return colleagueB;
	}

	public void setColleagueB(ConcreteColleagueB colleagueB) {
		this.colleagueB = colleagueB;
	}

}