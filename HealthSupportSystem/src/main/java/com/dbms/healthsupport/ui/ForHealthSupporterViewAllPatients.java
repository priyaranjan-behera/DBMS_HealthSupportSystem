package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dbms.healthsupport.dao.HealthSupporterDao;
import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.domain.HealthSupporter;
import com.dbms.healthsupport.domain.Patient;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ForHealthSupporterViewAllPatients extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForHealthSupporterViewAllPatients frame = new ForHealthSupporterViewAllPatients("P2");
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
	public ForHealthSupporterViewAllPatients(String HSSSN) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(327, 22, 117, 29);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 63, 432, 210);
		contentPane.add(scrollPane);
		HealthSupporter healthSupporter = null;
		String[][] patientData = null; 
		try
		{
			
			List<Patient> patients = new PatientDao().getAllData();

			patientData = new String[patients.size()][];
			System.out.println("Patients: " + patients);
			int i=0;
			for(Patient patient: patients)
			{
				String[] patientDetail = {patient.getSsn(), patient.getFirstName(), patient.getLastName()}; 
				patientData[i++] = patientDetail;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(ForHealthSupporterViewAllPatients.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		String[] columnNames = {"PatientSSN", "First Name", "LastName"};
		
		
		table_1 = new JTable(patientData, columnNames);
		scrollPane.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HealthSupporterLoggedIn(HSSSN).setVisible(true);
			}
		});
		btnNewButton.setBounds(42, 22, 117, 25);
		contentPane.add(btnNewButton);

	
	
	
	}
}
