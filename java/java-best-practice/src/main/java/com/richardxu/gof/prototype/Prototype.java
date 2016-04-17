package com.richardxu.gof.prototype;

/**
 * 声明一个克隆自身的接口 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月18日 上午12:04:02
 */
public interface Prototype {
	/**
	 * 克隆自身的方法
	 * @return 一个从自身克隆出来的对象
	 */
	Prototype clone();
}
