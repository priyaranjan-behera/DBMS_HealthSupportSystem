package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class PatientProfile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientProfile frame = new PatientProfile("P1");
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
	public PatientProfile(String patientSSN) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewPatientDetails = new JButton("View Patient Details");
		btnViewPatientDetails.setBounds(29, 40, 276, 29);
		contentPane.add(btnViewPatientDetails);
		
		JButton btnEditPatientDetails = new JButton("Edit Patient Details");
		btnEditPatientDetails.setBounds(29, 115, 276, 29);
		contentPane.add(btnEditPatientDetails);
		
		JButton btnExitSystem = new JButton("Exit System");
		btnExitSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitSystem.setBounds(29, 197, 276, 29);
		contentPane.add(btnExitSystem);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PatientLoggedIn(patientSSN).setVisible(true);
			}
		});
		btnNewButton.setBounds(29, 156, 276, 29);
		contentPane.add(btnNewButton);
		
		btnViewPatientDetails.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ViewPatientDetails(patientSSN).setVisible(true);;
			}
		});
		
		btnEditPatientDetails.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new EditPatientDetails(patientSSN).setVisible(true);;
			}
		});
	}

}
