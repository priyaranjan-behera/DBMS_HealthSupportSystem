package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class HealthSupporterAddRecommendation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthSupporterAddRecommendation frame = new HealthSupporterAddRecommendation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
//Integer recId, String frequencyName, Integer threshold, String observationSpecification
	/**
	 * Create the frame.
	 */
	public HealthSupporterAddRecommendation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddRecommendation = new JLabel("Add Recommendation");
		lblAddRecommendation.setBounds(18, 20, 183, 16);
		contentPane.add(lblAddRecommendation);
		
		JLabel lblNewLabel = new JLabel("Recommendation ID");
		lblNewLabel.setBounds(18, 43, 150, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(207, 38, 172, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Frequency Name");
		lblNewLabel_1.setBounds(18, 75, 130, 16);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(207, 65, 172, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Threshold");
		lblNewLabel_2.setBounds(18, 103, 150, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(207, 98, 172, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblObser = new JLabel("Obsersation Specification");
		lblObser.setBounds(18, 131, 172, 16);
		contentPane.add(lblObser);
		
		textField_3 = new JTextField();
		textField_3.setBounds(207, 136, 172, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAddRecommendation = new JButton("Add Recommendation");
		btnAddRecommendation.setBounds(129, 226, 198, 29);
		contentPane.add(btnAddRecommendation);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 226, 117, 29);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(327, 226, 117, 29);
		contentPane.add(btnExit);
	}
}
