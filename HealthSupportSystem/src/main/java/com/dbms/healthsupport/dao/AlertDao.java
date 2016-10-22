package com.dbms.healthsupport.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.domain.Alert;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.People;

public class AlertDao implements DaoInterface<Alert> {

	
	Connection conn;
	
	public AlertDao() throws SQLException
	{
		this.conn = DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "pbehera", "200106212");
		
	}

	public void insertRow(Alert x) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String insertSQL = " INSERT INTO ALERT values ("
				+ x.getAlertId()+ "," 
				+ x.getAlertType()+ ","
				+ x.getPatientId()+ ","
				+ x.getActionTaken()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(insertSQL);
		
		
	}

	public void deleteRow(Alert x) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	    
		String deleteSQL = " DELETE FROM ALERT WHERE (alertId="
				+ x.getAlertId()
				+ ")";
		 
		ResultSet rs = stmt.executeQuery(deleteSQL);
		
	}

	public List<Alert> getAllData() throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = conn.createStatement();
	
		String selectSQL = "SELECT * FROM ALERT";
		
		List<Alert> output = new ArrayList<Alert>();
		
		ResultSet rs = stmt.executeQuery(selectSQL);
	

		while(rs.next()) {
			
			Integer id = rs.getInt("alertId");
			String alertType = rs.getString("alertType");
			Long patientSSN = rs.getLong("patientSSN");
			String alertAction = rs.getString("alertAction");
			Integer limitId = rs.getInt("limitId");

			output.add(new Alert((Integer)id, alertType, alertAction, patientSSN, limitId, true));
		}
		
		return output;
	}

	public Alert getDataById(Object id) throws Exception {
		
			Statement stmt = conn.createStatement();
			String selectSQL1 = "SELECT a.alertType, a.patientSSN, a.alertAction, al.limitId FROM ALERT a, ALERTFORLIMIT al  WHERE a.alertId = " + (Long)id + " AND al.alertId = "+ (Long)id; 
			String selectSQL2 = "SELECT a.alertType, a.patientSSN, a.alertAction, rc.recommendationId FROM ALERT a, ALERTFORRECOMMENDATION rc  WHERE a.alertId = " + (Long)id + " AND rc.alertId = "+ (Long)id;
			
			ResultSet rs = stmt.executeQuery(selectSQL1);
			
			if(rs.next())
			{
				String alertType = rs.getString("alertType");
				Long patientSSN = rs.getLong("patientSSN");
				String alertAction = rs.getString("alertAction");
				Integer limitId = rs.getInt("limitId");
				
				return new Alert((Integer)id, alertType, alertAction, patientSSN, limitId, true);
			}
			else
			{
				rs = stmt.executeQuery(selectSQL2);

				if(rs.next())
				{
					String alertType = rs.getString("alertType");
					Long patientSSN = rs.getLong("patientSSN");
					String alertAction = rs.getString("alertAction");
				
					Integer recId = rs.getInt("recommendationId");
					
					return new Alert((Integer)id, alertType, alertAction, patientSSN, recId, false);
					
				}
			}
		return null;
	}


	
}