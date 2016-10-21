package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.HealthSupporter;
import com.dbms.healthsupport.domain.People;
import com.dbms.healthsupport.domain.SickPatient;
import com.dbms.healthsupport.domain.WellPatient;

public class WellPatientDao implements DaoInterface<WellPatient> {

	Connection conn;
	
	public WellPatientDao() throws SQLException {
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}

	public void insertRow(WellPatient x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void deleteRow(WellPatient x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<WellPatient> getAllData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public WellPatient getDataById(Object id) throws Exception {
		// TODO Auto-generated method stub
	
		Statement stmt = conn.createStatement();
		String selectSQL = "SELECT * FROM SICKPATIENT WHERE patientSSN = " + (Long)id; 
		
		ResultSet rs = stmt.executeQuery(selectSQL);
		
		if(rs.next())
		{
			Long patientSSN = rs.getLong("patientSSN");
			PatientDao patientDao = new PatientDao();
			return new WellPatient(patientDao.getDataById(patientSSN));
		}
		return null;
	}

	
	
	
	
}
