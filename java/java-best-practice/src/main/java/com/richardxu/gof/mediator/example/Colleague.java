package com.richardxu.gof.mediator.example;

public abstract class Colleague {
	private Mediator mediator;
	
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
