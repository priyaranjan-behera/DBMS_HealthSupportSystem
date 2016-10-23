package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.dbms.healthsupport.domain.Diseases;
import com.dbms.healthsupport.domain.SickPatient;
import com.dbms.healthsupport.domain.WellPatient;

public class WellPatientHasMinorDiseaseDao{
	
	
	public static Connection getConnection() throws SQLException
	{
		return(DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "vette", "200107075"));
		
	}
	
	public void addDiseaseDiagnoses(WellPatient x, Diseases y) throws Exception {
		// TODO Auto-generated method stub
		

		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		
		try
		{
			
			conn = getConnection();
			
			stmt = conn.createStatement();
			
			WellPatient wellPatient = new WellPatient(x);
			WellPatientDao wellPatientDao = new WellPatientDao();
			wellPatientDao.insertRow(wellPatient);
			
			String insertSQL = " INSERT INTO  WellPatientHasMinorDisease values ("
					+ x.getSsn() + ", \'" 
					+ y.getDisName()
					+ "\')";
			
			 System.out.println("Query is: " + insertSQL);
			 
			rs = stmt.executeQuery(insertSQL);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		
	}
	
	public void deleteMappingWellPatientHasMinorDisease(WellPatient x, Diseases y) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
		    
			String deleteSQL = " DELETE FROM WellHasMinorDisease WHERE (PatientSSN="
					+ x.getSsn()+ " AND DiseaseName="
				    + y.getDisName()
					+ ")";
			 
			rs = stmt.executeQuery(deleteSQL);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		
	}
	
	@SuppressWarnings("resource")
	public void updateMappingWellPatientHasThisMinorDisease(WellPatient x, Diseases y) throws Exception {
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
			
			String selectSQL = "SELECT * FROM WellHasMinorDisease WHERE PatientSSN = " + x.getSsn() +" AND DiseaseName="+y.getDisName();
			rs = stmt.executeQuery(selectSQL);
			

			if(rs.next())
			{
		    
			String deleteSQL = " UPDATE WellHasMinorDisease SET (DiseaseName="
				    + y.getDisName() + " WHERE PatientSSN=" 
					+ x.getSsn()
					+ ")";
			 
			rs = stmt.executeQuery(deleteSQL); 
			} else{
				throw new Exception("No such mapping of Well Patient to Disease exists. Cannot update mapping.");
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			conn.close();
		}
	}
}
