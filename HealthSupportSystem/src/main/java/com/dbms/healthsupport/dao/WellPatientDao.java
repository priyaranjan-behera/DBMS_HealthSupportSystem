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
	
	public static Connection getConnection() throws SQLException
	{
		return(DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "vette", "200107075"));
		
	}

	public void insertRow(WellPatient x) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO WELLPATIENT values ("
				+ x.getSsn()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		stmt.close();
		rs.close();
	
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
			return new WellPatient(patientDao.getDataById(patientSSN));
		}
		}catch(Exception e){
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
