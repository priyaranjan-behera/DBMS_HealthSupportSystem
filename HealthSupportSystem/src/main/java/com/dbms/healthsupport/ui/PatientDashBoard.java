package com.dbms.healthsupport.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PatientDashBoard extends JFrame{
	
	private JPanel contentPane;
	
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientDashBoard frame = new PatientDashBoard("P2");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PatientDashBoard(String PatientSSN){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnManageAlerts = new JButton("View alerts");
		btnManageAlerts.setBounds(120, 90, 117, 25);
		contentPane.add(btnManageAlerts);
		
		JButton btnManageRecommendations = new JButton("View Recommendations");
		btnManageRecommendations.setBounds(120, 120, 117, 25);
		contentPane.add(btnManageRecommendations);
		
		JButton btnManageLimits = new JButton("View limits");
		btnManageLimits.setBounds(120, 150, 117, 25);
		contentPane.add(btnManageLimits);
		
		JLabel lblManageAlertsRecommendations = new JLabel("View alerts recommendations and limits for patient: " + PatientSSN);
		lblManageAlertsRecommendations.setBounds(141, 70, 70, 15);
		contentPane.add(lblManageAlertsRecommendations);
		
		
		btnManageRecommendations.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SeeRecommendationForPatient frame = new SeeRecommendationForPatient(PatientSSN);
				frame.setVisible(true);
			}
		});
		
		btnManageLimits.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SeeLimitForPatient frame = new SeeLimitForPatient(PatientSSN);
				frame.setVisible(true);
			}
		});
		
		btnManageAlerts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PatientAlertsForPatient frame = new PatientAlertsForPatient(PatientSSN);
				frame.setVisible(true);
			}
		});
	}
}
