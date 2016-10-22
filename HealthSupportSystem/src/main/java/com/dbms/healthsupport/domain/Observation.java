package com.dbms.healthsupport.domain;

import java.util.Date;

public class Observation {

	Integer observationId;
	String observationValue;
	Date observationTime;
	Date recordedTime;
	String patientId;
	String observationSpecification;
	
	public Observation(Integer observationId, String observationValue, Date observationTime, Date recordedTime,
			String patientId, String observationSpecification) {
		super();
		this.observationId = observationId;
		this.observationValue = observationValue;
		this.observationTime = observationTime;
		this.recordedTime = recordedTime;
		this.patientId = patientId;
		this.observationSpecification = observationSpecification;
	}

	public Integer getObservationId() {
		return observationId;
	}

	public void setObservationId(Integer observationId) {
		this.observationId = observationId;
	}

	public String getObservationValue() {
		return observationValue;
	}

	public void setObservationValue(String observationValue) {
		this.observationValue = observationValue;
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
