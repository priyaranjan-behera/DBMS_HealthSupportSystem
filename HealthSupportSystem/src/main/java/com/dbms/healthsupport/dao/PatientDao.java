package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.People;

public class PatientDao implements DaoInterface<Patient> {
	
	Connection conn;
	
	public PatientDao() throws SQLException {
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}
	
	public void insertRow(Patient x) throws Exception {
		Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO PATIENT values ("
				+ x.getSsn() + "," 
				+ x.getDob() + ","
				+ x.getGender()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		
	}

	public void deleteRow(Patient x) throws Exception {
		  Statement stmt = conn.createStatement();
		    
				String deleteSQL = " DELETE FROM PATIENT WHERE (ssn="
						+ x.getSsn()
						+ ")";
				 
				ResultSet rs = stmt.executeQuery(deleteSQL);
		
	}

	public List<Patient> getAllData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Patient getDataById(Object ssn) throws Exception {
		Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM PATIENT  WHERE ssn = " + (Long)ssn;
		ResultSet rs = stmt.executeQuery(selectSQL);
		

		if(rs.next())
		{
			Date dob = rs.getDate("DOB");
			String gender = rs.getString("gender");
			
			PeopleDao peopleDao =new PeopleDao();
			People people=peopleDao.getDataById(ssn);
			
			//Only those health supporters that have auth date before current date should be retrieved.
			String selectSQL1 = "SELECT * FROM PatientAssignedToHealthSupporter  WHERE PatientSSN = " + (Long)ssn + "AND primarySecondary =\"primary\"";
			ResultSet rs1 = stmt.executeQuery(selectSQL1);
			Long primaryHealthSupporter=null;
			if(rs1.next()){
				primaryHealthSupporter=rs1.getLong("HsSSN");
			}
			
			
			String selectSQL2 = "SELECT * FROM PatientAssignedToHealthSupporter  WHERE PatientSSN = " + (Long)ssn + "AND primarySecondary =\"secondary\"";
			ResultSet rs2 = stmt.executeQuery(selectSQL2);
			
			List<Long> secondaryHealthSupporters=new ArrayList<Long>();
			while(rs2.next()){
				secondaryHealthSupporters.add(rs2.getLong("HsSSN"));
			}
			
			String selectSQL3 = "SELECT * FROM LimitsForPatient  WHERE PatientSSN = " + (Long)ssn ;
			ResultSet rs3 = stmt.executeQuery(selectSQL3);
			
			List<Integer> limits=new ArrayList<Integer>();
			while(rs3.next()){
				limits.add(rs3.getInt("limitId"));
			}
			
			String selectSQL4 = "SELECT * FROM RecommendationForPatient  WHERE PatientSSN = " + (Long)ssn;
			ResultSet rs4 = stmt.executeQuery(selectSQL4);
			
			List<Integer> recommendations=new ArrayList<Integer>();
			while(rs4.next()){
				recommendations.add(rs4.getInt("recommendationId"));
			}
			
			String selectSQL5 = "SELECT * FROM WellPatientHasMinorDisease  WHERE PatientSSN = " + (Long)ssn + "UNION" + "SELECT * FROM SickHasMajorDisease  WHERE PatientSSN = " + (Long)ssn;
			ResultSet rs5 = stmt.executeQuery(selectSQL5);
			
			List<String> diseases=new ArrayList<String>();
			while(rs5.next()){
				diseases.add(rs4.getString("diseaseName"));
			}
			
			String selectSQL6 = "SELECT * FROM Observation WHERE PatientSSN="+ (Long)ssn ;
			ResultSet rs6 = stmt.executeQuery(selectSQL6);
			
			List<Integer> observations=new ArrayList<Integer>();
			while(rs6.next()){
				observations.add(rs4.getInt("observation"));
			}
			
			
			return new Patient((Long)ssn, people.getFirstName(), people.getLastName(), people.getAddress(), people.getPassword(), dob, gender, primaryHealthSupporter, secondaryHealthSupporters, recommendations, limits, diseases, observations);
		}
		
		return null;

	}
	

	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String dropSQL = "DROP TABLE PATIENT";
		 
		ResultSet rs = stmt.executeQuery(dropSQL);
	}


}
