package com.richardxu.gof.command.example3;

/**
 * 操作运算的接口
 *  
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年5月2日
 */
public interface OperationApi {
	/**
	 * 获取计算完成后的结果
	 * @return
	 */
	int getResult();
	
	/**
	 * 设置计算开始的初始值
	 * @param result
	 */
	void setResult(int result);
	
	/**
	 * 执行加法
	 * @param num
	 */
	void add(int num);
	
	/**
	 * 执行减法
	 * @param num
	 */
	void substract(int num);
}