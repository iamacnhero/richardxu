package com.richardxu.gof.mediator.example;

public class VideoCard extends Colleague {
	
	public VideoCard(Mediator mediator) {
		super(mediator);
	}

	public void showData(String data) {
		System.out.println("您正观看的是: " + data);
	}

}
