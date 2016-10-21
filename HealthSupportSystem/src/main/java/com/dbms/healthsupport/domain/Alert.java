package com.dbms.healthsupport.domain;

public class Alert {

	Integer alertId;
	String alertType;
	String actionTaken;
	
	Long patientId;
	Integer limitId;
	Integer recommendationId;
	
	

	
	
	public Alert(Integer alertId, String alertType, String actionTaken, Long patientId, Integer limitId,
			Integer recommendationId) {
		super();
		this.alertId = alertId;
		this.alertType = alertType;
		this.actionTaken = actionTaken;
		this.patientId = patientId;
		this.limitId = limitId;
		this.recommendationId = recommendationId;
	}
	
	public Alert(Integer alertId, String alertType, String actionTaken, Long patientId, Integer limitId,
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
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
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
	
	
	
}