package com.dbms.healthsupport.dao;

import java.sql.CallableStatement;
import oracle.sql.ARRAY;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.ObservationSpec;

import oracle.sql.ArrayDescriptor;


public class ObservationSpecDao implements DaoInterface<ObservationSpec>{
	
	
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "ssharm17", "200100060");
		
	}
	
	public void insertData(ObservationSpec x) throws Exception {
	    
		Connection conn = null;
		CallableStatement stmt = null;
		
		try{
			conn = getConnection();
			stmt = conn.prepareCall("{call \"AddObservationSpecAndMetric\" (?)}");
			
			String array[] = null;
			int count = 0;
			for(String metric: x.getMetrics())
			{
				array[count] = metric;
				count+=1;
			}
			ArrayDescriptor des = ArrayDescriptor.createDescriptor("ssharm17.\"Metric\"",conn);
			ARRAY array_to_pass = new ARRAY(des,conn,array);
			stmt.setString(1, x.getObservationName());
			stmt.setString(2, x.getDescription());
			stmt.setArray(3, array_to_pass);

			stmt.executeUpdate();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			conn.close();
			stmt.close();
		}
		/*
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try
		{	
			conn = getConnection();
			stmt = conn.createStatement();
		    
			String insertSQL = " INSERT INTO OBSERVATIONSPEC values (\'"
					+ x.getObservationName() + "\',\'" 
					+ x.getDescription()
					+ "\')";
			
			rs = stmt.executeQuery(insertSQL);
			
			for(String metric: x.getMetrics())
			{
				insertSQL = "INSERT INTO METRICINOBSSPEC values (\'"
					+ metric + "\',\'" 
					+ x.getObservationName()
					+ "\')";
				
				rs = stmt.executeQuery(insertSQL);
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			rs.close();
			stmt.close();
			conn.close();
		}
			*/	 

	}

	public void deleteData(ObservationSpec x) throws Exception {
		// TODO Auto-generated method stub
		

		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
		    
			String deleteSQL = " DELETE FROM OBSERVATIONSPEC WHERE (observationName=\'"
					+ x.getObservationName()
					+ "\')";
			 
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
		    
			String dropSQL = "DROP TABLE OBSERVATIONSPEC";
			 
			rs = stmt.executeQuery(dropSQL);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		
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
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		Statement stmt1 = null;
		
		try
		{
			conn = getConnection();
			stmt = conn.createStatement();
		    stmt1 = conn.createStatement();
		    
			String selectSQL = "SELECT * FROM OBSERVATIONSPEC WHERE OBSERVATIONSPECNAME=\'"+(String)id+"\'";
			 
			ObservationSpec output =null;
			
			rs = stmt.executeQuery(selectSQL);
		

			while(rs.next())
			{
				String observationName = rs.getString("observationSpecName");
				String description = rs.getString("description");
				
				String selectSQL1 = "SELECT * FROM METRICINOBSSPEC WHERE OBSERVATIONSPECNAME=\'"+(String)id+"\'";
				 
				List<String> metrics=new ArrayList<String>();
				rs1 = stmt1.executeQuery(selectSQL1);
				while(rs1.next()){
					metrics.add(rs1.getString("METRICNAME"));
				}
				
				output=new ObservationSpec(observationName,description,metrics);
			}
			
			return output;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			rs1.close();
			stmt1.close();
			rs.close();
			stmt.close();
			conn.close();
		}
		
		return null;

		}
			
}
