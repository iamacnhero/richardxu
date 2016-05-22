package com.richardxu.gof.prototype;

/**
 * 克隆的具体实现对象 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月18日 上午12:09:40
 */
public class ConcretePrototype2 implements Prototype {
	public Prototype clone() {
		// 最简单的克隆，就建一个自身对象，由于没有属性，就不再复制值了
		Prototype prototype = new ConcretePrototype2();
		return prototype;
	}

}
