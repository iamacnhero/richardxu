package com.richardxu.gof.command.example4;

/**
 * 命令接口，声明执行的操作
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年5月3日
 */
public interface Command {
	/**
	 * 执行命令对应的操作
	 */
	void execute();
}