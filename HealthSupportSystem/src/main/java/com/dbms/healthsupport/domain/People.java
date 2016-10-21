package com.dbms.healthsupport.domain;

public class People {

	Long ssn;
	String firstName;
	String lastName;
	String address;
	String password; 
	

	public People(Long ssn, String firstName, String lastName, String address, String password) {
		super();
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.password = password;
	}
	
	public People(People people)
	{
		this.ssn = people.getSsn();
		this.firstName = people.getFirstName();
		this.lastName = people.getLastName();
		this.address = people.getAddress();
		this.password = people.getAddress();
		
	}


	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	
}
