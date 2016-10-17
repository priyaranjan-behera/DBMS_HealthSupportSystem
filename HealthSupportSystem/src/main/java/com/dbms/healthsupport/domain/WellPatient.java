package com.dbms.healthsupport.domain;

import java.sql.Date;
import java.util.List;

import com.dbms.healthsupport.dao.HealthSupporterDetails;

public class WellPatient extends Patient {

	public WellPatient(Long ssn, String firstName, String lastName, String address, Date dob, String gender,
			String primaryHealthSupporter, List<String> secondaryHealthSupporters) {
		super(ssn, firstName, lastName, address, dob, gender, primaryHealthSupporter, secondaryHealthSupporters);
		// TODO Auto-generated constructor stub
	}



}
