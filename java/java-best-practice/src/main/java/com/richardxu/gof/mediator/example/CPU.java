package com.richardxu.gof.mediator.example;

public class CPU extends Colleague {
	
	private String videoData = "";
	private String soundData = "";

	public CPU(Mediator mediator) {
		super(mediator);
	}

	public String getVideoData() {
		return videoData;
	}

	public void setVideoData(String videoData) {
		this.videoData = videoData;
	}

	public String getSoundData() {
		return soundData;
	}

	public void setSoundData(String soundData) {
		this.soundData = soundData;
	}
	
	public void executeData(String data) {
		String[] ss = data.split(",");
		this.videoData = ss[0];
		this.soundData = ss[1];
		this.getMediator().changed(this);
	}

}
