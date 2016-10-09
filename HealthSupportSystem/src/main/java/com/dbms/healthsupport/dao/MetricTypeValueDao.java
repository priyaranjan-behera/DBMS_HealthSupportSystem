package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.MetricTypeValue;

public class MetricTypeValueDao implements DaoInterface<MetricTypeValue>{
	
    Connection conn;
	
	public MetricTypeValueDao() throws SQLException
	{
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}

	public void createTable() throws Exception {
		// TODO Auto-generated method stub
		
        Statement stmt = conn.createStatement();
	    
		String createSQL = " CREATE TABLE METRICTYPEVALUE ("
				+ "metricTypeValueID Integer,"
				+ "metricTypeValue VARCHAR(10))";
		
		ResultSet rs = stmt.executeQuery(createSQL);
		
	}

	public void insertData(MetricTypeValue x) throws Exception {
		// TODO Auto-generated method stub
		
	    Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO METRICTYPEVALUE values ("
				+ x.getMetricTypeValueID() + "," 
				+ x.getMetricTypeValue()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		
	}

	public void deleteData(MetricTypeValue x) throws Exception {
		// TODO Auto-generated method stub
		
        Statement stmt = conn.createStatement();
	    
		String deleteSQL = " DELETE FROM METRICTYPEVALUE WHERE (metricTypeValueID="
				+ x.getMetricTypeValueID()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(deleteSQL);
		
	}

	public List<MetricTypeValue> getData() throws Exception {
        
		Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM METRICTYPEVALUE";
		 
		List<MetricTypeValue> output = new ArrayList<MetricTypeValue>();
		
		ResultSet rs = stmt.executeQuery(selectSQL);
	

		while(rs.next())
		{
			int metricTypeValueID = rs.getInt("metricTypeValueID");
			String metricTypeValue = rs.getString("metricTypeValue");
			
			output.add(new MetricTypeValue(metricTypeValueID, metricTypeValue));
		}
		
		return output;
	}

	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
        Statement stmt = conn.createStatement();
	    
		String dropSQL = "DROP TABLE METRICTYPEVALUE";
		 
		ResultSet rs = stmt.executeQuery(dropSQL);
		
	}

	

}
