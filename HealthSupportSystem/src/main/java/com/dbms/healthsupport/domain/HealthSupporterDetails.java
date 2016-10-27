package com.dbms.healthsupport.domain;

import java.sql.Date;

public class HealthSupporterDetails {

	String patientSSN;
	String healthSupporterSSN;
	Date authDate;
	
	public HealthSupporterDetails(String patientSSN, String healthSupporterSSN, Date authDate) {
		super();
		this.patientSSN = patientSSN;
		this.healthSupporterSSN = healthSupporterSSN;
		this.authDate = authDate;
	}
	
	public String getPatientSSN() {
		return patientSSN;
	}
	public void setPatientSSN(String patientSSN) {
		this.patientSSN = patientSSN;
	}
	public String getHealthSupporterSSN() {
		return healthSupporterSSN;
	}
	public void setHealthSupporterSSN(String healthSupporterSSN) {
		this.healthSupporterSSN = healthSupporterSSN;
	}
	public Date getAuthDate() {
		return authDate;
	}
	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}


}
