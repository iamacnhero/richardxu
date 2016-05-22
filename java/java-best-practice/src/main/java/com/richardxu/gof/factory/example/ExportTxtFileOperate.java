package com.richardxu.gof.factory.example;

public class ExportTxtFileOperate extends ExportOperate {

	@Override
	protected ExportFileApi factoryMethod() {
		return new ExportTxtFile();
	}

}
