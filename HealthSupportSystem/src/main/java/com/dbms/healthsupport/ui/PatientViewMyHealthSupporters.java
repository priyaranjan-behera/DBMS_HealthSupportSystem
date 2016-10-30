package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class PatientViewMyHealthSupporters extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientViewMyHealthSupporters frame = new PatientViewMyHealthSupporters("P2");
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
	public PatientViewMyHealthSupporters(String patientSSN) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMyHealthSupporters = new JLabel("My Health Supporters");
		lblMyHealthSupporters.setBounds(38, 30, 147, 16);
		contentPane.add(lblMyHealthSupporters);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(38, 72, 390, 148);
		contentPane.add(textArea);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(199, 232, 117, 29);
		contentPane.add(btnBack);
		
		JButton btnExitSystem = new JButton("Exit System");
		btnExitSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitSystem.setBounds(328, 232, 117, 29);
		contentPane.add(btnExitSystem);
	}

}
