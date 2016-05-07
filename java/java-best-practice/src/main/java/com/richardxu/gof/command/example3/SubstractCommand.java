package com.richardxu.gof.command.example3;

public class SubstractCommand implements Command {

	private OperationApi operation;
	private int opeNum;				// 操作的数据

	@Override
	public void execute() {
		operation.substract(opeNum);		// 转调接收者去真正执行功能，这个命令是做减法
	}

	@Override
	public void undo() {
		// 命令本身是做减法，那么撤销的时候就是做加法了
		operation.add(opeNum);
	}

	public SubstractCommand(OperationApi operation, int opeNum) {
		this.operation = operation;
		this.opeNum = opeNum;
	}

}
