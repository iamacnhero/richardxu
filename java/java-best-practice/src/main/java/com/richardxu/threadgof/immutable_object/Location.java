package com.richardxu.threadgof.immutable_object;

/**
 * 状态可变的位置信息模型（非线程安全） 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年6月7日
 */
public class Location {
	private double x;
	private double y;
	
	public Location(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setXY(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
}