package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class SignUpForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpForm frame = new SignUpForm();
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
	public SignUpForm() {
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
		
		textField_2 = new JTextField();
		textField_2.setBounds(185, 107, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Contact Number");
		lblNewLabel_4.setBounds(6, 112, 114, 16);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(185, 135, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setBounds(6, 173, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(185, 173, 130, 26);
		contentPane.add(passwordField);
		
        String[] profileInformation = { "Patient", "Health Supporter" };
		
		JComboBox comboBox = new JComboBox(profileInformation);
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
		btnBack.setBounds(133, 324, 117, 29);
		contentPane.add(btnBack);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(6, 249, 61, 16);
		contentPane.add(lblAddress);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(185, 260, 210, 52);
		contentPane.add(textArea);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(267, 324, 117, 29);
		contentPane.add(btnExit);
	}
}
