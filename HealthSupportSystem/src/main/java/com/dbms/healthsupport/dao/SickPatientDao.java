package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.Alert;
import com.dbms.healthsupport.domain.People;
import com.dbms.healthsupport.domain.SickPatient;

public class SickPatientDao implements DaoInterface<SickPatient> {

	Connection conn;
	
	public SickPatientDao() throws SQLException {
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}

	public void insertRow(SickPatient x) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO SICKPATIENT values ("
				+ x.getSsn() + "," 
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
	}

	public void deleteRow(SickPatient x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<SickPatient> getAllData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public SickPatient getDataById(Object id) throws Exception {
		// TODO Auto-generated method stub

		Statement stmt = conn.createStatement();
		String selectSQL = "SELECT * FROM SICKPATIENT WHERE patientSSN = " + (Long)id; 
		
		ResultSet rs = stmt.executeQuery(selectSQL);
		
		if(rs.next())
		{
			Long patientSSN = rs.getLong("patientSSN");
			PatientDao patientDao = new PatientDao();
			return new SickPatient(patientDao.getDataById(patientSSN));
		}
		return null;
	}

	
	
}
