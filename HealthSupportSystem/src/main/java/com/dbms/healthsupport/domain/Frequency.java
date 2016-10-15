package com.dbms.healthsupport.domain;

public class Frequency {
	
	String frequencyDesc;
	Integer duration;
	
	
	public Frequency(String frequencyDesc, Integer duration) {
		super();
		this.frequencyDesc = frequencyDesc;
		this.duration = duration;
	}
	public String getFrequencyDesc() {
		return frequencyDesc;
	}
	public void setFrequencyDesc(String frequencyDesc) {
		this.frequencyDesc = frequencyDesc;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

}
