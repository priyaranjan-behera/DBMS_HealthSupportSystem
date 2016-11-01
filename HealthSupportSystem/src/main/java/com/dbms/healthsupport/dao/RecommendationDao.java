package com.dbms.healthsupport.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.Alert;
import com.dbms.healthsupport.domain.Diseases;
import com.dbms.healthsupport.domain.Limits;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.People;
import com.dbms.healthsupport.domain.Recommendation;

public class RecommendationDao implements DaoInterface<Recommendation>{
	Connection conn;
	
	
	public static Connection getConnection() throws SQLException
	{
		return(DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "ssharm17", "200100060"));
		
	}

	public void insertRow(Recommendation x) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO RECOMMENDATION values ("
				+ x.getRecId()+ ","
				+ x.getThreshold()+ ",\'"
				+ x.getObservationSpecification()+ "\',\'"
				+ x.getFrequencyName()+"\'"
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		stmt.close();
		rs.close();
	}
	
	public List<Integer> getGeneralRecommendations() throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		
		List<Integer> list = new ArrayList<>();
	    
		String insertSQL = " SELECT RecommendationID FROM RECOMMENDATION WHERE RecommendationID NOT IN "
				+ "(SELECT RecommendationID from RecommendationForPatient) AND RecommendationID NOT IN "
				+ "(SELECT RecommendationID from RecommendationForDisease)";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		
		while(rs.next())
		{
			list.add(rs.getInt("RecommendationId"));
		}
		
		if(stmt != null)
			stmt.close();
		if(rs != null)
			rs.close();
		
		return list;
	}

	public void recommendationForPatient(Recommendation x, Patient p) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO RECOMMENDATION values ("
				+ x.getRecId()+ ","
				+ x.getThreshold()+ ",\'"
				+ x.getObservationSpecification()+ "\',\'"
				+ x.getFrequencyName()+"\'"
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		String insertSQL1 = " INSERT INTO RECOMMENDATIONFORPATIENT values (\'"
				+ p.getSsn()+ "\',"
				+ x.getRecId()
				+ ")";
		ResultSet rs2 = stmt.executeQuery(insertSQL1);
		stmt.close();
		rs.close();
		rs2.close();
	}
	
	public void DiseaseSpecificRecommendation(Recommendation x, Diseases d) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try{
			
			conn = getConnection();
			stmt = conn.createStatement();
			
			String insertSQL1 = " INSERT INTO RECOMMENDATION values ("
					+ x.getRecId()+ ","
					+ x.getThreshold()+ ","
					+ x.getObservationSpecification()+ ","
					+ x.getFrequencyName()
					+ ")";
		
			rs =  stmt.executeQuery(insertSQL1);
			String insertSQL2 = " INSERT INTO RECOMMENDATIONFORDISEASE values (\'"
				+ d.getDisName() + "\',\'" 
				+ x.getRecId()
				+ "\')";
		 
        rs2 = stmt.executeQuery(insertSQL2);
					
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			conn.close();
			rs2.close();
		}
		
	}
	
	public Recommendation insertGeneralRecommendation(Recommendation x) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		Connection con = null;
		CallableStatement stmt = null;
		
		try
		{
		
		con = getConnection();
		
		stmt = con.prepareCall("{call \"AddGeneralRecommendation\" (?,?,?,?)}");
	    
		stmt.setString("observationSpecName", x.getObservationSpecification());
		stmt.setString("frequencyName", x.getFrequencyName());
		stmt.setLong("threshold", x.getThreshold());
		stmt.registerOutParameter("recommendationId", java.sql.Types.INTEGER);
		
		stmt.executeQuery();
		
		
		Integer recommendationId = stmt.getInt("recommendationId");
		

		System.out.println("Returned Recommendation ID: " + recommendationId);
		return new RecommendationDao().getDataById(recommendationId);
		
		
		}catch(Exception e)
		{
		throw e;
		}
		finally {
			stmt.close();
			con.close();
			
		}
		
		
	}
	
	public Recommendation insertDiseaseRecommendation(Recommendation x, Diseases y) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		Connection con = null;
		CallableStatement stmt = null;
		
		try
		{
		
			con = getConnection();
			
			stmt = con.prepareCall("{call \"AddDiseaseRecommendation\" (?,?,?,?,?)}");
		 
			stmt.setString("observationSpecName", x.getObservationSpecification());
			stmt.setString("frequencyName", x.getFrequencyName());
			stmt.setLong("threshold", x.getThreshold());
			stmt.setString("diseaseName", y.getDisName());
			stmt.registerOutParameter("recommendationId", java.sql.Types.INTEGER);
			
			
			stmt.executeQuery();
			

			Integer recommendationId = stmt.getInt("recommendationId");
			

			System.out.println("Returned Recommendation ID: " + recommendationId);
			return new RecommendationDao().getDataById(recommendationId);
			
	
		
		}catch(Exception e)
		{
		throw e;
		}
		finally {
			stmt.close();
			con.close();
			
		}
		
		
	}
	

	

	public Recommendation insertPatientRecommendation(Recommendation x, Patient y) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		Connection con = null;
		CallableStatement stmt = null;
		
		try
		{
		
		con = getConnection();
		
		stmt = con.prepareCall("{call \"AddPatientRecommendation\" (?,?,?,?,?)}");
	 

		stmt.setString("observationSpecName", x.getObservationSpecification());
		stmt.setString("frequencyName", x.getFrequencyName());
		stmt.setLong("threshold", x.getThreshold());
		stmt.setString("patientSSN", y.getSsn());
		stmt.registerOutParameter("recommendationId", java.sql.Types.INTEGER);
		
		
		
		stmt.executeQuery();
		

		Integer recommendationId = stmt.getInt("recommendationId");
		

		System.out.println("Returned Recommendation ID: " + recommendationId);
		return new RecommendationDao().getDataById(recommendationId);
		
		
		
		}catch(Exception e)
		{
		throw e;
		}
		finally {
			stmt.close();
			con.close();
			
		}
		
		
	}



	public void deleteRow(Recommendation x) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			
		conn = getConnection();	
		stmt = conn.createStatement();
		String selectSQL = "DELETE FROM RECOMMENDATION  WHERE recommendationId = " + x.getRecId(); 
		
		rs = stmt.executeQuery(selectSQL);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		
	}

	public List<Recommendation> getAllData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Recommendation getDataById(Object id) throws Exception {
		// TO
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			
		conn = getConnection();	
		stmt = conn.createStatement();
		String selectSQL = "SELECT * FROM RECOMMENDATION  WHERE recommendationId = " + (Integer)id; 
		
		rs = stmt.executeQuery(selectSQL);
		
		if(rs.next())
		{
			Integer recommendationId = rs.getInt("recommendationId");
			String frequencyName = rs.getString("frequencyName");
			Integer threshold = rs.getInt("threshold");
			String observationSpecName = rs.getString("observationSpecName");
		 
			return new Recommendation(recommendationId, frequencyName, threshold, observationSpecName);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		return null;
	}
	
	
	

}
