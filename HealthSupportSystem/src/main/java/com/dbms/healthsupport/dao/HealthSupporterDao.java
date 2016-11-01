package com.dbms.healthsupport.dao;

import java.sql.CallableStatement;
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
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "ssharm17", "200100060"));
		
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
		CallableStatement stmt = null;

		try{
			conn = getConnection();
			stmt = conn.prepareCall("{call \"AddHealthSupporterProc\" (?,?,?,?,?,?)}");
			
			stmt.setString("p_ssn", x.getSsn());
			stmt.setLong("hs_contactnumber", x.getContactNumber());
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

	public void deleteRow(HealthSupporter x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<HealthSupporter> getAllData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void updateRow(HealthSupporter x) throws Exception{
		
		Connection conn = null;
		CallableStatement stmt = null;
		
		try{
			conn = getConnection();
			stmt = conn.prepareCall("{call \"UpdateHealthSupporterProc\" (?,?,?,?,?,?)}");
			
			stmt.setString("p_ssn", x.getSsn());
			stmt.setLong("hs_contactnumber", x.getContactNumber());
			stmt.setString("p_firstname", x.getFirstName());
			stmt.setString("p_lastname", x.getLastName());
			stmt.setString("p_address", x.getAddress());
			stmt.setString("p_password", x.getPassword());

			stmt.executeUpdate();
			
			
		}catch(Exception e){
			throw e;
		}finally {
			conn.close();
			stmt.close();
		}
		
	}
	
	
	public void makeHealthSupporterAPatient(HealthSupporter x) throws Exception
	{
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			Statement stmt2 = null;
			ResultSet rs2=null;
		    
			try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String insertSQL = " INSERT INTO PATIENT values (\'"
					+ x.getSsn() + "\'," 
					+ "TO_DATE(\'"+ "2016-11-11" + "\',\'YYYY-MM-DD\'),\'"
					+ "Male\')";
			 
	        rs = stmt.executeQuery(insertSQL);
	        
	        stmt2 = conn.createStatement();
	        
	        insertSQL = " INSERT INTO WELLPATIENT values (\'"
					+ x.getSsn() + "\')";
	        
	        rs2 = stmt2.executeQuery(insertSQL);
	        
			} catch(Exception e){
				e.printStackTrace();
			}finally {
				rs.close();
				stmt.close();
				conn.close();
			}

	}
	
	public HealthSupporter getDataById(Object id) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		HealthSupporter output=null;
		
		try
		{
		
		conn = getConnection();
		
		stmt = conn.createStatement();
		stmt1 = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM HEALTHSUPPORTER WHERE SSN=\'"+(String)id+"\'";
		
		rs = stmt.executeQuery(selectSQL);
		
		PeopleDao peopleDao = new PeopleDao();
	
		List<String> patients=new ArrayList<String>();
		String selectSQL1="SELECT * FROM PATIENTTOHEALTHSUPPORTER WHERE HSSSN=\'"+(String)id+"\'";
		rs1 = stmt1.executeQuery(selectSQL1);
		while(rs1.next()){
			patients.add(rs1.getString("PATIENTSSN"));
		}
		
		if(rs.next())
		{
			String ssn = rs.getString("ssn");
			Long contactNumber = rs.getLong("contactNumber");
			People people = peopleDao.getDataById(ssn);
			output=new HealthSupporter(ssn, people.getFirstName(), people.getLastName(), people.getAddress(), people.getPassword(), contactNumber, patients);
			return output;
		}
		
		
		}catch(Exception e)
		{
			throw e;
		}
		finally {
			rs1.close();
			stmt1.close();
			rs.close();
			stmt.close();
			conn.close();
			
		}
		
		return null;
		
		
	}
	



}
