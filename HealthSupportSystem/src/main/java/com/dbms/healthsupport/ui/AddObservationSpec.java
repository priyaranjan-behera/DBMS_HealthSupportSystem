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

public class AddObservationSpec extends JFrame {

	private JPanel contentPane;
	private List<ObservationSpec> obspeclist;
	private JTextField txtObservationSpecName;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblObservationSpecDesc;
	private JTextField txtObservationSpecDesc;
	private JButton btnBack;
	private JButton btnExit;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddObservationSpec frame = new AddObservationSpec();
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
	public AddObservationSpec() {
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblObservationSpecName = new JLabel("Observation Spec Name: ");
		lblObservationSpecName.setBounds(48, 46, 200, 15);
		contentPane.add(lblObservationSpecName);
		
		txtObservationSpecName = new JTextField();
		txtObservationSpecName.setText("Observation Spec Name");
		txtObservationSpecName.setBounds(266, 44, 114, 19);
		contentPane.add(txtObservationSpecName);
		txtObservationSpecName.setColumns(10);
		
		JLabel lblMetricName = new JLabel("Metric Name");
		lblMetricName.setBounds(73, 128, 120, 15);
		contentPane.add(lblMetricName);
		
		textField = new JTextField();
		textField.setBounds(194, 126, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("Metric Name");
		label.setBounds(83, 157, 120, 15);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(204, 155, 114, 19);
		contentPane.add(textField_1);
		
		JLabel label_1 = new JLabel("Metric Name");
		label_1.setBounds(73, 186, 120, 15);
		contentPane.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(194, 184, 114, 19);
		contentPane.add(textField_2);
		
		JButton btnAddSpecification = new JButton("Add Specification");
		btnAddSpecification.setBounds(3, 236, 200, 25);
		contentPane.add(btnAddSpecification);
		
		lblObservationSpecDesc = new JLabel("Observation Spec Desc: ");
		lblObservationSpecDesc.setBounds(48, 75, 200, 15);
		contentPane.add(lblObservationSpecDesc);
		
		txtObservationSpecDesc = new JTextField();
		txtObservationSpecDesc.setText("Observation Spec Desc");
		txtObservationSpecDesc.setColumns(10);
		txtObservationSpecDesc.setBounds(266, 73, 114, 19);
		contentPane.add(txtObservationSpecDesc);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(191, 236, 117, 25);
		contentPane.add(btnBack);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(304, 234, 117, 29);
		contentPane.add(btnExit);
		
		
		btnAddSpecification.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				List<String> metrics = new ArrayList<>();
				if(!textField.getText().equals(""))
					{
						metrics.add(textField.getText());
						System.out.println("Adding 1");
					}
				if(!textField_1.getText().equals(""))
					{
					metrics.add(textField_1.getText());
					System.out.println("Adding 2");
					}
				if(!textField_2.getText().equals(""))
					{
					metrics.add(textField_2.getText());
					System.out.println("Adding 3");
					}

				String observationSpec = txtObservationSpecName.getText();
				
				String observationSpecDec = txtObservationSpecDesc.getText();
				
				System.out.println("Size of Metrics: " + metrics.size());
				
				ObservationSpec observationSpec2 = new ObservationSpec(observationSpec, observationSpecDec, metrics);
				try
				{
				new ObservationSpecDao().insertObservationSpec(observationSpec2);
				JOptionPane.showMessageDialog(AddObservationSpec.this,
					    "Created Observation Spec");
				}catch (Exception exp) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(AddObservationSpec.this,
						    exp.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		

		
	}
}
