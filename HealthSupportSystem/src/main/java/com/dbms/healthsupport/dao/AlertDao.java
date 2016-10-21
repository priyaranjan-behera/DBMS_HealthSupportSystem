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
		
	}

	public void deleteRow(Alert x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<Alert> getAllData() throws Exception {
		// TODO Auto-generated method stub
		
		return null;
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