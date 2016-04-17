package com.richardxu.gof.prototype.example2;

public class PersonalOrder implements OrderApi, Cloneable {
	
	private String customerName;
	private String productId;
	private int orderProductNum = 0;
	
	@Override
	public Object clone() {
		// 克隆方法的真正实现，直接调用父类的克隆方法就可以了
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public String toString() {
		return "个人订单的订购人是: " + this.customerName + ", 订购产品是：" + this.productId + ", 订购数量为：" + this.orderProductNum;
	}

	@Override
	public int getOrderProductNum() {
		return this.orderProductNum;
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

	public void setOrderProductNum(int orderProductNum) {
		this.orderProductNum = orderProductNum;
	}

}
