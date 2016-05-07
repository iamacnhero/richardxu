package com.richardxu.gof.command.example2;

import com.richardxu.gof.command.Command;

/**
 * 机箱对象，本身有按钮，持有按钮对应的命令对象
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年5月2日
 */
public class Box {
	/**
	 * 开机命令对象
	 */
	private Command openCommand;
	
	private Command resetCommand;

	public Command getOpenCommand() {
		return openCommand;
	}

	/**
	 * 设置开机命令对象
	 */
	public void setOpenCommand(Command openCommand) {
		this.openCommand = openCommand;
	}
	
	/**
	 * 提供给客户使用，接收并响应用户请求，相当于按钮被按下触发的方法
	 */
	public void openButtonPressed() {
		openCommand.execute();
	}
	
	public void resetButtonPressed() {
		resetCommand.execute();
	}

	public Command getResetCommand() {
		return resetCommand;
	}

	public void setResetCommand(Command resetCommand) {
		this.resetCommand = resetCommand;
	}
	
}
