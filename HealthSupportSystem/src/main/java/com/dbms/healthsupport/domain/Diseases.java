package com.dbms.healthsupport.domain;

public class Diseases {
	public String getDis_name() {
		return dis_name;
	}
	public void setDis_name(String dis_name) {
		this.dis_name = dis_name;
	}
	public String getDis_description() {
		return dis_description;
	}
	public void setDis_description(String dis_description) {
		this.dis_description = dis_description;
	}
	public Diseases(String dis_name, String dis_description) {
		super();
		this.dis_name = dis_name;
		this.dis_description = dis_description;
	}
	String dis_name;
	String dis_description;

}
