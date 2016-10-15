package com.dbms.healthsupport.domain;

public class Limits {
	
	Integer limitID;
	Integer lowerLimit;
	Integer upperLimit;
	Integer metricId;
	public Integer getLimitID() {
		return limitID;
	}
	public void setLimitID(Integer limitID) {
		this.limitID = limitID;
	}
	public Integer getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(Integer lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	public Integer getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(Integer upperLimit) {
		this.upperLimit = upperLimit;
	}
	public Integer getMetricId() {
		return metricId;
	}
	public void setMetricId(Integer metricId) {
		this.metricId = metricId;
	}
	
	public Limits(Integer limitID, Integer lowerLimit, Integer upperLimit, Integer metricId) {
		super();
		this.limitID = limitID;
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
		this.metricId = metricId;
	}
	
	

}
