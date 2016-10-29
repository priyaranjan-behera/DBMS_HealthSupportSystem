package com.dbms.healthsupport.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbms.healthsupport.dao.ObservationSpecDao;
import com.dbms.healthsupport.domain.ObservationSpec;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
public class AddDiseaseLimit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private List<ObservationSpec> obspeclist;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDiseaseLimit frame = new AddDiseaseLimit();
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
	public AddDiseaseLimit() {
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
			JOptionPane.showMessageDialog(AddDiseaseLimit.this,
				    e.getMessage(),
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		List<String> specNames=new ArrayList<String>();
		for(ObservationSpec obspec: obspeclist){
			specNames.add(getName());
		}
		
		Label label = new Label("Observation Spec");
		label.setBounds(34, 42, 68, 21);
		contentPane.add(label);
		
		comboBox = new JComboBox(specNames.toArray(new String[specNames.size()]));
		comboBox.setBounds(100, 42, 32, 24);
		contentPane.add(comboBox);
		
		
		JLabel lblMetricName = new JLabel("Metric Name");
		lblMetricName.setBounds(64, 147, 70, 15);
		contentPane.add(lblMetricName);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(200, 147, 32, 24);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("upper limit");
		lblNewLabel.setBounds(64, 233, 70, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(179, 231, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLowerLimit = new JLabel("lower limit");
		lblLowerLimit.setBounds(64, 250, 70, 15);
		contentPane.add(lblLowerLimit);
		
		textField_1 = new JTextField();
		textField_1.setBounds(179, 250, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String obsspec = (String) comboBox.getSelectedItem();
				try
				{
					DefaultComboBoxModel dcm = new DefaultComboBoxModel();
					comboBox_1.setModel( dcm );
					
					for( ObservationSpec obspec : obspeclist ) {
					    if(obspec.getObservationName().equals(obspec)){
							for(String metric:obspec.getMetrics())
								dcm.addElement(metric);
							break;
					    }
					}
					

				}catch (Exception exp) {
					// TODO: handle exception
				}
				
			}
		});
		

		
		}
}
