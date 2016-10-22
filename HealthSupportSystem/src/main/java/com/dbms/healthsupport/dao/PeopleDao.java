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
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "anayakv", "200110688");
		
	}


	public List<People> getAllData() throws Exception {
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
			String password = rs.getString("password");
			
			output.add(new People(ssn, fName, lName, address, password));
		}
		
		return output;
	}
	
	public People getDataById(Object ssn) throws Exception
	{
		Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM PEOPLE  WHERE ssn = " + (Long)ssn;
		ResultSet rs = stmt.executeQuery(selectSQL);
		

		while(rs.next())
		{
			String fName = rs.getString("firstName");
			String lName = rs.getString("lastName");
			String address = rs.getString("address");
			String password = rs.getString("password");
			
			return new People((Long)ssn, fName, lName, address, password);
		}
		
		return null;
		
	}


	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String dropSQL = "DROP TABLE PEOPLE";
		 
		ResultSet rs = stmt.executeQuery(dropSQL);
	}


	public void insertRow(People x) throws Exception {
		// TODO Auto-generated method stub

	    Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO PEOPLE values ("
				+ x.getSsn() + ",\'" 
				+ x.getFirstName() + "\',\'"
				+ x.getLastName() + "\',\'"
				+ x.getAddress() + "\',\'"
				+ x.getPassword()
				+ "\')";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		
	}


	public void deleteRow(People x) throws Exception {
		// TODO Auto-generated method stub
		  Statement stmt = conn.createStatement();
		    
			String deleteSQL = " DELETE FROM PEOPLE WHERE (ssn="
					+ x.getSsn()
					+ ")";
			 
			ResultSet rs = stmt.executeQuery(deleteSQL);
		
	}


	public void createTable() {
		// TODO Auto-generated method stub
		
	}

}
