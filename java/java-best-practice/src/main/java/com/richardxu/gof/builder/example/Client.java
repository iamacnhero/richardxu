package com.richardxu.gof.builder.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Client {
	public static void main(String[] args) {
		ExportHeaderModel ehm = new ExportHeaderModel();
		ehm.setDeptId("第一分公司");
		ehm.setExportDate("2016-04-16");
		
		Map<String, Collection<ExportDataModel>> mapData = new HashMap<String, Collection<ExportDataModel>>();
		Collection<ExportDataModel> col = new ArrayList<ExportDataModel>();
		
		ExportDataModel edm1 = new ExportDataModel();
		edm1.setProductId("001");
		edm1.setPrice(100);
		edm1.setAmount(80);
		col.add(edm1);
		
		ExportDataModel edm2 = new ExportDataModel();
		edm2.setProductId("002");
		edm2.setPrice(99);
		edm2.setAmount(55);
		col.add(edm2);
		
		ExportDataModel edm3 = new ExportDataModel();
		edm3.setProductId("003");
		edm3.setPrice(120);
		edm3.setAmount(60);
		col.add(edm3);
		mapData.put("销售记录表", col);
		
		ExportFooterModel efm = new ExportFooterModel();
		efm.setExportUser("张三");
		
		Director director = new Director(new TxtBuilder());
		director.construct(ehm, mapData, efm);
		System.out.println(director.getBuilder().getResult());
		
		director = new Director(new XmltBuilder());
		director.construct(ehm, mapData, efm);
		System.out.println(director.getBuilder().getResult());
	}
}
