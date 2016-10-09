package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.Limits;
import com.dbms.healthsupport.domain.People;


public class LimitsDao implements DaoInterface<Limits>{
	
	Connection conn;

	public LimitsDao() throws SQLException
	{
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}
	public void createTable() throws Exception {
		// TODO Auto-generated method stub
Statement stmt = conn.createStatement();
	    
		String createSQL = " CREATE TABLE LIMITS ("
				+ "LimitID Integer,"
				+ "LowerLimit Integer"
				+ "UpperLimit Integer)";
		
		ResultSet rs = stmt.executeQuery(createSQL);
		
		
		
	}

	public void insertData(Limits x) throws Exception {
		// TODO Auto-generated method stub
Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO LIMITS values ("
				+ x.getlimitID() + "," 
				+ x.getlowerLimit() + ","
				+ x.getupperLimit() + ","
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
	}

	public void deleteData(Limits x) throws Exception {
		// TODO Auto-generated method stub
		 Statement stmt = conn.createStatement();
		    
			String deleteSQL = " DELETE FROM LIMITS WHERE (limitID="
					+ x.getlimitID()
					+ ")";
			 
			ResultSet rs = stmt.executeQuery(deleteSQL);
		
	}

	public List<Limits> getData() throws Exception {
		// TODO Auto-generated method stub
Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM LIMITS";
		 
		List<Limits> output = new ArrayList<Limits>();
		
		ResultSet rs = stmt.executeQuery(selectSQL);
	

		while(rs.next())
		{
			Integer limitID = rs.getInt("LimitID");
			Integer lowerLimit = rs.getInt("LowerLimit");
			Integer upperLimit = rs.getInt("UpperLimit");

			
			output.add(new Limits(limitID, lowerLimit, upperLimit));
		}
		
		return output;
	}

	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String dropSQL = "DROP TABLE LIMITS";
		 
		ResultSet rs = stmt.executeQuery(dropSQL);
	}

	
}
