package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbms.healthsupport.dao.AlertDao;
import com.dbms.healthsupport.dao.LimitsDao;
import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.dao.RecommendationDao;
import com.dbms.healthsupport.domain.Alert;
import com.dbms.healthsupport.domain.Limits;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.Recommendation;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class SeeGeneralLimitForPatient extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeGeneralLimitForPatient frame = new SeeGeneralLimitForPatient("P1");
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
	public SeeGeneralLimitForPatient(String ssn) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String[][] limitDetails = new String[10][];
		
		try
		{
			List<Integer> limits = new LimitsDao().getGeneralLimits();
		
			limitDetails = new String[limits.size()][];
		
		
		int i=0;
		for(Integer limit: limits)
		{
			Limits limits2 = new LimitsDao().getDataById(limit);
			String[] limitDetail = {limits2.getLimitID().toString(), limits2.getObservationSpec(), limits2.getMetricId(), limits2.getUpperLimit(), limits2.getLowerLimit()};
			limitDetails[i++] = limitDetail;
		}
		
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(SeeGeneralLimitForPatient.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		String[] columnNames = {"LimitId", "ObservationSpec", "Metric", "Upper Limit", "Lower Limit"};
		
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 31, 300, 150);
		contentPane.add(scrollPane);
		
		table = new JTable(limitDetails, columnNames);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PatientHealthIndicators(ssn).setVisible(true);
			}
		});
		btnNewButton.setBounds(155, 217, 117, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(297, 217, 117, 29);
		contentPane.add(btnNewButton_1);
	}
}
