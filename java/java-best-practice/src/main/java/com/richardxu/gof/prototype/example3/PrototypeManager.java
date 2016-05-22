package com.richardxu.gof.prototype.example3;

import java.util.HashMap;
import java.util.Map;

/**
 * 原型管理器
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月20日 上午1:04:44
 */
public class PrototypeManager {
	/**
	 * 用来记录原型的编号和原型实例的对应关系
	 */
	private static Map<String, Prototype> map = new HashMap<String, Prototype>();
	
	private PrototypeManager() {
		
	}
	
	/**
	 * 向原型管理器添加或修改某个原型注册
	 * @param prototypeId
	 * @param prototype
	 */
	public synchronized static void setPrototype(String prototypeId, Prototype prototype) {
		map.put(prototypeId, prototype);
	}
	
	/**
	 * 从原型管理器里面删除某个原型注册
	 * @param prototypeId
	 */
	public synchronized static void removePrototype(String prototypeId) {
		map.remove(prototypeId);
	}
	
	public synchronized static Prototype getPrototype(String prototypeId) throws Exception {
		Prototype prototype = map.get(prototypeId);
		if (prototype == null) {
			throw new Exception("原型还没有注册或已被销毁");
		}
		return prototype;
	}
}
