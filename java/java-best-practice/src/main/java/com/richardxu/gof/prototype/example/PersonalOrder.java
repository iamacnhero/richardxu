package com.richardxu.gof.prototype.example;

public class PersonalOrder implements OrderApi {
	
	private String customerName;
	private String productId;
	private int orderProductNum = 0;
	
	@Override
	public OrderApi cloneOrder() {
		// 创建一个新的订单，然后把本实例的数据复制过去
		PersonalOrder order = new PersonalOrder();
		order.setCustomerName(this.customerName);
		order.setProductId(this.productId);
		order.setOrderProductNum(this.orderProductNum);
		return order;
	}
	
	public String toString() {
		return "个人订单的订购人是: " + this.customerName + ", 订购产品是：" + this.productId + ", 订购数量为：" + orderProductNum;
	}

	@Override
	public int getOrderProductNum() {
		return this.orderProductNum;
	}

	@Override
	public void setOrderProductNum(int num) {
		this.orderProductNum = num;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}
