package com.richardxu.gof.builder.example2;

public class ConcreteBuilder {
	private String contractId;		// 合同编号
	private String personName;		// 被保险人员的名称
	private String companyName;		// 被保险公司的名称
	private long beginDate;			// 保险开始生效的日期
	private long endDate;			// 保险失效的日期，一定会大于保险开始生效的日期
	private String otherDate;		// 其他数据

	public ConcreteBuilder(String contractId, long beginDate, long endDate) {
		this.contractId = contractId;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public ConcreteBuilder setPersonName(String personName) {
		this.personName = personName;
		return this;
	}

	public ConcreteBuilder setCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	}

	public ConcreteBuilder setOtherData(String otherData) {
		this.otherDate = otherData;
		return this;
	}

	/**
	 * 构建真正的对象并返回，并考虑带约束规则，如果不合约束，抛出异常
	 * @return
	 */
	public InsuranceContract build() {
		if (contractId == null || contractId.trim().length() == 0) {
			throw new IllegalArgumentException("合同编号不能为空");
		}
		
		boolean signPerson = personName != null && personName.trim().length() > 0;
		boolean signCompany = companyName != null && companyName.trim().length() > 0;
		if (signPerson && signCompany) {
			throw new IllegalArgumentException("一份合同不能同时与人和公司签订");
		}
		
		if (signPerson == false && signCompany == false) {
			throw new IllegalArgumentException("一份合同不能没有签订对象");
		}
		
		if (beginDate <= 0) {
			throw new IllegalArgumentException("合同必须有保险开始生效的日期");
		}
		
		if (endDate <= 0) {
			throw new IllegalArgumentException("合同必须有保险失效的日期");
		}
		
		if (endDate <= beginDate) {
			throw new IllegalArgumentException("保险失效的日期必须大于保险生效的日期");
		}
		
		return new InsuranceContract(this);
	}

	public String getContractId() {
		return contractId;
	}

	public String getPersonName() {
		return personName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public long getBeginDate() {
		return beginDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public String getOtherDate() {
		return otherDate;
	}

}
