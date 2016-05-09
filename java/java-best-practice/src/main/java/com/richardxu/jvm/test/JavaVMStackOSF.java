package com.richardxu.jvm.test;

/**
 * java.lang.StackOverflowError demo
 * VM Args: -Xss128k
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年5月8日 下午11:28:30
 */
public class JavaVMStackOSF {
	private int stackLength = 1;
	
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) {
		JavaVMStackOSF oom = new JavaVMStackOSF();
		try {
			oom.stackLeak();
		} catch (Exception e) {
			System.out.println("stack length: " + oom.stackLength);
			throw e;
		}
	}
}
