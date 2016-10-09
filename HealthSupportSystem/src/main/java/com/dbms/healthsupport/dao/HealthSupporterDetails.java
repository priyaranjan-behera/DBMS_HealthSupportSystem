package com.dbms.healthsupport.dao;

import java.sql.Date;

import com.dbms.healthsupport.domain.HealthSupporter;

public class HealthSupporterDetails {

	HealthSupporter healthSupporter;
	Date authDate;
	
	public HealthSupporter getHealthSupporter() {
		return healthSupporter;
	}
	public void setHealthSupporter(HealthSupporter healthSupporter) {
		this.healthSupporter = healthSupporter;
	}
	public Date getAuthDate() {
		return authDate;
	}
	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}
	public HealthSupporterDetails(HealthSupporter healthSupporter, Date authDate) {
		super();
		this.healthSupporter = healthSupporter;
		this.authDate = authDate;
	}
	
	
	
	

}
