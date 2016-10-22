package com.dbms.healthsupport.domain;

public class Frequency {
	
	String frequencyName;
	Integer duration;
	
	
	public Frequency(String frequencyName, Integer duration) {
		super();
		this.frequencyName = frequencyName;
		this.duration = duration;
	}
	public String getFrequencyName() {
		return frequencyName;
	}
	public void setFrequencyDesc(String frequencyName) {
		this.frequencyName = frequencyName;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

}
