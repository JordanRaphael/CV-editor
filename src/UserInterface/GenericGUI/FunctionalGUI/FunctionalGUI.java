package UserInterface.GenericGUI.FunctionalGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CVConstruction.FunctionalCV;
import CVConstruction.GenericCV;
import Parser.Input.InputParser;
import Parser.Input.InputParserLatex;
import Parser.Input.InputParserTXT;
import Parser.Output.OutputParser;
import Parser.Output.OutputParserLatex;
import Parser.Output.OutputParserTXT;
import UserInterface.AddEditGUI;
import UserInterface.GenericGUI.AdditionalInformationWindow;
import UserInterface.GenericGUI.GeneralInformationWindow;
import UserInterface.GenericGUI.InterestsWindow;
import UserInterface.GenericGUI.ProfessionalProfileWindow;

@SuppressWarnings("serial")
public class FunctionalGUI extends JFrame {

	private JPanel contentPane;
	private GenericCV cvObj;



	/**
	 * Create the frame.
	 */
	public FunctionalGUI(GenericCV obj) {
		cvObj = obj;
		setTitle("Functional Template");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dialogLabel = new JLabel("Please select the category you would like to modify");
		dialogLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		dialogLabel.setBounds(307, 11, 427, 37);
		contentPane.add(dialogLabel);
		
		JButton generalInformationButton = new JButton("General Information");
		generalInformationButton.setBounds(111, 88, 214, 67);
		contentPane.add(generalInformationButton);
		
		JButton professionalProfileButton = new JButton("Professional Profile");
		professionalProfileButton.setBounds(111, 211, 214, 67);
		contentPane.add(professionalProfileButton);
		
		JButton skillsAndExperienceButton = new JButton("Skills And Experience");
		skillsAndExperienceButton.setBounds(111, 350, 214, 67);
		contentPane.add(skillsAndExperienceButton);
		
		JButton careerSummaryButton = new JButton("Career Summary");
		careerSummaryButton.setBounds(111, 490, 214, 67);
		contentPane.add(careerSummaryButton);
		
		JButton educationAndTrainingButton = new JButton("Education And Training");
		educationAndTrainingButton.setBounds(566, 88, 214, 67);
		contentPane.add(educationAndTrainingButton);
		
		JButton furtherCoursesButton = new JButton("Further Courses");
		furtherCoursesButton.setBounds(566, 211, 214, 67);
		contentPane.add(furtherCoursesButton);
		
		JButton additionalInformationButton = new JButton("Additional Information");
		additionalInformationButton.setBounds(566, 350, 214, 67);
		contentPane.add(additionalInformationButton);
		
		JButton interestsButton = new JButton("Interests");
		interestsButton.setBounds(566, 490, 214, 67);
		contentPane.add(interestsButton);
		
		JButton readFromTXTButton = new JButton("Read from TXT");
		readFromTXTButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				InputParser parser = new InputParserTXT(cvObj);
				cvObj = (FunctionalCV) parser.readFromFile();
		    }
				
		});
		readFromTXTButton.setBounds(281, 582, 123, 45);
		contentPane.add(readFromTXTButton);
		
		GeneralInformationWindow basicInformationWindow = new GeneralInformationWindow(cvObj);
		basicInformationWindow.setVisible(false);
		generalInformationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				basicInformationWindow.setVisible(true);
			}
		});
		
		ProfessionalProfileWindow professionalProfileWindow = new ProfessionalProfileWindow(cvObj);
		professionalProfileWindow.setVisible(false);
		professionalProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				professionalProfileWindow.setVisible(true);
			}
		});
		
		AddEditGUI skillsAndExperienceAddEditGUI = new AddEditGUI(cvObj,"SkillsAndExperience");
		skillsAndExperienceAddEditGUI.setVisible(false);
		skillsAndExperienceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				skillsAndExperienceAddEditGUI.setVisible(true);
			}
		});
		
		AddEditGUI careerSummaryAddEditGUI = new AddEditGUI(cvObj,"CareerSummary");
		careerSummaryAddEditGUI.setVisible(false);
		careerSummaryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				careerSummaryAddEditGUI.setVisible(true);
			}
		});
		
		AddEditGUI educationAndTrainingAddEditGUI = new AddEditGUI(cvObj,"EducationAndTraining");
		educationAndTrainingAddEditGUI.setVisible(false);
		educationAndTrainingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				educationAndTrainingAddEditGUI.setVisible(true);
			}
		});
		
		AddEditGUI furtherCoursesAddEditGUI = new AddEditGUI(cvObj,"FurtherCourses");
		furtherCoursesAddEditGUI.setVisible(false);
		furtherCoursesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				furtherCoursesAddEditGUI.setVisible(true);
			}
		});
		
		AdditionalInformationWindow additionalInformationWindow = new AdditionalInformationWindow(cvObj);
		additionalInformationWindow.setVisible(false);
		additionalInformationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				additionalInformationWindow.setVisible(true);
			}
		});
		
		InterestsWindow interestsWindow = new InterestsWindow(cvObj);
		interestsWindow.setVisible(false);
		interestsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				interestsWindow.setVisible(true);
			}
		});
		
		JButton printToTXTButton = new JButton("Print to TXT");
		printToTXTButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OutputParser parser = new OutputParserTXT(cvObj);
				parser.generateFile();
			}
		});
		printToTXTButton.setBounds(111, 579, 114, 50);
		contentPane.add(printToTXTButton);
		
		JButton printToLatexButton = new JButton("Print to Latex");
		printToLatexButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OutputParser parser = new OutputParserLatex(cvObj);
				parser.generateFile();
			}
		});
		printToLatexButton.setBounds(703, 579, 114, 50);
		contentPane.add(printToLatexButton);
		
		JButton readLatexButton = new JButton("Read from Latex");
		readLatexButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputParser parser = new InputParserLatex(cvObj);
				cvObj = parser.readFromFile();
			}
		});
		readLatexButton.setBounds(495, 579, 166, 50);
		contentPane.add(readLatexButton);
		
	}
}
