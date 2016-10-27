package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ForHealthSupporterViewAllAuthorizedPatients extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForHealthSupporterViewAllAuthorizedPatients frame = new ForHealthSupporterViewAllAuthorizedPatients();
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
	public ForHealthSupporterViewAllAuthorizedPatients() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(327, 6, 117, 29);
		contentPane.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 78, 432, 210);
		contentPane.add(scrollPane);
		
		String col[] = {"Pos","Team","P", "W", "L", "D", "MP", "GF", "GA", "GD"};
		DefaultTableModel defaultTableModel = new DefaultTableModel(col,0);
		table = new JTable(defaultTableModel);
		Object[] objs = {1, "Arsenal", 35, 11, 2, 2, 15, 30, 11, 19};
		defaultTableModel.addRow(objs);
	
		scrollPane.setViewportView(table);
	}
}
