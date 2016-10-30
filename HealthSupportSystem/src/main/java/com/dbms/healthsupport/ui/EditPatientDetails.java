package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.dao.PeopleDao;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.People;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class EditPatientDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_4;
	private JLabel lblPatientCategory;
	private JTextField textField_5;
	private JLabel lblAddress;
	private JTextArea textArea;
	private JButton btnBack;
	private JButton btnExit;
	private String patientSSN;
	private JPasswordField passwordField;
    private	JComboBox comboBox_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPatientDetails frame = new EditPatientDetails("P1");
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
	public EditPatientDetails(String patientSSN) {
		this.patientSSN = patientSSN;
		PatientDao patientdao=new PatientDao();
		Patient patient=null;
		try {
			patient=patientdao.getDataById(patientSSN);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(EditPatientDetails.this,
				    e1.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SSN");
		lblNewLabel.setBounds(22, 29, 61, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(206, 24, 130, 26);
		textField.setText(patientSSN);
		textField.setEditable(false);;
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DOB");
		lblNewLabel_1.setBounds(22, 78, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setText(patient.getDob().toString());
		textField_1.setBounds(206, 73, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setBounds(22, 123, 122, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(206, 118, 130, 26);
		textField_2.setText(patient.getFirstName());
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Last Name");
		lblNewLabel_3.setBounds(22, 166, 114, 16);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(206, 161, 130, 26);
		textField_3.setText(patient.getLastName());
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
//		lblNewLabel_4 = new JLabel("Gender");
//		lblNewLabel_4.setBounds(22, 214, 61, 16);
//		contentPane.add(lblNewLabel_4);
		
		String[] genderInformation = { "Male", "Female" };
		comboBox_1 = new JComboBox(genderInformation);
		comboBox_1.setBounds(450, 151, 32, 24);
		contentPane.add(comboBox_1);
		
		
		textField_4 = new JTextField();
		textField_4.setBounds(206, 199, 130, 26);
		textField_4.setText(patient.getGender());
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblPatientCategory = new JLabel("Patient Category");
		lblPatientCategory.setBounds(22, 251, 103, 16);
		contentPane.add(lblPatientCategory);
		
		textField_5 = new JTextField();
		try {
			if(new PatientDao().isSick(patientSSN)){
				textField_5.setText("Sick Patient");
			}else{
				textField_5.setText("Well Patient");
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(EditPatientDetails.this,
				    e1.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(206, 246, 130, 26);
		contentPane.add(textField_5);
		
		lblAddress = new JLabel("Address");
		lblAddress.setBounds(22, 296, 61, 16);
		contentPane.add(lblAddress);
		
		textArea = new JTextArea();
		textArea.setText(patient.getAddress());
		textArea.setBounds(207, 296, 129, 44);
		contentPane.add(textArea);
		
		btnBack = new JButton("Submit Details");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientDao patientDao = new PatientDao();
				People people = new People(textField.getText(), textField_2.getText(), textField_3.getText(), textArea.getText(), passwordField.getText());
				Patient patient = new Patient(people ,java.sql.Date.valueOf(textField_1.getText()), (String)comboBox_1.getSelectedItem());
				PeopleDao peopleDao = new PeopleDao();
				try {
					peopleDao.updatePeopleRow(people);
					JOptionPane.showMessageDialog(EditPatientDetails.this,
						    "Details updated");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(EditPatientDetails.this,
						    e1.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
				try {
					patientDao.updateRow(patient);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(EditPatientDetails.this,
						    e1.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnBack.setBounds(219, 379, 117, 29);
		contentPane.add(btnBack);
		
		btnExit = new JButton("Exit System");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(333, 379, 117, 29);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setBounds(22, 352, 70, 15);
		contentPane.add(lblNewLabel_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(206, 379, -58, 19);
		passwordField.setText(patient.getPassword());
		contentPane.add(passwordField);
	}
}
