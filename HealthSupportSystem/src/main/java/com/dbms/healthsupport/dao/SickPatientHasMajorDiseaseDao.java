package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.dbms.healthsupport.domain.Diseases;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.SickPatient;

public class SickPatientHasMajorDiseaseDao  {
	
	public static Connection getConnection() throws SQLException
	{
		return(DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "vette", "200107075"));
		
	}

	public void addDiseaseDiagnoses(Patient x, Diseases y) throws Exception {
		// TODO Auto-generated method stub
		

		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		
		try
		{
			conn = getConnection();
			
			stmt = conn.createStatement();
			
			//This will be a check for shifting well patient to sick patient
			if(new PatientDao().isSick(x.getSsn())) {
		    
			String insertSQL = " INSERT INTO SickHasMajorDisease values ("
					+ x.getSsn() + ","
					+ y.getDisName()
					+ ")";
			
			 System.out.println("Query is: " + insertSQL);
			 
			rs = stmt.executeQuery(insertSQL);
			}
			
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
	
	public void deleteMappingSickPatientHasMajorDisease(SickPatient x, Diseases y) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
		    
			String deleteSQL = " DELETE FROM SickHasMajorDisease WHERE (PatientSSN="
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
	public void updateMappingSickPatientHasThisMajorDisease(SickPatient x, Diseases y) throws Exception {
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
			
			String selectSQL = "SELECT * FROM SickHasMajorDisease WHERE PatientSSN = " + x.getSsn() +" AND DiseaseName="+y.getDisName();
			rs = stmt.executeQuery(selectSQL);
			

			if(rs.next())
			{
		    
			String deleteSQL = " UPDATE SickHasMajorDisease SET (DiseaseName="
				    + y.getDisName() + " WHERE PatientSSN=" 
					+ x.getSsn()
					+ ")";
			 
			rs = stmt.executeQuery(deleteSQL); 
			} else{
				throw new Exception("No such mapping of Sick Patient to Disease exists. Cannot update mapping.");
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
