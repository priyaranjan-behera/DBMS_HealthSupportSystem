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
	public void createTable() throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String createSQL = " CREATE TABLE DISEASES ("
				+ "DiseaseName VARCHAR(10),"
				+ "DiseaseDescription VARCHAR(20))";
		
		ResultSet rs = stmt.executeQuery(createSQL);
		
		
	}

	public void insertData(Diseases x) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO DISEASES values ("
				+ x.getDisName() + "," 
				+ x.getDisDescription()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
	}
		

	public void deleteData(Diseases x) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String deleteSQL = " DELETE FROM DISEASES WHERE (DiseaseName="
				+ x.getDisName()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(deleteSQL);
	}

	public List<Diseases> getData() throws Exception {
		// TODO Auto-generated method stub
Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM DISEASES";
		 
		List<Diseases> output = new ArrayList<Diseases>();
		
		ResultSet rs = stmt.executeQuery(selectSQL);
	

		while(rs.next())
		{
			String disName = rs.getString("DiseaseName");
			String disDescription = rs.getString("DiseaseDescription");
			
			output.add(new Diseases(disName,disDescription));
		}
		
		return output;
	}

	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String dropSQL = "DROP TABLE DISEASES";
		 
		ResultSet rs = stmt.executeQuery(dropSQL);
		
	}



}
