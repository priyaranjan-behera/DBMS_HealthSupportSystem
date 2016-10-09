package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.ObservationSpec;
import com.dbms.healthsupport.domain.People;


public class ObservationSpecDao implements DaoInterface<ObservationSpec>{
	
	Connection conn;
	
	public ObservationSpecDao() throws SQLException
	{
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}
	
	public void createTable()throws SQLException {
		Statement stmt = conn.createStatement();
	    
		String createSQL = " CREATE TABLE OBSERVATIONSPEC ("
				+ "observationName VARCHAR(10),"
				+ "description VARCHAR(10))";
		
		ResultSet rs = stmt.executeQuery(createSQL);
	
	}

	
	public void insertData(ObservationSpec x) throws Exception {
	    Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO OBSERVATIONSPEC values ("
				+ x.getObservationName() + "," 
				+ x.getDescription()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
	}

	public void deleteData(ObservationSpec x) throws Exception {
		// TODO Auto-generated method stub

	    Statement stmt = conn.createStatement();
	    
		String deleteSQL = " DELETE FROM OBSERVATIONSPEC WHERE (observationName="
				+ x.getObservationName()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(deleteSQL);
		
	}

	public List<ObservationSpec> getData() throws Exception {
		Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM OBSERVATIONSPEC)";
		 
		List<ObservationSpec> output = new ArrayList<ObservationSpec>();
		
		ResultSet rs = stmt.executeQuery(selectSQL);
	

		while(rs.next())
		{
			String observationName = rs.getString("observationName");
			String description = rs.getString("description");
			
			output.add(new ObservationSpec(observationName,description));
		}
		
		return output;
	}

	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String dropSQL = "DROP TABLE OBSERVATIONSPEC";
		 
		ResultSet rs = stmt.executeQuery(dropSQL);
		
	}
	
}
