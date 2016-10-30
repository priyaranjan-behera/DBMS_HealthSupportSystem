package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.Metric;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.People;


public class metricDao implements DaoInterface<Metric> {
	
	Connection conn;
	
	public static Connection getConnection() throws SQLException
	{
	 return(DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "ssharm17", "200100060"));
		
	}


	public void insertRow(Metric x) throws Exception {
		// TODO Auto-generated method stub
	    Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
	   try{ 
		conn = getConnection();
		stmt = conn.createStatement();
		String insertSQL = " INSERT INTO METRICINOBSSPEC values (\'"
				+ x.getName() + "\'," 
				+ x.getObservationSpecification()
				+ ")";
		 
        rs = stmt.executeQuery(insertSQL);
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			rs.close();
			stmt.close();
			conn.close();
		}
	   
		
	}

	public void deleteRow(Metric x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<Metric> getAllData() throws Exception {
		// TODO Auto-generated method stub
		/*
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
	   try{ 
		conn = getConnection();
		stmt = conn.createStatement();
		String selectSQL = "SELECT * FROM FREQUENCY";
         rs = stmt.executeQuery(selectSQL);
		
         List<Metric> frequencies = new ArrayList<Metric>();
		while(rs.next()){
			String frequencyDesc = rs.getString("frequencyName");
			Integer duration = rs.getInt("duration");
			
			frequencies.add(new Metric(frequencyDesc, duration));
			
		}
		
	   return frequencies;
	   } catch(Exception e){
			throw e;
		}finally {
			rs.close();
			stmt.close();
			conn.close();
		}
	   */
		
		return null;
		
	}

	public Metric getDataById(Object id) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
	   try{ 
		conn = getConnection();
		stmt = conn.createStatement();
		String selectSQL = "SELECT * FROM METRICINOBSSPEC";
         rs = stmt.executeQuery(selectSQL);
		
		if(rs.next()){
			String metricName = rs.getString("metricName");
			String obsSpecName = rs.getString("observationSpecName");
			
			return new Metric(obsSpecName, metricName, 1);
			
		}} catch(Exception e){
			throw e;
		}finally {
			rs.close();
			stmt.close();
			conn.close();
		}
	   
		return null;
	}
	

}
