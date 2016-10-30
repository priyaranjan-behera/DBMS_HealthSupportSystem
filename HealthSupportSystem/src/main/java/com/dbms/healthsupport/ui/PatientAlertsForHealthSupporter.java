package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbms.healthsupport.dao.AlertDao;
import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.dao.RecommendationDao;
import com.dbms.healthsupport.domain.Alert;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.Recommendation;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class PatientAlertsForHealthSupporter extends JFrame {

	private JPanel contentPane;
	String patientSSN;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientAlertsForHealthSupporter frame = new PatientAlertsForHealthSupporter("P2");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PatientAlertsForHealthSupporter(String currPatientSSN) {
		this.patientSSN = currPatientSSN;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String[][] alertDetails = new String[10][];
		
		try
		{
			List<Alert> alerts = new AlertDao().getAllDataForPatient(currPatientSSN);
			System.out.println("Total alerts: " + alerts.size());
		
		
			alertDetails = new String[alerts.size()][];
		
		
		int i=0;
		for(Alert alert: alerts)
		{
			String[] alertDetail = {alert.getAlertId().toString(), alert.getAlertType(), alert.getPatientId(), alert.getAlertDate().toGMTString(), alert.getLimitId().toString()};
			alertDetails[i++] = alertDetail;
		}
		
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(PatientAlertsForHealthSupporter.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		String[] columnNames = {"AlertId", "Alert Type", "Patient SSN", "AlertDate", "Recommendation/Limit Id"};
		
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 31, 300, 150);
		contentPane.add(scrollPane);
		
		table = new JTable(alertDetails, columnNames);
		scrollPane.setViewportView(table);
		
		JButton btnClearAlert = new JButton("Clear Alert");
		btnClearAlert.setBounds(59, 218, 117, 25);
		contentPane.add(btnClearAlert);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(188, 216, 117, 29);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(317, 216, 117, 29);
		contentPane.add(btnExit);
		
		btnClearAlert.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				try
				{
				int row = table.getSelectedRow();
				if(row == -1)
				{
					JOptionPane.showMessageDialog(PatientAlertsForHealthSupporter.this,
						    "Select a row to clear the alert");
				}
				else
				{
					String Table_click = (table.getModel().getValueAt(row, 0).toString());
					Integer alertId = Integer.parseInt(Table_click);
					new AlertDao().clearAlert(alertId);
					JOptionPane.showMessageDialog(PatientAlertsForHealthSupporter.this,
						    "Alert Id: " + alertId + " has been cleared");
					
					
					String[][] alertDetails = new String[10][];
					
					try
					{
						List<Alert> alerts = new AlertDao().getAllDataForPatient(patientSSN);
						System.out.println("Total alerts: " + alerts.size());
					
					
						alertDetails = new String[alerts.size()][];
					
					
					int i=0;
					for(Alert alert: alerts)
					{
						String[] alertDetail = {alert.getAlertId().toString(), alert.getAlertType(), alert.getPatientId(), alert.getAlertDate().toGMTString(), alert.getLimitId().toString()};
						alertDetails[i++] = alertDetail;
					}
					
					}
					catch (Exception exp1) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(PatientAlertsForHealthSupporter.this,
							    exp1.getMessage(),
							    "Inane warning",
							    JOptionPane.WARNING_MESSAGE);
					}
					
					String[] columnNames = {"AlertId", "Alert Type", "Patient SSN", "AlertDate", "Recommendation/Limit Id"};
					
					table = new JTable(alertDetails, columnNames);
					scrollPane.setViewportView(table);
					
				}
				// TODO Auto-generated method stub
				}
				catch (Exception exp) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(PatientAlertsForHealthSupporter.this,
						    exp.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
	}

}
