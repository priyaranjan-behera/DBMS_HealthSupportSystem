package com.dbms.healthsupport.domain;

import java.util.Date;

public class Observation {

	int observationSpecificationId;
	String value;
	Date observationTime;
	Date recordedTime;
	
	public Observation() {
		
	}

	public int getObservationSpecificationId() {
		return observationSpecificationId;
	}

	public void setObservationSpecificationId(int observationSpecificationId) {
		this.observationSpecificationId = observationSpecificationId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
