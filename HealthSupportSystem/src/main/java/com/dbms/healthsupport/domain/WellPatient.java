package com.dbms.healthsupport.domain;

import java.sql.Date;
import java.util.List;

public class WellPatient extends Patient {

	public WellPatient(Long ssn, String firstName, String lastName, String address, String password, Date dob,
			String gender, Long primaryHealthSupporter, List<Long> secondaryHealthSupporters,
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
