package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.People;
import com.dbms.healthsupport.domain.Recommendation;

public class RecommendationDao implements DaoInterface<Recommendation>{
	Connection conn;
	
	public RecommendationDao() throws SQLException
	{
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}
	public void createTable() throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String createSQL = " CREATE TABLE RECOMMENDATION ("
				+ "RecommendationID Integer,"
				+ "FrequencyID Integer"
				+ "Threshold Integer)";
		
		ResultSet rs = stmt.executeQuery(createSQL);
		
		
	}

	public void insertData(Recommendation x) throws Exception {
		// TODO Auto-generated method stub
		 Statement stmt = conn.createStatement();
		    
			String insertSQL = " INSERT INTO RECOMMENDATION values ("
					+ x.getrecId() + "," 
					+ x.getfreqId() + ","
					+ x.getThreshold() + ","
					+ ")";
			 
			ResultSet rs = stmt.executeQuery(insertSQL);
		
	}

	public void deleteData(Recommendation x) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String deleteSQL = " DELETE FROM RECOMMENDATION WHERE (RecommendationID="
				+ x.getrecId()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(deleteSQL);
	}

	public List<Recommendation> getData() throws Exception {
		// TODO Auto-generated method stub
Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM RECOMMENDATION)";
		 
		List<Recommendation> output = new ArrayList<Recommendation>();
		
		ResultSet rs = stmt.executeQuery(selectSQL);
	

		while(rs.next())
		{
			Integer recId = rs.getInt("RecommendationID");
			Integer freqId = rs.getInt("FrequencyID");
			Integer threshold = rs.getInt("Threshold");
			
			output.add(new Recommendation(recId,freqId,threshold));
		}
		
		return output;
	}

	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String dropSQL = "DROP TABLE RECOMMENDATION";
		 
		ResultSet rs = stmt.executeQuery(dropSQL);
	}
	
	

}
