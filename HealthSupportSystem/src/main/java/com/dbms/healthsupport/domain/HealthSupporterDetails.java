package com.dbms.healthsupport.domain;

import java.sql.Date;

public class HealthSupporterDetails {

	Long patientSSN;
	Long healthSupporterSSN;
	Date authDate;
	
	public HealthSupporterDetails(Long patientSSN, Long healthSupporterSSN, Date authDate) {
		super();
		this.patientSSN = patientSSN;
		this.healthSupporterSSN = healthSupporterSSN;
		this.authDate = authDate;
	}
	
	public Long getPatientSSN() {
		return patientSSN;
	}
	public void setPatientSSN(Long patientSSN) {
		this.patientSSN = patientSSN;
	}
	public Long getHealthSupporterSSN() {
		return healthSupporterSSN;
	}
	public void setHealthSupporterSSN(Long healthSupporterSSN) {
		this.healthSupporterSSN = healthSupporterSSN;
	}
	public Date getAuthDate() {
		return authDate;
	}
	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}


}
