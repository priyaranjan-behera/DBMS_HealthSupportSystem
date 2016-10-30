package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HSManageMetaData extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HSManageMetaData frame = new HSManageMetaData("P4");
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
	public HSManageMetaData(String currHSSSN) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Manage Disease");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManageDisease(currHSSSN).setVisible(true);
			}
		});
		btnNewButton.setBounds(131, 30, 216, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Manage Frequency");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HSManageFrequency(currHSSSN).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(131, 74, 216, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Manage Observation Specification");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ObservationSpecificationManagement(currHSSSN).setVisible(true);
			}
		});
		btnNewButton_2.setBounds(131, 120, 216, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HealthSupporterLoggedIn(currHSSSN).setVisible(true);
			}
		});
		btnNewButton_3.setBounds(198, 229, 117, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Exit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_4.setBounds(327, 229, 117, 29);
		contentPane.add(btnNewButton_4);
		
		JButton btnManageGeneralLimits = new JButton("Manage General Limits");
		btnManageGeneralLimits.setBounds(25, 180, 200, 25);
		contentPane.add(btnManageGeneralLimits);
		
		btnManageGeneralLimits.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SeeGeneralLimitForHealthSupporter(currHSSSN).setVisible(true);
				
			}
		});
		
		JButton btnManageGeneralRecommendation = new JButton("Manage General Recom");
		btnManageGeneralRecommendation.setBounds(244, 180, 200, 25);
		contentPane.add(btnManageGeneralRecommendation);
		
		btnManageGeneralRecommendation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SeeGeneralRecommendationForHealthSupporter().setVisible(true);
			}
		});
	}

}
