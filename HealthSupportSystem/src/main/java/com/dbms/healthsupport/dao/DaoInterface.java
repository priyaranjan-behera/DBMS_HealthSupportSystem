package com.dbms.healthsupport.dao;

public interface DaoInterface<T> {
	
	static final String jdbcURL = "jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01";
	
	static String user = "pbehera";	// For example, "jsmith"
    static String passwd = "200106212";	// Your 9 digit student ID number
	
	
	void createTable();
	void insertData();
	void deleteData();

}
