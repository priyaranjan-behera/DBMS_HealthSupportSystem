package com.dbms.healthsupport.domain;

public class Limits {
	
	Integer limitID;
	Integer lowerLimit;
	Integer upperLimit;
	String metricId;
	String observationSpec;
	
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
	public String getMetricId() {
		return metricId;
	}
	public void setMetricId(String metricId) {
		this.metricId = metricId;
	}
	public String getObservationSpec() {
		return observationSpec;
	}
	public void setObservationSpec(String observationSpec) {
		this.observationSpec = observationSpec;
	}
	public Limits(Integer limitID, Integer lowerLimit, Integer upperLimit, String metricId, String observationSpec) {
		super();
		this.limitID = limitID;
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
		this.metricId = metricId;
		this.observationSpec = observationSpec;
	}
	
	
	
	

}
