package com.richardxu.gof.prototype.example;

/**
 * 订单接口，声明了可以克隆自身的方法 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月18日 上午12:16:13
 */
public interface OrderApi {
	
	int getOrderProductNum();
	
	void setOrderProductNum(int num);
	
	// 克隆方法
	OrderApi cloneOrder();
	
}
