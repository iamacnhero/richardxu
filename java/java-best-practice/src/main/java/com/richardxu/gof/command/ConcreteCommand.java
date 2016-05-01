package com.richardxu.gof.command;

/**
 * 具体的命令实现对象
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年5月2日
 */
public class ConcreteCommand implements Command {
	
	/**
	 * 持有相应的接收者对象
	 */
	private Receiver receiver;
	
	/**
	 * 示意，命令对象可以有自己的状态
	 */
	private String state;
	
	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		// 通常会转调接收者对象的相应方法，让接收者来直接执行功能
		receiver.action();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
