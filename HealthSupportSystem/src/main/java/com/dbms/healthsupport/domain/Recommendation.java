package com.dbms.healthsupport.domain;

public class Recommendation {
	
	public Recommendation(Integer recId, String frequencyName, Integer threshold, Integer observationSpecification) {
		super();
		this.recId = recId;
		this.frequencyName = frequencyName;
		this.threshold = threshold;
		this.observationSpecification = observationSpecification;
	}

	Integer recId;
	String frequencyName;
	Integer threshold;
	
	Integer observationSpecification;

	public Integer getRecId() {
		return recId;
	}

	public void setRecId(Integer recId) {
		this.recId = recId;
	}

	public String getFrequencyName() {
		return frequencyName;
	}

	public void setFrequencyName(String frequencyName) {
		this.frequencyName = frequencyName;
	}

	public Integer getThreshold() {
		return threshold;
	}

	public void setThreshold(Integer threshold) {
		this.threshold = threshold;
	}

	public Integer getObservationSpecification() {
		return observationSpecification;
	}

	public void setObservationSpecification(Integer observationSpecification) {
		this.observationSpecification = observationSpecification;
	}
	

}
