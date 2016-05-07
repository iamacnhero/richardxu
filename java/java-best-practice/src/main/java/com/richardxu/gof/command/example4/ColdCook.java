package com.richardxu.gof.command.example4;

public class ColdCook implements CookApi {

	@Override
	public void cook(String name) {
		System.out.println("冷菜厨师正在做: " + name);
	}

}
