package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dbms.healthsupport.domain.Observation;

public class ObservationDao implements DaoInterface<Observation> {
	
    Connection conn;
	
	public ObservationDao() throws SQLException
	{
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}

	public void createTable() throws Exception {
		// TODO Auto-generated method stub
		
	    Statement stmt = conn.createStatement();
	    
		String createSQL = " CREATE TABLE OBSERVATION ("
				+ "observationSpecificationId Integer,"
				+ "observationValue VARCHAR(10),"
				+ "observationTime DATE,"
				+ "recordedTime DATE)";
		
		ResultSet rs = stmt.executeQuery(createSQL);
	
	}

	public void insertData(Observation x) throws Exception {
		// TODO Auto-generated method stub
		

	    Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO OBSERVATION values ("
				+ x.getObservationSpecificationId() + "," 
				+ x.getObservationValue() + ","
				+ x.getObservationTime() + ","
				+ x.getRecordedTime()
				+ ")";
		
		ResultSet rs = stmt.executeQuery(insertSQL);
		
	}

	public void deleteData(Observation x) throws Exception {
		// TODO Auto-generated method stub
		
	    Statement stmt = conn.createStatement();
	    
	 String deleteSQL = " DELETE FROM OBSERVATION WHERE (observationSpecificationId="
					+ x.getObservationSpecificationId()
					+ ")";
			 
	    ResultSet rs = stmt.executeQuery(deleteSQL);
		
	}

	public List<Observation> getData() throws Exception {
		// TODO Auto-generated method stub
Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM OBSERVATION";
		 
		List<Observation> output = new ArrayList<Observation>();
		
		ResultSet rs = stmt.executeQuery(selectSQL);
	

		while(rs.next())
		{
			int observationSpecificationId = rs.getInt("observationSpecificationId");
			String observationValue = rs.getString("observationValue");
			Date observationTime = rs.getDate("observationTime");
			Date recordedTime = rs.getDate("recordedTime");
			
			output.add(new Observation(observationSpecificationId, observationValue, observationTime, recordedTime));
		}
		
		return output;
	}

	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		
		Statement stmt = conn.createStatement();
	    
		String dropSQL = "DROP TABLE OBSERVATION";
		 
		ResultSet rs = stmt.executeQuery(dropSQL);
		
	}

}
