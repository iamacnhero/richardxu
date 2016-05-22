package com.richardxu.gof.builder.example;

import java.util.Collection;
import java.util.Map;

/**
 * 
 * 指导者，指导使用生成器的接口来构建输出的文件的对象
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月16日
 */
public class Director {
	
	private Builder builder;
	
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	public void construct(ExportHeaderModel ehm, Map<String, Collection<ExportDataModel>> mapData, ExportFooterModel efm) {
		getBuilder().buildHeader(ehm);
		getBuilder().buildBody(mapData);
		getBuilder().buildFooter(efm);
	}

	public Builder getBuilder() {
		return builder;
	}

}