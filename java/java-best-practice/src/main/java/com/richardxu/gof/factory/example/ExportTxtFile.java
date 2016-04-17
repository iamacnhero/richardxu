package com.richardxu.gof.factory.example;

public class ExportTxtFile implements ExportFileApi {

	@Override
	public boolean export(String data) {
		// 简单示意一下，这里需要操作文件
		System.out.println("导出数据" + data + "到文本文件");
		return true;
	}

}
