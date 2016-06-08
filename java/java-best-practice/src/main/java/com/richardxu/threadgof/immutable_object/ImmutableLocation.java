package com.richardxu.threadgof.immutable_object;

/**
 * 状态不可变的位置信息模型
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年6月7日
 */
public class ImmutableLocation {
	public final double x;
	public final double y;

	public ImmutableLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
