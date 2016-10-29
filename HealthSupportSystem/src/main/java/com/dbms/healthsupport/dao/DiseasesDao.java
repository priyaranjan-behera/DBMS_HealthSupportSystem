package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.Diseases;
import com.dbms.healthsupport.domain.People;


public class DiseasesDao implements	DaoInterface<Diseases> {
	Connection conn;
	
	public static Connection getConnection() throws SQLException
	{
	 return(DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "ssharm17", "200100060"));
		
	}

	public void insertRow(Diseases x) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	    
		try {
		conn = getConnection();
		stmt = conn.createStatement();
		
		String insertSQL = " INSERT INTO DISEASES values (\'"
				+ x.getDisName() + "\',\'" 
				+ x.getDisDescription()
				+ "\')";
		 
        rs = stmt.executeQuery(insertSQL);
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		
	}

	public void deleteRow(Diseases x) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	    
	    try {
        conn = getConnection();
        stmt = conn.createStatement();
        
		String deleteSQL = " DELETE FROM DISEASES WHERE (DiseaseName=\'"
				+ x.getDisName()
				+ "\')";
        rs = stmt.executeQuery(deleteSQL);
	    }catch(Exception e){
			e.printStackTrace();
		}finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		
	}

	public List<Diseases> getAllData() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		Statement stmt1 = null;
		Statement stmt2 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		List<Diseases> output = null;
		
	    try {
		conn = getConnection();
		stmt = conn.createStatement();
		stmt1 = conn.createStatement();
		stmt2 = conn.createStatement();
		
		//String selectSQL = "SELECT * FROM DISEASES d, RecommendationForDisease r, LimitsForDisease l where d.DiseaseName = r.DiseaseName AND l.DiseaseName = r.DiseaseName";
		String selectSQL = "SELECT * FROM DISEASES d";
		
		
		output = new ArrayList<Diseases>();
		
		
		rs = stmt.executeQuery(selectSQL);
	

		while(rs.next())
		{
			String disName = rs.getString("DiseaseName");
			String disDescription = rs.getString("DiseaseDescription");
			String selectSQL2 = "SELECT * FROM RecommendationForDisease r where r.DiseaseName =\'"+disName+"\'";
			
			List<Integer> recommendationIds = new ArrayList<Integer>();
			
			rs1 = stmt1.executeQuery(selectSQL2);
			
			while(rs1.next()) {
				
				recommendationIds.add(rs1.getInt("recommendationId"));
			}
			
            String selectSQL3 = "SELECT * FROM LimitsForDisease l where l.DiseaseName =\'"+disName+"\'";
			
			List<Integer> limitsIds = new ArrayList<Integer>();
			
			rs2 = stmt2.executeQuery(selectSQL3);
			
			while(rs2.next()) {
				
				limitsIds.add(rs2.getInt("limitId"));
			}
			
			output.add(new Diseases(disName,disDescription, recommendationIds, limitsIds));
		} 
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			rs.close();
			stmt.close();
			conn.close();
			rs1.close();
			rs2.close();
		}
		
		return output;
	}

	public Diseases getDataById(Object id) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
        Diseases output = null;    
	
        try {
        	
		    conn = getConnection();
		    stmt = conn.createStatement();
		    
        	String selectSQL = "SELECT * FROM DISEASES d where diseaseName =\'"+ String.valueOf(id) +"\'";
    		
    		rs = stmt.executeQuery(selectSQL);
    	

    	   if(rs.next())
    		{
    			String disName = rs.getString("DiseaseName");
    			String disDescription = rs.getString("DiseaseDescription");
    			String selectSQL2 = "SELECT * FROM RecommendationForDisease r where r.DiseaseName =\'"+disName+"\'";
    			
    			List<Integer> recommendationIds = new ArrayList<Integer>();
    			
    			ResultSet rs1 = stmt.executeQuery(selectSQL2);
    			
    			while(rs1.next()) {
    				
    				recommendationIds.add(rs1.getInt("recommendationId"));
    			}
    			
                String selectSQL3 = "SELECT * FROM LimitsForDisease l where l.DiseaseName =\'"+disName+"\'";
    			
    			List<Integer> limitsIds = new ArrayList<Integer>();
    			
    			ResultSet rs2 = stmt.executeQuery(selectSQL3);
    			
    			while(rs2.next()) {
    				
    				limitsIds.add(rs2.getInt("limitId"));
    			}
    			
    			output = new Diseases(disName,disDescription, recommendationIds, limitsIds);
    		}
        } catch(Exception e){
			throw e;
		}finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		return output;
	}
}





