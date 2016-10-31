package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import com.dbms.healthsupport.dao.DiseasesDao;
import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.domain.Patient;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ViewDiagnosesForHS extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String patientSSN;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDiagnosesForHS frame = new ViewDiagnosesForHS("P2");
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
	public ViewDiagnosesForHS(String currPatientSSN) {
		this.patientSSN = currPatientSSN;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMyDiagnoses = new JLabel("My Diagnoses");
		lblMyDiagnoses.setBounds(27, 17, 126, 16);
		contentPane.add(lblMyDiagnoses);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(203, 330, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit System");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(327, 330, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 70, 300, 150);
		contentPane.add(scrollPane);
		
		Patient patient = null;
		String[][] listDiseases=null;
		try
		{
			patient = new PatientDao().getDataById(patientSSN);
			
			listDiseases = new String[patient.getDiseases().size()][];
			
			int i=0;
			
			for(String disease: patient.getDiseases())
			{
				String[] diseaseDetail = {disease, new DiseasesDao().getDataById(disease).getDisDescription()};
				listDiseases[i++] = diseaseDetail;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(ViewDiagnosesForHS.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		
		
		String[] columnNames = {"Disease Name", "Disease Description"};
		
		table_1 = new JTable(listDiseases, columnNames);
		scrollPane.setViewportView(table_1);
		
		JButton btnSeeLimits = new JButton("See Limits");
		btnSeeLimits.setBounds(27, 248, 117, 25);
		contentPane.add(btnSeeLimits);
		
		JButton btnSetLimit = new JButton("Set Limit");
		btnSetLimit.setBounds(238, 248, 117, 25);
		contentPane.add(btnSetLimit);
		
		JButton btnSeeRecommendation = new JButton("See Recommendation");
		btnSeeRecommendation.setBounds(27, 292, 165, 25);
		contentPane.add(btnSeeRecommendation);
		
		JButton btnSetRecommendation = new JButton("Set Recommendation");
		btnSetRecommendation.setBounds(236, 293, 189, 25);
		contentPane.add(btnSetRecommendation);
		
		JLabel lblPatientId = new JLabel("Patient Id: " + patientSSN);
		lblPatientId.setBounds(25, 45, 219, 15);
		contentPane.add(lblPatientId);
		
		JButton btnAddDiagnosis = new JButton("Add Diagnosis");
		btnAddDiagnosis.setBounds(27, 320, 117, 25);
		contentPane.add(btnAddDiagnosis);
		
		btnAddDiagnosis.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddDiseaseDiagnosesForHealthSupporter(patientSSN).setVisible(true);
			}
		});
		
		
	}
}
