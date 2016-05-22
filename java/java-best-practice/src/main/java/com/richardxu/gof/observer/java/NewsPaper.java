package com.richardxu.gof.observer.java;

import java.util.Observable;

/**
 * 使用Java自身的Observable
 */
public class NewsPaper extends Observable {
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		// 内容有了，需要通知所有读者
		this.setChanged();
		// 推的方式
		this.notifyObservers(this.content);
		// 拉的方式
		// this.notifyObservers();
	}
	
}
