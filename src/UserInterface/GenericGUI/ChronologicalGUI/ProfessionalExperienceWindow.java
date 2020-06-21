package UserInterface.GenericGUI.ChronologicalGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import CVConstruction.ChronologicalCV;
import CVConstruction.CombinedCV;
import CVConstruction.GenericCV;

@SuppressWarnings("serial")
public class ProfessionalExperienceWindow extends JFrame {

	private JPanel contentPane;
	private JTextField companyNametextField;
	private JTextField jobTitleTextField;
	private JTextField dateTextField;
	private JTextField achievementTextField;
	private JTextArea responsibilitiesTextArea;
	private ArrayList<String> achievements = new ArrayList<String>();
	private GenericCV cvObj;

	/**
	 * Create the frame.
	 * @param obj 
	 */
	public ProfessionalExperienceWindow(GenericCV obj) {
		cvObj = obj;
		setTitle("Professional Experience");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1050, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dialogLabel = new JLabel("Please provide your professional experiences");
		dialogLabel.setBounds(370, 22, 352, 34);
		dialogLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(dialogLabel);
		
		JLabel companyNameLabel = new JLabel("Company Name :");
		companyNameLabel.setBounds(19, 96, 129, 14);
		companyNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(companyNameLabel);
		
		JLabel jobTitleLabel = new JLabel("Job Title :");
		jobTitleLabel.setBounds(62, 150, 129, 14);
		jobTitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(jobTitleLabel);
		
		JLabel dateLabel = new JLabel("Date :");
		dateLabel.setBounds(88, 205, 129, 14);
		dateLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(dateLabel);
		
		companyNametextField = new JTextField();
		companyNametextField.setBounds(140, 94, 321, 20);
		contentPane.add(companyNametextField);
		companyNametextField.setColumns(10);
		
		jobTitleTextField = new JTextField();
		jobTitleTextField.setColumns(10);
		jobTitleTextField.setBounds(140, 148, 321, 20);
		contentPane.add(jobTitleTextField);
		
		dateTextField = new JTextField();
		dateTextField.setColumns(10);
		dateTextField.setBounds(140, 203, 321, 20);
		contentPane.add(dateTextField);
		
		JButton addAnotherProfessionalExperienceButton = new JButton("Add another professional experience");
		addAnotherProfessionalExperienceButton.setBounds(140, 594, 274, 42);
		contentPane.add(addAnotherProfessionalExperienceButton);
		
		JButton okButton = new JButton("OK");
		okButton.setBounds(640, 594, 274, 42);
		contentPane.add(okButton);
		
		JLabel responsibilitiesLabel = new JLabel("Write a paragraph with the responsibilities you had");
		responsibilitiesLabel.setBounds(132, 251, 372, 26);
		responsibilitiesLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(responsibilitiesLabel);
		
		responsibilitiesTextArea = new JTextArea();
		responsibilitiesTextArea.setBounds(88, 301, 416, 245);
		contentPane.add(responsibilitiesTextArea);
		
		JLabel achievementsLabel = new JLabel("Achievements :");
		achievementsLabel.setBounds(758, 68, 98, 20);
		achievementsLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(achievementsLabel);
		
		achievementTextField = new JTextField();
		achievementTextField.setBounds(693, 112, 234, 26);
		contentPane.add(achievementTextField);
		achievementTextField.setColumns(10);
		
		JButton addAchievementButton = new JButton("Add achievement");
		addAchievementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(achievementTextField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please fill the achievement's field!");
				} else {
					achievements.add(achievementTextField.getText());
					achievementTextField.setText("");
				}
			}
		});
		addAchievementButton.setBounds(711, 178, 196, 34);
		contentPane.add(addAchievementButton);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isAllFieldsEmpty() || isAllFieldsFilled()) {
					setVisible(false);
					if (isAllFieldsFilled()){
						if (cvObj.getTemplateSelection().equals("chronological")){
							((ChronologicalCV)cvObj).professionalExperienceSave(companyNametextField.getText(),
									jobTitleTextField.getText(), 
									dateTextField.getText(), 
									responsibilitiesTextArea.getText(),
									achievements);
						} else {
							((CombinedCV)cvObj).professionalExperienceSave(companyNametextField.getText(),
									jobTitleTextField.getText(), 
									dateTextField.getText(), 
									responsibilitiesTextArea.getText(),
									achievements);
						}
						achievements.clear();
					}
					companyNametextField.setText("");
					jobTitleTextField.setText("");
					dateTextField.setText("");
					responsibilitiesTextArea.setText("");
					achievementTextField.setText("");
				} else {
					checkFieldValues();
				}
			}
		});
		
		addAnotherProfessionalExperienceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isAllFieldsFilled()) {
					if (cvObj.getTemplateSelection().equals("chronological")){
						((ChronologicalCV)cvObj).professionalExperienceSave(companyNametextField.getText(),
								jobTitleTextField.getText(), 
								dateTextField.getText(), 
								responsibilitiesTextArea.getText(),
								achievements);
					} else {
						((CombinedCV)cvObj).professionalExperienceSave(companyNametextField.getText(),
								jobTitleTextField.getText(), 
								dateTextField.getText(), 
								responsibilitiesTextArea.getText(),
								achievements);
					}
					achievements.clear();
					companyNametextField.setText("");
					jobTitleTextField.setText("");
					dateTextField.setText("");
					responsibilitiesTextArea.setText("");
				} else {
					checkFieldValues();
				}
			}
		});
	}
	
	private boolean isAllFieldsEmpty(){
		return (companyNametextField.getText().isEmpty()
				&& jobTitleTextField.getText().isEmpty()
				&& dateTextField.getText().isEmpty()
				&& responsibilitiesTextArea.getText().isEmpty());
	}
	
	private boolean isAllFieldsFilled(){
		return (companyNametextField.getText().isEmpty() == false 
				&& jobTitleTextField.getText().isEmpty() == false 
				&& dateTextField.getText().isEmpty() == false
				&& responsibilitiesTextArea.getText().isEmpty() == false);
	}
	
	private void checkFieldValues(){
		if (companyNametextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please fill the company's name field!");
		} else if (jobTitleTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please fill the job title's field!");
		} else if (dateTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please fill the date's field!");
		} else {
			JOptionPane.showMessageDialog(null,"Please fill the responsibilities' paragraph!");
		}
	}

}
