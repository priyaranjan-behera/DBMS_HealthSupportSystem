package com.dbms.healthsupport.domain;

import java.sql.Date;

public class WellPatient extends Patient {

	public WellPatient(Long ssn, String firstName, String lastName, String address, Date dob, String gender) {
		super(ssn, firstName, lastName, address, dob, gender);
	}

}
