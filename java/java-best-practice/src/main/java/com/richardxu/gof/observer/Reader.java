package com.richardxu.gof.observer;

public class Reader implements Observer {
	
	private String name;

	/*
	 * 拉的方式
	 */
	public void update(Subject subject) {
		System.out.println(name + "收到报纸了，阅读它。内容是===" + ((NewsPaper) subject).getContent());
	}
	
	/*
	 * 推的方式: 直接接收传入的数据
	 */
	public void update(String content) {
		System.out.println(name + "收到报纸了，阅读它。内容是===" + content);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}