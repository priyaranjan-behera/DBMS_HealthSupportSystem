package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class AddPatientByHealthSupporter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JTextField txtYyyymmdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPatientByHealthSupporter frame = new AddPatientByHealthSupporter("P4");
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
	public AddPatientByHealthSupporter(String HSSSN) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up Form");
		lblNewLabel.setBounds(6, 6, 114, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(6, 34, 107, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(185, 29, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(6, 72, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(185, 67, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("SSN");
		lblNewLabel_3.setBounds(6, 140, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(185, 135, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		final JLabel lblNewLabel_4 = new JLabel("Contact Number");
		lblNewLabel_4.setBounds(6, 112, 114, 16);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.hide();
		
		textField_2 = new JTextField();
		textField_2.setBounds(185, 107, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.hide();
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setBounds(6, 173, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(185, 173, 130, 26);
		contentPane.add(passwordField);
		
        String[] profileInformation = { "Patient"};
		
		final JComboBox comboBox = new JComboBox(profileInformation);
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(185, 209, 199, 27);
		contentPane.add(comboBox);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(6, 213, 61, 16);
		contentPane.add(lblRole);
		
		JButton btnCreateProfile = new JButton("Create Profile");
		btnCreateProfile.setBounds(6, 324, 117, 29);
		contentPane.add(btnCreateProfile);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HealthSupporterLoggedIn(HSSSN).setVisible(true);
				
			}
		});
		btnBack.setBounds(133, 324, 117, 29);
		contentPane.add(btnBack);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(6, 259, 61, 16);
		contentPane.add(lblAddress);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(185, 260, 210, 52);
		contentPane.add(textArea);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(267, 324, 117, 29);
		contentPane.add(btnExit);
		
		final JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(363, 58, 70, 15);
		contentPane.add(lblDob);
		
		txtYyyymmdd = new JTextField();
		txtYyyymmdd.setText("YYYY-MM-DD");
		txtYyyymmdd.setBounds(432, 85, 114, 19);
		contentPane.add(txtYyyymmdd);
		txtYyyymmdd.setColumns(10);
		
		final JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(363, 135, 70, 15);
		contentPane.add(lblGender);

		String[] genderInformation = { "Male", "Female" };
		final JComboBox comboBox_1 = new JComboBox(genderInformation);
		comboBox_1.setBounds(450, 151, 32, 24);
		contentPane.add(comboBox_1);
		
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String role = (String) comboBox.getSelectedItem();
				try
				{
					if(role.equals("Patient"))
					{
						lblNewLabel_4.hide();
						textField_2.hide();
						lblDob.show();
						txtYyyymmdd.show();
						lblGender.show();
						comboBox_1.show();
					}
					else if (role.equals("Health Supporter"))
					{
						lblDob.hide();
						txtYyyymmdd.hide();
						lblGender.hide();
						comboBox_1.hide();
						lblNewLabel_4.show();
						textField_2.show();
					}
					

				}catch (Exception exp) {
					// TODO: handle exception
				}
				
			}
		});
		
		btnCreateProfile.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String role = (String)comboBox.getSelectedItem();
				
				
				try
				{
					if(role.equals("Patient"))
					{
						PatientDao patientDao = new PatientDao();
						People people = new People(textField_3.getText(), textField.getText(), textField_1.getText(), textArea.getText(), passwordField.getText());
						Patient patient = new Patient(people ,java.sql.Date.valueOf(txtYyyymmdd.getText()), (String)comboBox_1.getSelectedItem());
						PeopleDao peopleDao = new PeopleDao();
						peopleDao.insertRow(people);
						patientDao.insertRow(patient);
					}
					else if (role.equals("Health Supporter"))
					{
						HealthSupporterDao healthSupporterDao = new HealthSupporterDao();
						People people = new People(textField_3.getText(), textField.getText(), textField_1.getText(), textArea.getText(), passwordField.getText());
						HealthSupporter healthSupporter = new HealthSupporter(people, Long.parseLong(textField_2.getText()));
						PeopleDao peopleDao = new PeopleDao();
						peopleDao.insertRow(people);
						healthSupporterDao.insertRow(healthSupporter);
					}
					
					JOptionPane.showMessageDialog(AddPatientByHealthSupporter.this,
						    "Member Created");

				}catch (Exception exp) {
					JOptionPane.showMessageDialog(AddPatientByHealthSupporter.this,
						    exp.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
								
			}
		});
	}
}
