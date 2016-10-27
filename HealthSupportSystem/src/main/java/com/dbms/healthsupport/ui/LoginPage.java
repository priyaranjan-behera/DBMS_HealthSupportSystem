package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDbmsProject = new JLabel("DBMS 540 Project");
		lblDbmsProject.setBounds(6, 18, 139, 16);
		contentPane.add(lblDbmsProject);
		
		textField = new JTextField();
		textField.setBounds(6, 106, 199, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsernamessn = new JLabel("UserName (SSN)");
		lblUsernamessn.setBounds(6, 78, 229, 16);
		contentPane.add(lblUsernamessn);
		
		JLabel lblHealthSupporterPassword = new JLabel("Password");
		lblHealthSupporterPassword.setBounds(6, 142, 212, 16);
		contentPane.add(lblHealthSupporterPassword);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(234, 213, -37, -17);
		contentPane.add(separator);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(6, 159, 199, 26);
		contentPane.add(passwordField);
		
		String[] profileInformation = { "Patient", "Health Supporter" };
		
		final JComboBox comboBox = new JComboBox(profileInformation);
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(6, 188, 199, 27);
		contentPane.add(comboBox);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String profileInformationValue = comboBox.getSelectedItem().toString();
				if(profileInformationValue.equalsIgnoreCase("Health Supporter")) {
					
					///Check if health supporter propper
					
					
					//if okay
					HealthSupporterLoggedIn healthSupporterLoggedIn = new HealthSupporterLoggedIn();
					healthSupporterLoggedIn.setVisible(true);
	
					
				} else if(profileInformationValue.equalsIgnoreCase("Patient")) {
					
					///Check if Patient propper
					
					
					//if okay
					PatientLoggedIn patientLoggedIn = new PatientLoggedIn();
					patientLoggedIn.setVisible(true);
 					
				} else {
					System.exit(0);
				}
			}
		});
		btnLogin.setBounds(6, 227, 117, 29);
		contentPane.add(btnLogin);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(118, 227, 117, 29);
		contentPane.add(btnBack);
		
		JButton btnExitApplication = new JButton("Exit System");
		btnExitApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnExitApplication.setBounds(234, 227, 139, 29);
		contentPane.add(btnExitApplication);

	}
}
