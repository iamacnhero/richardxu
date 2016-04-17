package com.richardxu.gof.prototype.example;

public class EnterpriseOrder implements OrderApi {
	
	private String enterpriseName;
	private String productId;
	private int orderProductNum = 0;
	
	@Override
	public OrderApi cloneOrder() {
		// 创建一个新的订单，然后把本实例的数据复制过去
		EnterpriseOrder order = new EnterpriseOrder();
		order.setEnterpriseName(this.getEnterpriseName());
		order.setProductId(this.productId);
		order.setOrderProductNum(this.orderProductNum);
		return order;
	}
	
	public String toString() {
		return "企业订单的订购企业是: " + this.enterpriseName + ", 订购产品是：" + this.productId + ", 订购数量为：" + orderProductNum;
	}

	@Override
	public int getOrderProductNum() {
		return this.orderProductNum;
	}

	@Override
	public void setOrderProductNum(int num) {
		this.orderProductNum = num;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

}
