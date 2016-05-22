package com.richardxu.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/**
 * InvocationHandler 接口的实现类
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年2月28日
 */
public class LoggingInvocationHandler implements InvocationHandler {
	
	private static final Logger logger = Logger.getLogger(LoggingInvocationHandler.class);
	
	private Object receiverObject;
	
	public LoggingInvocationHandler(Object object) {
		this.receiverObject = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		logger.log(Level.INFO, "调用方法 " + method.getName() + ", 参数为：" + Arrays.deepToString(args));
		return method.invoke(receiverObject, args);
	}

}
