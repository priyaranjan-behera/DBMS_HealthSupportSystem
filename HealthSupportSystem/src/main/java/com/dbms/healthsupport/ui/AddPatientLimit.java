package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dbms.healthsupport.dao.DiseasesDao;
import com.dbms.healthsupport.dao.LimitsDao;
import com.dbms.healthsupport.dao.ObservationSpecDao;
import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.domain.Limits;
import com.dbms.healthsupport.domain.ObservationSpec;

public class AddPatientLimit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private List<ObservationSpec> obspeclist;
	private JButton btnCreateLimit;
	private JLabel lblCreateLimitFor;
	String patientSSN;
	private JButton btnExit;
	private JButton btnButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPatientLimit frame = new AddPatientLimit("");
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
	public AddPatientLimit(String patientSSN1) {
			
		this.patientSSN = patientSSN1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.obspeclist = null;
		
		ObservationSpecDao osd=new ObservationSpecDao();
		try {
			obspeclist = osd.getAllData();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(AddPatientLimit.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		List<String> specNames=new ArrayList<String>();
		for(ObservationSpec obspec: obspeclist){
			specNames.add(obspec.getObservationName());
		}
		
		Label label = new Label("Observation Spec");
		label.setBounds(34, 42, 68, 21);
		contentPane.add(label);
		
		comboBox = new JComboBox(specNames.toArray());
		comboBox.setBounds(159, 42, 100, 24);
		contentPane.add(comboBox);
		
		
		JLabel lblMetricName = new JLabel("Metric Name");
		lblMetricName.setBounds(34, 105, 70, 15);
		contentPane.add(lblMetricName);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(159, 101, 100, 24);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("upper limit");
		lblNewLabel.setBounds(34, 160, 70, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(159, 157, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLowerLimit = new JLabel("lower limit");
		lblLowerLimit.setBounds(32, 199, 70, 15);
		contentPane.add(lblLowerLimit);
		
		textField_1 = new JTextField();
		textField_1.setBounds(169, 199, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnCreateLimit = new JButton("Create Limit");
		btnCreateLimit.setBounds(74, 230, 117, 25);
		contentPane.add(btnCreateLimit);
		
		lblCreateLimitFor = new JLabel("Create Limit For: " + patientSSN);
		lblCreateLimitFor.setBounds(47, 42, 70, 15);
		contentPane.add(lblCreateLimitFor);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(327, 227, 117, 29);
		contentPane.add(btnExit);
		
		btnButton = new JButton("Button");
		btnButton.setBounds(203, 228, 117, 29);
		contentPane.add(btnButton);

		
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String obsspec = (String) comboBox.getSelectedItem();
				try
				{
					DefaultComboBoxModel dcm = new DefaultComboBoxModel();
					comboBox_1.setModel( dcm );
					
					ObservationSpec observationSpec = new ObservationSpecDao().getDataById(obsspec);
					
							for(String metric:observationSpec.getMetrics())
								dcm.addElement(metric);
					

				}catch (Exception exp) {
					// TODO: handle exception
				}
				
			}
		});
		
		btnCreateLimit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					Limits limits = new LimitsDao().insertPatientLimit(new Limits(0, textField_1.getText(), textField.getText(), comboBox_1.getSelectedItem().toString(), comboBox.getSelectedItem().toString()), new PatientDao().getDataById(patientSSN) );
					JOptionPane.showMessageDialog(AddPatientLimit.this,
						    "Limits ID: " + limits.getLimitID());
				}
				catch (Exception exp) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(AddPatientLimit.this,
						    exp.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
	}

}
