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
	public List<String> getPatients() {
		return patients;
	}
	public void setPatients(List<String> patients) {
		this.patients = patients;
	}
	
	
	public HealthSupporter(Long ssn, String firstName, String lastName, String address) {
		super(ssn, firstName, lastName, address);
		// TODO Auto-generated constructor stub
	}    

	


}
