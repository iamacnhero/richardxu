package com.richardxu.gof.prototype.example3;

public interface Prototype {
	Prototype clone();
	String getName();
	void setName(String name);
}
