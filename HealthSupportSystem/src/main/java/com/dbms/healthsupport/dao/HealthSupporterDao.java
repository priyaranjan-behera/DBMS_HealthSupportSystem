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
	
	public void createTable() throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String createSQL = " CREATE TABLE HEALTHSUPPORTER ("
				+ "ssn Integer,"
				+ "contactNumber Integer)";
		
		ResultSet rs = stmt.executeQuery(createSQL);
		
	}

	public void insertData(HealthSupporter x) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO HEALTHSUPPORTER values ("
				+ x.getSsn() + "," 
				+ x.getContactNumber()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		
	}

	public void deleteData(HealthSupporter x) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String deleteSQL = " DELETE FROM HEALTHSUPPORTER WHERE (ssn="
				+ x.getSsn()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(deleteSQL);
		
	}

	public List<HealthSupporter> getData() throws Exception {
		// TODO Auto-generated method stub
		
		Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM HEALTHSUPPORTER";
		 
		List<HealthSupporter> output = new ArrayList<HealthSupporter>();
		
		ResultSet rs = stmt.executeQuery(selectSQL);
		
		PeopleDao peopleDao = new PeopleDao();
	

		while(rs.next())
		{
			Long ssn = rs.getLong("ssn");
			Long contactNumber = rs.getLong("contactNumber");
			People people = peopleDao.getDataBySsn(ssn);
			output.add(new HealthSupporter(ssn, people.getFirstName(), people.getLastName(), people.getAddress(), contactNumber));
		}
		
		return output;
	}

	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String dropSQL = "DROP TABLE HEALTHSUPPORTER";
		 
		ResultSet rs = stmt.executeQuery(dropSQL);
		
	}
	



}
