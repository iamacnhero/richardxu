package com.richardxu.gof.factory.example;

public class ExportXml implements ExportFileApi {

	@Override
	public boolean export(String data) {
		System.out.println("导出数据  {" + data + "} 到XML文件");
		return true;
	}

}
