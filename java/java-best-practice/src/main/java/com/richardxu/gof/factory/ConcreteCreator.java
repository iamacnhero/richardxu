package com.richardxu.gof.factory;

public class ConcreteCreator extends Creator {

	@Override
	protected Product factoryMethod() {
		// 返回一个具体的Product对象
		return new ConcreteProduct();
	}
	
}
