package com.dbms.healthsupport.domain;

public class ObservationMetricDetails {
	
	String metricName;
	String metricValue;
	
	public String getMetricName() {
		return metricName;
	}
	public void setMetricName(String metricName) {
		this.metricName = metricName;
	}
	public String getMetricValue() {
		return metricValue;
	}
	public void setMetricValue(String metricValue) {
		this.metricValue = metricValue;
	}
	
	public ObservationMetricDetails(String metricName, String metricValue) {
		super();
		this.metricName = metricName;
		this.metricValue = metricValue;
	}
	
	

}
