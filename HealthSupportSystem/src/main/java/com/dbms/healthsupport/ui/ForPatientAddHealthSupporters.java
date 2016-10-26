package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ForPatientAddHealthSupporters extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForPatientAddHealthSupporters frame = new ForPatientAddHealthSupporters();
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
	public ForPatientAddHealthSupporters() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddPrimaryHealth = new JLabel("Add Primary Health Supporter");
		lblAddPrimaryHealth.setBounds(31, 32, 198, 16);
		contentPane.add(lblAddPrimaryHealth);
		
		textField = new JTextField();
		textField.setBounds(31, 70, 188, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAddSecondaryHealth = new JLabel("Add Secondary Health Supporter");
		lblAddSecondaryHealth.setBounds(31, 136, 246, 16);
		contentPane.add(lblAddSecondaryHealth);
		
		textField_1 = new JTextField();
		textField_1.setBounds(31, 180, 188, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnExitSystem = new JButton("Exit System");
		btnExitSystem.setBounds(306, 230, 117, 29);
		contentPane.add(btnExitSystem);
		
		JButton btnAddValue = new JButton("Add Value");
		btnAddValue.setBounds(180, 230, 117, 29);
		contentPane.add(btnAddValue);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(51, 230, 117, 29);
		contentPane.add(btnBack);
	}

}
