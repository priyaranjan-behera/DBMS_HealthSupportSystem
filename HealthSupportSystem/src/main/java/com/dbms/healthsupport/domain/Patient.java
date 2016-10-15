package com.dbms.healthsupport.domain;

import java.sql.Date;
import java.util.List;

import com.dbms.healthsupport.dao.HealthSupporterDetails;

public class Patient extends People {
	
	Date dob;
	String gender;
	
	String primaryHealthSupporter;
	List<String> secondaryHealthSupporters;
	List<Integer>recommendations;
	List<Integer>limits; 
	List<String> diseases;
	List<Integer> observations;
	
	
	
	public Patient(Long ssn, String firstName, String lastName, String address, Date dob, String gender,
			String primaryHealthSupporter, List<String> secondaryHealthSupporters) {
		super(ssn, firstName, lastName, address);
		this.dob = dob;
		this.gender = gender;
		this.primaryHealthSupporter = primaryHealthSupporter;
		this.secondaryHealthSupporters = secondaryHealthSupporters;
	}
	
	public String getPrimaryHealthSupporter() {
		return primaryHealthSupporter;
	}
	public void setPrimaryHealthSupporter(String primaryHealthSupporter) {
		this.primaryHealthSupporter = primaryHealthSupporter;
	}
	public List<String> getSecondaryHealthSupporters() {
		return secondaryHealthSupporters;
	}
	public void setSecondaryHealthSupporters(List<String> secondaryHealthSupporters) {
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
