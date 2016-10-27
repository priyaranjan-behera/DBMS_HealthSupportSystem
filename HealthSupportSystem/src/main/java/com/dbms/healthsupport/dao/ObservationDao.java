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
import com.dbms.healthsupport.domain.ObservationMetricDetails;

public class ObservationDao implements DaoInterface<Observation> {
	
	
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "ssharm17", "200100060");
		
	}


	public void deleteData(Observation x) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
		    
			 String deleteSQL = " DELETE FROM OBSERVATION WHERE (observationId="
							+ x.getObservationId()
							+ ")";
					 
			 rs = stmt.executeQuery(deleteSQL);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			rs.close();
			stmt.close();
			conn.close();
		}
	    
		
	}

	
	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
		    
			String dropSQL = "DROP TABLE OBSERVATION";
			 
			rs = stmt.executeQuery(dropSQL);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		
		
		
		
	}

	public void insertRow(Observation x) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		ResultSet rs1 = null;
		Statement stmt1 = null;
		
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
		    
			String insertSQL = " INSERT INTO OBSERVATION values ("
					+ x.getObservationId() + "," 
					+ "TO_DATE(\'"+x.getObservationTime() + "\',\'YYYY-MM-DD\')" + ","
					+ "TO_DATE(\'"+x.getRecordedTime() + "\',\'YYYY-MM-DD\')" + ",\'"
					+ x.getPatientId()
					+ "\')";
			System.out.println("Query: " + insertSQL);
			
			rs = stmt.executeQuery(insertSQL);
			
			for(ObservationMetricDetails metricDetails: x.getMetricDetails())
			{
				stmt1 = conn.createStatement();
			    
				String insertSQL1 = " INSERT INTO OBSERVATIONDETAILS values ("
						+ x.getObservationId() + ",\'" 
						+ x.getObservationSpecification() + "\',\'"
						+ metricDetails.getMetricName() + "\',\'"
						+ metricDetails.getMetricValue() + "\'"
						+ ")";
				System.out.println("Query: " + insertSQL1);
				rs1 = stmt1.executeQuery(insertSQL1);
				
				rs1.close();
				stmt1.close();
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			rs.close();
			stmt.close();
			rs1.close();
			stmt1.close();
			conn.close();
			
		}
		
		
	}

	public void deleteRow(Observation x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	public Observation getDataById(Object id) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		ResultSet rs1 = null;
		Statement stmt1 = null;
		
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
		    
			String selectSQL = "SELECT * FROM OBSERVATION WHERE OBSERVATIONID="+(Integer)id;
			 
			Observation output=null;
			
			rs = stmt.executeQuery(selectSQL);
			
			stmt1 = conn.createStatement();
			String selectSQL1 = "SELECT * FROM OBSERVATIONDETAILS WHERE OBSERVATIONID="+(Integer)id;
			rs1 = stmt1.executeQuery(selectSQL1);
			
			List<ObservationMetricDetails> metricDetails = new ArrayList<ObservationMetricDetails>();
			String observationSpec = null;
			while(rs1.next())
			{
				observationSpec = rs1.getString("observationSpecName");
				String metricName = rs1.getString("metricName");
				String metricValue = rs1.getString("observationValue");
				metricDetails.add(new ObservationMetricDetails(metricName, metricValue));
			}

			if(rs.next())
			{
				int observationId = rs.getInt("observationId");
				Date observationTime = rs.getDate("observationTime");
				Date recordedTime = rs.getDate("recordedTime");
				String patientSSN=rs.getString("PATIENTSSN");
				
				return new Observation(observationId, observationTime, recordedTime, patientSSN, observationSpec, metricDetails);
			}
			
			return output;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		
		return null;
		
	}


	public List<Observation> getAllData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
