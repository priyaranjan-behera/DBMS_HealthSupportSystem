package com.dbms.healthsupport.domain;

public class Metric {
	
	String observationSpecification;
	String name;
	Integer metricType;
	
	
	
	public Metric(String observationSpecification, String name, Integer metricType) {
		super();
		this.observationSpecification = observationSpecification;
		this.name = name;
		this.metricType = metricType;
	}
	
	public String getObservationSpecification() {
		return observationSpecification;
	}
	public void setObservationSpecification(String observationSpecification) {
		this.observationSpecification = observationSpecification;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMetricType() {
		return metricType;
	}
	public void setMetricType(Integer metricType) {
		this.metricType = metricType;
	}

}
