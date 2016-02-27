package com.richardxu.exception;

import java.math.BigDecimal;

/**
 * 继承自支持国际化异常消息的异常类的子类
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年2月27日
 */
public class InsufficientBalanceException extends LocalizedException {

	private static final long serialVersionUID = 5716796776843738352L;
	
	private BigDecimal requested;
	private BigDecimal balance;
	private BigDecimal shortage;
	
	public InsufficientBalanceException(BigDecimal requested, BigDecimal balance) {
		super("INSUFFICIENT_BALANCE_EXCEPTION");
		this.requested = requested;
		this.balance = balance;
		this.shortage = requested.subtract(balance);
	}

	@Override
	public String getLocalizedMessage() {
		return format(balance, requested, shortage);
	}

}