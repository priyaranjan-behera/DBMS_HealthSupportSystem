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
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "ssharm17", "200100060"));
		
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
	    
		String selectSQL = "SELECT * FROM PATIENTHEALTHSUPPORTER WHERE PatientSSN=\'"+(String)patientSSN +
				"\' AND HSSSN=\'" + (String)HSSSN+"\'";
		 
		
		rs = stmt.executeQuery(selectSQL);
		
		if (rs.next()){
			Date authDate = rs.getDate("authorizationDate");
			return new HealthSupporterDetails(String.valueOf(patientSSN), String.valueOf(HSSSN), authDate);
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
	
	public void assignHS(Object patientSSN,Object HSSSN, Date d,boolean isprimary) throws Exception {
		if(isprimary)
			assignPrimaryHS(patientSSN,HSSSN,d);
		else
			assignSecondaryHS(patientSSN,HSSSN,d);
	}

	public void assignPrimaryHS(Object patientSSN, Object HSSSN, Date d) throws Exception {
		// TODO Auto-generated method stub

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1= null;
		
		
		try
		{
		
		con = getConnection();
		stmt = con.createStatement();
	    
		String selectSQL = "SELECT * FROM PATIENTTOHEALTHSUPPORTER WHERE PatientSSN=\'"+(String)patientSSN +
				"\' AND PRIMARYSECONDARY = 'primary'";
		 
		
		rs = stmt.executeQuery(selectSQL);
		
		if (rs.next()){
			System.out.println(rs.getInt("patientSSN"));
			System.out.println("Primary Health Supporter has been assigned");
			return ;
		}
		
		String insertSQL = "INSERT INTO PATIENTTOHEALTHSUPPORTER values("
				+ "TO_DATE(\'"+d + "\',\'YYYY-MM-DD\')" + ","+ "\'" + "primary"+ "\',\'"
				+ (String) HSSSN + "\',\'"
				+ (String) patientSSN+"\')";
		
		 
		rs1 = stmt.executeQuery(insertSQL);
		
		}catch(Exception e)
			{
			e.printStackTrace();
		}
		finally {
			if(rs!=null)
				rs.close();
			if(rs1!=null)
				rs.close();
			stmt.close();
			con.close();
			
		}
	}

	public void assignSecondaryHS(Object patientSSN, Object HSSSN, Date d) throws Exception {
			// TODO Auto-generated method stub

			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			ResultSet rs1=null;
			
			try
			{
			
			con = getConnection();
			stmt = con.createStatement();
		    
			String selectSQL = "SELECT * FROM PATIENTTOHEALTHSUPPORTER WHERE PatientSSN=\'"+(String)patientSSN +
					"\' AND PRIMARYSECONDARY = 'secondary'";
			 
			
			rs = stmt.executeQuery(selectSQL);
			
			if (rs.next()){
				System.out.println("Secondary Health Supporter has been assigned");
				return ;
			}
			
			String insertSQL = "INSERT INTO PATIENTTOHEALTHSUPPORTER values("
					+ "TO_DATE(\'"+d + "\',\'YYYY-MM-DD\')" + ",\'" + "secondary"+ "\',\'"
					+ (String) HSSSN+ "\',\'"
					+ (String) patientSSN+"\')";
			
			 
			rs1 = stmt.executeQuery(insertSQL);
			

			
			}catch(Exception e)
				{
				e.printStackTrace();
			}
			finally {
				if(rs!=null)
					rs.close();
				if(rs1!=null)
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
	    
		String deleteSQL = " DELETE FROM PATIENT WHERE (HSSSN=\'"
				+ (String)HSSSN +"\' AND PATIENTSSN=\'" +(String)patientSSN
				+ "\')";
	 
		
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
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		try
		{
		
		con = getConnection();
		stmt = con.createStatement();
	    
		if(new PatientDao().isSick(patientSSN)){
			String selectSQL = "SELECT * FROM PATIENTTOHEALTHSUPPORTER WHERE PatientSSN=\'"+(String)patientSSN +
					"\' AND PRIMARYSECONDARY = 'secondary'";
			 
			
			rs = stmt.executeQuery(selectSQL);

			if (rs.next()){
				String updateSQL = "UPDATE PATIENTTOHEALTHSUPPORTER "
						+ "SET PRIMARYSECONDARY = 'primary' "
						+ "WHERE PatientSSN=\n"+(String)patientSSN +
						"\n AND PRIMARYSECONDARY = secondary";
				rs1 = stmt.executeQuery(updateSQL);
			
			}else{
				System.out.println("Cannot remove primary supporter");
				throw new Exception("Cannot remove primary supporter");
			
			}
			
		}
		
		
		String deleteSQL = " DELETE FROM PATIENTTOHEALTHSUPPORTER WHERE (HSSSN=\'"
				+ (String)HSSSN +"\' AND PATIENTSSN=\'" +(String)patientSSN
				+ "\')";
	 
		rs2 = stmt.executeQuery(deleteSQL);
		rs2.close();
		
		
		}catch(Exception e)
			{
			e.printStackTrace();
		}
		finally {
			if(rs!=null)
				rs.close();
			if(rs1!=null)
				rs1.close();
			if(rs2!=null)
				rs2.close();
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
