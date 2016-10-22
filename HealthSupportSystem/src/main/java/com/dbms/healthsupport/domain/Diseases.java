package com.dbms.healthsupport.domain;

import java.util.List;

public class Diseases {
	String disName;
	String disDescription;
	List<Integer> recommendations;
	List<Integer> limits;
	
	
	public Diseases(String disName, String disDescription, List<Integer> recommendations, List<Integer> limits) {
		super();
		this.disName = disName;
		this.disDescription = disDescription;
		this.recommendations = recommendations;
		this.limits = limits;
	}

	public Diseases(String disName, String disDescription) {
		super();
		this.disName = disName;
		this.disDescription = disDescription;
	}

	
	
	public String getDisName() {
		return disName;
	}
	public void setDisName(String disName) {
		this.disName = disName;
	}
	public String getDisDescription() {
		return disDescription;
	}
	public void setDisDescription(String disDescription) {
		this.disDescription = disDescription;
	}
	public List<Integer> getRecommendations() {
		return recommendations;
	}
	public void setRecommendations(List<Integer> recommendations) {
		this.recommendations = recommendations;
	}
	public List<Integer> getLimits() {
		return limits;
	}
	public void setLimits(List<Integer> limits) {
		this.limits = limits;
	}
	
	
	
	

}
