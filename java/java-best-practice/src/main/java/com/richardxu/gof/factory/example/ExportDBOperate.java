package com.richardxu.gof.factory.example;

public class ExportDBOperate extends ExportOperate {

	@Override
	protected ExportFileApi factoryMethod() {
		return new ExportDB();
	}

}
