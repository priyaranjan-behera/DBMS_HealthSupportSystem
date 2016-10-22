package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.People;

public class PeopleDao implements DaoInterface<People> {

	
	public static Connection getConnection() throws SQLException
	{
		return(DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "vette", "200107075"));
		
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
			Long ssn = rs.getLong("ssn");
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
		    
			String selectSQL = "SELECT * FROM PEOPLE  WHERE ssn = " + (Long)ssn;
			rs = stmt.executeQuery(selectSQL);
			

			while(rs.next())
			{
				String fName = rs.getString("firstName");
				String lName = rs.getString("lastName");
				String address = rs.getString("address");
				String password = rs.getString("password");
				
				return new People((Long)ssn, fName, lName, address, password);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			rs.close();
			stmt.close();
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
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{

			conn = getConnection();
		    stmt = conn.createStatement();
		    
			String insertSQL = " INSERT INTO PEOPLE values ("
					+ x.getSsn() + ",\'" 
					+ x.getFirstName() + "\',\'"
					+ x.getLastName() + "\',\'"
					+ x.getAddress() + "\',\'"
					+ x.getPassword()
					+ "\')";
			
			System.out.println("Query: " + insertSQL);
			rs = stmt.executeQuery(insertSQL);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		
	}

	public void updatePeopleRow(People x) throws Exception{
		
		Statement stmt = null;
		Connection conn = null;
		//ResultSet rs = null;
		
		try{
			
			conn = getConnection();
			stmt = conn.createStatement();
			String updateSQL = "UPDATE PEOPLE SET firstName ="+ x.getFirstName() + "\',\'"
					+ x.getLastName() + "\',\'"
					+ x.getAddress() + "\',\'"
					+ x.getPassword() + "," +" WHERE (ssn="+ x.getSsn() +")";
		
			stmt.executeUpdate(updateSQL);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			//rs.close();
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
		    
			String deleteSQL = " DELETE FROM PEOPLE WHERE (ssn="
					+ x.getSsn()
					+ ")";
			 
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
