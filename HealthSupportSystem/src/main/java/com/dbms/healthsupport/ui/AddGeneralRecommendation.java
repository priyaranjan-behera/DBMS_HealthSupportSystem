package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbms.healthsupport.dao.FrequencyDao;
import com.dbms.healthsupport.dao.ObservationSpecDao;
import com.dbms.healthsupport.dao.RecommendationDao;
import com.dbms.healthsupport.domain.Frequency;
import com.dbms.healthsupport.domain.ObservationSpec;
import com.dbms.healthsupport.domain.Recommendation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AddGeneralRecommendation extends JFrame {

	private JPanel contentPane;
	private JComboBox textField_1;
	private JTextField textField_2;
	private JComboBox textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGeneralRecommendation frame = new AddGeneralRecommendation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
//Integer recId, String frequencyName, Integer threshold, String observationSpecification
	/**
	 * Create the frame.
	 */
	public AddGeneralRecommendation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddRecommendation = new JLabel("Add General Recommendation");
		lblAddRecommendation.setBounds(18, 20, 183, 16);
		contentPane.add(lblAddRecommendation);
		
		JLabel lblNewLabel_1 = new JLabel("Frequency Name");
		lblNewLabel_1.setBounds(18, 75, 130, 16);
		contentPane.add(lblNewLabel_1);
		List<Frequency> frequencies=new ArrayList<Frequency>();
		try{
		frequencies = new FrequencyDao().getAllData();
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(AddGeneralRecommendation.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		List<String> frequencyNames = new ArrayList<String>();
		System.out.println("Frequencies: " + frequencies);
		for(Frequency frequency: frequencies)
		{
			frequencyNames.add(frequency.getFrequencyName());
		}
		textField_1 = new JComboBox(frequencyNames.toArray());
		textField_1.setBounds(207, 65, 172, 26);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Threshold");
		lblNewLabel_2.setBounds(18, 103, 150, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(207, 98, 172, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblObser = new JLabel("Observation Specification");
		lblObser.setBounds(18, 131, 172, 16);
		contentPane.add(lblObser);
		
		List<ObservationSpec> observationSpecs=new ArrayList<ObservationSpec>();
		try{
		observationSpecs = new ObservationSpecDao().getAllData();
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(AddGeneralRecommendation.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		List<String> observationSpecNames = new ArrayList<String>();
		for(ObservationSpec observationSpec: observationSpecs)
		{
			observationSpecNames.add(observationSpec.getObservationName());
		}
		
		textField_3 = new JComboBox(observationSpecNames.toArray());
		textField_3.setBounds(207, 136, 172, 26);
		contentPane.add(textField_3);
		
		JButton btnAddRecommendation = new JButton("Add Recommendation");
		btnAddRecommendation.setBounds(129, 226, 198, 29);
		contentPane.add(btnAddRecommendation);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 226, 117, 29);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(327, 226, 117, 29);
		contentPane.add(btnExit);
		
		btnAddRecommendation.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					Recommendation recommendation = new RecommendationDao().insertGeneralRecommendation(new Recommendation(0, textField_1.getSelectedItem().toString(), Integer.parseInt(textField_2.getText()), textField_3.getSelectedItem().toString()));
					JOptionPane.showMessageDialog(AddGeneralRecommendation.this,
						    "Recommendation ID: " + recommendation.getRecId());
				}
				catch (Exception exp) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(AddGeneralRecommendation.this,
						    exp.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
	}
}
