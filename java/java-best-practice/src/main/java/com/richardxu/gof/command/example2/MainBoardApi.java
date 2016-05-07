package com.richardxu.gof.command.example2;

/**
 * 主板的接口
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年5月2日
 */
public interface MainBoardApi {
	/**
	 * 主板具有能开机的功能
	 */
	void open();
	
	/**
	 * 主板具有实现重启的功能
	 */
	void reset();
}