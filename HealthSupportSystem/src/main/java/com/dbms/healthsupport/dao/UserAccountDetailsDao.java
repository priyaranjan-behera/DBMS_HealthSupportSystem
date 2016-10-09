package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.UserAccountDetails;

public class UserAccountDetailsDao implements DaoInterface<UserAccountDetails>{

   Connection conn;
	
	public UserAccountDetailsDao() throws SQLException
	{
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}
	public void createTable() throws Exception {
		// TODO Auto-generated method stub
		
		 Statement stmt = conn.createStatement();
		    
	     String createSQL = " CREATE TABLE USERACCOUNTDETAILS ("
					+ "SSN Integer,"
					+ "password VARCHAR(10))";
			
	     ResultSet rs = stmt.executeQuery(createSQL);
		
	}

	public void insertData(UserAccountDetails x) throws Exception {
		// TODO Auto-generated method stub
		
	    Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO USERACCOUNTDETAILS values ("
				+ x.getSsn() + "," 
				+ x.getPassword()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		
	}

	public void deleteData(UserAccountDetails x) throws Exception {
		// TODO Auto-generated method stub
		
	    Statement stmt = conn.createStatement();
	    
		String deleteSQL = " DELETE FROM USERACCOUNTDETAILS WHERE (SSN="
				+ x.getSsn()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(deleteSQL);
		
	}

	public List<UserAccountDetails> getData() throws Exception {
		// TODO Auto-generated method stub
Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM USERACCOUNTDETAILS";
		 
		List<UserAccountDetails> output = new ArrayList<UserAccountDetails>();
		
		ResultSet rs = stmt.executeQuery(selectSQL);
	

		while(rs.next())
		{
			Long ssn = rs.getLong("SSN");
			String password = rs.getString("password");
			
			output.add(new UserAccountDetails(ssn, password));
		}
		
		return output;
	}

	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String dropSQL = "DROP TABLE USERACCOUNTDETAILS";
		 
		ResultSet rs = stmt.executeQuery(dropSQL);
	}

}
