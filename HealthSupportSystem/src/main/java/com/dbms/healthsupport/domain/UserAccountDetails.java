package com.dbms.healthsupport.domain;

public class UserAccountDetails {
	
	String ssn;
	String password;
	
	public UserAccountDetails(String ssn, String password) {
		super();
		this.ssn = ssn;
		this.password = password;
	}
	
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
