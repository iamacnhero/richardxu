package com.richardxu.gof.singleton;

public class Client {
	
	public static void main(String[] args) {
		AppConfig appConfig = AppConfig.getInstance();
		System.out.println(appConfig.getParameterA());
		System.out.println(appConfig.getParameterB());
	}
	
}
