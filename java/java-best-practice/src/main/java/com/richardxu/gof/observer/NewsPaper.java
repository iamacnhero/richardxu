package com.richardxu.gof.observer;

/**
 * 报纸——具体的目标对象，负责把有关状态存入到相应的观察者对象，
 * 并在自己状态发生改变时，通知各个观察者 
 */
public class NewsPaper extends Subject {
	
	private String content;			// 报纸的具体内容 

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		notifyObservers();			// 内容有了，说明又出报纸了，通知所有的读者
	}
	
}
