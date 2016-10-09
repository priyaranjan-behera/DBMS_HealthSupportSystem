package com.dbms.healthsupport.domain;

public class Alert {

	Integer alertId;
	String alertType;
	String actionTaken;
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
	public Alert(Integer alertid, String alerttype, String actiontaken) {
		super();
		this.alertId = alertid;
		this.alertType = alerttype;
		this.actionTaken = actiontaken;
	}
	



	
}