package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.dbms.healthsupport.dao.AlertDao;
import com.dbms.healthsupport.dao.FrequencyDao;
import com.dbms.healthsupport.domain.Alert;
import com.dbms.healthsupport.domain.Frequency;

import javax.swing.JTable;
import javax.swing.JButton;

public class ViewFrequency extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnInsertFrequency;
	private JButton btnExit;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFrequency frame = new ViewFrequency("P4");
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
	public ViewFrequency(String currHSSSN) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[][] frequencyDetails = new String[10][];
		
		try
		{
			List<Frequency> frequency = new FrequencyDao().getAllData();
			System.out.println("Total alerts: " + frequency.size());
		
		
			frequencyDetails = new String[frequency.size()][];
		
		
		int i=0;
		for(Frequency alert: frequency)
		{
			String[] frequencyDetail = {alert.getFrequencyName().toString(), alert.getDuration().toString()};
			frequencyDetails[i++] = frequencyDetail;
		}
		
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(ViewFrequency.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		
		String[] columnNames = {"Frequency Name", "Frequency Duration"};
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 31, 300, 150);
		contentPane.add(scrollPane);
		
		table = new JTable(frequencyDetails, columnNames);
		scrollPane.setViewportView(table);
		
		btnInsertFrequency = new JButton("Insert Frequency");
		btnInsertFrequency.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertFrequency insertFrequency  = new InsertFrequency();
				insertFrequency.setVisible(true);
			}
		});
		btnInsertFrequency.setBounds(296, 227, 148, 29);
		contentPane.add(btnInsertFrequency);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(167, 227, 117, 29);
		contentPane.add(btnExit);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HealthSupporterLoggedIn(currHSSSN).setVisible(true);
			}
		});
		btnBack.setBounds(38, 227, 117, 29);
		contentPane.add(btnBack);
		
	}
}
