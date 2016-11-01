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

import com.dbms.healthsupport.domain.Diseases;
import com.dbms.healthsupport.domain.HealthSupporter;
import com.dbms.healthsupport.domain.HealthSupporterDetails;
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
			throw e;
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
	
	public void makePatientAHealthSupporter(Patient x) throws Exception
	{
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
		    
			try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String insertSQL = " INSERT INTO HEALTHSUPPORTER values (\'"
					+ x.getSsn() + "\'," 
					+ "0"
					+ ")";
			 
	        rs = stmt.executeQuery(insertSQL);
			} catch(Exception e){
				e.printStackTrace();
			}finally {
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
			stmt = conn.prepareCall("{call \"UpdatePatientProc\" (?,?,?,?,?,?,?)}");
			
			
			stmt.setString("p_gender", x.getGender());
			stmt.setDate("p_dob", x.getDob());
			stmt.setString("p_ssn", x.getSsn());
			stmt.setString("p_firstname",x.getFirstName());
			stmt.setString("p_lastname",x.getLastName());
			stmt.setString("p_address",x.getAddress());
			stmt.setString("p_password",x.getPassword());
			
			stmt.executeUpdate();
		}catch(Exception e){
			throw e;
		}finally {
			conn.close();
			stmt.close();
		}
		
		
	}
	
	public void AssignDiseaseToPatient(Patient x, Diseases y) throws Exception {
		Connection conn = null;
		CallableStatement stmt = null;
		
		try{
			conn = getConnection();
			stmt = conn.prepareCall("{call \"AssignDiseaseToPatient\" (?,?)}");
			
			
			stmt.setString("p_ssn", x.getSsn());
			stmt.setString("d_name", y.getDisName());
			
			stmt.executeUpdate();
		}catch(Exception e){
			throw e;
		}finally {
			conn.close();
			stmt.close();
		}
		
	}
	public void AssignPrimaryHealthSupporter (HealthSupporterDetails z) throws Exception{
		Connection conn = null;
		CallableStatement stmt = null;
		
		try{
			conn = getConnection();
			stmt = conn.prepareCall("{call \"assignPrimarySupporter\" (?,?,?)}");
			
			
			stmt.setString("patientSSN", z.getPatientSSN());
			stmt.setString("hsSSN", z.getHealthSupporterSSN());
			stmt.setDate("authorizationDate", z.getAuthDate());
			
			stmt.executeQuery();
		}catch(Exception e){
			throw e;
		}finally {
			conn.close();
			stmt.close();
		}
	}
	
	public void AssignSecondaryHealthSupporter (HealthSupporterDetails z) throws Exception{
		Connection conn = null;
		CallableStatement stmt = null;
		
		try{
			conn = getConnection();
			stmt = conn.prepareCall("{call \"assignSecondarySupporter\" (?,?,?)}");
			
			
			stmt.setString("patientSSN", z.getPatientSSN());
			stmt.setString("hsSSN", z.getHealthSupporterSSN());
			stmt.setDate("authorizationDate", z.getAuthDate());
			
			stmt.executeQuery();
		}catch(Exception e){
			throw e;
		}finally {
			conn.close();
			stmt.close();
		}
	}
	
	public void deleteSecondaryHealthSupporter (String hsSSN, String patientSSN) throws Exception{
		Connection conn = null;
		CallableStatement stmt = null;
		
		try{
			conn = getConnection();
			stmt = conn.prepareCall("{call \"deleteSecondarySupporter\" (?,?)}");
			
			
			stmt.setString("patientSSN", patientSSN);
			stmt.setString("hsSSN", hsSSN);
			
			stmt.executeQuery();
		}catch(Exception e){
			throw e;
		}finally {
			conn.close();
			stmt.close();
		}
	}

	
	public void deletePrimaryHealthSupporter (String hsSSN, String patientSSN) throws Exception{
		Connection conn = null;
		CallableStatement stmt = null;
		
		try{
			conn = getConnection();
			stmt = conn.prepareCall("{call \"deletePrimarySupporter\" (?,?)}");
			
			
			stmt.setString("patientSSN", patientSSN);
			stmt.setString("hsSSN", hsSSN);
			
			stmt.executeQuery();
		}catch(Exception e){
			throw e;
		}finally {
			if(conn != null)
				conn.close();
			if(conn != null)
				stmt.close();
		}
	}
	
	
	public List<Patient> getAllData() throws Exception {
		// TODO Auto-generated method stub
		
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
		    
			String selectSQL = "SELECT * FROM PATIENT";
			rs = stmt.executeQuery(selectSQL);
			
			List<Patient> patients = new ArrayList<>();

			while(rs.next())
			{
				Date dob = rs.getDate("DOB");
				String gender = rs.getString("gender");
				String ssn = rs.getString("PatientSSN");
				
				PeopleDao peopleDao =new PeopleDao();
				People people=peopleDao.getDataById(ssn);
				
				Patient patient = new Patient(people, dob, gender);
				
				
				patients.add(patient);
			}
			
			return patients;

		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally {
			if(rs != null)
			rs.close();
			if(stmt != null)
			stmt.close();
			if(conn != null)
			conn.close();
		}
		
		
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
				String selectSQL1 = "SELECT * FROM PatientToHealthSupporter WHERE PatientSSN = \'" + String.valueOf(ssn) + "\'AND primarySecondary =\'Primary\'";
				ResultSet rs1 = stmt.executeQuery(selectSQL1);
				String primaryHealthSupporter=null;
				if(rs1.next()){
					primaryHealthSupporter=rs1.getString("HsSSN");
				}
				
				
				String selectSQL2 = "SELECT * FROM PatientToHealthSupporter  WHERE PatientSSN = \'" +String.valueOf(ssn) + "\'AND primarySecondary =\'Secondary\'";
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
					observations.add(rs6.getInt("observationId"));
				}
				
				
				return new Patient(String.valueOf(ssn), people.getFirstName(), people.getLastName(), people.getAddress(), people.getPassword(), dob, gender, primaryHealthSupporter, secondaryHealthSupporters, recommendations, limits, diseases, observations);
			}

		}catch (Exception e) {
			// TODO: handle exception
			throw e;
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
