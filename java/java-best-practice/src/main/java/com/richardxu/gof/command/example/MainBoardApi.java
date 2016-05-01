package com.richardxu.gof.command.example;

public interface MainBoardApi {
	/**
	 * 主板具有开机的功能
	 */
	void open();
	
	void shutdown();
}
