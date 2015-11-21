package com.richardxu.gof.abstract_factory;

public class American implements Person {

	@Override
	public void speak(String msg) {
		System.out.println("Speak [" + msg + "] in english!");
	}

}
