package com.richardxu.examples.jdbc;

public class User {
	private Integer id;
	private Integer credits;
	private String lastIp;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCredits() {
		return credits;
	}

	public User() {
		super();
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public User(Integer credits, String lastIp) {
		super();
		this.credits = credits;
		this.lastIp = lastIp;
	}
	
}