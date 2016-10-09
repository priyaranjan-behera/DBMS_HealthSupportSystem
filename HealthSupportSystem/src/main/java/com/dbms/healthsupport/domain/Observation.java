package com.dbms.healthsupport.domain;

import java.util.Date;

public class Observation {

	int observationSpecificationId;
	String observationValue;
	Date observationTime;
	Date recordedTime;
	
	public Observation(int observationSpecificationId, String observationValue, Date observationTime, Date recordedTime) {
		
		this.observationSpecificationId = observationSpecificationId;
		this.observationValue = observationValue;
		this.observationTime = observationTime;
		this.recordedTime = recordedTime;
	}

	public int getObservationSpecificationId() {
		return observationSpecificationId;
	}

	public void setObservationSpecificationId(int observationSpecificationId) {
		this.observationSpecificationId = observationSpecificationId;
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
}
