package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.HealthSupporter;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.People;

public class HealthSupporterDao implements DaoInterface<HealthSupporter> {

	

	public static Connection getConnection() throws SQLException
	{
		return(DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "vette", "200107075"));
		
	}

	

	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
		
			con = getConnection();
		    
			String dropSQL = "DROP TABLE HEALTHSUPPORTER";
			 
			rs = stmt.executeQuery(dropSQL);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			con.close();
			
		}
		
	}

	public void insertRow(HealthSupporter x) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
		
		stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO HEALTHSUPPORTER values ("
				+ x.getSsn() + "," 
				+ x.getContactNumber()
				+ ")";
		 
		rs = stmt.executeQuery(insertSQL);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			rs.close();
			stmt.close();
			conn.close();
		}
		
		
	}

	public void deleteRow(HealthSupporter x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<HealthSupporter> getAllData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public void updateRow(HealthSupporter x) throws Exception{
		
		Statement stmt = null;
		Connection conn = null;
		//ResultSet rs = null;
		
		try{
			
			conn = getConnection();
			stmt = conn.createStatement();
			String updateSQL = "UPDATE HEALTHSUPPORTER SET contact ="+ x.getContactNumber() +" WHERE (ssn="+ x.getSsn() +")";
		
			stmt.executeUpdate(updateSQL);
			
			PeopleDao peopleDao= new PeopleDao();
			People people = peopleDao.getDataById(x.getSsn());
			peopleDao.updatePeopleRow(people);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			//rs.close();
			stmt.close();
			conn.close();
		}
	}
	public HealthSupporter getDataById(Object id) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		HealthSupporter output=null;
		
		try
		{
		
		conn = getConnection();
		
		stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM HEALTHSUPPORTER WHERE SSN="+(Long)id;
		
		rs = stmt.executeQuery(selectSQL);
		
		PeopleDao peopleDao = new PeopleDao();
	
		List<Long> patients=new ArrayList<Long>();
		String selectSQL1="SELECT * FROM PATIENTASSIGNEDHEALTHSUPPORTER WHERE HSSN="+(Long)id;
		ResultSet rs1 = stmt.executeQuery(selectSQL1);
		while(rs1.next()){
			patients.add(rs1.getLong("PATIENTTSSN"));
		}
		
		while(rs.next())
		{
			Long ssn = rs.getLong("ssn");
			Long contactNumber = rs.getLong("contactNumber");
			People people = peopleDao.getDataById(ssn);
			output=new HealthSupporter(ssn, people.getFirstName(), people.getLastName(), people.getAddress(), people.getPassword(), contactNumber, patients);
		}
		
		return output;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			conn.close();
			
		}
		
		return output;
		
		
	}
	



}
