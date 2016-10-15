package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.People;
import com.dbms.healthsupport.domain.SickPatient;

public class SickPatientDao implements DaoInterface<SickPatient> {

	Connection conn;
	
	public SickPatientDao() throws SQLException {
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}

	public void createTable() throws Exception {
		// TODO Auto-generated method stub

	    Statement stmt = conn.createStatement();
	    
		String createSQL = " CREATE TABLE SICKPATIENT ("
				+ "ssn INTEGER,"
				+ "dob DATE,"
				+ "gender VARCHAR(10))";
		
		ResultSet rs = stmt.executeQuery(createSQL);
		
	}

	public void insertData(SickPatient x) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO PEOPLE values ("
				+ x.getSsn() + "," 
				+ x.getDob() + ","
				+ x.getGender() 
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		
	}

	public void deleteData(SickPatient x) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String deleteSQL = " DELETE FROM SICKPATIENT WHERE (ssn="
				+ x.getSsn()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(deleteSQL);
		
	}

	public List<SickPatient> getData() throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM SICKPATIENT";
		 
		List<SickPatient> output = new ArrayList<SickPatient>();
		
		ResultSet rs = stmt.executeQuery(selectSQL);
		
		PeopleDao peopleDao = new PeopleDao();
	

		while(rs.next())
		{
			Long ssn = rs.getLong("ssn");
			Date dob = rs.getDate("dob");
			String gender = rs.getString("gender");
			People people = peopleDao.getDataBySsn(ssn);
			//Retrieve data from health supporter map table
			output.add(new SickPatient(ssn, people.getFirstName(), people.getLastName(), people.getAddress(), dob, gender));
		}
		
		return output;
	}

	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String dropSQL = "DROP TABLE SICKPATIENT";
		 
		ResultSet rs = stmt.executeQuery(dropSQL);
		
	}

	public void insertRow(SickPatient x) throws Exception {
		// TODO Auto-generated method stub
		
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
		return null;
	}
	
	
	
	
}
