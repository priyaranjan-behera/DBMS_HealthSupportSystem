package com.dbms.healthsupport.domain;

public class Alert {

	Integer alertid;
	String alerttype;
	String actiontaken;
	public Integer getAlertid() {
		return alertid;
	}
	public void setAlertid(Integer alertid) {
		this.alertid = alertid;
	}
	public String getAlerttype() {
		return alerttype;
	}
	public void setAlerttype(String alerttype) {
		this.alerttype = alerttype;
	}
	public String getActiontaken() {
		return actiontaken;
	}
	public void setActiontaken(String actiontaken) {
		this.actiontaken = actiontaken;
	}
	public Alert(Integer alertid, String alerttype, String actiontaken) {
		super();
		this.alertid = alertid;
		this.alerttype = alerttype;
		this.actiontaken = actiontaken;
	}
	



	
}