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
		
		btnViewAllPatients.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ForHealthSupporterViewAllPatients(currHSSSN).setVisible(true);
				
			}
		});
		
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
		
		btnAddPatient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddPatientByHealthSupporter().setVisible(true);
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("Exit System");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(236, 229, 191, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View/Edit Profile");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ForHealthSupporterEditProfile(HSSSN).setVisible(true);
			}
		});
		btnNewButton_3.setBounds(246, 78, 185, 29);
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
				new HSManageMetaData(HSSSN).setVisible(true);
			}
		});
		btnManageMetadata.setBounds(141, 119, 162, 29);
		contentPane.add(btnManageMetadata);
		
		JButton btnBecomePrimarySupporter = new JButton("Become Primary Supporter");
		btnBecomePrimarySupporter.setBounds(45, 160, 160, 25);
		contentPane.add(btnBecomePrimarySupporter);
		
		btnBecomePrimarySupporter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ForHealthSupporterAddPatientAsAPrimaryHealthSupporter(HSSSN).setVisible(true);;
				
			}
		});
		
		JButton btnBecomeSecondarySupporter = new JButton("Become Secondary Supporter");
		btnBecomeSecondarySupporter.setBounds(264, 160, 160, 25);
		contentPane.add(btnBecomeSecondarySupporter);
		
		btnBecomeSecondarySupporter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ForHealthSupporterAddAsASecondaryHS(HSSSN).setVisible(true);
				
			}
		});
	}

}
