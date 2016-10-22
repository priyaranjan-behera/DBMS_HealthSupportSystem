package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.HealthSupporter;
import com.dbms.healthsupport.domain.HealthSupporterDetails;
import com.dbms.healthsupport.domain.People;

public class HealthSupporterDetailsDao implements DaoInterface<HealthSupporterDetails> {

	

	public static Connection getConnection() throws SQLException
	{
		return(DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "vette", "200107075"));
		
	}

	
	

	public HealthSupporterDetails getDataById(Object id) throws Exception {
		return null;
	}

	
	public HealthSupporterDetails getDataById(Object patientSSN, Object HSSSN) throws Exception {
		// TODO Auto-generated method stub

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		HealthSupporterDetails output=null;
		
		try
		{
		
		con = getConnection();
		stmt = con.createStatement();
	    
		String selectSQL = "SELECT * FROM PATIENTHEALTHSUPPORTER WHERE PatientSSN="+(Long)patientSSN +
				" AND HSSSN=" + (Long)HSSSN;
		 
		
		rs = stmt.executeQuery(selectSQL);
		
		if (rs.next()){
			Date authDate = rs.getDate("authorizationDate");
			return new HealthSupporterDetails((Long)patientSSN, (Long)HSSSN, authDate);
		}
				
		return output;

		
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
	
	public void assignHS(Object patientSSN,Object HSSSN, boolean isprimary) throws Exception {
		if(isprimary)
			assignPrimaryHS(patientSSN,HSSSN);
		else
			assignSecondaryHS(patientSSN,HSSSN);
	}

	public void assignPrimaryHS(Object patientSSN, Object HSSSN) throws Exception {
		// TODO Auto-generated method stub

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1= null;
		
		
		try
		{
		
		con = getConnection();
		stmt = con.createStatement();
	    
		String selectSQL = "SELECT * FROM PATIENTTOHEALTHSUPPORTER WHERE PatientSSN="+(Long)patientSSN +
				" AND PRIMARYSECONDARY = primary";
		 
		
		rs = stmt.executeQuery(selectSQL);
		
		if (rs.next()){
			System.out.println("Primary Health Supporter has been assigned");
			return ;
		}
		rs.close();
		
		String insertSQL = "INSERT INTO PATIENTTOHEALTHSUPPORTER values("
				+ System.currentTimeMillis() + "," 
				+ "\'" + "primary"+ "\',"
				+ (Long) patientSSN+
				+ (Long) HSSSN+")";
		
		 
		rs1 = stmt.executeQuery(insertSQL);
		
		}catch(Exception e)
			{
			e.printStackTrace();
		}
		finally {
			rs.close();
			rs1.close();
			stmt.close();
			con.close();
			
		}
	}

	public void assignSecondaryHS(Object patientSSN, Object HSSSN) throws Exception {
			// TODO Auto-generated method stub

			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			ResultSet rs1=null;
			
			try
			{
			
			con = getConnection();
			stmt = con.createStatement();
		    
			String selectSQL = "SELECT * FROM PATIENTTOHEALTHSUPPORTER WHERE PatientSSN="+(Long)patientSSN +
					" AND PRIMARYSECONDARY = secondary";
			 
			
			rs = stmt.executeQuery(selectSQL);
			
			if (rs.next()){
				System.out.println("Secondary Health Supporter has been assigned");
				return ;
			}
			
			String insertSQL = "INSERT INTO PATIENTTOHEALTHSUPPORTER values("
					+ System.currentTimeMillis() + "," 
					+ "\'" + "secondary"+ "\',"
					+ (Long) patientSSN+
					+ (Long) HSSSN+")";
			
			 
			rs1 = stmt.executeQuery(insertSQL);
			

			
			}catch(Exception e)
				{
				e.printStackTrace();
			}
			finally {
				rs.close();
				rs1.close();
				stmt.close();
				con.close();
				
			}
		
		
	}

	public void removeSecondaryHS(Object patientSSN, Object HSSSN) throws Exception {
		// TODO Auto-generated method stub

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
		
		con = getConnection();
		stmt = con.createStatement();
	    
		String deleteSQL = " DELETE FROM PATIENT WHERE (HSSSN="
				+ (Integer)HSSSN +" AND PATIENTSSN=" +(Integer)patientSSN
				+ ")";
	 
		
		rs = stmt.executeQuery(deleteSQL);
		
		
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

	
	public void removePrimaryHS(Object patientSSN, Object HSSSN) throws Exception {
		// TODO Auto-generated method stub

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
		
		con = getConnection();
		stmt = con.createStatement();
	    
		if(new PatientDao.isSick(patientSSN)){
			String selectSQL = "SELECT * FROM PATIENTTOHEALTHSUPPORTER WHERE PatientSSN="+(Long)patientSSN +
					" AND PRIMARYSECONDARY = secondary";
			 
			
			rs = stmt.executeQuery(selectSQL);
			
			if (!rs.next()){
				System.out.println("Cannot remove primary supporter");
				return ;
			}
			String updateSQL = "UPDATE PATIENTTOHEALTHSUPPORTER "
					+ "SET PRIMARYSECONDARY = 'primary' "
					+ "WHERE PatientSSN="+(Long)patientSSN +
					" AND PRIMARYSECONDARY = secondary";
			rs = stmt.executeQuery(selectSQL);
		}
		
		
		String deleteSQL = " DELETE FROM PATIENT WHERE (HSSSN="
				+ (Integer)HSSSN +" AND PATIENTSSN=" +(Integer)patientSSN
				+ ")";
	 
		rs = stmt.executeQuery(deleteSQL);
		
		
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

	

	public void insertRow(HealthSupporterDetails x) throws Exception {
		// TODO Auto-generated method stub
		
	}





	public void deleteRow(HealthSupporterDetails x) throws Exception {
		// TODO Auto-generated method stub
		
	}





	public List<HealthSupporterDetails> getAllData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	




}
