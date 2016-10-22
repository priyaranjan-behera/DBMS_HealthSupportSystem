package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.HealthSupporter;
import com.dbms.healthsupport.domain.MetricTypeValue;
import com.dbms.healthsupport.domain.People;

public class MetricTypeValueDao implements DaoInterface<MetricTypeValue>{
	
	Connection conn;


	public static Connection getConnection() throws SQLException
	{
		return(DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "vette", "200107075"));
		
	}

	public void createTable() throws Exception {
		// TODO Auto-generated method stub
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
		
		con = getConnection();
		stmt = con.createStatement();
	    
		String createSQL = " CREATE TABLE METRICTYPEVALUE ("
				+ "metricTypeValueID Integer,"
				+ "metricTypeValue VARCHAR(10))";
		
		rs = stmt.executeQuery(createSQL);
		}catch(Exception e)
		{
		e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			con.close();
			
		}
		
		
	}

	

	public List<MetricTypeValue> getData() throws Exception {
        
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<MetricTypeValue> output = new ArrayList<MetricTypeValue>();
		
		try
		{
			
			con = getConnection();
			
			stmt = con.createStatement();
		    
			String selectSQL = "SELECT * FROM METRICTYPEVALUE";
			
			rs = stmt.executeQuery(selectSQL);
		
	
			while(rs.next())
			{
				int metricTypeValueID = rs.getInt("metricTypeValueID");
				String metricTypeValue = rs.getString("metricTypeValue");
				
				output.add(new MetricTypeValue(metricTypeValueID, metricTypeValue));
			}
			
			return output;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			con.close();
		}
		return output;
	}

	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			con = getConnection();
			
			stmt = con.createStatement();
		
			String dropSQL = "DROP TABLE METRICTYPEVALUE";
		 
			rs = stmt.executeQuery(dropSQL);
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			con.close();
		}
		
	}	

	public void insertRow(MetricTypeValue x) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			con = getConnection();
			stmt = con.createStatement();
		    
			String insertSQL = " INSERT INTO METRICTYPEVALUE values ("
					+ x.getMetricTypeValue() + "," 
					+ x.getMetricTypeValueID()
					+ ")";
			 
			rs = stmt.executeQuery(insertSQL);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			con.close();
		}
		
	
	}

	public void deleteRow(MetricTypeValue x) throws Exception {
		// TODO Auto-generated method stub
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
		
		con = getConnection();
		stmt = con.createStatement();
	    
		String deleteSQL = " DELETE FROM METRICTYPEVALUE WHERE (metricTypeValueID="
				+ x.getMetricTypeValueID()
				+ ")";
		 
		rs = stmt.executeQuery(deleteSQL);
		}catch(Exception e)
		{
		e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			con.close();
			
		}
		
	}

	public List<MetricTypeValue> getAllData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public MetricTypeValue getDataById(Object id) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		MetricTypeValue output=null;
		
		try
		{
		
			con = getConnection();
			stmt = con.createStatement();
	
			String selectSQL = "SELECT * FROM METRICTYPEVALUE WHERE METRICTYPEVALUEID="+(Integer)id;
			 
			rs = stmt.executeQuery(selectSQL);
			
			while(rs.next()){
				Integer metricTypeValueId=rs.getInt("metricTypeValueId");
				String metricTypeValue=rs.getString("metricTypeValue");
				output=new MetricTypeValue(metricTypeValueId,metricTypeValue);
			}
		return output;
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			con.close();
		}
		return output;
	}

	

}
