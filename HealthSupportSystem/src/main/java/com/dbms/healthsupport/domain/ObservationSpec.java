package com.dbms.healthsupport.domain;

import java.util.List;

public class ObservationSpec {
	String observationName;
	String description;
	
	List<Integer> metrics;
	
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
