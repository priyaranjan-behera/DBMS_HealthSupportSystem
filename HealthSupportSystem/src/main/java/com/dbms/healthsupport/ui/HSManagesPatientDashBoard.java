package com.dbms.healthsupport.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class HSManagesPatientDashBoard extends JFrame{
	
	private JPanel contentPane;
	String patientSSN;
	String hsSSN;
	
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HSManagesPatientDashBoard frame = new HSManagesPatientDashBoard("P2","P3");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public HSManagesPatientDashBoard(String currPatientSSN, String currHSSSN){
		this.patientSSN = currPatientSSN;
		this.hsSSN = currHSSSN;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnManageAlerts = new JButton("Manage alerts");
		btnManageAlerts.setBounds(120, 50, 200, 25);
		contentPane.add(btnManageAlerts);
		
		JButton btnManageRecommendations = new JButton("Manage Recommendations");
		btnManageRecommendations.setBounds(120, 90, 200, 25);
		contentPane.add(btnManageRecommendations);
		
		JButton btnManageLimits = new JButton("Manage limits");
		btnManageLimits.setBounds(120, 130, 200, 25);
		contentPane.add(btnManageLimits);
		
		JLabel lblManageAlertsRecommendations = new JLabel("Manage for Patient: " + patientSSN);
		lblManageAlertsRecommendations.setBounds(100, 20, 300, 15);
		contentPane.add(lblManageAlertsRecommendations);
		
		JButton btnAddObservations = new JButton("Manage Observation");
		btnAddObservations.setBounds(120, 231, 200, 25);
		contentPane.add(btnAddObservations);
		
		JButton btnManageDiagnosis = new JButton("Manage Diagnosis");
		btnManageDiagnosis.setBounds(120, 166, 200, 25);
		contentPane.add(btnManageDiagnosis);
		
		btnManageDiagnosis.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ViewDiagnosesForHS(patientSSN, hsSSN).setVisible(true);
				
			}
		});
		
		btnAddObservations.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SeeObservationForHealthSupporter(patientSSN, hsSSN).setVisible(true);;
				
			}
		});
		
		
		btnManageRecommendations.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SeePatientRecommendationForHealthSupporter frame = new SeePatientRecommendationForHealthSupporter(patientSSN);
				frame.setVisible(true);
			}
		});
		
		btnManageLimits.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SeePatientLimitForHealthSupporter frame = new SeePatientLimitForHealthSupporter(patientSSN);
				frame.setVisible(true);
			}
		});
		
		btnManageAlerts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PatientAlertsForHealthSupporter frame = new PatientAlertsForHealthSupporter(patientSSN);
				frame.setVisible(true);
			}
		});
	}
}
