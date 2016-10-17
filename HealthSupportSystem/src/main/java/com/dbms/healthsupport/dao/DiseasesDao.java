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
	
	public DiseasesDao() throws SQLException{	
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
	
	}

	public void insertRow(Diseases x) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO DISEASES values ("
				+ x.getDisName() + "," 
				+ x.getDisDescription()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		
	}

	public void deleteRow(Diseases x) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String deleteSQL = " DELETE FROM DISEASES WHERE (DiseaseName="
				+ x.getDisName()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(deleteSQL);
		
	}

	public List<Diseases> getAllData() throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		//String selectSQL = "SELECT * FROM DISEASES d, RecommendationForDisease r, LimitsForDisease l where d.DiseaseName = r.DiseaseName AND l.DiseaseName = r.DiseaseName";
		String selectSQL = "SELECT * FROM DISEASES d";
		
		
		List<Diseases> output = new ArrayList<Diseases>();
		
		
		ResultSet rs = stmt.executeQuery(selectSQL);
	

		while(rs.next())
		{
			String disName = rs.getString("DiseaseName");
			String disDescription = rs.getString("DiseaseDescription");
			String selectSQL2 = "SELECT * FROM RecommendationForDisease r where r.DiseaseName ="+disName;
			
			List<Integer> recommendationIds = new ArrayList<Integer>();
			
			ResultSet rs1 = stmt.executeQuery(selectSQL2);
			
			while(rs1.next()) {
				
				recommendationIds.add(rs1.getInt("recommendationIds"));
			}
			
            String selectSQL3 = "SELECT * FROM LimitsForDisease l where l.DiseaseName ="+disName;
			
			List<Integer> limitsIds = new ArrayList<Integer>();
			
			ResultSet rs2 = stmt.executeQuery(selectSQL3);
			
			while(rs2.next()) {
				
				limitsIds.add(rs2.getInt("limitId"));
			}
			
			output.add(new Diseases(disName,disDescription, recommendationIds, limitsIds));
		}
		
		return output;
	}

	public Diseases getDataById(Object id) throws Exception {
		// TODO Auto-generated method stub
Statement stmt = conn.createStatement();
	    
	
		//Cross check if works
        String selectSQL = "SELECT * FROM DISEASES d where diseaseName ="+ String.valueOf(id);
		
		
		Diseases output = null;
		
		
		ResultSet rs = stmt.executeQuery(selectSQL);
	

	   if(rs.next())
		{
			String disName = rs.getString("DiseaseName");
			String disDescription = rs.getString("DiseaseDescription");
			String selectSQL2 = "SELECT * FROM RecommendationForDisease r where r.DiseaseName ="+disName;
			
			List<Integer> recommendationIds = new ArrayList<Integer>();
			
			ResultSet rs1 = stmt.executeQuery(selectSQL2);
			
			while(rs1.next()) {
				
				recommendationIds.add(rs1.getInt("recommendationIds"));
			}
			
            String selectSQL3 = "SELECT * FROM LimitsForDisease l where l.DiseaseName ="+disName;
			
			List<Integer> limitsIds = new ArrayList<Integer>();
			
			ResultSet rs2 = stmt.executeQuery(selectSQL3);
			
			while(rs2.next()) {
				
				limitsIds.add(rs2.getInt("limitId"));
			}
			
			output = new Diseases(disName,disDescription, recommendationIds, limitsIds);
		}
		
		return output;
	}
}





