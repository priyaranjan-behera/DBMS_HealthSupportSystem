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
	
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HSManagesPatientDashBoard frame = new HSManagesPatientDashBoard("P2");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public HSManagesPatientDashBoard(String PatientSSN){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnManageAlerts = new JButton("Manage alerts");
		btnManageAlerts.setBounds(120, 90, 117, 25);
		contentPane.add(btnManageAlerts);
		
		JButton btnManageRecommendations = new JButton("Manage Recommendations");
		btnManageRecommendations.setBounds(120, 120, 117, 25);
		contentPane.add(btnManageRecommendations);
		
		JButton btnManageLimits = new JButton("Manage limits");
		btnManageLimits.setBounds(120, 150, 117, 25);
		contentPane.add(btnManageLimits);
		
		JLabel lblManageAlertsRecommendations = new JLabel("Manage alerts recommendations and limits for patient");
		lblManageAlertsRecommendations.setBounds(141, 70, 70, 15);
		contentPane.add(lblManageAlertsRecommendations);
		
		
		btnManageRecommendations.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SeePatientRecommendationForHealthSupporter frame = new SeePatientRecommendationForHealthSupporter(PatientSSN);
				frame.setVisible(true);
			}
		});
		
		btnManageLimits.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SeePatientLimitForHealthSupporter frame = new SeePatientLimitForHealthSupporter(PatientSSN);
				frame.setVisible(true);
			}
		});
		
		btnManageAlerts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PatientAlertsForHealthSupporter frame = new PatientAlertsForHealthSupporter(PatientSSN);
				frame.setVisible(true);
			}
		});
	}
}
