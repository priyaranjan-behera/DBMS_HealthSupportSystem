package com.dbms.healthsupport.domain;

import java.sql.Date;

public class Patient extends People {
	
	Date dob;
	String gender;
	
	
	public Patient(Long ssn, String firstName, String lastName, String address, Date dob, String gender) {
		super(ssn, firstName, lastName, address);
		this.dob = dob;
		this.gender = gender;
	}
	
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
