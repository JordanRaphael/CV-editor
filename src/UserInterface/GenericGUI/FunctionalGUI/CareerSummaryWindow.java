package UserInterface.GenericGUI.FunctionalGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import CVConstruction.FunctionalCV;
import CVConstruction.GenericCV;

@SuppressWarnings("serial")
public class CareerSummaryWindow extends JFrame {

	private JPanel contentPane;
	private JTextField companyNameTextField;
	private JTextField jobTitleTextField;
	private JTextField dateTextField;
	private GenericCV cvObj;


	/**
	 * Create the frame.
	 * @param cvObj 
	 */
	public CareerSummaryWindow(GenericCV obj) {
		cvObj = obj;
		setTitle("Career Summary");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dialogLabel = new JLabel("Please provide your career summary");
		dialogLabel.setBounds(180, 11, 352, 34);
		dialogLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(dialogLabel);
		
		JLabel companyNameLabel = new JLabel("Company Name :");
		companyNameLabel.setBounds(19, 96, 129, 14);
		companyNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(companyNameLabel);
		
		JLabel jobTitleLabel = new JLabel("Job Title :");
		jobTitleLabel.setBounds(62, 150, 129, 14);
		jobTitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(jobTitleLabel);
		
		JLabel dateLabel = new JLabel("Date :");
		dateLabel.setBounds(88, 205, 129, 14);
		dateLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(dateLabel);
		
		companyNameTextField = new JTextField();
		companyNameTextField.setBounds(140, 94, 321, 20);
		contentPane.add(companyNameTextField);
		companyNameTextField.setColumns(10);
		
		jobTitleTextField = new JTextField();
		jobTitleTextField.setColumns(10);
		jobTitleTextField.setBounds(140, 148, 321, 20);
		contentPane.add(jobTitleTextField);
		
		dateTextField = new JTextField();
		dateTextField.setColumns(10);
		dateTextField.setBounds(140, 203, 321, 20);
		contentPane.add(dateTextField);
		
		JButton addAnotherCareerButton = new JButton("Add another career summary");
		addAnotherCareerButton.setBounds(10, 298, 243, 39);
		contentPane.add(addAnotherCareerButton);
		
		JButton okButton = new JButton("OK");
		okButton.setBounds(331, 298, 243, 39);
		contentPane.add(okButton);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isAllFieldsEmpty()
						||isAllFieldsFilled()) {
					setVisible(false);
					if (isAllFieldsFilled()){
						((FunctionalCV) cvObj).careerSummarySave(companyNameTextField.getText(),
								jobTitleTextField.getText(), dateTextField.getText());
						companyNameTextField.setText("");
						jobTitleTextField.setText("");
						dateTextField.setText("");
					}
				} else {
					checkFieldValues();
				}
			}
		});
		
		addAnotherCareerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isAllFieldsFilled()) {
					((FunctionalCV) cvObj).careerSummarySave(companyNameTextField.getText(),
							jobTitleTextField.getText(), dateTextField.getText());
					companyNameTextField.setText("");
					jobTitleTextField.setText("");
					dateTextField.setText("");
				} else {
					checkFieldValues();
				}
			}
		});
	}
	
	private boolean isAllFieldsEmpty(){
		return (companyNameTextField.getText().isEmpty()
				&& jobTitleTextField.getText().isEmpty() 
				&& dateTextField.getText().isEmpty());
	}
	
	private boolean isAllFieldsFilled(){
		return (companyNameTextField.getText().isEmpty() == false 
				&& jobTitleTextField.getText().isEmpty() == false 
				&& dateTextField.getText().isEmpty() == false);
	}
	
	private void checkFieldValues(){
		if (companyNameTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please fill the company's name field!");
		} else if (jobTitleTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please fill the job title's field!");
		} else if (dateTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please fill the date's field!");
		}
	}
}
