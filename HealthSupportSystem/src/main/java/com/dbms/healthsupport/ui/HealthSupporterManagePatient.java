package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbms.healthsupport.dao.LimitsDao;
import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.dao.RecommendationDao;
import com.dbms.healthsupport.domain.Limits;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.Recommendation;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class HealthSupporterManagePatient extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	String patientSSN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthSupporterManagePatient frame = new HealthSupporterManagePatient("P2");
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
	public HealthSupporterManagePatient(String currPatientSSN) {
		this.patientSSN = currPatientSSN;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String[][] recommendationDetails = new String[10][];
		String[][] limitDetails = new String[10][];
		Patient patient = null;
		try
		{
			patient = new PatientDao().getDataById(currPatientSSN);
		
		
		recommendationDetails = new String[patient.getRecommendations().size()][];
		
		RecommendationDao recommendationDao = new RecommendationDao();
		
		int i=0;
		for(Integer recommendationId: patient.getRecommendations())
		{
			Recommendation recommendation =  recommendationDao.getDataById(recommendationId);
			String[] recommendationDetail = {recommendation.getRecId().toString(), recommendation.getObservationSpecification(), recommendation.getFrequencyName(), recommendation.getThreshold().toString()};
			recommendationDetails[i++] = recommendationDetail;
		}
		
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(HealthSupporterManagePatient.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		
		String[] columnNames = {"RecommendationId", "Observation Spec", "Frequency", "Threshold"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 85, 300, 50);
		contentPane.add(scrollPane);
		table = new JTable(recommendationDetails, columnNames);
		scrollPane.setViewportView(table);
		
		
		try
		{
		
		
		limitDetails = new String[patient.getLimits().size()][];
		
		LimitsDao limitsDao = new LimitsDao();
		
		int i=0;
		for(Integer limitId: patient.getLimits())
		{
			Limits limits =  limitsDao.getDataById(limitId);
			String[] limitDetail = {limits.getLimitID().toString(), limits.getObservationSpec(), limits.getMetricId(),limits.getUpperLimit(), limits.getLowerLimit()};
			limitDetails[i++] = limitDetail;
		}
		
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(HealthSupporterManagePatient.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		
		String[] columnNames1 = {"LimitId", "Observation Spec", "Metric Name", "Upper Limit", "Lower Limit"};
		
		
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(38, 156, 300, 50);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable(limitDetails, columnNames1);
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("Manage Patient Alerts");
		btnNewButton.setBounds(267, 233, 162, 25);
		contentPane.add(btnNewButton);
		
		JButton btnAddPatientLimit = new JButton("Add Patient Limit");
		btnAddPatientLimit.setBounds(178, 48, 214, 25);
		contentPane.add(btnAddPatientLimit);
		
		JButton btnAddPatientRecommendation = new JButton("Add Patient Recommendation");
		btnAddPatientRecommendation.setBounds(6, 233, 249, 25);
		contentPane.add(btnAddPatientRecommendation);
	}
}
