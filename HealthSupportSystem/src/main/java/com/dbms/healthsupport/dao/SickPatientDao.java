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
	
	public static Connection getConnection() throws SQLException
	{
		return(DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "vette", "200107075"));
		
	}
	public void insertRow(SickPatient x) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		
	    
		String insertSQL = " INSERT INTO SICKPATIENT values ("
				+ x.getSsn() + "," 
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		stmt.close();
		rs.close();
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
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			
		conn = getConnection();
		stmt = conn.createStatement();
		String selectSQL = "SELECT * FROM SICKPATIENT WHERE patientSSN = " + (Long)id; 
		
		rs = stmt.executeQuery(selectSQL);
		
		if(rs.next())
		{
			Long patientSSN = rs.getLong("patientSSN");
			PatientDao patientDao = new PatientDao();
			return new SickPatient(patientDao.getDataById(patientSSN));
		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		return null;
	}

	
	
}
