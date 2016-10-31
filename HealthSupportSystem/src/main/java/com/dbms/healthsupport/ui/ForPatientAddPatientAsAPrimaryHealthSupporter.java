package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.domain.HealthSupporterDetails;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForPatientAddPatientAsAPrimaryHealthSupporter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnGoBack;
	private JLabel lblAuthorizationDate;
	private JTextField txtYyyymmdd;
	private String patientSSN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForPatientAddPatientAsAPrimaryHealthSupporter frame = new ForPatientAddPatientAsAPrimaryHealthSupporter("P2");
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
	public ForPatientAddPatientAsAPrimaryHealthSupporter(String currPatientSSN) {
		this.patientSSN= currPatientSSN;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(19, 53, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBecome = new JLabel("Make Primary Health Supporter :");
		lblBecome.setBounds(23, 25, 342, 16);
		contentPane.add(lblBecome);
		
		btnNewButton = new JButton("Add Supporter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(79, 227, 117, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(327, 227, 117, 29);
		contentPane.add(btnNewButton_1);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PatientLoggedIn(patientSSN).setVisible(true);
			}
		});
		btnGoBack.setBounds(208, 227, 117, 29);
		contentPane.add(btnGoBack);
		
		lblAuthorizationDate = new JLabel("Authorization Date ");
		lblAuthorizationDate.setBounds(19, 140, 70, 15);
		contentPane.add(lblAuthorizationDate);
		
		txtYyyymmdd = new JTextField();
		txtYyyymmdd.setText("YYYY-MM-DD");
		txtYyyymmdd.setBounds(130, 163, 114, 19);
		contentPane.add(txtYyyymmdd);
		txtYyyymmdd.setColumns(10);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				HealthSupporterDetails healthSupporterDetails = new HealthSupporterDetails(patientSSN, textField.getText(), java.sql.Date.valueOf(txtYyyymmdd.getText()));
				try {
					new PatientDao().AssignPrimaryHealthSupporter(healthSupporterDetails);
					JOptionPane.showMessageDialog(ForPatientAddPatientAsAPrimaryHealthSupporter.this,
						    "Added HS: " + healthSupporterDetails.getHealthSupporterSSN() + "as Primary Supporter for: " + healthSupporterDetails.getPatientSSN());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(ForPatientAddPatientAsAPrimaryHealthSupporter.this,
						    e.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
	}
}
