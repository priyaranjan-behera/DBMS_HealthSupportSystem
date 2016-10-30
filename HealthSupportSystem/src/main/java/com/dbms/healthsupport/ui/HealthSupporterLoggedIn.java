package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HealthSupporterLoggedIn extends JFrame {

	private JPanel contentPane;
	private String HSSSN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthSupporterLoggedIn frame = new HealthSupporterLoggedIn("P4");
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
	public HealthSupporterLoggedIn(String currHSSSN) {
		this.HSSSN = currHSSSN;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewAllPatients = new JButton("View All Patients");
		btnViewAllPatients.setBounds(28, 37, 162, 29);
		contentPane.add(btnViewAllPatients);
		
		JButton btnNewButton = new JButton("My Authorized Patients");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForHealthSupporterViewAllAuthorizedPatients forHealthSupporterViewAllAuthorizedPatients  = new ForHealthSupporterViewAllAuthorizedPatients (HSSSN);
				forHealthSupporterViewAllAuthorizedPatients.setVisible(true);
			}
		});
		btnNewButton.setBounds(236, 37, 194, 29);
		contentPane.add(btnNewButton);
		
		JButton btnAddPatient = new JButton("Add Patient");
		btnAddPatient.setBounds(28, 78, 162, 29);
		contentPane.add(btnAddPatient);
		
		JButton btnVieweditMyProfile = new JButton("View My Profile");
		btnVieweditMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVieweditMyProfile.setBounds(28, 119, 155, 29);
		contentPane.add(btnVieweditMyProfile);
		
		JButton btnNewButton_1 = new JButton("View/Clear Alerts");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(236, 78, 194, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit System");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(236, 229, 191, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Edit Profile");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(245, 119, 185, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(28, 229, 162, 29);
		contentPane.add(btnNewButton_4);
		
		JButton btnManageMetadata = new JButton("Manage Metadata");
		btnManageMetadata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageMetadata.setBounds(28, 168, 162, 29);
		contentPane.add(btnManageMetadata);
	}

}
