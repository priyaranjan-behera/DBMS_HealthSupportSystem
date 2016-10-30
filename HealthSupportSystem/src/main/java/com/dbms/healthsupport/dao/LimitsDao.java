package com.dbms.healthsupport.dao;

import java.sql.CallableStatement;
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
import com.dbms.healthsupport.domain.Patient;
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
		CallableStatement stmt = null;
		ResultSet rs = null;
		
		try
		{
		
		con = getConnection();
		
		stmt = con.prepareCall("{call \"AddGeneralLimit\" (?,?,?,?,?)}");
	    
		stmt.setString("observationSpecName", x.getObservationSpec());
		stmt.setString("metricName", x.getMetricId());
		stmt.setString("upperLimit", x.getUpperLimit());
		stmt.setString("lowerLimit", x.getLowerLimit());
		stmt.registerOutParameter("limitId", java.sql.Types.INTEGER);
		
		stmt.executeUpdate();
		
		
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
	
	public List<Integer> getGeneralLimits() throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		
		List<Integer> list = new ArrayList<>();
	    
		String insertSQL = " SELECT LimitID FROM Limits WHERE LimitId NOT IN "
				+ "(SELECT LimitId from LimitsForPatient) AND LimitId NOT IN "
				+ "(SELECT LimitId from LimitsForDisease)";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		
		while(rs.next())
		{
			list.add(rs.getInt("limitId"));
		}
		
		if(stmt != null)
			stmt.close();
		if(rs != null)
			rs.close();
		
		return list;
	}
	
	public Limits insertGeneralLimit(Limits x) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		Connection con = null;
		CallableStatement stmt = null;
		
		try
		{
		
		con = getConnection();
		
		stmt = con.prepareCall("{call \"AddGeneralLimit\" (?,?,?,?,?)}");
	    
		stmt.setString("observationSpecName", x.getObservationSpec());
		stmt.setString("metricName", x.getMetricId());
		stmt.setString("upperLimit", x.getUpperLimit());
		stmt.setString("lowerLimit", x.getLowerLimit());
		stmt.registerOutParameter("limitId", java.sql.Types.INTEGER);
		
		stmt.executeQuery();
		
		
		Integer limitId = stmt.getInt("limitId");
		

		System.out.println("Returned Limit ID: " + limitId);
		return new LimitsDao().getDataById(limitId);
		
		
		}catch(Exception e)
		{
		throw e;
		}
		finally {
			stmt.close();
			con.close();
			
		}
		
		
	}
	
	public Limits insertDiseaseLimit(Limits x, Diseases y) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		Connection con = null;
		CallableStatement stmt = null;
		
		try
		{
		
			con = getConnection();
			
			stmt = con.prepareCall("{call \"AddDiseaseLimit\" (?,?,?,?,?,?)}");
		 
			stmt.setString("observationSpecName", x.getObservationSpec());
			stmt.setString("metricName", x.getMetricId());
			stmt.setString("upperLimit", x.getUpperLimit());
			stmt.setString("lowerLimit", x.getLowerLimit());
			stmt.setString("diseaseName", y.getDisName());
			stmt.registerOutParameter("limitId", java.sql.Types.INTEGER);
			
			stmt.executeQuery();
			
			Integer limitId = stmt.getInt("limitId");
			
			return new LimitsDao().getDataById(limitId);
				
		
		}catch(Exception e)
		{
		throw e;
		}
		finally {
			stmt.close();
			con.close();
			
		}
		
		
	}
	

	

	public Limits insertPatientLimit(Limits x, Patient y) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		Connection con = null;
		CallableStatement stmt = null;
		
		try
		{
		
		con = getConnection();
		
		stmt = con.prepareCall("{call \"AddPatientLimit\" (?,?,?,?,?,?)}");
	 
		stmt.setString("observationSpecName", x.getObservationSpec());
		stmt.setString("metricName", x.getMetricId());
		stmt.setString("upperLimit", x.getUpperLimit());
		stmt.setString("lowerLimit", x.getLowerLimit());
		stmt.setString("patientName", y.getSsn());
		stmt.registerOutParameter("limitId", java.sql.Types.INTEGER);
		
		stmt.executeQuery();
		
		Integer limitId = stmt.getInt("limitId");
		
		return new LimitsDao().getDataById(limitId);
		
		
		}catch(Exception e)
		{
		throw e;
		}
		finally {
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
	    
		String selectSQL = "SELECT * FROM LIMITS WHERE limitID = "+id;
		
		rs = stmt.executeQuery(selectSQL);
		
		while(rs.next()){
			Integer limitID = rs.getInt("limitID");
			String lowerlimit = rs.getString("lowerlimit");
			String upperlimit = rs.getString("upperlimit");
			String metricID = rs.getString("metricName");
			String observationSpec = rs.getString("observationSpecName");
			
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
