package com.dbms.healthsupport.domain;

public class Alert {

	Integer alertId;
	String alertType;
	String actionTaken;
	
	String pateintId;
	Integer limitId;
	Integer recommendationId;
	
	
	
	public Alert(Integer alertId, String alertType, String actionTaken, String pateintId, Integer limitId,
			Integer recommendationId) {
		super();
		this.alertId = alertId;
		this.alertType = alertType;
		this.actionTaken = actionTaken;
		this.pateintId = pateintId;
		this.limitId = limitId;
		this.recommendationId = recommendationId;
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
	public String getPateintId() {
		return pateintId;
	}
	public void setPateintId(String pateintId) {
		this.pateintId = pateintId;
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