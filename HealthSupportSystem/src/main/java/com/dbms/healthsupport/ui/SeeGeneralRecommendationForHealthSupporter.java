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

public class SeeGeneralRecommendationForHealthSupporter extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeGeneralRecommendationForHealthSupporter frame = new SeeGeneralRecommendationForHealthSupporter();
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
	public SeeGeneralRecommendationForHealthSupporter() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String[][] recommendationDetails = new String[10][];
		
		try
		{
			List<Integer> recommendations = new RecommendationDao().getGeneralRecommendations();
		
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
			JOptionPane.showMessageDialog(SeeGeneralRecommendationForHealthSupporter.this,
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
		
		JButton btnAddNewLimit = new JButton("Add New Recommendation");
		btnAddNewLimit.setBounds(27, 213, 213, 25);
		contentPane.add(btnAddNewLimit);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(266, 211, 117, 29);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(266, 243, 117, 29);
		contentPane.add(btnExit);
		
		JButton btnDeleteRecommendation = new JButton("Delete Recommendation");
		btnDeleteRecommendation.setBounds(27, 245, 220, 25);
		contentPane.add(btnDeleteRecommendation);
		
		btnDeleteRecommendation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
				int row = table.getSelectedRow();
				if(row == -1)
				{
					JOptionPane.showMessageDialog(SeeGeneralRecommendationForHealthSupporter.this,
						    "Select a row to clear the recommendation");
				}
				else
				{
					String Table_click = (table.getModel().getValueAt(row, 0).toString());
					Integer recId = Integer.parseInt(Table_click);
					//String diseaseName=Table_click;
					//new AlertDao().clearAlert(alertId);
					Recommendation recommendation = new RecommendationDao().getDataById(recId);
					new RecommendationDao().deleteRow(recommendation);
					
					JOptionPane.showMessageDialog(SeeGeneralRecommendationForHealthSupporter.this,
						    "Rec Id: " + recId + " has been cleared");
					
					
					
					String[][] recommendationDetails = new String[10][];
					
					try
					{
						List<Integer> recommendations = new RecommendationDao().getGeneralRecommendations();
					
						recommendationDetails = new String[recommendations.size()][];
					
					
					int i=0;
					for(Integer recommendation3: recommendations)
					{
						Recommendation recommendation2 = new RecommendationDao().getDataById(recommendation3);
						String[] recommendationDetail = {recommendation2.getRecId().toString(), recommendation2.getObservationSpecification(), recommendation2.getFrequencyName(), recommendation2.getThreshold().toString()};
						recommendationDetails[i++] = recommendationDetail;
					}
					
					}
					catch (Exception exp2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(SeeGeneralRecommendationForHealthSupporter.this,
							    exp2.getMessage(),
							    "Inane warning",
							    JOptionPane.WARNING_MESSAGE);
					}
					
					String[] columnNames = {"RecommendationId", "ObservationSpec", "Frequency", "Threshold"};

					table = new JTable(recommendationDetails, columnNames);
					scrollPane.setViewportView(table);
					
					
					
					

				}
				}catch (Exception exp) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(SeeGeneralRecommendationForHealthSupporter.this,
						    exp.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		btnAddNewLimit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddGeneralRecommendation().setVisible(true);
				
			}
		});
	}
}
