package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbms.healthsupport.dao.HealthSupporterDao;
import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.domain.HealthSupporter;
import com.dbms.healthsupport.domain.Patient;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PatientLoggedIn extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientLoggedIn frame = new PatientLoggedIn("P2");
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
	public PatientLoggedIn(String patientSSN) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientProfile patientProfile = new PatientProfile(patientSSN);
				patientProfile.setVisible(true);
			}
		});
		btnProfile.setBounds(25, 38, 189, 29);
		contentPane.add(btnProfile);
		
		JButton btnDiagnoses = new JButton("Diagnoses");
		btnDiagnoses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewDiagnosesForPatient(patientSSN).setVisible(true);
			}
		});
		btnDiagnoses.setBounds(25, 91, 195, 29);
		contentPane.add(btnDiagnoses);
		
		JButton btnAlerts = new JButton("Alerts");
		btnAlerts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientAlertsForPatient patientAlert = new PatientAlertsForPatient(patientSSN);
				patientAlert.setVisible(true);
			}
		});
		btnAlerts.setBounds(25, 146, 189, 29);
		contentPane.add(btnAlerts);
		
		JButton btnHealthIndicators = new JButton("Health Indicators");
		btnHealthIndicators.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TO DO
				new PatientHealthIndicators(patientSSN).setVisible(true);;
			}
		});
		btnHealthIndicators.setBounds(227, 91, 195, 29);
		contentPane.add(btnHealthIndicators);
		
		JButton btnViewHealthSupporters = new JButton("View Health Supporters");
		btnViewHealthSupporters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeeHSForPatient patientViewMyHealthSupporters = new SeeHSForPatient(patientSSN);
				patientViewMyHealthSupporters.setVisible(true);
			}
		});
		btnViewHealthSupporters.setBounds(227, 38, 195, 29);
		contentPane.add(btnViewHealthSupporters);
		
		JButton btnExitSystem = new JButton("Exit System");
		btnExitSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitSystem.setBounds(227, 146, 195, 29);
		contentPane.add(btnExitSystem);
		
		JButton btnButton = new JButton("Go Back");
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPage().setVisible(true);
				
			}
		});
		btnButton.setBounds(37, 207, 117, 29);
		contentPane.add(btnButton);
		
		JButton btnNewButton = new JButton("Manage Observations");
		btnNewButton.setBounds(227, 210, 150, 25);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SeeObservationForPatient(patientSSN).setVisible(true);;
				
			}
		});
		
		JLabel lblPatientId = new JLabel("Patient Id: " + patientSSN);
		lblPatientId.setBounds(184, 0, 150, 15);
		contentPane.add(lblPatientId);
		
		JButton btnMakeMeA = new JButton("Make me a HS");
		btnMakeMeA.setBounds(242, 120, 180, 25);
		contentPane.add(btnMakeMeA);
		
		JButton btnAddPrimarySupporter = new JButton("Add Primary Supporter");
		btnAddPrimarySupporter.setBounds(137, 175, 117, 25);
		contentPane.add(btnAddPrimarySupporter);
		
		btnMakeMeA.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					Patient patient = new PatientDao().getDataById(patientSSN);
					new PatientDao().makePatientAHealthSupporter(patient);
					
					JOptionPane.showMessageDialog(PatientLoggedIn.this,
						    "Added as HS");
				}
				catch (Exception exception) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(PatientLoggedIn.this,
						    exception.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		btnAddPrimarySupporter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					new ForPatientAddPatientAsAPrimaryHealthSupporter(patientSSN).setVisible(true);
				}
				catch (Exception exception) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(PatientLoggedIn.this,
						    exception.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
}
