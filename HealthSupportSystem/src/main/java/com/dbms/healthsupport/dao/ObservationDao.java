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


	public void deleteData(Observation x) throws Exception {
		// TODO Auto-generated method stub
		
	    Statement stmt = conn.createStatement();
	    
	 String deleteSQL = " DELETE FROM OBSERVATION WHERE (observationSpecificationId="
					+ x.getObservationId()
					+ ")";
			 
	    ResultSet rs = stmt.executeQuery(deleteSQL);
		
	}

	
	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		
		Statement stmt = conn.createStatement();
	    
		String dropSQL = "DROP TABLE OBSERVATION";
		 
		ResultSet rs = stmt.executeQuery(dropSQL);
		
	}

	public void insertRow(Observation x) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO OBSERVATION values ("
				+ x.getObservationId() + "," 
				+ x.getObservationValue() + ","
				+ x.getObservationTime() + ","
				+ x.getRecordedTime()
				+ ")";
		
		ResultSet rs = stmt.executeQuery(insertSQL);

	}

	public void deleteRow(Observation x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	public Observation getDataById(Object id) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM OBSERVATION WHERE OBSERVATIONID="+(Integer)id;
		 
		Observation output=null;
		
		ResultSet rs = stmt.executeQuery(selectSQL);
	

		while(rs.next())
		{
			int observationSpecificationId = rs.getInt("observationSpecificationId");
			String observationValue = rs.getString("observationValue");
			Date observationTime = rs.getDate("observationTime");
			Date recordedTime = rs.getDate("recordedTime");
			String patientSSN=rs.getString("PATIENTSSN");
			String selectSQL1 = "SELECT * FROM OBSERVATIONDETAILS WHERE OBSERVATIONID="+(Integer)id;
			String observationSpecName=null; 
			ResultSet rs1 = stmt.executeQuery(selectSQL1);
			while(rs1.next()){
				observationSpecName=rs1.getString("OBSERVATIONSPECNAME");
			}
			output=new Observation(observationSpecificationId, observationValue, observationTime, recordedTime,patientSSN,observationSpecName);
		}
		
		return output;
	}


	public List<Observation> getAllData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
