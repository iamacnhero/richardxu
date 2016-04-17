package com.richardxu.gof.builder.example2;

/**
 * 保险合同的对象
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月16日
 */
public class InsuranceContract {
	private String contractId;		// 合同编号
	private String personName;		// 被保险人员的名称
	private String companyName;		// 被保险公司的名称
	private long beginDate;			// 保险开始生效的日期
	private long endDate;			// 保险失效的日期，一定会大于保险开始生效的日期
	private String otherDate;		// 其他数据

	public InsuranceContract(ConcreteBuilder builder) {
		this.contractId = builder.getContractId();
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(long beginDate) {
		this.beginDate = beginDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public String getOtherDate() {
		return otherDate;
	}

	public void setOtherDate(String otherDate) {
		this.otherDate = otherDate;
	}
	
	/**
	 * 示意：保险合同的某些操作
	 */
	public void someOperation() {
		System.out.println("Now in Insurance Contract someOperation==" + this.contractId);
	}

}
