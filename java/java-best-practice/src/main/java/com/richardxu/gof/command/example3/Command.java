package com.richardxu.gof.command.example3;

public interface Command {
	/**
	 * 执行命令对应的操作
	 */
	void execute();
	
	/**
	 * 执行撤销命令对应的操作
	 */
	void undo();
}
