package com.dbms.healthsupport.domain;

public class Limits {
	public Integer getlimitID() {
		return limitID;
	}
	public void setlimitID(Integer limitID) {
		this.limitID = limitID;
	}
	public Integer getlowerLimit() {
		return lowerLimit;
	}
	public void setlowerLimit(Integer lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	public Integer getupperLimit() {
		return upperLimit;
	}
	public void setupperLimit(Integer upperLimit) {
		this.upperLimit = upperLimit;
	}
	public Limits(Integer limitID, Integer lowerLimit, Integer upperLimit) {
		super();
		this.limitID = limitID;
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}
	Integer limitID;
	Integer lowerLimit;
	Integer upperLimit;
}
