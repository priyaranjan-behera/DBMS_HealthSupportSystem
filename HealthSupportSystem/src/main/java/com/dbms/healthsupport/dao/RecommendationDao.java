package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.Alert;
import com.dbms.healthsupport.domain.People;
import com.dbms.healthsupport.domain.Recommendation;

public class RecommendationDao implements DaoInterface<Recommendation>{
	Connection conn;
	
	public RecommendationDao() throws SQLException
	{
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}

	public void insertRow(Recommendation x) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO RECOMMENDATION values ("
				+ x.getRecId()+ ","
				+ x.getThreshold()+ ","
				+ x.getObservationSpecification()+ ","
				+ x.getFrequencyName()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		
		
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
		Statement stmt = conn.createStatement();
		String selectSQL = "SELECT * FROM RECOMMENDATION  WHERE recommendationId = " + (Integer)id; 
		
		ResultSet rs = stmt.executeQuery(selectSQL);
		
		if(rs.next())
		{
			Integer recommendationId = rs.getInt("recommendationId");
			String frequencyId = rs.getString("frequencyId");
			Integer threshold = rs.getInt("threshold");
			String observationSpecName = rs.getString("observationSpecName");
		 
			return new Recommendation(recommendationId, frequencyId, threshold, observationSpecName);
		}
		
		return null;
	}
	
	
	

}
