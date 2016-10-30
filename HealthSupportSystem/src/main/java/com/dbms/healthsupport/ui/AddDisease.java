package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbms.healthsupport.dao.DiseasesDao;
import com.dbms.healthsupport.dao.FrequencyDao;
import com.dbms.healthsupport.domain.Diseases;
import com.dbms.healthsupport.domain.Frequency;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDisease extends JFrame {

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
					AddDisease frame = new AddDisease();
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
	public AddDisease() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertFrequency = new JLabel("Insert Disease");
		lblInsertFrequency.setBounds(6, 18, 165, 16);
		contentPane.add(lblInsertFrequency);
		
		JLabel lblNewLabel = new JLabel("Disease Name");
		lblNewLabel.setBounds(6, 46, 165, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(6, 74, 186, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDuration = new JLabel("Disease Description");
		lblDuration.setBounds(6, 112, 61, 16);
		contentPane.add(lblDuration);
		
		textField_1 = new JTextField();
		textField_1.setBounds(6, 140, 186, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Diseases disease = new Diseases(textField.getText(), textField_1.getText());
				DiseasesDao diseasesDAO = new DiseasesDao();
				diseasesDAO.insertRow(disease);
				JOptionPane.showMessageDialog(AddDisease.this,
					    "Added Disease");
				
				} catch (Exception exception) {
					
					JOptionPane.showMessageDialog(AddDisease.this,
						    exception.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
					
				}
			}
		});
		btnNewButton.setBounds(327, 230, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(196, 230, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBounds(69, 230, 117, 29);
		contentPane.add(btnNewButton_2);
	}

}
