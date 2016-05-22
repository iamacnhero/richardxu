package com.richardxu.utils;

import java.util.Random;
import org.junit.Test;

/**
 * 1. 使用DbUnit进行数据库集成测试
 * 2. 用JUnitPerf进行性能测试
 * 3. 用SoapUI测试Web服务
 * 4. 使用Eclipse插件TPTP进行性能分析
 * 5. 用SchemaSpy查看数据库结构
 * 6. 用Doxygen生成源代码文档
 * 7. 用UmlGraph在Javadoc中嵌入UML图表 
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2015年11月22日
 */
public class TestA {
	// timeout 设置时间上限
	@Test(timeout = 1)
	public void testTimeConsume() {
		for (int i = 0; i < 10; i++) {
			System.out.println(new Random(i));
		}
	}
	
	// 如果没有抛出IllegalArgumentException, 测试将失败
	@Test(expected = IllegalArgumentException.class)
	public void testException() {
		testMethod(3000);
	}
	
	static void testMethod(int year) {
		if (year > 2000)
			throw new IllegalArgumentException();
		else 
			System.out.println(year);
	}
	
}