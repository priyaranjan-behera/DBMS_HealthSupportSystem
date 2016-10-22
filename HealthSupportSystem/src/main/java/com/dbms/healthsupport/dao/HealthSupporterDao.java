package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.HealthSupporter;
import com.dbms.healthsupport.domain.People;

public class HealthSupporterDao implements DaoInterface<HealthSupporter> {

	

	Connection conn;
	
	public HealthSupporterDao() throws SQLException
	{
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}
	

	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String dropSQL = "DROP TABLE HEALTHSUPPORTER";
		 
		ResultSet rs = stmt.executeQuery(dropSQL);
		
	}

	public void insertRow(HealthSupporter x) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO HEALTHSUPPORTER values ("
				+ x.getSsn() + "," 
				+ x.getContactNumber()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		
	}

	public void deleteRow(HealthSupporter x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<HealthSupporter> getAllData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public HealthSupporter getDataById(Object id) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM HEALTHSUPPORTER WHERE SSN="+(Long)id;
		 
		HealthSupporter output=null;
		
		ResultSet rs = stmt.executeQuery(selectSQL);
		
		PeopleDao peopleDao = new PeopleDao();
	
		List<Long> patients=new ArrayList<Long>();
		String selectSQL1="SELECT * FROM PATIENTASSIGNEDHEALTHSUPPORTER WHERE HSSN="+(Long)id;
		ResultSet rs1 = stmt.executeQuery(selectSQL);
		while(rs1.next()){
			patients.add(rs.getLong("PATIENTTSSN"));
		}
		
		while(rs.next())
		{
			Long ssn = rs.getLong("ssn");
			Long contactNumber = rs.getLong("contactNumber");
			People people = peopleDao.getDataById(ssn);
			output=new HealthSupporter(ssn, people.getFirstName(), people.getLastName(), people.getAddress(), people.getPassword(), contactNumber, patients);
		}
		
		return output;

		
	}
	



}
