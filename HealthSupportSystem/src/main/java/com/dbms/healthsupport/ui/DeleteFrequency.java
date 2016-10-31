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

public class DeleteFrequency extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteFrequency frame = new DeleteFrequency();
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
	public DeleteFrequency() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteFrequency = new JLabel("Delete Frequency");
		lblDeleteFrequency.setBounds(6, 25, 154, 16);
		contentPane.add(lblDeleteFrequency);
		
		textField = new JTextField();
		textField.setBounds(6, 110, 200, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterFrequencyId = new JLabel("Enter Frequency ID:");
		lblEnterFrequencyId.setBounds(6, 73, 200, 16);
		contentPane.add(lblEnterFrequencyId);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(299, 231, 130, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(170, 231, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBounds(41, 231, 117, 29);
		contentPane.add(btnNewButton_2);
	}
}
