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

public class ViewDiagnoses extends JFrame {

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
					ViewDiagnoses frame = new ViewDiagnoses("P2");
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
	public ViewDiagnoses(String patientSSN) {
		this.patientSSN = patientSSN;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMyDiagnoses = new JLabel("My Diagnoses");
		lblMyDiagnoses.setBounds(46, 17, 126, 16);
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
		scrollPane.setBounds(77, 67, 300, 150);
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
			JOptionPane.showMessageDialog(ViewDiagnoses.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		
		
		String[] columnNames = {"Disease Name", "Disease Description"};
		
		table_1 = new JTable(listDiseases, columnNames);
		scrollPane.setViewportView(table_1);
		
		JButton btnSeeLimits = new JButton("See LImits");
		btnSeeLimits.setBounds(27, 232, 117, 25);
		contentPane.add(btnSeeLimits);
		
		JButton btnSetLimit = new JButton("Set Limit");
		btnSetLimit.setBounds(155, 232, 117, 25);
		contentPane.add(btnSetLimit);
		
		JButton btnSeeRecommendation = new JButton("See Recommendation");
		btnSeeRecommendation.setBounds(155, 270, 117, 25);
		contentPane.add(btnSeeRecommendation);
		
		JButton btnSetRecommendation = new JButton("Set Recommendation");
		btnSetRecommendation.setBounds(293, 270, 117, 25);
		contentPane.add(btnSetRecommendation);
		
		JLabel lblPatientId = new JLabel("Patient Id: " + patientSSN);
		lblPatientId.setBounds(203, 44, 70, 15);
		contentPane.add(lblPatientId);
		
		
	}
}
