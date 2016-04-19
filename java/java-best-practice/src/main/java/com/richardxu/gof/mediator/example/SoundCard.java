package com.richardxu.gof.mediator.example;

public class SoundCard extends Colleague {
	
	public SoundCard(Mediator mediator) {
		super(mediator);
	}

	public void soundData(String data) {
		System.out.println("画外音: " + data);
	}

}
