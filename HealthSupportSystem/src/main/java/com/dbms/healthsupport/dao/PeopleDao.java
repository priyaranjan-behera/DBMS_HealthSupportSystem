package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PeopleDao {
	
	static final String jdbcURL = "jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01";
	
	static String user = "pbehera";	// For example, "jsmith"
    static String passwd = "200106212";	// Your 9 digit student ID number
	
	
	
	public static void main(String[] args) throws SQLException
	{
		//Connection conn = DriverManager.getConnection(jdbcURL,user,passwd);
		Connection conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
		Statement stmt = conn.createStatement();
		
		//String createSQL = " CREATE TABLE table1 ("
		//		+ "SSN Integer,"
		//		+ "FirstName VARCHAR(10))";
		
		String insertSQL = "INSERT INTO table1 VALUES(12345, 'Akshay')";
		ResultSet rs = stmt.executeQuery(insertSQL);
		
		String selectSQL = "SELECT SSN, FirstName FROM table1";
		rs = stmt.executeQuery(selectSQL);
		
		while(rs.next())
		{
			Long r1 = rs.getLong("SSN");
			System.out.println("Name: " + r1 );
			
			String r2 = rs.getString("FirstName");
			System.out.println("Name: " + r2);
		}
		
	}
	
	
	

}
