package com.dbms.healthsupport.domain;

import java.sql.Date;
import java.util.List;


public class SickPatient extends Patient {

	public SickPatient(Long ssn, String firstName, String lastName, String address, String password, Date dob,
			String gender, Long primaryHealthSupporter, List<Long> secondaryHealthSupporters,
			List<Integer> recommendations, List<Integer> limits, List<String> diseases, List<Integer> observations) {
		super(ssn, firstName, lastName, address, password, dob, gender, primaryHealthSupporter, secondaryHealthSupporters,
				recommendations, limits, diseases, observations);
		// TODO Auto-generated constructor stub
	}
	
	public SickPatient(Patient patient)
	{
		super(patient);
	}


	
	

}
