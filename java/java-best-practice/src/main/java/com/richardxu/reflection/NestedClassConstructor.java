package com.richardxu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用反射获取构造器
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年6月5日
 */
public class NestedClassConstructor {
	
	static class StaticNestedClass {
		public StaticNestedClass(String name) {
			
		}
	}

	class NestedClass {
		public NestedClass(int count) {
			
		}
	}
	
	public void useNestedClassConstructor() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<StaticNestedClass> sncc = StaticNestedClass.class.getConstructor(String.class);
		sncc.newInstance("Alex");
		Constructor<NestedClass> ncc = NestedClass.class.getDeclaredConstructor(NestedClassConstructor.class, int.class);
		
		// 在获取非静态嵌套类的构造方法的时候，类型参数列表的第一个值必须是外部类的Class对象
		@SuppressWarnings("unused")
		NestedClass ic = ncc.newInstance(this, 3);
	}

}
