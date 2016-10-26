package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AddDiseaseDiagnosesForPatient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnAddDiseaseName;
	private JButton btnExitSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDiseaseDiagnosesForPatient frame = new AddDiseaseDiagnosesForPatient();
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
	public AddDiseaseDiagnosesForPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(51, 58, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDiseseName = new JLabel("Disease Name");
		lblDiseseName.setBounds(51, 29, 122, 16);
		contentPane.add(lblDiseseName);
		
		btnAddDiseaseName = new JButton("Add Disease Name");
		btnAddDiseaseName.setBounds(128, 225, 162, 29);
		contentPane.add(btnAddDiseaseName);
		
		btnExitSystem = new JButton("Exit System");
		btnExitSystem.setBounds(297, 225, 117, 29);
		contentPane.add(btnExitSystem);
	}

}
