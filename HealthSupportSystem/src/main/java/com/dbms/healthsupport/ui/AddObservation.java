package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.dbms.healthsupport.dao.ObservationDao;
import com.dbms.healthsupport.dao.ObservationSpecDao;
import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.domain.Limits;
import com.dbms.healthsupport.domain.Observation;
import com.dbms.healthsupport.domain.ObservationMetricDetails;
import com.dbms.healthsupport.domain.ObservationSpec;

import jdk.internal.org.objectweb.asm.util.Textifiable;

public class AddObservation extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private List<ObservationSpec> obspeclist;
	private JButton btnCreateLimit;
	private JLabel lblCreateLimitFor;
	private JButton btnExit;
	private JTextField txtMetricValue;
	private JTextField txtDateYyyymmdd;
	private JTextField textField;
	private JLabel label_2;
	private JTextField textField_1;
	private List<JTextField> textFields = new ArrayList<>();
	private List<JLabel> labels = new ArrayList<>();
	ObservationSpec observationSpec;
	String patientSSN;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddObservation frame = new AddObservation("P2");
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
	public AddObservation(String currPatientSSN) {
		this.patientSSN = currPatientSSN;
			
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
			JOptionPane.showMessageDialog(AddObservation.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		List<String> specNames=new ArrayList<String>();
		for(ObservationSpec obspec: obspeclist){
			specNames.add(obspec.getObservationName());
		}
		
		Label label = new Label("Observation Spec");
		label.setBounds(66, 70, 68, 21);
		contentPane.add(label);
		
		comboBox = new JComboBox(specNames.toArray());
		comboBox.setBounds(161, 70, 100, 24);
		contentPane.add(comboBox);
		
		btnCreateLimit = new JButton("Record Observation");
		btnCreateLimit.setBounds(77, 250, 117, 25);
		contentPane.add(btnCreateLimit);
		
		lblCreateLimitFor = new JLabel("Record Observation for: " + patientSSN);
		lblCreateLimitFor.setBounds(50, 29, 200, 15);
		contentPane.add(lblCreateLimitFor);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(290, 250, 117, 29);
		contentPane.add(btnExit);
		
		JLabel lblMetric = new JLabel("Metric1");
		lblMetric.setBounds(79, 153, 70, 15);
		labels.add(lblMetric);
		contentPane.add(lblMetric);
		
		txtMetricValue = new JTextField();
		txtMetricValue.setText("Metric1 Value");
		txtMetricValue.setBounds(189, 151, 114, 19);
		textFields.add(txtMetricValue);
		contentPane.add(txtMetricValue);
		txtMetricValue.setColumns(10);
		
		JLabel lblObservedTime = new JLabel("Observed Date");
		lblObservedTime.setBounds(77, 109, 70, 15);
		contentPane.add(lblObservedTime);
		
		txtDateYyyymmdd = new JTextField();
		txtDateYyyymmdd.setText("Date - YYYY-MM-DD");
		txtDateYyyymmdd.setBounds(189, 109, 114, 19);
		contentPane.add(txtDateYyyymmdd);
		txtDateYyyymmdd.setColumns(10);
		
		JLabel label_1 = new JLabel("Metric2");
		label_1.setBounds(91, 170, 70, 15);
		labels.add(label_1);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setText("Metric2 Value");
		textField.setColumns(10);
		textField.setBounds(201, 201, 114, 19);
		textFields.add(textField);
		contentPane.add(textField);
		
		label_2 = new JLabel("Metric3");
		label_2.setBounds(115, 241, 70, 15);
		labels.add(label_2);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setText("Metric3 Value");
		textField_1.setColumns(10);
		textField_1.setBounds(225, 239, 114, 19);
		textFields.add(textField_1);
		contentPane.add(textField_1);
		
		for(int i=0; i<3; i++)
		{
			JLabel jLabel = labels.get(i);
			jLabel.setVisible(false);
			
			JTextField jTextField = textFields.get(i);
			jTextField.setVisible(false);
		}
		
		comboBox.setSelectedIndex(-1);

		
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String obsspec = (String) comboBox.getSelectedItem();
				try
				{
					
					observationSpec = new ObservationSpecDao().getDataById(obsspec);
					
					for(int i=0; i<observationSpec.getMetrics().size() && i<3; i++)
					{
						JLabel jLabel = labels.get(i);
						jLabel.setText(observationSpec.getMetrics().get(i));
						jLabel.setVisible(true);
						
						JTextField jTextField = textFields.get(i);
						jTextField.setVisible(true);
						jTextField.setText(observationSpec.getMetrics().get(i));
						
					}
					
					for(int i=observationSpec.getMetrics().size(); i<3; i++)
					{
						JLabel jLabel = labels.get(i);
						jLabel.setVisible(false);
						JTextField jTextField = textFields.get(i);
						jTextField.setVisible(false);
					}
					

				}catch (Exception exp) {
					// TODO: handle exception
				}
				
			}
		});
		
		
		btnCreateLimit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try
				{
				
				List<ObservationMetricDetails> metricDetails= new ArrayList<>();
						
				for(int i=0; (i<observationSpec.getMetrics().size()) && (i<3); i++)
				{

					JTextField jTextField = textFields.get(i);
					ObservationMetricDetails observationMetricDetails = new ObservationMetricDetails(observationSpec.getMetrics().get(i), jTextField.getText());
					metricDetails.add(observationMetricDetails);
				}
				Calendar currenttime = Calendar.getInstance();
				
				Observation observation = new Observation(0, java.sql.Date.valueOf(txtDateYyyymmdd.getText()), new Date((currenttime.getTime()).getTime()), patientSSN, observationSpec.getObservationName(), metricDetails);
					
				observation = new ObservationDao().insertObservation(observation);
				
				JOptionPane.showMessageDialog(AddObservation.this,
					    "Added Observation: " + observation.getObservationId());
				
				}catch (Exception exp) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(AddObservation.this,
						    exp.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
						
						
			}
		});
		
		
		
	}
}
