package com.richardxu.gof.prototype.example2;

public class EnterpriseOrder implements Cloneable, OrderApi {
	
	private String enterpriseName;
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
		return "企业订单的订购企业是: " + this.enterpriseName + ", 订购产品是：" + this.productId + ", 订购数量为：" + orderProductNum;
	}

	@Override
	public int getOrderProductNum() {
		return this.orderProductNum;
	}

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
