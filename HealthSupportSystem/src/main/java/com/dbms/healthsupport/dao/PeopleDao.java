package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.People;

public class PeopleDao implements DaoInterface<People> {

	Connection conn;
	
	public PeopleDao() throws SQLException
	{
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}
	
	
	public void createTable() throws SQLException {
		// TODO Auto-generated method stub

	    Statement stmt = conn.createStatement();
	    
		String createSQL = " CREATE TABLE PEOPLE ("
				+ "ssn Integer,"
				+ "firstName VARCHAR(10),"
				+ "lastName VARCHAR(10),"
				+ "address VARCHAR(10))";
		
		ResultSet rs = stmt.executeQuery(createSQL);
		
	}

	public void insertData(People x) throws Exception {
		// TODO Auto-generated method stub
	

	    Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO PEOPLE values ("
				+ x.getSsn() + "," 
				+ x.getFirstName() + ","
				+ x.getLastName() + ","
				+ x.getAddress()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
	}


	public void deleteData(People x) throws Exception {
		// TODO Auto-generated method stub

	    Statement stmt = conn.createStatement();
	    
		String deleteSQL = " DELETE FROM PEOPLE WHERE (ssn="
				+ x.getSsn()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(deleteSQL);
	}


	public List<People> getData() throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM PEOPLE";
		 
		List<People> output = new ArrayList<People>();
		
		ResultSet rs = stmt.executeQuery(selectSQL);
	

		while(rs.next())
		{
			Long ssn = rs.getLong("ssn");
			String fName = rs.getString("firstName");
			String lName = rs.getString("lastName");
			String address = rs.getString("address");
			
			output.add(new People(ssn, fName, lName, address));
		}
		
		return output;
	}
	
	public People getDataBySsn(Long ssn) throws SQLException
	{
		Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM PEOPLE  WHERE ssn = " + ssn;
		ResultSet rs = stmt.executeQuery(selectSQL);
		

		while(rs.next())
		{
			String fName = rs.getString("firstName");
			String lName = rs.getString("lastName");
			String address = rs.getString("address");
			
			return new People(ssn, fName, lName, address);
		}
		
		return null;
		
	}


	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String dropSQL = "DROP TABLE PEOPLE";
		 
		ResultSet rs = stmt.executeQuery(dropSQL);
	}
	
	
	
	
	
	
	
	

}
