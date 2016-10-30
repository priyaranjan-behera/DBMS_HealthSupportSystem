package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbms.healthsupport.dao.FrequencyDao;
import com.dbms.healthsupport.domain.Frequency;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertFrequency extends JFrame {

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
					InsertFrequency frame = new InsertFrequency();
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
	public InsertFrequency() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertFrequency = new JLabel("Insert Frequency");
		lblInsertFrequency.setBounds(6, 18, 165, 16);
		contentPane.add(lblInsertFrequency);
		
		JLabel lblNewLabel = new JLabel("Frequency Name");
		lblNewLabel.setBounds(6, 46, 165, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(6, 74, 186, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDuration = new JLabel("Duration");
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
				Frequency frequency = new Frequency(textField.getText(), Integer.parseInt(textField_1.getText()));
				FrequencyDao frequencyDAO = new FrequencyDao();
				frequencyDAO.insertRow(frequency);
				JOptionPane.showMessageDialog(InsertFrequency.this,
					    "Added Frequency value");
				
				} catch (Exception exception) {
					
					JOptionPane.showMessageDialog(InsertFrequency.this,
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
