package com.richardxu.gof.factory.example;

public class Client {
	public static void main(String[] args) {
		ExportOperate operate = new ExportDBOperate();
		operate.export("测试数据");
	}
}
