package com.dbms.healthsupport.domain;

public class Recommendation {
	public Integer getRec_id() {
		return rec_id;
	}
	public void setRec_id(Integer rec_id) {
		this.rec_id = rec_id;
	}
	public Integer getFreq_id() {
		return freq_id;
	}
	public void setFreq_id(Integer freq_id) {
		this.freq_id = freq_id;
	}
	public Integer getThreshold() {
		return threshold;
	}
	public void setThreshold(Integer threshold) {
		this.threshold = threshold;
	}
	public Recommendation(Integer rec_id, Integer freq_id, Integer threshold) {
		super();
		this.rec_id = rec_id;
		this.freq_id = freq_id;
		this.threshold = threshold;
	}
	Integer rec_id;
	Integer freq_id;
	Integer threshold;
}
