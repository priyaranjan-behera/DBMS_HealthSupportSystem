package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class PatientLoggedIn extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientLoggedIn frame = new PatientLoggedIn();
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
	public PatientLoggedIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.setBounds(25, 38, 189, 29);
		contentPane.add(btnProfile);
		
		JButton btnDiagnoses = new JButton("Diagnoses");
		btnDiagnoses.setBounds(25, 91, 195, 29);
		contentPane.add(btnDiagnoses);
		
		JButton btnAlerts = new JButton("Alerts");
		btnAlerts.setBounds(25, 146, 189, 29);
		contentPane.add(btnAlerts);
		
		JButton btnHealthIndicators = new JButton("Health Indicators");
		btnHealthIndicators.setBounds(227, 91, 195, 29);
		contentPane.add(btnHealthIndicators);
		
		JButton btnViewHealthSupporters = new JButton("View Health Supporters");
		btnViewHealthSupporters.setBounds(227, 38, 195, 29);
		contentPane.add(btnViewHealthSupporters);
		
		JButton btnExitSystem = new JButton("Exit System");
		btnExitSystem.setBounds(227, 146, 195, 29);
		contentPane.add(btnExitSystem);
	}

}
