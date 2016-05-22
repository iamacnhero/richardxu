package com.richardxu.exception;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * 支持国际化异常消息的异常类的基类
 * 在使用时，每个需要国际化的异常类只需要继承 LocalizedException，并实现getLocalizedMessage方法即可。
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年2月27日
 */
public abstract class LocalizedException extends Exception {

	private static final long serialVersionUID = 2880085556617222298L;
	
	private static String DEFAULT_BASE_NAME = "com/richard/java7/messages";
	
	private String baseName = DEFAULT_BASE_NAME;
	protected ResourceBundle resouceBundle;
	private String messageKey;
	
	public LocalizedException(String messageKey) {
		this.messageKey = messageKey;
		initResourceBundle();
	}
	
	public LocalizedException(String messageKey, String baseName) {
		this.messageKey = messageKey;
		this.setBaseName(baseName);
		initResourceBundle();
	}

	private void initResourceBundle() {
		resouceBundle = ResourceBundle.getBundle(getBaseName());
	}

	public String getBaseName() {
		return baseName;
	}

	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}
	
	public abstract String getLocalizedMessage();
	
	public String getMessage() {
		return getLocalizedMessage();
	}
	
	protected String format(Object...args) {
		String message = resouceBundle.getString(messageKey);
		return MessageFormat.format(message, args);
	}

}