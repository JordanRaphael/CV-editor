package UserInterface.GenericGUI.FunctionalGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import CVConstruction.CareerSummary;
import CVConstruction.FunctionalCV;
import CVConstruction.GenericCV;

@SuppressWarnings("serial")
public class CareerSummaryEdit extends JFrame {

	private JPanel contentPane;
	private JTextField companyNameTextField;
	private JTextField jobTitleTextField;
	private JTextField dateTextField;
	private GenericCV cvObj;
	private JComboBox<CareerSummary> dropDownList;
	private CareerSummary objectToEdit;


	/**
	 * Create the frame.
	 * @param obj 
	 **/

	public CareerSummaryEdit(GenericCV obj) {
		cvObj = obj;
		setTitle("Edit your info");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dialogLabel = new JLabel("Please edit the information you provided");
		dialogLabel.setBounds(210, 11, 474, 33);
		dialogLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(dialogLabel);
		
		JLabel companyNameLabel = new JLabel("Company Name :");
		companyNameLabel.setBounds(40, 126, 101, 14);
		companyNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(companyNameLabel);
		
		JLabel jobTitleLabel = new JLabel("Job Title :");
		jobTitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		jobTitleLabel.setBounds(74, 173, 101, 14);
		contentPane.add(jobTitleLabel);
		
		JLabel dateLabel = new JLabel("Date :");
		dateLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		dateLabel.setBounds(96, 219, 101, 14);
		contentPane.add(dateLabel);
		
		companyNameTextField = new JTextField();
		companyNameTextField.setBounds(137, 123, 273, 20);
		contentPane.add(companyNameTextField);
		companyNameTextField.setColumns(10);
		
		jobTitleTextField = new JTextField();
		jobTitleTextField.setColumns(10);
		jobTitleTextField.setBounds(137, 170, 273, 20);
		contentPane.add(jobTitleTextField);
		
		dateTextField = new JTextField();
		dateTextField.setColumns(10);
		dateTextField.setBounds(137, 216, 273, 20);
		contentPane.add(dateTextField);
		
		JButton editButton = new JButton("Edit");
		editButton.setBounds(519, 259, 114, 53);
		contentPane.add(editButton);
		editButton.setEnabled(false);
		
		dropDownList = new JComboBox<CareerSummary>();
		dropDownList.setBounds(224, 71, 218, 20);
		contentPane.add(dropDownList);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setEnabled(false);
		deleteButton.setBounds(74, 259, 114, 53);
		contentPane.add(deleteButton);

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((FunctionalCV)cvObj).deleteCareerSummary(objectToEdit);
				companyNameTextField.setText("");
				jobTitleTextField.setText("");
				dateTextField.setText("");
				updateList();
			}
		});
		
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((FunctionalCV) cvObj).updateCareerSummary(objectToEdit,companyNameTextField.getText(),
						jobTitleTextField.getText(),
						dateTextField.getText());
				updateList();
			}
		});
		
		dropDownList.addItemListener(
				new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						editButton.setEnabled(true);
						deleteButton.setEnabled(true);
						if (e.getStateChange() == ItemEvent.SELECTED){
							objectToEdit = (CareerSummary) e.getItem();
							companyNameTextField.setText(objectToEdit.getCompanyName());
							jobTitleTextField.setText(objectToEdit.getJobTitle());
							dateTextField.setText(objectToEdit.getDate());
						}
					}
				});
	}
	
	public void updateList(){
		dropDownList.removeAllItems();
		ArrayList<CVConstruction.CareerSummary> careerSummaryObjects = ((FunctionalCV) cvObj).getCareerSummaryObjects();
		for (CVConstruction.CareerSummary object : careerSummaryObjects){
			dropDownList.addItem(object);
		}
	}
}
