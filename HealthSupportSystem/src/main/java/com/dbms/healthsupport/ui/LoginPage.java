package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbms.healthsupport.dao.HealthSupporterDao;
import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.dao.PeopleDao;
import com.dbms.healthsupport.domain.HealthSupporter;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.People;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
				
				try
				{
				String profileInformationValue = comboBox.getSelectedItem().toString();
				People people = new PeopleDao().getDataById(textField.getText());
				System.out.println("Password" + people.getPassword());
				System.out.println("Password Field: " + passwordField.getText());
				if(!people.getPassword().equals(passwordField.getText()))
					throw new Exception("Incorrect Password");
				new PeopleDao().logUsage(people);
				if(profileInformationValue.equalsIgnoreCase("Health Supporter")) {
					
					///Check if health supporter propper
					
					
					//if okay
					HealthSupporter healthSupporter = new HealthSupporterDao().getDataById(textField.getText());
					if(healthSupporter == null)
						throw new Exception("Incorrect Password");
					HealthSupporterLoggedIn healthSupporterLoggedIn = new HealthSupporterLoggedIn(textField.getText());
					healthSupporterLoggedIn.setVisible(true);
	
					
				} else if(profileInformationValue.equalsIgnoreCase("Patient")) {
					
					///Check if Patient propper
					Patient patient = new PatientDao().getDataById(textField.getText());
					if(patient == null)
						throw new Exception("Incorrect PAssword");
					
					
					//if okay
					
					System.out.println("Password" + patient.getPassword());
					
					if(new PatientDao().isSick(patient.getSsn()))
					{
						if(patient.getPrimaryHealthSupporter() == null)
							new ForPatientAddPatientAsAPrimaryHealthSupporter(textField.getText()).setVisible(true);
					}
					
					PatientLoggedIn patientLoggedIn = new PatientLoggedIn(textField.getText());
					patientLoggedIn.setVisible(true);
 					
				} else {
					JOptionPane.showMessageDialog(LoginPage.this,
						    "Incorrect Credentials",
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
				
				}catch (Exception exp) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(LoginPage.this,
						    "Incorrect Credentials",
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(6, 227, 117, 29);
		contentPane.add(btnLogin);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Start().setVisible(true);
				
			}
		});

		btnBack.setBounds(118, 227, 117, 29);
		contentPane.add(btnBack);
		
		
		JButton btnExitApplication = new JButton("Exit System");
		btnExitApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnExitApplication.setBounds(234, 227, 139, 29);
		contentPane.add(btnExitApplication);

	}
}
