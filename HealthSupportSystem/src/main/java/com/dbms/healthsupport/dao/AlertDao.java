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
    			Date alertDate = rs.getDate("alertDate");

    			output.add(new Alert((Integer)id, alertType, alertDate, alertAction, patientSSN, limitId, true));
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

	public void clearAlert(Integer alertId) throws Exception
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			con = getConnection();
			stmt = con.createStatement();
			
			String updateSQL = "UPDATE ALERT SET alertAction = 'Clear' where alertId="+alertId;
			
			stmt.executeQuery(updateSQL);
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	public List<Alert> getAllDataForPatient(String patientSSN) throws Exception {
		// TODO Auto-generated method stub
		
		Connection con = null;
		Statement stmt1 = null;
		Statement stmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		List<Alert> output = null;
		
		try{
			con = getConnection();
            stmt1 = con.createStatement();
            stmt2 = con.createStatement();
            
            String selectSQL = "SELECT * FROM ALERT WHERE patientSSN=\'"+patientSSN+"\'";
            String selectSQL1 = "SELECT a.alertId, a.alertType, a.patientSSN, a.alertAction, a.alertDate, al.limitId FROM ALERT a, ALERTFORLIMIT al  WHERE a.alertAction <> 'Clear' AND a.alertId = al.alertId AND a.patientSSN = \'"+ patientSSN +"\'"; 
			String selectSQL2 = "SELECT a.alertId, a.alertType, a.patientSSN, a.alertAction, a.alertDate, rc.recommendationId FROM ALERT a, ALERTFORRECOMMENDATION rc  WHERE a.alertAction <> 'Clear' AND a.alertId = rc.alertId AND a.patientSSN = \'"+ patientSSN +"\'";
			
            
            output = new ArrayList<Alert>();
    		
    		rs1 = stmt1.executeQuery(selectSQL1);
    		
    		while(rs1.next()) {
    			
    			Integer id = rs1.getInt("alertId");
    			String alertType = rs1.getString("alertType");
    			patientSSN = rs1.getString("patientSSN");
    			String alertAction = rs1.getString("alertAction");
    			Integer limitId = rs1.getInt("limitId");
    			Date alertDate = rs1.getDate("alertDate");

    			output.add(new Alert((Integer)id, alertType, alertDate, alertAction, patientSSN, limitId, true));
    		}

    		rs2 = stmt2.executeQuery(selectSQL2);
    		
    		while(rs2.next()) {
    			
    			Integer id = rs2.getInt("alertId");
    			String alertType = rs2.getString("alertType");
    			patientSSN = rs2.getString("patientSSN");
    			String alertAction = rs2.getString("alertAction");
    			Integer limitId = rs2.getInt("recommendationId");
    			Date alertDate = rs2.getDate("alertDate");

    			output.add(new Alert((Integer)id, alertType, alertDate, alertAction, patientSSN, limitId, true));
    		}
    		
		}
		catch(Exception e){
			throw e;
		}finally {
			if(rs1 != null)
			rs1.close();
			if(stmt1 != null)
			stmt1.close();
			if(rs2 != null)
			rs2.close();
			if(stmt2 != null)
			stmt2.close();
			if(con != null)
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
		    
			String selectSQL1 = "SELECT a.alertType, a.patientSSN, a.alertAction, a.alertDate, al.limitId FROM ALERT a, ALERTFORLIMIT al  WHERE a.alertId = " + (Long)id + " AND al.alertId = "+ (Long)id; 
			String selectSQL2 = "SELECT a.alertType, a.patientSSN, a.alertAction, a.alertDate, rc.recommendationId FROM ALERT a, ALERTFORRECOMMENDATION rc  WHERE a.alertId = " + (Long)id + " AND rc.alertId = "+ (Long)id;
			
            rs = stmt.executeQuery(selectSQL1);
			
			if(rs.next())
			{
				String alertType = rs.getString("alertType");
				String patientSSN = rs.getString("patientSSN");
				String alertAction = rs.getString("alertAction");
				Integer limitId = rs.getInt("limitId");
				Date alertDate = rs.getDate("alertDate");
				
				return new Alert((Integer)id, alertType, alertDate, alertAction, patientSSN, limitId, true);
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
					Date alertDate = rs.getDate("alertDate");
					
					return new Alert((Integer)id, alertType, alertDate, alertAction, patientSSN, recId, false);
					
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