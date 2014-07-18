/**
 * 
 */
package com.richardxu.common.lang.exception;

import java.lang.reflect.Field;

import com.richardxu.common.lang.exception.ChainedException;

/**
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * 
 * @version create on 2012-4-5 上午2:26:30
 */
public class FieldException extends ChainedException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3255946957997566049L;
	
	private Field field;

	/**
	 * 构造一个空的异常.
	 */
	public FieldException() {
		super();
	}

	/**
	 * 构造一个异常, 指明异常的详细信息.
	 * 
	 * @param message
	 *            详细信息
	 */
	public FieldException(String message) {
		super(message);
	}

	/**
	 * 构造一个异常, 指明引起这个异常的起因.
	 * 
	 * @param cause
	 *            异常的起因
	 */
	public FieldException(Throwable cause) {
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
	public FieldException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 构造一个异常, 指明引起这个异常的起因.
	 * 
	 * @param field
	 *            目标<code>Field</code>
	 * @param message
	 *            详细信息
	 */
	public FieldException(Field field, String message) {
		super(message);
		this.field = field;
	}

	/**
	 * 构造一个异常, 指明引起这个异常的起因.
	 * 
	 * @param field
	 *            目标<code>Field</code>
	 * @param message
	 *            详细信息
	 * @param cause
	 *            异常的起因
	 */
	public FieldException(Field field, String message, Throwable cause) {
		super(message, cause);
		this.field = field;
	}

	public Field getField() {
		return field;
	}

}
