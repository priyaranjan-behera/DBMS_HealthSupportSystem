package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HSManageFrequency extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HSManageFrequency frame = new HSManageFrequency();
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
	public HSManageFrequency() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewFrequency = new JButton("View/Insert Frequency");
		btnViewFrequency.setBounds(146, 24, 165, 29);
		contentPane.add(btnViewFrequency);
		
		JButton btnEditFrequency = new JButton("Edit Frequency");
		btnEditFrequency.setBounds(146, 79, 165, 29);
		contentPane.add(btnEditFrequency);
		
		JButton btnDeleteFrequency = new JButton("Delete Frequency");
		btnDeleteFrequency.setBounds(146, 137, 152, 29);
		contentPane.add(btnDeleteFrequency);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(166, 230, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit System");
		btnNewButton_1.setBounds(294, 230, 117, 29);
		contentPane.add(btnNewButton_1);
	}

}
