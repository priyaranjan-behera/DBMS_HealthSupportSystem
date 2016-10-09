package com.dbms.healthsupport.domain;

public class MetricTypeValue {
	
	int metricTypeValueID;
	String metricTypeValue;
	
	public MetricTypeValue(int metricTypeValueID, String metricTypeValue) {
		this.metricTypeValueID = metricTypeValueID;
		this.metricTypeValue = metricTypeValue;
	}

	public int getMetricTypeValueID() {
		return metricTypeValueID;
	}

	public void setMetricTypeValueID(int metricTypeValueID) {
		this.metricTypeValueID = metricTypeValueID;
	}

	public String getMetricTypeValue() {
		return metricTypeValue;
	}

	public void setMetricTypeValue(String metricTypeValue) {
		this.metricTypeValue = metricTypeValue;
	}
}
