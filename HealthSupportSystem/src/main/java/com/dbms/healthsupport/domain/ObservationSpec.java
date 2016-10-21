package com.dbms.healthsupport.domain;

import java.util.List;

public class ObservationSpec {
	String observationName;
	String description;
	
	List<String> metrics;

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

	public List<String> getMetrics() {
		return metrics;
	}

	public void setMetrics(List<String> metrics) {
		this.metrics = metrics;
	}

	public ObservationSpec(String observationName, String description, List<String> metrics) {
		super();
		this.observationName = observationName;
		this.description = description;
		this.metrics = metrics;
	}


	
}
