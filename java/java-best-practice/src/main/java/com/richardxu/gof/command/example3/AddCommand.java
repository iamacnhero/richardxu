package com.richardxu.gof.command.example3;

public class AddCommand implements Command {
	
	private OperationApi operation;
	private int opeNum;				// 操作的数据

	@Override
	public void execute() {
		operation.add(opeNum);		// 转调接收者去真正执行功能，这个命令是做加法
	}

	@Override
	public void undo() {
		// 命令本身是做加法，那么撤销的时候就是做减法了
		operation.substract(opeNum);
	}
	
	public AddCommand(OperationApi operation, int opeNum) {
		this.operation = operation;
		this.opeNum = opeNum;
	}

}
