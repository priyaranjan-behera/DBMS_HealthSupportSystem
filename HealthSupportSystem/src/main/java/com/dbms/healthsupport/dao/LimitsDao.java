package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.Diseases;
import com.dbms.healthsupport.domain.Frequency;
import com.dbms.healthsupport.domain.Limits;
import com.dbms.healthsupport.domain.People;


public class LimitsDao implements DaoInterface<Limits>{
	
	Connection conn;


	public static Connection getConnection() throws SQLException
	{
		return(DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "ssharm17", "200100060"));
		
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
	
	public void insertDiseaseSpecificLimit(Limits x, Diseases y) throws Exception
	{
		LimitsDao limitsDao = new LimitsDao();
		limitsDao.insertRow(x);
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
		
		con = getConnection();
		stmt = con.createStatement();
	    
		String insertSQL = " INSERT INTO LIMITSFORDISEASE values (\'"
				+ y.getDisName() + "\'," 
				+ x.getLimitID()
				+ ")";
		 
		System.out.println("Insert Query: " + insertSQL);
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
			String lowerlimit = rs.getString("lowerlimit");
			String upperlimit = rs.getString("upperlimit");
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

	
	public void personalizedLimit(Limits x, People y) throws SQLException {
		
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
		

		String insertSQL1 = " INSERT INTO PEOPLE values (\'"
				+ y.getSsn() + "\',\'" 
				+ y.getFirstName() + "\',\'"
				+ y.getLastName() + "\',\'"
				+ y.getAddress() + "\',\'"
				+ y.getPassword()
				+ "\')";
		
		System.out.println("Query: " + insertSQL1);
		rs = stmt.executeQuery(insertSQL1);
		
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
	
}
