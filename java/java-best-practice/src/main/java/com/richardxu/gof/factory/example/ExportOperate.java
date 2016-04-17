package com.richardxu.gof.factory.example;

public abstract class ExportOperate {
	/**
	 * 导出文件
	 * @param data
	 * @return
	 */
	public boolean export(String data) {
		ExportFileApi api = factoryMethod();
		return api.export(data);
	}
	
	protected abstract ExportFileApi factoryMethod();
	
}
