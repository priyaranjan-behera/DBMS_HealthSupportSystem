package com.dbms.healthsupport.ui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbms.healthsupport.dao.ObservationSpecDao;
import com.dbms.healthsupport.domain.ObservationSpec;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class ObservationSpecificationManagement extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObservationSpecificationManagement frame = new ObservationSpecificationManagement();
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
	public ObservationSpecificationManagement() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String[][] osDetails = new String[10][];
		int totalSize=0;;
		try
		{
			List<ObservationSpec> observationSpecs= new ObservationSpecDao().getAllData();
			
			for(ObservationSpec observationSpec: observationSpecs)
			{
				for(String metric: observationSpec.getMetrics())
					totalSize++;
			}
			
		
		
			osDetails = new String[totalSize][];
		
		
		int i=0;
		for(ObservationSpec observationSpec: observationSpecs)
		{
			for(String metric: observationSpec.getMetrics())
			{
				String[] osDetail = {observationSpec.getObservationName(), observationSpec.getDescription(), metric};
				osDetails[i++] = osDetail;
			}
			
		}
		
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(ObservationSpecificationManagement.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		String[] columnNames = {"ObservationSpecName", "ObservationSpecDescription", "MetricName"};
		
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 31, 300, 150);
		contentPane.add(scrollPane);
		
		table = new JTable(osDetails, columnNames);
		scrollPane.setViewportView(table);
		
		JButton btnClearAlert = new JButton("Back");
		btnClearAlert.setBounds(219, 214, 117, 25);
		contentPane.add(btnClearAlert);
		
		JButton btnAddObservationSpecification = new JButton("Add Observation Specification");
		btnAddObservationSpecification.setBounds(77, 214, 117, 25);
		contentPane.add(btnAddObservationSpecification);
		
	}
}
