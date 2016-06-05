package com.richardxu.reflection;

import java.lang.reflect.Field;

/**
 * 使用反射获取 Field
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年6月5日
 */
public class ReflectField {
	private int count;
	private String name;
	
	public void useField() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field fieldCount = ReflectField.class.getDeclaredField("count");
		fieldCount.set(this, 3);
		Field fieldName = ReflectField.class.getDeclaredField("name");
		fieldName.set(this, "Bob");
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ReflectField [count=" + count + ", name=" + name + "]";
	}

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		ReflectField f = new ReflectField();
		try {
			f.useField();
			System.out.println(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
