package com.dbms.healthsupport.domain;

import java.sql.Date;
import java.util.List;

public class Patient extends People {
	
	Date dob;
	String gender;
	
	Long primaryHealthSupporter;
	List<Long> secondaryHealthSupporters;
	List<Integer>recommendations;
	List<Integer>limits; 
	List<String> diseases;
	List<Integer> observations;
	
	public Patient(Long ssn, String firstName, String lastName, String address, String password, Date dob,
			String gender, Long primaryHealthSupporter, List<Long> secondaryHealthSupporters,
			List<Integer> recommendations, List<Integer> limits, List<String> diseases, List<Integer> observations) {
		super(ssn, firstName, lastName, address, password);
		this.dob = dob;
		this.gender = gender;
		this.primaryHealthSupporter = primaryHealthSupporter;
		this.secondaryHealthSupporters = secondaryHealthSupporters;
		this.recommendations = recommendations;
		this.limits = limits;
		this.diseases = diseases;
		this.observations = observations;
	}
	
	public Patient(Patient patient) {
		super(patient.getSsn(), patient.getFirstName(), patient.getLastName(), patient.getAddress(), patient.getPassword());
		this.dob = patient.getDob();
		this.gender = patient.getGender();
		this.primaryHealthSupporter = patient.getPrimaryHealthSupporter();
		this.secondaryHealthSupporters = patient.getSecondaryHealthSupporters();
		this.recommendations = patient.getRecommendations();
		this.limits = patient.getLimits();
		this.diseases = patient.getDiseases();
		this.observations = patient.getObservations();
	}
	
	public Patient(People people, Date dob, String gender)
	{
		super(people);
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


	public Long getPrimaryHealthSupporter() {
		return primaryHealthSupporter;
	}


	public void setPrimaryHealthSupporter(Long primaryHealthSupporter) {
		this.primaryHealthSupporter = primaryHealthSupporter;
	}


	public List<Long> getSecondaryHealthSupporters() {
		return secondaryHealthSupporters;
	}


	public void setSecondaryHealthSupporters(List<Long> secondaryHealthSupporters) {
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
