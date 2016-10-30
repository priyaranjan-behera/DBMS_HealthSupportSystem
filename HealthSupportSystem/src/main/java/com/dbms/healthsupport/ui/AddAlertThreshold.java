package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAlertThreshold extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAlertThreshold frame = new AddAlertThreshold();
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
	public AddAlertThreshold() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddAlertThreshold = new JLabel("Add Alert Threshold");
		lblAddAlertThreshold.setBounds(6, 43, 154, 16);
		contentPane.add(lblAddAlertThreshold);
		
		textField = new JTextField();
		textField.setBounds(6, 71, 261, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAddValue = new JButton("Add Value");
		btnAddValue.setBounds(172, 226, 117, 29);
		contentPane.add(btnAddValue);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(43, 226, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnExitSystem = new JButton("Exit System");
		btnExitSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitSystem.setBounds(301, 226, 117, 29);
		contentPane.add(btnExitSystem);
	}

}
