package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.domain.HealthSupporterDetails;

public class ForHealthSupporterAddAsASecondaryHS extends JFrame {


	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnGoBack;
	private JLabel lblAuthorizationDate;
	private JTextField txtYyyymmdd;
	private String HSSSN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForHealthSupporterAddAsASecondaryHS frame = new ForHealthSupporterAddAsASecondaryHS("P4");
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
	public ForHealthSupporterAddAsASecondaryHS(String HealthSupporterSSN) {
		this.HSSSN= HealthSupporterSSN;
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
		
		JLabel lblBecome = new JLabel("Become Secondary Health Supporter For:");
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
		btnGoBack.setBounds(208, 227, 117, 29);
		contentPane.add(btnGoBack);
		
		lblAuthorizationDate = new JLabel("Authorization Date ");
		lblAuthorizationDate.setBounds(19, 140, 149, 15);
		contentPane.add(lblAuthorizationDate);
		
		txtYyyymmdd = new JTextField();
		txtYyyymmdd.setText("YYYY-MM-DD");
		txtYyyymmdd.setBounds(211, 137, 114, 19);
		contentPane.add(txtYyyymmdd);
		txtYyyymmdd.setColumns(10);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				HealthSupporterDetails healthSupporterDetails = new HealthSupporterDetails(textField.getText(), HSSSN, java.sql.Date.valueOf(txtYyyymmdd.getText()));
				try {
					new PatientDao().AssignSecondaryHealthSupporter(healthSupporterDetails);
					JOptionPane.showMessageDialog(ForHealthSupporterAddAsASecondaryHS.this,
						    "Added HS: " + healthSupporterDetails.getHealthSupporterSSN() + " as Secondary Supporter for: " + healthSupporterDetails.getPatientSSN());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(ForHealthSupporterAddAsASecondaryHS.this,
						    e.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
	}

}
