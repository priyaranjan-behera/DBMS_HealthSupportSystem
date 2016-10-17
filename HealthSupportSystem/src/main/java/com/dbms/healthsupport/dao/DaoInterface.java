package com.dbms.healthsupport.dao;

import java.sql.SQLException;
import java.util.List;

public interface DaoInterface<T> {
	
	static final String jdbcURL = "jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01";
	
	static String user = "pbehera";	// For example, "jsmith"
    static String passwd = "200106212";	// Your 9 digit student ID number
	
	void insertRow(T x) throws Exception;
	void deleteRow(T x) throws Exception;
	List<T>getAllData() throws Exception;
	T getDataById(Object id) throws Exception;

}
