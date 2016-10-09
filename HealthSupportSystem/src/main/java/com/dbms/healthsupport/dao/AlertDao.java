package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.Alert;

public class AlertDao implements DaoInterface<Alert> {

	
	Connection conn;
	
	public AlertDao() throws SQLException
	{
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}
	
	public void createTable() throws Exception {
		Statement stmt = conn.createStatement();
	    
		String createSQL = " CREATE TABLE ALERT ("
				+ "alertId Integer,"
				+ "alertType VARCHAR(10),"
				+ "alertAction VARCHAR(10))";
		
		ResultSet rs = stmt.executeQuery(createSQL);		
	}

	public void insertData(Alert x) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO ALERT values ("
				+ x.getAlertId() + "," 
				+ x.getAlertType() + ","
				+ x.getActionTaken() 
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
	}

	public void deleteData(Alert x) throws Exception {
		// TODO Auto-generated method stub
	    Statement stmt = conn.createStatement();
	    
			String deleteSQL = " DELETE FROM ALERT WHERE (alertId="
					+ x.getAlertId()
					+ ")";
			 
			ResultSet rs = stmt.executeQuery(deleteSQL);
		
	}

	public List<Alert> getData() throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String selectSQL = "SELECT * FROM ALERT)";
		 
		List<Alert> output = new ArrayList<Alert>();
		
		ResultSet rs = stmt.executeQuery(selectSQL);
	

		while(rs.next())
		{
			Integer alertId = rs.getInt("alertId");
			String alertType = rs.getString("alertType");
			String actionTaken = rs.getString("actionTaken");
			
			output.add(new Alert(alertId,alertType,actionTaken));
		}
		
		return output;
	}

	public void dropTable() throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
			Statement stmt = conn.createStatement();
		    
			String dropSQL = "DROP TABLE ALERT";
			 
			ResultSet rs = stmt.executeQuery(dropSQL);		
	}


	
}