package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.People;

public class PeopleDao implements DaoInterface<People> {

	
	public static Connection getConnection() throws SQLException
	{
		return(DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "ssharm17", "200100060"));
		
	}


	public List<People> getAllData() throws Exception {
		// TODO Auto-generated method stub
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<People> output = null;
		
		try
		{
		
		con = getConnection();
		
		stmt = con.createStatement();
	    
		String selectSQL = "SELECT * FROM PEOPLE";
		 
		output = new ArrayList<People>();
		
		rs = stmt.executeQuery(selectSQL);
	

		while(rs.next())
		{
			String ssn = rs.getString("ssn");
			String fName = rs.getString("firstName");
			String lName = rs.getString("lastName");
			String address = rs.getString("address");
			String password = rs.getString("password");
			
			output.add(new People(ssn, fName, lName, address, password));
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			con.close();
			
		}
		
		return output;
		
	}
	
	public People getDataById(Object ssn) throws Exception
	{
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
		    
			String selectSQL = "SELECT * FROM PEOPLE  WHERE ssn =\'" + (String)ssn +"\'";
			rs = stmt.executeQuery(selectSQL);
			

			while(rs.next())
			{
				String fName = rs.getString("firstName");
				String lName = rs.getString("lastName");
				String address = rs.getString("address");
				String password = rs.getString("password");
				
				return new People(String.valueOf(ssn), fName, lName, address, password);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if(rs != null)
			rs.close();
			if(stmt != null)
			stmt.close();
			if(stmt != null)
			conn.close();
		}
		
		
		return null;
		
	}


	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
			String dropSQL = "DROP TABLE PEOPLE"; 
			rs = stmt.executeQuery(dropSQL);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		
	}


	public void insertRow(People x) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		CallableStatement stmt = null;
		
		try{
			conn = getConnection();
			stmt = conn.prepareCall("{call \"AddPeopleProc\" (?,?,?,?,?)}");
			
			stmt.setString("p_ssn", x.getSsn());
			stmt.setString("p_FirstName", x.getFirstName());
			stmt.setString("p_LastName", x.getLastName());
			stmt.setString("p_Address", x.getAddress());
			stmt.setString("p_Password", x.getPassword());
			
			stmt.executeUpdate();
		}catch(Exception e){
			throw e;
		}finally {
			conn.close();
			stmt.close();
		}
		
		
	}

	public void updatePeopleRow(People x) throws Exception{
		
		Statement stmt = null;
		Connection conn = null;
		//ResultSet rs = null;
		
		try{
			
			conn = getConnection();
			stmt = conn.createStatement();
			String updateSQL = "UPDATE PEOPLE SET firstName =\'"+ x.getFirstName() + 
					"\',lastName=\'" + x.getLastName() +
					"\',address=\'"+ x.getAddress() +
					"\',password=\'" + x.getPassword() + "\'" +" WHERE (ssn=\'"+ x.getSsn() +"\')";
		
			stmt.executeUpdate(updateSQL);
			
		}catch(Exception e){
			throw e;
		}finally {
			//rs.close();
			stmt.close();
			conn.close();
		}
	}
	
	public void logUsage(People x) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
		    
			String deleteSQL = " INSERT INTO LOGINDATA(SSN, LOGINDATE) VALUES (\'"
					+ x.getSsn() + "\'," +
					//"TO_DATE(\'"+new java.sql.Date(new java.util.Date().getTime()) + "\',\'YYYY-MON-DD HH24:MI\')"
					 "CURRENT_TIMESTAMP"+ ")";
			 
			System.out.println("Delete SQL: " + deleteSQL);
			rs = stmt.executeQuery(deleteSQL);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			rs.close();
			stmt.close();
			conn.close();
		}
	}
	
	
	public void deleteRow(People x) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
		    
			String deleteSQL = " DELETE FROM PEOPLE WHERE (ssn=\'"
					+ x.getSsn()
					+ "\')";
			 
			rs = stmt.executeQuery(deleteSQL);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			rs.close();
			stmt.close();
			conn.close();
		}
		
	}


	public void createTable() {
		// TODO Auto-generated method stub
		
	}

}
