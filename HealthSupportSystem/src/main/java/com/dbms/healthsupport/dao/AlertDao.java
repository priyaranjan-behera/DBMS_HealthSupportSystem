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
	
	public static Connection getConnection() throws SQLException
	{
	 return(DriverManager.getConnection
				  ("jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", "ssharm17", "200100060"));
		
	}

	public void insertRow(Alert x) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
	    try {
		conn = getConnection();
		stmt = conn.createStatement();
		String insertSQL = " INSERT INTO ALERT values ("
				+ x.getAlertId()+ "," 
				+ x.getAlertType()+ ","
				+ x.getPatientId()+ ","
				+ x.getActionTaken()
				+ ")";
		 
        rs = stmt.executeQuery(insertSQL);
	    } catch(Exception e){
			e.printStackTrace();
		}finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		
	}

	public void deleteRow(Alert x) throws Exception {
		// TODO Auto-generated method stub
	    
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String deleteSQL = " DELETE FROM ALERT WHERE (alertId="
					+ x.getAlertId()
					+ ")";
			 
            rs = stmt.executeQuery(deleteSQL);
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			rs.close();
			stmt.close();
			conn.close();
		}
	}

	public List<Alert> getAllData() throws Exception {
		// TODO Auto-generated method stub
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Alert> output = null;
		
		try{
			con = getConnection();
            stmt = con.createStatement();
            
            String selectSQL = "SELECT * FROM ALERT";
    		output = new ArrayList<Alert>();
    		
    		rs = stmt.executeQuery(selectSQL);
    		
    		while(rs.next()) {
    			
    			Integer id = rs.getInt("alertId");
    			String alertType = rs.getString("alertType");
    			String patientSSN = rs.getString("patientSSN");
    			String alertAction = rs.getString("alertAction");
    			Integer limitId = rs.getInt("limitId");

    			output.add(new Alert((Integer)id, alertType, alertAction, patientSSN, limitId, true));
    		}
    		
		}
		catch(Exception e){
			e.printStackTrace();
		}finally {
			rs.close();
			stmt.close();
			con.close();
		}
		return output;
	}

	@SuppressWarnings("resource")
	public Alert getDataById(Object id) throws Exception {
		
		   Connection conn = null;
		   Statement stmt = null;
		   ResultSet rs = null;
		
		    try{
		    
		    conn = getConnection();
		    stmt = conn.createStatement();
		    
			String selectSQL1 = "SELECT a.alertType, a.patientSSN, a.alertAction, al.limitId FROM ALERT a, ALERTFORLIMIT al  WHERE a.alertId = " + (Long)id + " AND al.alertId = "+ (Long)id; 
			String selectSQL2 = "SELECT a.alertType, a.patientSSN, a.alertAction, rc.recommendationId FROM ALERT a, ALERTFORRECOMMENDATION rc  WHERE a.alertId = " + (Long)id + " AND rc.alertId = "+ (Long)id;
			
            rs = stmt.executeQuery(selectSQL1);
			
			if(rs.next())
			{
				String alertType = rs.getString("alertType");
				String patientSSN = rs.getString("patientSSN");
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
					String patientSSN = rs.getString("patientSSN");
					String alertAction = rs.getString("alertAction");
				
					Integer recId = rs.getInt("recommendationId");
					
					return new Alert((Integer)id, alertType, alertAction, patientSSN, recId, false);
					
				}
			}
		    }catch(Exception e){
				e.printStackTrace();
			}finally {
				rs.close();
				stmt.close();
				conn.close();
			}
		    
		return null;
	}


	
}