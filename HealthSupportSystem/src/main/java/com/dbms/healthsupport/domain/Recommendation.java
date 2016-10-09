package com.dbms.healthsupport.domain;

public class Recommendation {
	public Integer getrecId() {
		return recId;
	}
	public void setrecId(Integer recId) {
		this.recId = recId;
	}
	public Integer getfreqId() {
		return freqId;
	}
	public void setfreqId(Integer freqId) {
		this.freqId = freqId;
	}
	public Integer getThreshold() {
		return threshold;
	}
	public void setThreshold(Integer threshold) {
		this.threshold = threshold;
	}
	public Recommendation(Integer recId, Integer freqId, Integer threshold) {
		super();
		this.recId = recId;
		this.freqId = freqId;
		this.threshold = threshold;
	}
	Integer recId;
	Integer freqId;
	Integer threshold;
}
