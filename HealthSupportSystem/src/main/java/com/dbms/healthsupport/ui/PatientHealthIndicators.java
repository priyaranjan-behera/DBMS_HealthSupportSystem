package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatientHealthIndicators extends JFrame {

	private JPanel contentPane;
	String patientSSN; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientHealthIndicators frame = new PatientHealthIndicators("P4");
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
	public PatientHealthIndicators(String currPatientSSN) {
		this.patientSSN=currPatientSSN;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("See General Limits");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SeeGeneralLimitForPatient(patientSSN).setVisible(true);
			}
		});
		btnNewButton.setBounds(131, 30, 216, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("See General Reco");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SeeGeneralRecommendationForPatients().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(131, 74, 216, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PatientLoggedIn(patientSSN).setVisible(true);
			}
		});
		btnNewButton_3.setBounds(198, 229, 117, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Exit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_4.setBounds(327, 229, 117, 29);
		contentPane.add(btnNewButton_4);
		
		JButton btnManageGeneralLimits = new JButton("My Personal Limits");
		btnManageGeneralLimits.setBounds(25, 180, 200, 25);
		contentPane.add(btnManageGeneralLimits);
		
		btnManageGeneralLimits.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SeePatientLimitForPatient(patientSSN).setVisible(true);
				
			}
		});
		
		JButton btnManageGeneralRecommendation = new JButton("My Personal Reco");
		btnManageGeneralRecommendation.setBounds(244, 180, 180, 25);
		contentPane.add(btnManageGeneralRecommendation);
		
		btnManageGeneralRecommendation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SeePatientRecommendationForPatient(patientSSN).setVisible(true);
			}
		});
	}

}
