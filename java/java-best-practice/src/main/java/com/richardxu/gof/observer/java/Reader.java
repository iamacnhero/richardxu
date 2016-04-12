package com.richardxu.gof.observer.java;

import java.util.Observable;
import java.util.Observer;

/**
 * 使用Java自身的Observer 
 */
public class Reader implements Observer {
	private String name;		// 读者姓名

	@Override
	public void update(Observable o, Object obj) {
		// 推的方式
		System.out.println(name + "收到报纸了，阅读先。目标推过来的内容是===" + obj);
		
		// 拉的方式
		System.out.println(name + "收到报纸了，阅读先。目标推过来的内容是===" + ((NewsPaper)o).getContent());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}