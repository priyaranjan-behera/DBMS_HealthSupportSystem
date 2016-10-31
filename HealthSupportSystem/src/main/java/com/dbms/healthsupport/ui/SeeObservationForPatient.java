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
import com.dbms.healthsupport.dao.DiseasesDao;
import com.dbms.healthsupport.dao.LimitsDao;
import com.dbms.healthsupport.dao.ObservationDao;
import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.dao.RecommendationDao;
import com.dbms.healthsupport.domain.Alert;
import com.dbms.healthsupport.domain.Diseases;
import com.dbms.healthsupport.domain.Limits;
import com.dbms.healthsupport.domain.Observation;
import com.dbms.healthsupport.domain.ObservationMetricDetails;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.Recommendation;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class SeeObservationForPatient extends JFrame {

	private JPanel contentPane;
	String patientSSN;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeObservationForPatient frame = new SeeObservationForPatient("P2");
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
	public SeeObservationForPatient(String currPatientSSN) {
		this.patientSSN = currPatientSSN;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String[][] obDetails = new String[100][];
		
		try
		{
			List<Integer> observations = new PatientDao().getDataById(currPatientSSN).getObservations();
		
			
			int count = 0;
			
			ObservationDao observationDao = new ObservationDao();
			
			for(Integer observation: observations)
			{
				Observation observation2 = observationDao.getDataById(observation);
				for(ObservationMetricDetails obMetricDetails: observation2.getMetricDetails())
				{
					count++;
				}
			}
		
			obDetails = new String[count][];
		
		int i=0;
		for(Integer observation: observations)
		{
			Observation observation2 = observationDao.getDataById(observation);
			for(ObservationMetricDetails obMetricDetails: observation2.getMetricDetails())
			{
				String[] obDetail = {observation2.getObservationId().toString(), observation2.getObservationSpecification(), observation2.getPatientId(), observation2.getObservationTime().toString(), obMetricDetails.getMetricName(), obMetricDetails.getMetricValue() };
				obDetails[i++] = obDetail;
			}
		}
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(SeeObservationForPatient.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		String[] columnNames = {"ObservationId","Observation Spec",  "PatientID", "Observation Time","Metric Name", "Metric Value"};
		
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 31, 600, 300);
		contentPane.add(scrollPane);
		
		table = new JTable(obDetails, columnNames);
		scrollPane.setViewportView(table);
		
		JButton btnAddNewLimit = new JButton("Add New Observation");
		btnAddNewLimit.setBounds(115, 393, 150, 25);
		contentPane.add(btnAddNewLimit);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(288, 391, 117, 29);
		contentPane.add(btnGoBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(433, 391, 117, 29);
		contentPane.add(btnExit);
		
		btnGoBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new PatientLoggedIn(patientSSN).setVisible(true);
			}
		});
		
		
		
		btnAddNewLimit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddObservation(patientSSN).setVisible(true);;
				
			}
		});
	}
}
