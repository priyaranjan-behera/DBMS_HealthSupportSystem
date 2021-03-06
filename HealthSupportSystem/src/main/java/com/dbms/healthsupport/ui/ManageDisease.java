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
import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.dao.RecommendationDao;
import com.dbms.healthsupport.domain.Alert;
import com.dbms.healthsupport.domain.Diseases;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.Recommendation;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class ManageDisease extends JFrame {

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
					ManageDisease frame = new ManageDisease("P4");
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
	public ManageDisease(String HSSN) {
//		this.patientSSN = currPatientSSN;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String[][] DiseaseDetails = new String[10][];
		
		try
		{
			//List<Alert> alerts = new AlertDao().getAllDataForPatient(currPatientSSN);
			List<Diseases> diseases = new DiseasesDao().getAllData(); 
			System.out.println("Total diseases: " + diseases.size());
		
		
			DiseaseDetails = new String[diseases.size()][];
		
		
		int i=0;
		for(Diseases disease: diseases)
		{
			//String[] DiseaseDetail = {alert.getAlertId().toString(), alert.getAlertType(), alert.getPatientId(), alert.getAlertDate().toGMTString(), alert.getLimitId().toString()};
			String[] DiseaseDetail={disease.getDisName(),disease.getDisDescription()};
			DiseaseDetails[i++] = DiseaseDetail;
		}
		
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(ManageDisease.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		String[] columnNames = {"Disease Name","Disease Description"};
		
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 31, 300, 150);
		contentPane.add(scrollPane);
		
		table = new JTable(DiseaseDetails, columnNames);
		scrollPane.setViewportView(table);
		
		JButton btnClearDisease = new JButton("Clear Disease");
		btnClearDisease.setBounds(162, 193, 117, 25);
		contentPane.add(btnClearDisease);
		
		JButton btnAddDisease = new JButton("Add Disease");
		btnAddDisease.setBounds(41, 193, 109, 27);
		contentPane.add(btnAddDisease);
		
		JButton btnAddLimit = new JButton("Manage Limit");
		btnAddLimit.setBounds(41, 230, 109, 25);
		contentPane.add(btnAddLimit);
		
		JButton btnAddRecommendation = new JButton("Manage Recommendation");
		btnAddRecommendation.setBounds(162, 230, 117, 25);
		contentPane.add(btnAddRecommendation);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HSManageMetaData(HSSN).setVisible(true);
				
			}
		});
		btnBack.setBounds(301, 193, 117, 29);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnExit.setBounds(291, 228, 117, 29);
		contentPane.add(btnExit);
		
		btnAddDisease.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddDisease frame = new AddDisease();
				frame.setVisible(true);
			}
		});
		
		btnAddLimit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){
				try{
					
				
						int row = table.getSelectedRow();
						if(row == -1)
						{
							JOptionPane.showMessageDialog(ManageDisease.this,
								    "Select a row to see details");
						}
						else
						{
							String Table_click = (table.getModel().getValueAt(row, 0).toString());
							new SeeDiseaseLimitForHealthSupporter(Table_click).setVisible(true);
						}
				}catch(Exception e2){
					JOptionPane.showMessageDialog(ManageDisease.this,
						    e2.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				
				}
			}
		});
				
		btnAddRecommendation.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){
				try{
					int row = table.getSelectedRow();
					if(row == -1)
					{
						JOptionPane.showMessageDialog(ManageDisease.this,
							    "Select a row to see details");
					}
					else
					{
						String Table_click = (table.getModel().getValueAt(row, 0).toString());
						new SeeDiseaseRecommendationForHealthSupporter(Table_click).setVisible(true);
					}
				}catch(Exception e2){
					JOptionPane.showMessageDialog(ManageDisease.this,
						    e2.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				
				}
			}
		});
			
		
		btnClearDisease.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				try
				{
				int row = table.getSelectedRow();
				if(row == -1)
				{
					JOptionPane.showMessageDialog(ManageDisease.this,
						    "Select a row to clear the alert");
				}
				else
				{
					String Table_click = (table.getModel().getValueAt(row, 0).toString());
					//Integer alertId = Integer.parseInt(Table_click);
					String diseaseName=Table_click;
					//new AlertDao().clearAlert(alertId);
					Diseases d=new DiseasesDao().getDataById(diseaseName);
					new DiseasesDao().deleteRow(d);
					
					JOptionPane.showMessageDialog(ManageDisease.this,
						    "Alert Id: " + diseaseName + " has been cleared");
					
					
					String[][] DiseaseDetails = new String[10][];
					
					try
					{
						List<Diseases> diseases = new DiseasesDao().getAllData();
						System.out.println("Total alerts: " + diseases.size());
					
					
						DiseaseDetails = new String[diseases.size()][];
					
					
					int i=0;
					for(Diseases disease: diseases)
					{
						String[] DiseaseDetail = {disease.getDisName(), disease.getDisDescription()};
						DiseaseDetails[i++] = DiseaseDetail;
					}
					
					}
					catch (Exception exp1) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(ManageDisease.this,
							    exp1.getMessage(),
							    "Inane warning",
							    JOptionPane.WARNING_MESSAGE);
					}
					
					String[] columnNames = {"Disease Name","Disease Description"};
					
					table = new JTable(DiseaseDetails, columnNames);
					scrollPane.setViewportView(table);
					
				}
				// TODO Auto-generated method stub
				}
				catch (Exception exp) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(ManageDisease.this,
						    exp.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
	}
}
