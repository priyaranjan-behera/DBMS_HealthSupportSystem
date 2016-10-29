package com.dbms.healthsupport.domain;

import java.sql.Date;

public class Alert {

	Integer alertId;
	String alertType;
	String actionTaken;
	Date alertDate;
	
	String patientId;
	Integer limitId;
	Integer recommendationId;
	
	public Alert(Integer alertId, String alertType, Date alertDate, String actionTaken, String patientId, Integer limitId,
			Integer recommendationId) {
		super();
		this.alertId = alertId;
		this.alertType = alertType;
		this.actionTaken = actionTaken;
		this.patientId = patientId;
		this.limitId = limitId;
		this.recommendationId = recommendationId;
		this.alertDate = alertDate;
	}
	
	public Alert(Integer alertId, String alertType,Date alertDate, String actionTaken, String patientId, Integer limitId,
			Boolean isLimit) {
		super();
		this.alertId = alertId;
		this.alertType = alertType;
		this.actionTaken = actionTaken;
		this.patientId = patientId;
		if(isLimit)
			this.limitId = limitId;
		else
			this.recommendationId = limitId;
		this.alertDate = alertDate;
	}
	
	public Integer getAlertId() {
		return alertId;
	}
	public void setAlertId(Integer alertid) {
		this.alertId = alertid;
	}
	public String getAlertType() {
		return alertType;
	}
	public void setAlertType(String alerttype) {
		this.alertType = alerttype;
	}
	public String getActionTaken() {
		return actionTaken;
	}
	public void setActionTaken(String actiontaken) {
		this.actionTaken = actiontaken;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public Integer getLimitId() {
		return limitId;
	}
	public void setLimitId(Integer limitId) {
		this.limitId = limitId;
	}
	public Integer getRecommendationId() {
		return recommendationId;
	}
	public void setRecommendationId(Integer recommendationId) {
		this.recommendationId = recommendationId;
	}
	public void setAlertDate(Date alertDate)
	{
		this.alertDate = alertDate;
	}
	public Date getAlertDate()
	{
		return this.alertDate;
	}
	
	
	
	
}