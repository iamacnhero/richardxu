package com.richardxu.gof.command.example2;

import com.richardxu.gof.command.Command;

/**
 * 开机命令的实现，实现Command接口
 * 持有开机命令的真正实现，通过调用接收者的方法来实现命令
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年5月2日
 */
public class OpenCommand implements Command {
	/**
	 * 持有真正实现命令的接收者——主板对象
	 */
	private MainBoardApi mainBoard;
	
	public OpenCommand(MainBoardApi mainBoard) {
		this.mainBoard = mainBoard;
	}
	
	public void execute() {
		// 对于命令对象，根本不知道如何开机，会转调主板对象
		// 让主板去完成开机的功能
		mainBoard.open();
	}

	public MainBoardApi getMainBoard() {
		return mainBoard;
	}

	public void setMainBoard(MainBoardApi mainBoard) {
		this.mainBoard = mainBoard;
	}
	
}
