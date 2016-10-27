package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForHealthSupporterAddPatientAsAPrimaryHealthSupporter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnGoBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForHealthSupporterAddPatientAsAPrimaryHealthSupporter frame = new ForHealthSupporterAddPatientAsAPrimaryHealthSupporter();
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
	public ForHealthSupporterAddPatientAsAPrimaryHealthSupporter() {
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
		
		JLabel lblBecome = new JLabel("Become Primary Health Supporter For:");
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
		btnNewButton_1.setBounds(327, 227, 117, 29);
		contentPane.add(btnNewButton_1);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(208, 227, 117, 29);
		contentPane.add(btnGoBack);
	}

}
