package com.richardxu.dynamicproxy.greet;

import java.lang.reflect.Proxy;

/**
 * 进行对象转换的工厂方法 在实际使用中，如果遇到GreetV1接口的实现，只需要将调用GreetFactory的adaptGreet方法转换成GreetV2接口，再按照GreetV2接口的方式来使用即可。
 * GreetV1接口可以继续在遗留代码中使用。
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年6月5日
 */
public class GreetFactory {
	public static GreetV2 adaptGreet(GreetV1 greet) {
		GreetAdapter adapter = new GreetAdapter(greet);
		ClassLoader cl = greet.getClass().getClassLoader();
		return (GreetV2) Proxy.newProxyInstance(cl, new Class<?>[] { GreetV2.class }, adapter);
	}
}
