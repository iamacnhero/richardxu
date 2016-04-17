package com.richardxu.gof.builder.example;

import java.util.Collection;
import java.util.Map;

public class XmltBuilder implements Builder {
	
	private StringBuffer buffer = new StringBuffer();	// 用于记录构建文件的内容，相当于产品

	@Override
	public void buildHeader(ExportHeaderModel ehm) {
		buffer.append("<?xml version='1.0' encoding='UTF-8' ?>\n");
		buffer.append("<report>\n");
		buffer.append("    <header>\n");
		buffer.append("        <deptId>" + ehm.getDeptId() + "</deptId>\n");
		buffer.append("        <exportDate>" + ehm.getExportDate() + "</exportDate>\n");
		buffer.append("    </header>\n");
	}

	@Override
	public void buildBody(Map<String, Collection<ExportDataModel>> mapData) {
		buffer.append("    <body>\n");
		for (String tblName : mapData.keySet()) {
			buffer.append("    <datas tableName=\"" + tblName + "\">\n");
			for (ExportDataModel edm : mapData.get(tblName)) {
				buffer.append("            <data>\n");
				buffer.append("                <productId>" + edm.getProductId() + "</productId>\n");
				buffer.append("                <price>" + edm.getPrice() + "</price>\n");
				buffer.append("                <amount" + edm.getAmount() + "</amount>\n");
				buffer.append("             </data>\n");
			}
			buffer.append("    </datas>\n");
		}
		buffer.append("    </body>\n");
	}
	
	@Override
	public void buildFooter(ExportFooterModel efm) {
		buffer.append("    <footer>\n");
		buffer.append("        <exportUser>" + efm.getExportUser() + "</exportUser>\n");
		buffer.append("    </footer>\n");
		buffer.append("</report>\n");
	}
	
	public StringBuffer getResult() {
		return buffer;
	}

}