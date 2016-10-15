package com.dbms.healthsupport.domain;

import java.util.List;

public class HealthSupporter extends People {
	
	Long contactNumber;
	List<String> patients;    

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public HealthSupporter(Long ssn, String firstName, String lastName, String address, Long contactNumber) {
		super(ssn, firstName, lastName, address);
		this.contactNumber = contactNumber;
	}



}
