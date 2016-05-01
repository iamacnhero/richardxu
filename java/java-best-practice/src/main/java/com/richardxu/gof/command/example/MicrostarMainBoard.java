package com.richardxu.gof.command.example;

/**
 * 微星主板类，开机命令的真正实现者，在Command模式中充当Receiver
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年5月2日
 */
public class MicrostarMainBoard implements MainBoardApi {

	/**
	 * 真正的开机命令的实现
	 */
	public void open() {
		System.out.println("微星主板现在正在开机，请等候");
		System.out.println("开通电源...");
		System.out.println("设备检查...");
		System.out.println("装载系统...");
		System.out.println("机器正常运转起来...");
		System.out.println("机器已经正常打开，请操作");
	}
	
	public void shutdown() {
		System.out.println("关闭操作系统...");
		System.out.println("微星主板现在已关机");
	}

}
