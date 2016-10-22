package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.Frequency;
import com.dbms.healthsupport.domain.Limits;
import com.dbms.healthsupport.domain.People;


public class LimitsDao implements DaoInterface<Limits>{
	
	Connection conn;


	public static Connection getConnection() throws SQLException
	{
		return(DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "vette", "200107075"));
		
	}

	
	public void insertRow(Limits x) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
		
		con = getConnection();
		stmt = con.createStatement();
	    
		String insertSQL = " INSERT INTO LIMITS values ("
				+ x.getLimitID() + "," 
				+ x.getLowerLimit() + ","
				+ x.getUpperLimit() + ","
				+ x.getObservationSpec() + ","
				+ x.getMetricId()
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

	public void deleteRow(Limits x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<Limits> getAllData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Limits getDataById(Object id) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
		
		con = getConnection();
		stmt = con.createStatement();
	    
		String selectSQL = "SELECT * FROM LIMITS";
		
		rs = stmt.executeQuery(selectSQL);
		
		while(rs.next()){
			Integer limitID = rs.getInt("limitID");
			Integer lowerlimit = rs.getInt("lowerlimit");
			Integer upperlimit = rs.getInt("upperlimit");
			String metricID = rs.getString("metricID");
			String observationSpec = rs.getString("observationSpec");
			
			return new Limits(limitID, lowerlimit, upperlimit, metricID, observationSpec);
			
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			rs.close();
			stmt.close();
			con.close();
			
		}
		
		
		return null;
	}

	
}
