package com.dbms.healthsupport.domain;

import java.util.List;

public class Diseases {
	String disName;
	String disDescription;
	List<Integer> recommendations;
	List<Integer> limits;
	
	
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
	public Diseases(String disName, String disDescription) {
		super();
		this.disName = disName;
		this.disDescription = disDescription;
	}
	

}
