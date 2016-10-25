package com.dbms.healthsupport.domain;

public class Limits {
	
	Integer limitID;
	String lowerLimit;
	String upperLimit;
	String metricId;
	String observationSpec;
	
	public Integer getLimitID() {
		return limitID;
	}
	public void setLimitID(Integer limitID) {
		this.limitID = limitID;
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
	public String getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(String lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	public String getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(String upperLimit) {
		this.upperLimit = upperLimit;
	}
	public Limits(Integer limitID, String lowerLimit, String upperLimit, String metricId, String observationSpec) {
		super();
		this.limitID = limitID;
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
		this.metricId = metricId;
		this.observationSpec = observationSpec;
	}

	
	
	
	

}
