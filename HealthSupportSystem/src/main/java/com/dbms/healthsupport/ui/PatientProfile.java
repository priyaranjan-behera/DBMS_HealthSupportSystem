package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class PatientProfile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientProfile frame = new PatientProfile();
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
	public PatientProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewPatientDetails = new JButton("View Patient Details");
		btnViewPatientDetails.setBounds(29, 40, 276, 29);
		contentPane.add(btnViewPatientDetails);
		
		JButton btnEditPatientDetails = new JButton("Edit Patient Details");
		btnEditPatientDetails.setBounds(29, 115, 276, 29);
		contentPane.add(btnEditPatientDetails);
		
		JButton btnExitSystem = new JButton("Exit System");
		btnExitSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitSystem.setBounds(29, 197, 276, 29);
		contentPane.add(btnExitSystem);
	}

}
