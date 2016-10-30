package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dbms.healthsupport.dao.HealthSupporterDao;
import com.dbms.healthsupport.domain.HealthSupporter;
import com.dbms.healthsupport.domain.Patient;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ForHealthSupporterViewAllAuthorizedPatients extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForHealthSupporterViewAllAuthorizedPatients frame = new ForHealthSupporterViewAllAuthorizedPatients("P2");
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
	public ForHealthSupporterViewAllAuthorizedPatients(String HSSSN) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(192, 80, 117, 29);
		contentPane.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 147, 432, 210);
		contentPane.add(scrollPane);
		HealthSupporter healthSupporter = null;
		String[][] patientData = null; 
		try
		{
			healthSupporter = new HealthSupporterDao().getDataById(HSSSN);
			
			patientData = new String[healthSupporter.getPatients().size()][];
			int i=0;
			for(String patient: healthSupporter.getPatients())
			{
				String[] patientDetail = {patient}; 
				patientData[i++] = patientDetail;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(ForHealthSupporterViewAllAuthorizedPatients.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		String[] columnNames = {"Patient Name"};
		
		
		table_1 = new JTable(patientData, columnNames);
		scrollPane.setViewportView(table_1);
		
		JButton btnEditPatientProfile = new JButton("Edit Patient Profile");
		btnEditPatientProfile.setBounds(6, 24, 166, 25);
		contentPane.add(btnEditPatientProfile);
		
		JButton btnManagePatient = new JButton("Manage Patient");
		btnManagePatient.setBounds(24, 82, 131, 25);
		contentPane.add(btnManagePatient);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(204, 22, 117, 29);
		contentPane.add(btnBack);
		
		
		btnEditPatientProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int row=table_1.getSelectedRow();
					if(row==-1){
						JOptionPane.showMessageDialog(ForHealthSupporterViewAllAuthorizedPatients.this,
							    "Select a patient to edit");
					}else{
						String Table_click = (table_1.getModel().getValueAt(row, 0).toString());
						//Integer alertId = Integer.parseInt(Table_click);
						String patientSSN=Table_click;
						System.out.println(patientSSN);
						EditPatientDetailsForHS epd = new EditPatientDetailsForHS(patientSSN);
						epd.setVisible(true);
					
					}
				}catch(Exception e2){
					JOptionPane.showMessageDialog(ForHealthSupporterViewAllAuthorizedPatients.this,
						    e2.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				
				}
				//EditPatientDetails epd = new EditPatientDetails("P2");
				//epd.setVisible(true);
			}
		});

	
	
		btnManagePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int row=table_1.getSelectedRow();
					if(row==-1){
						JOptionPane.showMessageDialog(ForHealthSupporterViewAllAuthorizedPatients.this,
							    "Select a patient to edit");
					}else{
						String Table_click = (table_1.getModel().getValueAt(row, 0).toString());
						//Integer alertId = Integer.parseInt(Table_click);
						String patientSSN=Table_click;
						System.out.println(patientSSN);
						HSManagesPatientDashBoard epd = new HSManagesPatientDashBoard(patientSSN);
						epd.setVisible(true);
					
					}
				}catch(Exception e2){
					JOptionPane.showMessageDialog(ForHealthSupporterViewAllAuthorizedPatients.this,
						    e2.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				
				}
				//EditPatientDetails epd = new EditPatientDetails("P2");
				//epd.setVisible(true);
			}
		});

	
	
	
	}
}
