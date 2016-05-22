package com.richardxu.gof.factory.example2;

public class Client {
	public static void main(String[] args) {
		ExportOperate operate = new ExportOperate();
		
		operate.export(1, "测试数据");
		operate.export(2, "测试数据");
		operate.export(3, "测试数据");
	}
}
