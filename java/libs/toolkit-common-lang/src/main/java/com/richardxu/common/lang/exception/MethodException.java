/**
 * 
 */
package com.richardxu.common.lang.exception;

import java.lang.reflect.Method;

import com.richardxu.common.lang.exception.ChainedException;

/**
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * 
 * @version create on 2012-4-6 上午4:21:24
 */
public class MethodException extends ChainedException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7170667630753619203L;

	private Method method;

	/**
	 * 构造一个空的异常.
	 */
	public MethodException() {
		super();
	}

	/**
	 * 构造一个异常, 指明异常的详细信息.
	 * 
	 * @param message
	 *            详细信息
	 */
	public MethodException(String message) {
		super(message);
	}

	/**
	 * 构造一个异常, 指明引起这个异常的起因.
	 * 
	 * @param cause
	 *            异常的起因
	 */
	public MethodException(Throwable cause) {
		super(cause);
	}

	/**
	 * 构造一个异常, 指明引起这个异常的起因.
	 * 
	 * @param message
	 *            详细信息
	 * @param cause
	 *            异常的起因
	 */
	public MethodException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 构造一个异常, 指明引起这个异常的起因.
	 * 
	 * @param method
	 *            目标<code>Method</code>
	 * @param message
	 *            详细信息
	 */
	public MethodException(Method method, String message) {
		super(message);
		this.method = method;
	}

	/**
	 * 构造一个异常, 指明引起这个异常的起因.
	 * 
	 * @param method
	 *            目标<code>Method</code>
	 * @param message
	 *            详细信息
	 * @param cause
	 *            异常的起因
	 */
	public MethodException(Method method, String message, Throwable cause) {
		super(message, cause);
		this.method = method;
	}

	public Method getMethod() {
		return method;
	}

}
