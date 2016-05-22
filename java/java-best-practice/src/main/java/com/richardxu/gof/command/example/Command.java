package com.richardxu.gof.command.example;

/**
 * 命令接口，声明执行的操作
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年5月2日
 */
public interface Command {
	/**
	 * 执行命令相应的操作
	 */
	void execute();
}