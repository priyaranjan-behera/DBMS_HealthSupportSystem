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

import com.dbms.healthsupport.dao.DiseasesDao;
import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.domain.Diseases;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AddDiseaseDiagnosesForHealthSupporter extends JFrame {

	private JPanel contentPane;
	private JComboBox textField;
	private JButton btnAddDiseaseName;
	private JButton btnExitSystem;
	String patientSSN;
	String HSSSN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDiseaseDiagnosesForHealthSupporter frame = new AddDiseaseDiagnosesForHealthSupporter("P3","P4");
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
	public AddDiseaseDiagnosesForHealthSupporter(String currPatientSSN, String currHSSSN) {
		this.patientSSN = currPatientSSN;
		this.HSSSN = currHSSSN;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		List<Diseases> diseases = new ArrayList<Diseases>();
		List<String> diseaseNames = new ArrayList<String>();
		try
		{
			diseases = new DiseasesDao().getAllData();
			for(Diseases diseases2: diseases)
			{
				diseaseNames.add(diseases2.getDisName());
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(AddDiseaseDiagnosesForHealthSupporter.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		textField = new JComboBox(diseaseNames.toArray());
		textField.setBounds(51, 58, 130, 26);
		contentPane.add(textField);
		
		JLabel lblDiseseName = new JLabel("Add Disease For: " + currPatientSSN);
		lblDiseseName.setBounds(51, 29, 300, 16);
		contentPane.add(lblDiseseName);
		
		btnAddDiseaseName = new JButton("Add Disease");
		btnAddDiseaseName.setBounds(128, 225, 162, 29);
		contentPane.add(btnAddDiseaseName);
		
		btnExitSystem = new JButton("Exit System");
		btnExitSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitSystem.setBounds(297, 225, 117, 29);
		contentPane.add(btnExitSystem);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(297, 187, 117, 25);
		contentPane.add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HealthSupporterLoggedIn(HSSSN).setVisible(true);
				
			}
		});
		
		btnAddDiseaseName.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					new PatientDao().AssignDiseaseToPatient(new PatientDao().getDataById(patientSSN), new DiseasesDao().getDataById(textField.getSelectedItem().toString()));
					JOptionPane.showMessageDialog(AddDiseaseDiagnosesForHealthSupporter.this,
						    "Added Disease: " + textField.getSelectedItem() + " to " + patientSSN);
					
				}catch (Exception exp) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(AddDiseaseDiagnosesForHealthSupporter.this,
						    exp.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
	}
}
