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

public class SeePatientRecommendationForPatient extends JFrame {

	private JPanel contentPane;
	String patientSSN;
	private JTable table;
	private JButton btnGoBack;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeePatientRecommendationForPatient frame = new SeePatientRecommendationForPatient("P2");
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
	public SeePatientRecommendationForPatient(String currPatientSSN) {
		this.patientSSN = currPatientSSN;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String[][] recommendationDetails = new String[10][];
		
		try
		{
			List<Integer> recommendations = new PatientDao().getDataById(currPatientSSN).getRecommendations();
		
			recommendationDetails = new String[recommendations.size()][];
		
		
		int i=0;
		for(Integer recommendation: recommendations)
		{
			Recommendation recommendation2 = new RecommendationDao().getDataById(recommendation);
			String[] recommendationDetail = {recommendation2.getRecId().toString(), recommendation2.getObservationSpecification(), recommendation2.getFrequencyName(), recommendation2.getThreshold().toString()};
			recommendationDetails[i++] = recommendationDetail;
		}
		
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(SeePatientRecommendationForPatient.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		String[] columnNames = {"RecommendationId", "ObservationSpec", "Frequency", "Threshold"};
		
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 31, 300, 150);
		contentPane.add(scrollPane);
		
		table = new JTable(recommendationDetails, columnNames);
		scrollPane.setViewportView(table);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(184, 214, 117, 29);
		contentPane.add(btnGoBack);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(313, 214, 117, 29);
		contentPane.add(btnExit);

	}
}
