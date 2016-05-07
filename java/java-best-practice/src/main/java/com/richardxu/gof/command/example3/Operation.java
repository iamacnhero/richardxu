package com.richardxu.gof.command.example3;

/**
 * 运算类，真正实现加减法运算
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年5月2日
 */
public class Operation implements OperationApi {
	/**
	 * 记录运算的结果
	 */
	private int result;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	public void add(int num) {
		result += num;
	}
	
	public void substract(int num) {
		result -= num;
	}
	
}
