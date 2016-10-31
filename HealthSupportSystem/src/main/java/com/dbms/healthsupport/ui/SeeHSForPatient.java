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
import com.dbms.healthsupport.dao.HealthSupporterDao;
import com.dbms.healthsupport.dao.LimitsDao;
import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.dao.RecommendationDao;
import com.dbms.healthsupport.domain.Alert;
import com.dbms.healthsupport.domain.HealthSupporter;
import com.dbms.healthsupport.domain.Limits;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.Recommendation;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class SeeHSForPatient extends JFrame {

	private JPanel contentPane;
	String patientSSN;
	private JTable table;
	private JButton btnGoBack;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeHSForPatient frame = new SeeHSForPatient("P2");
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
	public SeeHSForPatient(String currPatientSSN) {
		this.patientSSN = currPatientSSN;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String[][] hsDetails=null;
		
		try
		{
			
			String primarySupporter = new PatientDao().getDataById(currPatientSSN).getPrimaryHealthSupporter();
//			hsDetails = new String[][];
			System.out.println(primarySupporter);
			
			HealthSupporter hs=new HealthSupporterDao().getDataById(primarySupporter);
			int i=0;
			System.out.println(hs.getSsn());
			
			List<String> secondarySupporter = new PatientDao().getDataById(currPatientSSN).getSecondaryHealthSupporters();
			
			if(secondarySupporter!=null){
				if(secondarySupporter.size()>0){
					hsDetails=new String[2][];
					String[] hsDetail={hs.getSsn(),hs.getFirstName(),hs.getLastName(),hs.getContactNumber().toString(),"Primary"};
					hsDetails[i++] = hsDetail;
					System.out.println("=====");
					hs = new HealthSupporterDao().getDataById(secondarySupporter.get(0));
					String[] shsDetail={hs.getSsn(),hs.getFirstName(),hs.getLastName(),hs.getContactNumber().toString(),"Secondary"};
					hsDetails[i++] = shsDetail;
					
				}
			}
			if(hsDetails==null){
				if(primarySupporter!=null){
					hsDetails=new String[1][];
					String[] hsDetail={hs.getSsn(),hs.getFirstName(),hs.getLastName(),hs.getContactNumber().toString(),"Primary"};
					hsDetails[i++] = hsDetail;
					System.out.println("2=====");

				}else{
					hsDetails=new String[0][];
					System.out.println("=====3");

				}
			}
			

		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(SeeHSForPatient.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		String[] columnNames = {"HSSSN", "FirstName", "LastName", "Contact", "P/S"};
		
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 31, 300, 150);
		contentPane.add(scrollPane);
		
		table = new JTable(hsDetails, columnNames);
		scrollPane.setViewportView(table);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(173, 218, 117, 29);
		contentPane.add(btnGoBack);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(310, 218, 117, 29);
		contentPane.add(btnExit);

	}
}
