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
			String primaryHealthSupporter, List<String> secondaryHealthSupporters, List<Integer> recommendations,
			List<Integer> limits, List<String> diseases, List<Integer> observations) {
		super(ssn, firstName, lastName, address);
		this.dob = dob;
		this.gender = gender;
		this.primaryHealthSupporter = primaryHealthSupporter;
		this.secondaryHealthSupporters = secondaryHealthSupporters;
		this.recommendations = recommendations;
		this.limits = limits;
		this.diseases = diseases;
		this.observations = observations;
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


	public List<Integer> getRecommendations() {
		return recommendations;
	}


	public void setRecommendations(List<Integer> recommendations) {
		this.recommendations = recommendations;
	}


	public List<Integer> getLimits() {
		return limits;
	}


	public void setLimits(List<Integer> limits) {
		this.limits = limits;
	}


	public List<String> getDiseases() {
		return diseases;
	}


	public void setDiseases(List<String> diseases) {
		this.diseases = diseases;
	}


	public List<Integer> getObservations() {
		return observations;
	}


	public void setObservations(List<Integer> observations) {
		this.observations = observations;
	}
	
	
	
	
}
