package com.richardxu.gof.builder.example2;

/**
 * 保险合同的对象——内联化
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月16日
 */
public class InsuranceContractInline {
	private String contractId;		// 合同编号
	private String personName;		// 被保险人员的名称
	private String companyName;		// 被保险公司的名称
	private long beginDate;			// 保险开始生效的日期
	private long endDate;			// 保险失效的日期，一定会大于保险开始生效的日期
	private String otherDate;		// 其他数据

	private InsuranceContractInline(ConcreteBuilder builder) {
		this.contractId = builder.contractId;
		this.personName = builder.personName;
		this.companyName = builder.companyName;
		this.beginDate = builder.beginDate;
		this.endDate = builder.endDate;
		this.otherDate = builder.otherDate;
	}
	
	/**
	 * 构造保险合同对象的构建器，作为保险合同的内部类 
	 */
	public static class ConcreteBuilder {
		private String contractId;
		private String personName;
		private String companyName;
		private long beginDate;
		private long endDate;
		private String otherDate;
		
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
		public InsuranceContractInline build() {
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
			
			return new InsuranceContractInline(this);
		}
	}

	/**
	 * 示意：保险合同的某些操作
	 */
	public void someOperation() {
		System.out.println("Now in Insurance Contract someOperation==" + this.contractId);
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
	
}