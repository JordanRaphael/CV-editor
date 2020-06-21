package UserInterface.GenericGUI.ChronologicalGUI;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import CVConstruction.ChronologicalCV;
import CVConstruction.CombinedCV;
import CVConstruction.GenericCV;
import CVConstruction.ProfessionalExperience;

@SuppressWarnings("serial")
public class ProfessionalExperienceEdit extends JFrame {

	private JPanel contentPane;
	private JTextField companyNametextField;
	private JTextField jobTitleTextField;
	private JTextField dateTextField;
	private JTextField achievementTextField;
	private JTextArea paragraphTextArea;
	private ArrayList<String> achievements = new ArrayList<String>();
	private JComboBox<ProfessionalExperience> professionalExperienceDropDownList;
	private JComboBox<String> achievementsDropDownList;
	private GenericCV cvObj;
	private ProfessionalExperience objectToEdit;
	private String achievementToEdit;

	/**
	 * Create the frame.
	 * 
	 * @param obj
	 */
	public ProfessionalExperienceEdit(GenericCV obj) {
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
		dialogLabel.setBounds(370, 11, 352, 26);
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

		JButton editProfessionalExperienceButton = new JButton("Edit professional experience");
		editProfessionalExperienceButton.setBounds(23, 595, 250, 42);
		contentPane.add(editProfessionalExperienceButton);

		JLabel responsibilitiesLabel = new JLabel("Write a paragraph with the responsibilities you had");
		responsibilitiesLabel.setBounds(132, 251, 372, 26);
		responsibilitiesLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(responsibilitiesLabel);

		paragraphTextArea = new JTextArea();
		paragraphTextArea.setBounds(88, 301, 416, 245);
		contentPane.add(paragraphTextArea);

		JLabel achievementsLabel = new JLabel("Achievements :");
		achievementsLabel.setBounds(758, 150, 98, 20);
		achievementsLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(achievementsLabel);

		achievementTextField = new JTextField();
		achievementTextField.setBounds(693, 194, 234, 26);
		contentPane.add(achievementTextField);
		achievementTextField.setColumns(10);

		JButton editAchievementButton = new JButton("Edit Achievement");
		editAchievementButton.setBounds(718, 263, 196, 34);
		contentPane.add(editAchievementButton);

		professionalExperienceDropDownList = new JComboBox<ProfessionalExperience>();
		professionalExperienceDropDownList.setBounds(137, 46, 189, 20);
		contentPane.add(professionalExperienceDropDownList);

		achievementsDropDownList = new JComboBox<String>();
		achievementsDropDownList.setBounds(707, 74, 207, 20);
		contentPane.add(achievementsDropDownList);
		
		JButton deleteProfessionalExperienceButton = new JButton("Delete professional experience");
		deleteProfessionalExperienceButton.setBounds(312, 595, 250, 42);
		contentPane.add(deleteProfessionalExperienceButton);
		
		deleteProfessionalExperienceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cvObj instanceof ChronologicalCV){
					((ChronologicalCV)cvObj).deleteProfessionalExperience(objectToEdit);
				} else {
					((CombinedCV)cvObj).deleteProfessionalExperience(objectToEdit);
				}
				companyNametextField.setText("");
				jobTitleTextField.setText("");
				dateTextField.setText("");
				paragraphTextArea.setText("");
				achievementTextField.setText("");
				updateList();
				updateAchievementsList();
			}
		});
		
		JButton deleteAchievementButton = new JButton("Delete Achievement");
		deleteAchievementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cvObj instanceof ChronologicalCV){
					((ChronologicalCV)cvObj).deleteProfessionalExperienceAchievement(objectToEdit, achievementToEdit);
				} else {
					((CombinedCV)cvObj).deleteProfessionalExperienceAchievement(objectToEdit, achievementToEdit);
				}
				achievementTextField.setText("");
				updateAchievementsList();
			}
		});
		deleteAchievementButton.setBounds(718, 349, 196, 34);
		contentPane.add(deleteAchievementButton);

		editProfessionalExperienceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cvObj instanceof ChronologicalCV){
					((ChronologicalCV) cvObj).updateProfessionalExperience(objectToEdit,
							companyNametextField.getText(),jobTitleTextField.getText(),
							dateTextField.getText(),paragraphTextArea.getText(),
							achievements);
				} else {
					((CombinedCV) cvObj).updateProfessionalExperience(objectToEdit,
							companyNametextField.getText(),jobTitleTextField.getText(),
							dateTextField.getText(),paragraphTextArea.getText(),
							achievements);
				}
				
				professionalExperienceDropDownList.removeAllItems();
				updateList();
			}
		});
		
		editAchievementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cvObj instanceof ChronologicalCV){
					((ChronologicalCV) cvObj).updateProfessionalExperienceAchievements(objectToEdit, achievementTextField.getText(), achievementToEdit);
				} else {
					((CombinedCV) cvObj).updateProfessionalExperienceAchievements(objectToEdit, achievementTextField.getText(), achievementToEdit);
				}
				
				achievementsDropDownList.removeAllItems();
				updateAchievementsList();
			}
		});

		professionalExperienceDropDownList.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				editProfessionalExperienceButton.setEnabled(true);
				if (e.getStateChange() == ItemEvent.SELECTED) {
					objectToEdit = (ProfessionalExperience) e.getItem();
					companyNametextField.setText(objectToEdit.getCompanyName());
					jobTitleTextField.setText(objectToEdit.getJobTitle());
					dateTextField.setText(objectToEdit.getDate());
					paragraphTextArea.setText(objectToEdit.getParagraph());
					updateAchievementsList();
				}
			}
		});
		
		achievementsDropDownList.addItemListener(new ItemListener() {


			@Override
			public void itemStateChanged(ItemEvent e) {
				editAchievementButton.setEnabled(true);
				if (e.getStateChange() == ItemEvent.SELECTED) {
					achievementToEdit = (String) e.getItem();
					achievementTextField.setText(achievementToEdit);
				}
			}
		});

	}
	
	private void updateAchievementsList(){
		achievementsDropDownList.removeAllItems();
		achievementTextField.setText("");
		ArrayList<ProfessionalExperience> professionalExperienceObjects;
		if (cvObj instanceof ChronologicalCV){
			professionalExperienceObjects = ((ChronologicalCV) cvObj).getProfessionalExperienceObjects();
		} else {
			professionalExperienceObjects = ((CombinedCV) cvObj).getProfessionalExperienceObjects();
		}
		if (professionalExperienceObjects.isEmpty()){
			return;
		}
		ArrayList<String> achievements = objectToEdit.getAchievements();
		for (String object : achievements){
			achievementsDropDownList.addItem(object);
		}
	}

	public void updateList() {
		professionalExperienceDropDownList.removeAllItems();
		ArrayList<ProfessionalExperience> professionalExperienceObjects;
		if (cvObj instanceof ChronologicalCV) {
			professionalExperienceObjects = ((ChronologicalCV) cvObj).getProfessionalExperienceObjects();
		} else {
			professionalExperienceObjects = ((CombinedCV) cvObj).getProfessionalExperienceObjects();
		}

		int tmpSize = professionalExperienceObjects.size();
		for (int i = 0 ; i < tmpSize ; i++){
			professionalExperienceDropDownList.addItem(professionalExperienceObjects.get(i));
		}
		 /*THIS IS FOR THE PROFESSOR
		 for (ProfessionalExperience object : professionalExperienceObjects) {
			professionalExperienceDropDownList.addItem(object);
		 }*/
	}
	
}
