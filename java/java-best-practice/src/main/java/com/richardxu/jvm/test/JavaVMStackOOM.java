package com.richardxu.jvm.test;

/**
 * java.lang.OutOfMemoryError: unable to create new native thread demo
 * VM Args: -Xss2M
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年5月8日 下午11:32:29
 */
public class JavaVMStackOOM {
	private void dontStop() {
		while(true) {
		}
	}
	
	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
