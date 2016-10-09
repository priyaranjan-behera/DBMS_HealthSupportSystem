package com.dbms.healthsupport.domain;

public class UserAccountDetails {
	
	Long ssn;
	String password;
	
	public UserAccountDetails(Long ssn, String password) {
		super();
		this.ssn = ssn;
		this.password = password;
	}
	
	public Long getSsn() {
		return ssn;
	}
	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
