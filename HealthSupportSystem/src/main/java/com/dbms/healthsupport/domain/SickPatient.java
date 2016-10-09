package com.dbms.healthsupport.domain;

import java.sql.Date;
import java.util.List;

import com.dbms.healthsupport.dao.HealthSupporterDetails;

public class SickPatient extends Patient {

	public SickPatient(Long ssn, String firstName, String lastName, String address, Date dob, String gender,
			HealthSupporterDetails primaryHealthSupporter, List<HealthSupporterDetails> secondaryHealthSupporters) {
		super(ssn, firstName, lastName, address, dob, gender, primaryHealthSupporter, secondaryHealthSupporters);
		// TODO Auto-generated constructor stub
	}

	

}
