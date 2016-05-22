package com.richardxu.gof.prototype.example2;

/**
 *  
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月20日 上午12:46:36
 */
public class Product implements Cloneable {
    
    /**
     * 产品编号
     */
    private String productId;
    
    /**
     * 产品名称 
     */
    private String name;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + "]";
	}

	@Override
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
    
}
