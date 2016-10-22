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

	public LimitsDao() throws SQLException
	{
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}

	public void insertRow(Limits x) throws Exception {
		// TODO Auto-generated method stub
		
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
		Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM LIMITS";
		
		ResultSet rs = stmt.executeQuery(selectSQL);
		
		while(rs.next()){
			Integer limitID = rs.getInt("limitID");
			Integer lowerlimit = rs.getInt("lowerlimit");
			Integer upperlimit = rs.getInt("upperlimit");
			String metricID = rs.getString("metricID");
			String observationSpec = rs.getString("observationSpec");
			
			return new Limits(upperlimit, upperlimit, upperlimit, observationSpec, observationSpec);
			
		}
		
		return null;
	}

	
}
