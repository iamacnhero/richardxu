package com.richardxu.gof.command.example2;

import com.richardxu.gof.command.Command;

/**
 * 重启机器命令的实现，实现Command接口
 * 持有重启机器命令的真正实现，通过调用接收者的方法来实现命令
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年5月2日
 */
public class ResetCommand implements Command {
	
	/**
	 * 持有真正实现命令的接收者——主板对象
	 */
	private MainBoardApi mainBoard;
	
	public ResetCommand(MainBoardApi mainBoard) {
		this.mainBoard = mainBoard;
	}

	@Override
	public void execute() {
		// 命令对象根本不知道如何重启机器，会转调主板对象，让主板去完成重启机器的功能
		mainBoard.reset();
	}

}
