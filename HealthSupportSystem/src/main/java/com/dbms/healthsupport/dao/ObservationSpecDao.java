package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.ObservationSpec;


public class ObservationSpecDao implements DaoInterface<ObservationSpec>{
	
	Connection conn;
	
	public ObservationSpecDao() throws SQLException
	{
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}
	
	public void insertData(ObservationSpec x) throws Exception {
	    Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO OBSERVATIONSPEC values ("
				+ x.getObservationName() + "," 
				+ x.getDescription()
				+ ")";
		
		ResultSet rs = stmt.executeQuery(insertSQL);
		
		for(String metric: x.getMetrics())
		{
			insertSQL = "INSERT INTO METRICINOBSSPEC values ("
				+ metric + "," 
				+ x.getObservationName()
				+ ")";
			
			rs = stmt.executeQuery(insertSQL);
		}
		 

	}

	public void deleteData(ObservationSpec x) throws Exception {
		// TODO Auto-generated method stub

	    Statement stmt = conn.createStatement();
	    
		String deleteSQL = " DELETE FROM OBSERVATIONSPEC WHERE (observationName="
				+ x.getObservationName()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(deleteSQL);
		
	}

	
	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String dropSQL = "DROP TABLE OBSERVATIONSPEC";
		 
		ResultSet rs = stmt.executeQuery(dropSQL);
		
	}

	public void insertRow(ObservationSpec x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void deleteRow(ObservationSpec x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<ObservationSpec> getAllData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ObservationSpec getDataById(Object id) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM OBSERVATIONSPEC WHERE OBSERVATIONSPEC=)"+(String)id;
		 
		ObservationSpec output =null;
		
		ResultSet rs = stmt.executeQuery(selectSQL);
	

		while(rs.next())
		{
			String observationName = rs.getString("observationName");
			String description = rs.getString("description");
			
			String selectSQL1 = "SELECT * FROM METRICINOBSSPEC WHERE OBSERVATIONSPEC=)"+(String)id;
			 
			List<String> metrics=new ArrayList<String>();
			ResultSet rs1 = stmt.executeQuery(selectSQL);
			while(rs1.next()){
				metrics.add(rs1.getString("METRICNAME"));
			}
			
			output=new ObservationSpec(observationName,description,metrics);
		}
		
		return output;
	}
	
}
