package com.richardxu.gof.mediator.example;

public class MotherBoard implements Mediator {
	
	private CDDriver cdDriver = null;
	private CPU cpu = null;
	private VideoCard videoCard = null;
	private SoundCard soundCard = null;

	public CDDriver getCdDriver() {
		return cdDriver;
	}

	public void setCdDriver(CDDriver cdDriver) {
		this.cdDriver = cdDriver;
	}

	public CPU getCpu() {
		return cpu;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	public VideoCard getVideoCard() {
		return videoCard;
	}

	public void setVideoCard(VideoCard videoCard) {
		this.videoCard = videoCard;
	}

	public SoundCard getSoundCard() {
		return soundCard;
	}

	public void setSoundCard(SoundCard soundCard) {
		this.soundCard = soundCard;
	}

	@Override
	public void changed(Colleague colleague) {
		if (colleague == cdDriver) {
			this.openCDDriverReadData((CDDriver) colleague);
		} else if (colleague == cpu) {
			this.openCPU((CPU) colleague);
		}
	}

	private void openCPU(CPU colleague) {
		String videoData = cpu.getVideoData();
		String soundData = cpu.getSoundData();
		this.videoCard.showData(videoData);
		this.soundCard.soundData(soundData);
	}

	private void openCDDriverReadData(CDDriver cdDriver) {
		String data = cdDriver.getData();
		this.cpu.executeData(data);
	}

}
