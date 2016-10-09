package com.dbms.healthsupport.domain;

public class People {

	public Integer getSsn() {
		return ssn;
	}
	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public People(Integer ssn, String firstName, String lastName) {
		super();
		this.ssn = ssn;
		FirstName = firstName;
		LastName = lastName;
	}
	Integer ssn;
	String FirstName;
	String LastName;
	
}
