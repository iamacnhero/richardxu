package com.richardxu.gof.mediator.example;

public class CDDriver extends Colleague {
	
	private String data = "";		// 光驱自身数据

	public CDDriver(Mediator mediator) {
		super(mediator);
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void readCD() {
		this.data = "设计模式,值得研究";
		this.getMediator().changed(this);
	}

}
