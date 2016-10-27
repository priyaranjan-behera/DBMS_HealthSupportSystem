package com.dbms.healthsupport.dao;

import java.sql.CallableStatement;
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
	
	static Connection conn;
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "ssharm17", "200100060");
		
	}
	
	public boolean isSick(Object ssn) throws Exception
	{	

		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
		    
			String selectSQL = "SELECT * FROM SICKPATIENT  WHERE patientSSN = \'" + (String)ssn+"\'";
			rs = stmt.executeQuery(selectSQL);
			
			if(rs.next())
				return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		
		return false;
		
	}
	
	public void insertRow(Patient x) throws Exception {
		
		Connection conn = null;
		CallableStatement stmt = null;
		
		try{
			conn = getConnection();
			stmt = conn.prepareCall("{call \"AddPatientProc\" (?,?,?,?,?,?,?)}");
			
			stmt.setString("p_ssn", x.getSsn());
			stmt.setDate("p_dob", x.getDob());
			stmt.setString("p_gender", x.getGender());
			stmt.setString("p_FirstName", x.getFirstName());
			stmt.setString("p_LastName", x.getLastName());
			stmt.setString("p_Address", x.getAddress());
			stmt.setString("p_Password", x.getPassword());
			
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			conn.close();
			stmt.close();
		}
			
	}

	public void deleteRow(Patient x) throws Exception {
		
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
		    
			String deleteSQL = " DELETE FROM PATIENT WHERE (ssn=\'"
					+ x.getSsn()
					+ "\')";
			 
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
	public void updateRow(Patient x) throws Exception{
		
		Connection conn = null;
		CallableStatement stmt = null;
		
		try{
			conn = getConnection();
			stmt = conn.prepareCall("{call \"UpdatePatientProc\" (?,?,?)}");
			
			
			stmt.setString("GENDER", x.getGender());
			stmt.setDate("DOB", x.getDob());
			stmt.setString("PATIENTSSN", x.getSsn());
			stmt.setString(4,x.getFirstName());
			stmt.setString(5,x.getLastName());
			stmt.setString(6,x.getAddress());
			stmt.setString(7,x.getPassword());
			
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			conn.close();
			stmt.close();
		}
		
		/*
		Statement stmt = null;
		Connection conn = null;
		//ResultSet rs = null;
		
		try{
			
			conn = getConnection();
			stmt = conn.createStatement();
			String updateSQL = "UPDATE PATIENT SET dob ="+ "TO_DATE(\'"+x.getDob() + "\',\'YYYY-MM-DD\')" + "," + "gender ="+ x.getGender() +" WHERE (ssn=\'"+ x.getSsn() +"\')";
		
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
		}*/
	}
	public List<Patient> getAllData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Patient getDataById(Object ssn) throws Exception {
		
		
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
		    
			String selectSQL = "SELECT * FROM PATIENT  WHERE patientSSN = \'" + String.valueOf(ssn)+"\'";
			rs = stmt.executeQuery(selectSQL);
			

			if(rs.next())
			{
				Date dob = rs.getDate("DOB");
				String gender = rs.getString("gender");
				
				PeopleDao peopleDao =new PeopleDao();
				People people=peopleDao.getDataById(ssn);
				
				//Only those health supporters that have auth date before current date should be retrieved.
				String selectSQL1 = "SELECT * FROM PatientToHealthSupporter WHERE PatientSSN = \'" + String.valueOf(ssn) + "\'AND primarySecondary =\'primary\'";
				ResultSet rs1 = stmt.executeQuery(selectSQL1);
				Long primaryHealthSupporter=null;
				if(rs1.next()){
					primaryHealthSupporter=rs1.getLong("HsSSN");
				}
				
				
				String selectSQL2 = "SELECT * FROM PatientToHealthSupporter  WHERE PatientSSN = \'" +String.valueOf(ssn) + "\'AND primarySecondary =\'secondary\'";
				ResultSet rs2 = stmt.executeQuery(selectSQL2);
				
				List<String> secondaryHealthSupporters=new ArrayList<String>();
				while(rs2.next()){
					secondaryHealthSupporters.add(rs2.getString("HsSSN"));
				}
				
				String selectSQL3 = "SELECT * FROM LimitsForPatient  WHERE PatientSSN = \'" + String.valueOf(ssn)+"\'";
				ResultSet rs3 = stmt.executeQuery(selectSQL3);
				
				List<Integer> limits=new ArrayList<Integer>();
				while(rs3.next()){
					limits.add(rs3.getInt("limitId"));
				}
				
				String selectSQL4 = "SELECT * FROM RecommendationForPatient  WHERE PatientSSN = \'" + String.valueOf(ssn)+"\'";
				ResultSet rs4 = stmt.executeQuery(selectSQL4);
				
				List<Integer> recommendations=new ArrayList<Integer>();
				while(rs4.next()){
					recommendations.add(rs4.getInt("recommendationId"));
				}
				
				String selectSQL5 = "SELECT * FROM WellPatientHasMinorDisease  WHERE PatientSSN = \'" + String.valueOf(ssn)+ "\' UNION " + "SELECT * FROM SickHasMajorDisease  WHERE PatientSSN = \'" + String.valueOf(ssn) + "\'";
				ResultSet rs5 = stmt.executeQuery(selectSQL5);
				
				List<String> diseases=new ArrayList<String>();
				while(rs5.next()){
					diseases.add(rs5.getString("diseaseName"));
				}
				
				String selectSQL6 = "SELECT * FROM Observation WHERE PatientSSN=\'"+ ssn + "\'";
				ResultSet rs6 = stmt.executeQuery(selectSQL6);
				
				List<Integer> observations=new ArrayList<Integer>();
				while(rs6.next()){
					observations.add(rs6.getInt("observation"));
				}
				
				
				return new Patient(String.valueOf(ssn), people.getFirstName(), people.getLastName(), people.getAddress(), people.getPassword(), dob, gender, primaryHealthSupporter, secondaryHealthSupporters, recommendations, limits, diseases, observations);
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
		    String dropSQL = "DROP TABLE PATIENT";
			rs = stmt.executeQuery(dropSQL);

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


}
