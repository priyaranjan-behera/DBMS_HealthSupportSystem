package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForHealthSupporterViewAllAuthorizedPatients frame = new ForHealthSupporterViewAllAuthorizedPatients("P3");
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(327, 22, 117, 29);
		contentPane.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 63, 432, 210);
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
		btnEditPatientProfile.setBounds(24, 24, 117, 25);
		contentPane.add(btnEditPatientProfile);
		
		JButton btnManagePatient = new JButton("Manage Patient");
		btnManagePatient.setBounds(184, 25, 117, 25);
		contentPane.add(btnManagePatient);
		
	}
}
