package com.dbms.healthsupport.domain;

import java.sql.Date;
import java.util.List;

import com.dbms.healthsupport.dao.HealthSupporterDetails;

public class Patient extends People {
	
	Date dob;
	String gender;
	
	HealthSupporterDetails primaryHealthSupporter;
	List<HealthSupporterDetails> secondaryHealthSupporters;
	
	public Patient(Long ssn, String firstName, String lastName, String address, Date dob, String gender,
			HealthSupporterDetails primaryHealthSupporter, List<HealthSupporterDetails> secondaryHealthSupporters) {
		super(ssn, firstName, lastName, address);
		this.dob = dob;
		this.gender = gender;
		this.primaryHealthSupporter = primaryHealthSupporter;
		this.secondaryHealthSupporters = secondaryHealthSupporters;
	}
	
	
	public HealthSupporterDetails getPrimaryHealthSupporter() {
		return primaryHealthSupporter;
	}
	public void setPrimaryHealthSupporter(HealthSupporterDetails primaryHealthSupporter) {
		this.primaryHealthSupporter = primaryHealthSupporter;
	}
	public List<HealthSupporterDetails> getSecondaryHealthSupporters() {
		return secondaryHealthSupporters;
	}
	public void setSecondaryHealthSupporters(List<HealthSupporterDetails> secondaryHealthSupporters) {
		this.secondaryHealthSupporters = secondaryHealthSupporters;
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
