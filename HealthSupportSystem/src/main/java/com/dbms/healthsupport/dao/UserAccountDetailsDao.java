package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.People;
import com.dbms.healthsupport.domain.UserAccountDetails;

public class UserAccountDetailsDao implements DaoInterface<UserAccountDetails>{

   Connection conn;
	
   public static Connection getConnection() throws SQLException
	{
		return(DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "vette", "200107075"));
		
	}
	public void createTable() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		 Statement stmt = conn.createStatement();
		    
	     String createSQL = " CREATE TABLE USERACCOUNTDETAILS ("
					+ "SSN Integer,"
					+ "password VARCHAR(10))";
			
	     ResultSet rs = stmt.executeQuery(createSQL);
	     stmt.close();
			rs.close();
		
	}

	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
	    
		String dropSQL = "DROP TABLE USERACCOUNTDETAILS";
		 
		ResultSet rs = stmt.executeQuery(dropSQL);
		stmt.close();
		rs.close();
	}
	public void insertRow(UserAccountDetails x) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
          Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO USERACCOUNTDETAILS values ("
				+ x.getSsn() + "," 
				+ x.getPassword()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		stmt.close();
		rs.close();
		
	}
	public void deleteRow(UserAccountDetails x) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
	    Statement stmt = conn.createStatement();
	    
		String deleteSQL = " DELETE FROM USERACCOUNTDETAILS WHERE (SSN="
				+ x.getSsn()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(deleteSQL);
		stmt.close();
		rs.close();
		
	}
	public List<UserAccountDetails> getAllData() throws Exception {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
		conn = getConnection();
        stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM USERACCOUNTDETAILS";
		 
		List<UserAccountDetails> output = new ArrayList<UserAccountDetails>();
		
		rs = stmt.executeQuery(selectSQL);
	

		while(rs.next())
		{
			Long ssn = rs.getLong("SSN");
			String password = rs.getString("password");
			
			output.add(new UserAccountDetails(ssn, password));
			return output;
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
	public UserAccountDetails getDataById(Object ssn) throws Exception {
	    
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
		conn = getConnection();
		stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM USERACCOUNTDETAILS  WHERE ssn = " + (Long)ssn;
		rs = stmt.executeQuery(selectSQL);
		

		while(rs.next())
		{
			String password = rs.getString("password");
			
			return new UserAccountDetails((Long)ssn,password);
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
