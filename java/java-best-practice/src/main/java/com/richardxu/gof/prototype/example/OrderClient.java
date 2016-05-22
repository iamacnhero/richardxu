package com.richardxu.gof.prototype.example;

public class OrderClient {
	public static void main(String[] args) {
		PersonalOrder op = new PersonalOrder();
		op.setOrderProductNum(2925);
		op.setCustomerName("张三");
		op.setProductId("001");
		
		OrderBusiness ob = new OrderBusiness();
		ob.saveOrder(op);
	}
}
