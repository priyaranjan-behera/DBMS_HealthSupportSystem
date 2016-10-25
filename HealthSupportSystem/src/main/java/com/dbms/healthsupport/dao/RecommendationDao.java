package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.Alert;
import com.dbms.healthsupport.domain.Diseases;
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

	public void deleteRow(Recommendation x) throws Exception {
		// TODO Auto-generated method stub
		
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
