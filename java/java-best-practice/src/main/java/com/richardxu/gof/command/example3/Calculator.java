package com.richardxu.gof.command.example3;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
	private Command addCmd;
	private Command substractCmd;
	
	/**
	 * 要实现可撤销操作，首先需要把操作过的命令记录下来，形成命令的历史列表，撤销的时候就从最后一个开始执行撤销
	 */
	private List<Command> undoCmds = new ArrayList<Command>();
	
	/**
	 * 还可以实现恢复的功能。为恢复设置一个可恢复的列表，需要恢复时从列表里取最后一个命令重新执行即可
	 */
	private List<Command> redoCmds = new ArrayList<Command>();
	
	/**
	 * 提供给客户使用，执行加法功能
	 */
	public void addPressed() {
		addCmd.execute();
		// 把操作记录到历史记录里面
		undoCmds.add(this.addCmd);
	}
	
	/**
	 * 提供给客户使用，执行减法功能
	 */
	public void substractPressed() {
		substractCmd.execute();
		// 把操作记录到历史记录里面
		undoCmds.add(this.substractCmd);
	}
	
	public void undoPressed() {
		if (undoCmds.size() > 0) {
			// 取出最后一个命令来撤销
			Command cmd = undoCmds.get(undoCmds.size() - 1);
			cmd.undo();
			// 如果还有恢复的功能，那就把这个命令记录到恢复的历史记录里
			redoCmds.add(cmd);
			// 然后把最后一个命令删除掉
			undoCmds.remove(cmd);
		} else {
			System.out.println("当前没有可撤销的命令");
		}
	}
	
	public void redoPressed() {
		if (redoCmds.size() > 0) {
			// 取出最后一个命令来重做
			Command cmd = redoCmds.get(redoCmds.size() - 1);
			cmd.execute();
			// 把这个命令记录到可撤销的历史记录里
			undoCmds.add(cmd);
			// 然后把最后一个命令删除掉
			redoCmds.remove(cmd);
		} else {
			System.out.println("没有可恢复的命令");
		}
	}

	public Command getAddCmd() {
		return addCmd;
	}

	public void setAddCmd(Command addCmd) {
		this.addCmd = addCmd;
	}

	public Command getSubstractCmd() {
		return substractCmd;
	}

	public void setSubstractCmd(Command substractCmd) {
		this.substractCmd = substractCmd;
	}

}
