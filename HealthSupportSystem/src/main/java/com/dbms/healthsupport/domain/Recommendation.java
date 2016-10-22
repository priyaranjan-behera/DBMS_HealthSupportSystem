package com.dbms.healthsupport.domain;

public class Recommendation {
	

	Integer recId;
	String frequencyName;
	Integer threshold;
	String observationSpecification;

	
	
	
	public Recommendation(Integer recId, String frequencyName, Integer threshold, String observationSpecification) {
		super();
		this.recId = recId;
		this.frequencyName = frequencyName;
		this.threshold = threshold;
		this.observationSpecification = observationSpecification;
	}

	public String getObservationSpecification() {
		return observationSpecification;
	}

	public void setObservationSpecification(String observationSpecification) {
		this.observationSpecification = observationSpecification;
	}

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

	

}
