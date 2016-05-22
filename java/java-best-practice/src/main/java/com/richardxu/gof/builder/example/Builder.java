package com.richardxu.gof.builder.example;

import java.util.Collection;
import java.util.Map;

/**
 * 
 * 生产器接口：定义创建一个输出文件对象所需的各个部件的操作
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月16日
 */
public interface Builder {
	
	void buildHeader(ExportHeaderModel ehm);
	
	void buildBody(Map<String, Collection<ExportDataModel>> mapData);
	
	void buildFooter(ExportFooterModel efm);
	
	StringBuffer getResult();
	
}