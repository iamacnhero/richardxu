package com.richardxu.gof.abstract_factory;

public class America implements Country {

	@Override
	public Person createPerson() {
		return new American();
	}

	@Override
	public Language createLanguage() {
		return new English();
	}
	
}
