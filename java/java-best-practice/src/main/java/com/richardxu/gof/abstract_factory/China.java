package com.richardxu.gof.abstract_factory;

public class China implements Country {

	@Override
	public Person createPerson() {
		return new American();
	}

	@Override
	public Language createLanguage() {
		return new Mandarin();
	}
	
}
