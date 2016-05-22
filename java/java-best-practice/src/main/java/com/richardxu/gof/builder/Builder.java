package com.richardxu.gof.builder;

/**
 * 生成器接口，定义创建一个产品对象所需的各个部件的操作
 */
public interface Builder {

	void buildPart();	// 构建部件
	
}
