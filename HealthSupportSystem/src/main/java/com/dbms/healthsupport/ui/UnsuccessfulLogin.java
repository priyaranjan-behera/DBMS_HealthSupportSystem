package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UnsuccessfulLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnsuccessfulLogin frame = new UnsuccessfulLogin();
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
	public UnsuccessfulLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUnsuccessfulLoginPlease = new JLabel("Unsuccessful Login! Please try again!");
		lblUnsuccessfulLoginPlease.setBounds(62, 73, 302, 55);
		contentPane.add(lblUnsuccessfulLoginPlease);
		
		JButton btnGoToLogin = new JButton("Go to Login");
		btnGoToLogin.setBounds(187, 206, 117, 29);
		contentPane.add(btnGoToLogin);
		
		JButton btnExit = new JButton("Exit System");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.setBounds(316, 206, 117, 29);
		contentPane.add(btnExit);
	}

}
