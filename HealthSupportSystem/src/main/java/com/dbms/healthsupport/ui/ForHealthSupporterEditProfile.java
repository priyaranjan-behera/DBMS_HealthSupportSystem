package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.dbms.healthsupport.dao.HealthSupporterDao;
import com.dbms.healthsupport.dao.PeopleDao;
import com.dbms.healthsupport.domain.HealthSupporter;
import com.dbms.healthsupport.domain.People;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ForHealthSupporterEditProfile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForHealthSupporterEditProfile frame = new ForHealthSupporterEditProfile("P2");
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
	public ForHealthSupporterEditProfile(String HSSSN) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		HealthSupporter healthSupporter=null;
		try
		{
			healthSupporter = new HealthSupporterDao().getDataById(HSSSN);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(ForHealthSupporterEditProfile.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		
		JLabel lblNewLabel = new JLabel("HS Profile Details");
		lblNewLabel.setBounds(6, 6, 114, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(6, 34, 107, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(185, 29, 130, 26);
		textField.setText(healthSupporter.getFirstName());
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(6, 72, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(185, 67, 130, 26);
		textField_1.setText(healthSupporter.getLastName());
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("SSN");
		lblNewLabel_3.setBounds(6, 140, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(185, 135, 130, 26);
		textField_3.setEnabled(false);
		textField_3.setText(healthSupporter.getSsn());
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		final JLabel lblNewLabel_4 = new JLabel("Contact Number");
		lblNewLabel_4.setBounds(6, 112, 114, 16);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.hide();
		
		textField_2 = new JTextField();
		textField_2.setBounds(185, 107, 130, 26);
		textField_2.setText(String.valueOf(healthSupporter.getContactNumber()));
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.hide();
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setBounds(6, 173, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(185, 173, 130, 26);
		passwordField.setText(healthSupporter.getPassword());
		contentPane.add(passwordField);
		
		JButton btnCreateProfile = new JButton("Update Details");
		btnCreateProfile.setBounds(6, 324, 117, 29);
		contentPane.add(btnCreateProfile);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(133, 324, 117, 29);
		contentPane.add(btnBack);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(6, 259, 61, 16);
		contentPane.add(lblAddress);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(185, 260, 210, 52);
		textArea.setText(healthSupporter.getAddress());
		textArea.setWrapStyleWord(word);
		contentPane.add(textArea);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(267, 324, 117, 29);
		contentPane.add(btnExit);
		
		btnCreateProfile.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HealthSupporterDao healthSupporterDao = new HealthSupporterDao();
				People people = new People(textField_3.getText(), textField.getText(), textField_1.getText(), textArea.getText(), passwordField.getText());
				HealthSupporter healthSupporter = new HealthSupporter(people, Long.parseLong(textField_2.getText()));
				try {
					healthSupporterDao.updateRow(healthSupporter);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(ForHealthSupporterEditProfile.this,
						    e1.getMessage(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});

	}
}
