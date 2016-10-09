package com.dbms.healthsupport.domain;

public class Limits {
	public Integer getLimit_id() {
		return limit_id;
	}
	public void setLimit_id(Integer limit_id) {
		this.limit_id = limit_id;
	}
	public Integer getLower_limit() {
		return lower_limit;
	}
	public void setLower_limit(Integer lower_limit) {
		this.lower_limit = lower_limit;
	}
	public Integer getUpper_limit() {
		return upper_limit;
	}
	public void setUpper_limit(Integer upper_limit) {
		this.upper_limit = upper_limit;
	}
	public Limits(Integer limit_id, Integer lower_limit, Integer upper_limit) {
		super();
		this.limit_id = limit_id;
		this.lower_limit = lower_limit;
		this.upper_limit = upper_limit;
	}
	Integer limit_id;
	Integer lower_limit;
	Integer upper_limit;
}
