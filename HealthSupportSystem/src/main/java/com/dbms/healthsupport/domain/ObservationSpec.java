package com.dbms.healthsupport.domain;

public class ObservationSpec {
	String observationName;
	String description;
	public String getObservationName() {
		return observationName;
	}
	public void setObservationName(String observationName) {
		this.observationName = observationName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ObservationSpec(String observationName, String description) {
		super();
		this.observationName = observationName;
		this.description = description;
	}
	
	
}
