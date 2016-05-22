package com.richardxu.gof.command;

/**
 * 调用者
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年5月2日
 */
public class Invoker {
	/**
	 * 持有命令对象
	 */
	private Command command;
	
	/**
	 * 示意方法，要求命令执行请求
	 */
	public void runCommand() {
		// 调用命令对象的执行方法
		command.execute();
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	
}
