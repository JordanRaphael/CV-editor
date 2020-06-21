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

import CVConstruction.CombinedCV;
import CVConstruction.FunctionalCV;
import CVConstruction.GenericCV;
import UserInterface.SpecificationsWindow;

@SuppressWarnings("serial")
public class SkillsAndExperienceWindow extends JFrame {

	private static JButton okButton;
	private static JButton specificationsButton;
	private JPanel contentPane;
	private JTextField skillsAndExperienceTitleTextField;
	private boolean titledSaved = false;
	private GenericCV cvObj;


	/**
	 * Create the frame.
	 */
	public SkillsAndExperienceWindow(GenericCV obj) {
		cvObj = obj;
		setTitle("Skills and Experience");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dialogLabel = new JLabel("Please provide your skills and experience");
		dialogLabel.setBounds(158, 29, 340, 28);
		dialogLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		contentPane.add(dialogLabel);
		
		JLabel skillsAndExperienceLabel = new JLabel("Where do you have skills and experience on ?");
		skillsAndExperienceLabel.setBounds(158, 119, 292, 14);
		skillsAndExperienceLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(skillsAndExperienceLabel);
		
		skillsAndExperienceTitleTextField = new JTextField();
		skillsAndExperienceTitleTextField.setBounds(158, 158, 279, 20);
		contentPane.add(skillsAndExperienceTitleTextField);
		skillsAndExperienceTitleTextField.setColumns(10);
		
		okButton = new JButton("OK");
		okButton.setBounds(345, 250, 187, 48);
		okButton.setEnabled(false);
		contentPane.add(okButton);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				skillsAndExperienceTitleTextField.setEnabled(true);
				skillsAndExperienceTitleTextField.setText("");
				setVisible(false);
				titledSaved = false;
				skillsAndExperienceTitleTextField.setEditable(true);
			}
		});
		
		specificationsButton = new JButton("Add specification");
		specificationsButton.setBounds(57, 250, 187, 48);
		contentPane.add(specificationsButton);
		
		SpecificationsWindow specificationsWindow = new SpecificationsWindow(cvObj);
		specificationsWindow.setVisible(false);
		specificationsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(skillsAndExperienceTitleTextField.getText().isEmpty() == false){
					specificationsWindow.setVisible(true);
					if (titledSaved == false){
						titledSaved = true;
						if (cvObj.getTemplateSelection().equals("functional")){
							((FunctionalCV) cvObj).skillsAndExperienceSaveTitle(
									skillsAndExperienceTitleTextField.getText());
						} else {
							((CombinedCV) cvObj).skillsAndExperienceSaveTitle(
									skillsAndExperienceTitleTextField.getText());
						}
						skillsAndExperienceTitleTextField.setEditable(false);
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Please provide your field of expertise!");
				}
			}
		});
	}
	
	public static void changeSpecificationsButtonName(){
		specificationsButton.setText("Add another specification");
	}
	
	public static void enableOkButton(){
		okButton.setEnabled(true);
	}
}
