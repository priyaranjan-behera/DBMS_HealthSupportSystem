package com.dbms.healthsupport.domain;

import java.util.Date;
import java.util.List;

public class Observation {

	Integer observationId;
	Date observationTime;
	Date recordedTime;
	String patientId;
	String observationSpecification;
	List<ObservationMetricDetails> metricDetails;	




	
	

	public Observation(Integer observationId, Date observationTime, Date recordedTime, String patientId,
			String observationSpecification, List<ObservationMetricDetails> metricDetails) {
		super();
		this.observationId = observationId;
		this.observationTime = observationTime;
		this.recordedTime = recordedTime;
		this.patientId = patientId;
		this.observationSpecification = observationSpecification;
		this.metricDetails = metricDetails;
	}



	public List<ObservationMetricDetails> getMetricDetails() {
		return metricDetails;
	}



	public void setMetricDetails(List<ObservationMetricDetails> metricDetails) {
		this.metricDetails = metricDetails;
	}



	public Integer getObservationId() {
		return observationId;
	}

	public void setObservationId(Integer observationId) {
		this.observationId = observationId;
	}

	public Date getObservationTime() {
		return observationTime;
	}

	public void setObservationTime(Date observationTime) {
		this.observationTime = observationTime;
	}

	public Date getRecordedTime() {
		return recordedTime;
	}

	public void setRecordedTime(Date recordedTime) {
		this.recordedTime = recordedTime;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getObservationSpecification() {
		return observationSpecification;
	}

	public void setObservationSpecification(String observationSpecification) {
		this.observationSpecification = observationSpecification;
	}
	
	
}
