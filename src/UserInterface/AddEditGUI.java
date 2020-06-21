package UserInterface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CVConstruction.GenericCV;
import UserInterface.GenericGUI.EducationAndTrainingEdit;
import UserInterface.GenericGUI.EducationAndTrainingWindow;
import UserInterface.GenericGUI.FurtherCoursesEdit;
import UserInterface.GenericGUI.FurtherCoursesWindow;
import UserInterface.GenericGUI.ChronologicalGUI.ProfessionalExperienceEdit;
import UserInterface.GenericGUI.ChronologicalGUI.ProfessionalExperienceWindow;
import UserInterface.GenericGUI.FunctionalGUI.CareerSummaryEdit;
import UserInterface.GenericGUI.FunctionalGUI.CareerSummaryWindow;
import UserInterface.GenericGUI.FunctionalGUI.SkillsAndExperienceEdit;
import UserInterface.GenericGUI.FunctionalGUI.SkillsAndExperienceWindow;

@SuppressWarnings("serial")
public class AddEditGUI extends JFrame {

	private JPanel contentPane;
	private GenericCV cvObj;
	/**
	 * Create the frame.
	 */
	public AddEditGUI(GenericCV obj, String category) {
		cvObj = obj;
		setTitle("Add or Edit");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dialogLabel = new JLabel("Please select Add or Edit option");
		dialogLabel.setBounds(241, 11, 474, 33);
		dialogLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(dialogLabel);
		
		JButton AddButton = new JButton("Add");
		AddButton.setBounds(128, 146, 139, 74);
		contentPane.add(AddButton);
		
		JButton EditButton = new JButton("Edit");
		EditButton.setBounds(412, 146, 139, 74);
		contentPane.add(EditButton);
		
		
		switch(category){
			case "EducationAndTraining": 
				EducationAndTrainingWindow educationAndTrainingWindow = new EducationAndTrainingWindow(cvObj);
				educationAndTrainingWindow.setVisible(false);
				
				AddButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						educationAndTrainingWindow.setVisible(true);
						setVisible(false);
					}
				});
				
				EducationAndTrainingEdit educationAndTrainingEdit = new EducationAndTrainingEdit(cvObj);
				educationAndTrainingWindow.setVisible(false);
				EditButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						educationAndTrainingEdit.setVisible(true);
						setVisible(false);
						educationAndTrainingEdit.updateList();
					}
				});
				break;
			case "FurtherCourses":
				FurtherCoursesWindow furtherCoursesWindow = new FurtherCoursesWindow(cvObj);
				furtherCoursesWindow.setVisible(false);
				
				AddButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						furtherCoursesWindow.setVisible(true);
						setVisible(false);
					}
				});
				
				FurtherCoursesEdit furtherCoursesEdit = new FurtherCoursesEdit(cvObj);
				furtherCoursesEdit.setVisible(false);
				EditButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						furtherCoursesEdit.setVisible(true);
						setVisible(false);
						furtherCoursesEdit.updateList();
					}
				});
				break;
			case "SkillsAndExperience":
				SkillsAndExperienceWindow skillsAndExperienceWindow = new SkillsAndExperienceWindow(cvObj);
				skillsAndExperienceWindow.setVisible(false);
				
				AddButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						skillsAndExperienceWindow.setVisible(true);
						setVisible(false);
					}
				});
				
				SkillsAndExperienceEdit skillsAndExperienceEdit = new SkillsAndExperienceEdit(cvObj);
				skillsAndExperienceWindow.setVisible(false);
				EditButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						skillsAndExperienceEdit.setVisible(true);
						setVisible(false);
						skillsAndExperienceEdit.updateList();
					}
				});
				break;
			case "CareerSummary":
				CareerSummaryWindow careerSummaryWindow = new CareerSummaryWindow(cvObj);
				careerSummaryWindow.setVisible(false);
				
				AddButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						careerSummaryWindow.setVisible(true);
						setVisible(false);
					}
				});
				
				CareerSummaryEdit careerSummaryEdit = new CareerSummaryEdit(cvObj);
				careerSummaryWindow.setVisible(false);
				EditButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						careerSummaryEdit.setVisible(true);
						setVisible(false);
						careerSummaryEdit.updateList();
					}
				});
				break;
			case "ProfessionalExperience":
				ProfessionalExperienceWindow professionalExperienceWindow = new ProfessionalExperienceWindow(cvObj);
				professionalExperienceWindow.setVisible(false);
				
				AddButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						professionalExperienceWindow.setVisible(true);
						setVisible(false);
					}
				});
				
				ProfessionalExperienceEdit professionalExperienceEdit = new ProfessionalExperienceEdit(cvObj);
				professionalExperienceEdit.setVisible(false);
				EditButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						professionalExperienceEdit.setVisible(true);
						setVisible(false);
						professionalExperienceEdit.updateList();
					}
				});
				break;
		}
	}
}
