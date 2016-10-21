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
	
	
	public HealthSupporter(Long ssn, String firstName, String lastName, String address,String password,Long contactNumber,List<String> patients) {
		super(ssn, firstName, lastName, address,password);
		// TODO Auto-generated constructor stub
		this.contactNumber=contactNumber;
		this.patients=patients;
	}    

	


}
