package com.richardxu.gof.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标对象，它知道观察它的观察者，并提供注册和删除观察者的接口
 */
public class Subject {
	// 用来保存注册的观察者对象
	private List<Observer> readers = new ArrayList<Observer>();
	
	// 注册观察者对象
	public void attach(Observer reader) {
		readers.add(reader);
	}
	
	// 删除观察者对象
	public void detach(Observer observer) {
		readers.remove(observer);
	}
	
	protected void notifyObservers() {
		for (Observer reader : readers) {
			reader.update(this);
		}
	}
}
