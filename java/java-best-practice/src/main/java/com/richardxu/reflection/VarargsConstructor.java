package com.richardxu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 获取变长参数
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年6月5日
 */
public class VarargsConstructor {
	public VarargsConstructor(String... names) {
	}

	public void useVarargsConstructor() throws NoSuchMethodException, SecurityException, InstantiationException,
		IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 如果构造方法声明了长度可变的参数，在获取构造方法时，要使用对象的数组类型的Class对象。这是因为长度可变的参数实际上是通过数组来实现的。
		// Constructor<?>[] constructors = Constructor.class.getDeclaredConstructors();
		Constructor<VarargsConstructor> constructor = VarargsConstructor.class.getDeclaredConstructor(String[].class);
		constructor.newInstance((Object) new String[] { "A", "B", "C" });
	}

}
