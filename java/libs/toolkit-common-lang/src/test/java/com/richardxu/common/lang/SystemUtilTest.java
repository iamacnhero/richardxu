package com.richardxu.common.lang;

import org.junit.Test;

public class SystemUtilTest {

	@Test
	public void test() {
	    SystemUtil.dumpSystemInfo();
	    
		// 检测是否大于等于1.6版本
		System.out.println(SystemUtil.getJavaInfo().isJavaVersionAtLeast(160));
	}
}
