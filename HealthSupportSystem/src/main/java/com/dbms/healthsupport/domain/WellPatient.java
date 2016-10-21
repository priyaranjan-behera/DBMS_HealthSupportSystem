package com.dbms.healthsupport.domain;

import java.sql.Date;
import java.util.List;

import com.dbms.healthsupport.dao.HealthSupporterDetails;

public class WellPatient extends Patient {

	public WellPatient(Long ssn, String firstName, String lastName, String address, String password, Date dob,
			String gender, String primaryHealthSupporter, List<String> secondaryHealthSupporters,
			List<Integer> recommendations, List<Integer> limits, List<String> diseases, List<Integer> observations) {
		super(ssn, firstName, lastName, address, password, dob, gender, primaryHealthSupporter, secondaryHealthSupporters,
				recommendations, limits, diseases, observations);
		// TODO Auto-generated constructor stub
	}

	public WellPatient(Patient patient) {
		super(patient);
		// TODO Auto-generated constructor stub
	}

}
