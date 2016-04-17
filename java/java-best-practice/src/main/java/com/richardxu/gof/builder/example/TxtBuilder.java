package com.richardxu.gof.builder.example;

import java.util.Collection;
import java.util.Map;

public class TxtBuilder implements Builder {
	
	private StringBuffer buffer = new StringBuffer();	// 用于记录构建文件的内容，相当于产品

	@Override
	public void buildHeader(ExportHeaderModel ehm) {
		buffer.append(ehm.getDeptId() + "," + ehm.getExportDate() + "\n");
	}

	@Override
	public void buildBody(Map<String, Collection<ExportDataModel>> mapData) {
		for (String tblName : mapData.keySet()) {
			buffer.append(tblName + "\n");
			for (ExportDataModel edm : mapData.get(tblName)) {
				buffer.append(edm.getProductId() + "," + edm.getPrice() + "," + edm.getAmount() + "\n");
			}
		}
	}
	
	@Override
	public void buildFooter(ExportFooterModel efm) {
		buffer.append(efm.getExportUser());
	}
	
	public StringBuffer getResult() {
		return buffer;
	}

}