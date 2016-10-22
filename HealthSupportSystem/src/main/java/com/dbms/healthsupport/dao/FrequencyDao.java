package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.Frequency;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.People;


public class FrequencyDao implements DaoInterface<Frequency> {
	
	Connection conn;
	
	public FrequencyDao() throws SQLException
	{
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}

	public void insertRow(Frequency x) throws Exception {
		// TODO Auto-generated method stub
        Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO FREQUENCY values ("
				+ x.getFrequencyName() + "," 
				+ x.getDuration()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		
	}

	public void deleteRow(Frequency x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<Frequency> getAllData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Frequency getDataById(Object id) throws Exception {
		// TODO Auto-generated method stub
		
		Statement stmt = conn.createStatement();
		String selectSQL = "SELECT * FROM FREQUENCY";
		
		ResultSet rs = stmt.executeQuery(selectSQL);
		
		if(rs.next()){
			String frequencyDesc = rs.getString("frequencyDesc");
			Integer duration = rs.getInt("duration");
			
			return new Frequency(frequencyDesc, duration);
			
		}
		return null;
	}
	

}
