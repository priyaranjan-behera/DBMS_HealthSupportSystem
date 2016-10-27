package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class HealthSupporterViewAllPatients extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthSupporterViewAllPatients frame = new HealthSupporterViewAllPatients();
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
	public HealthSupporterViewAllPatients() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(29, 47, 392, 211);
		contentPane.add(textArea);
		
		JButton btnExitSystem = new JButton("Exit System");
		btnExitSystem.setBounds(304, 6, 117, 29);
		contentPane.add(btnExitSystem);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(182, 6, 117, 29);
		contentPane.add(btnGoBack);
	}

}
