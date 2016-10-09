package com.dbms.healthsupport.domain;

public class ObservationSpec {
	String ObservationName;
	String description;
	public String getObservationName() {
		return ObservationName;
	}
	public void setObservationName(String observationName) {
		ObservationName = observationName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ObservationSpec(String observationName, String description) {
		super();
		ObservationName = observationName;
		this.description = description;
	}
	
	
}
