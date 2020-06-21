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

import CVConstruction.CombinedCV;
import CVConstruction.FunctionalCV;
import CVConstruction.GenericCV;
import CVConstruction.SkillsAndExperience;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class SkillsAndExperienceEdit extends JFrame {

	private JPanel contentPane;
	JTextPane paragraphTextArea;
	private JTextField titleTextField;
	private GenericCV cvObj;
	private JComboBox<SkillsAndExperience> titleDropDownList;
	JComboBox<String> paragraphDropDownList;
	private SkillsAndExperience objectToEdit;
	private String paragraphToEdit;


	/**
	 * Create the frame.
	 * @param obj 
	 **/

	public SkillsAndExperienceEdit(GenericCV obj) {
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
		
		JLabel titleLabel = new JLabel("Skills and Experience on :");
		titleLabel.setBounds(40, 126, 308, 14);
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(titleLabel);
		
		titleTextField = new JTextField();
		titleTextField.setBounds(205, 123, 273, 20);
		contentPane.add(titleTextField);
		titleTextField.setColumns(10);
		
		JButton editTitleButton = new JButton("Edit Title");
		editTitleButton.setBounds(503, 38, 171, 53);
		contentPane.add(editTitleButton);
		editTitleButton.setEnabled(false);
		
		titleDropDownList = new JComboBox<SkillsAndExperience>();
		titleDropDownList.setBounds(224, 71, 218, 20);
		contentPane.add(titleDropDownList);
		
		paragraphDropDownList = new JComboBox<String>();
		paragraphDropDownList.setBounds(134, 164, 218, 20);
		contentPane.add(paragraphDropDownList);
		
		JButton editParagraphButton = new JButton("Edit Paragraph");
		editParagraphButton.setBounds(503, 195, 171, 53);
		contentPane.add(editParagraphButton);
		editParagraphButton.setEnabled(false);
		
		paragraphTextArea = new JTextPane();
		paragraphTextArea.setBounds(40, 195, 438, 138);
		contentPane.add(paragraphTextArea);
		
		JButton deleteTitleButton = new JButton("Delete Title");
		deleteTitleButton.setEnabled(false);
		deleteTitleButton.setBounds(503, 122, 171, 53);
		contentPane.add(deleteTitleButton);

		deleteTitleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cvObj instanceof FunctionalCV){
					((FunctionalCV)cvObj).deleteSkillsAndExperienceTitle(objectToEdit);
				} else {
					((CombinedCV)cvObj).deleteSkillsAndExperienceTitle(objectToEdit);
				}
				titleTextField.setText("");
				paragraphTextArea.setText("");
				updateList();
				updateParagraphList();
			}
		});
		
		JButton deleteParagraphButton = new JButton("Delete Paragraph");
		deleteParagraphButton.setBounds(503, 280, 171, 53);
		contentPane.add(deleteParagraphButton);
		deleteParagraphButton.setEnabled(false);

		deleteParagraphButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cvObj instanceof FunctionalCV){
					((FunctionalCV)cvObj).deleteSkillsAndExperienceParagraph(objectToEdit,paragraphTextArea.getText());
				} else {
					((CombinedCV)cvObj).deleteSkillsAndExperienceParagraph(objectToEdit,paragraphTextArea.getText());
				}
				paragraphTextArea.setText("");
				updateParagraphList();
			}
		});
		
		paragraphDropDownList.addItemListener(
				new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						editTitleButton.setEnabled(true);
						if (e.getStateChange() == ItemEvent.SELECTED){
							paragraphToEdit = (String) e.getItem();
							paragraphTextArea.setText(paragraphToEdit);
						}
					}
				});
		
		editTitleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cvObj instanceof FunctionalCV){
					((FunctionalCV) cvObj).updateSkillsAndExperienceTitle(objectToEdit,titleTextField.getText());
				} else {
					((CombinedCV) cvObj).updateSkillsAndExperienceTitle(objectToEdit,titleTextField.getText());
				}
				
				updateList();
			}
		});
		
		editParagraphButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cvObj instanceof FunctionalCV){
					((FunctionalCV) cvObj).updateSkillsAndExperienceParagraph(objectToEdit,paragraphTextArea.getText(),paragraphToEdit);
				} else {
					((CombinedCV) cvObj).updateSkillsAndExperienceParagraph(objectToEdit,paragraphTextArea.getText(),paragraphToEdit);
				}
				
				updateParagraphList();
			}
		});
		
		titleDropDownList.addItemListener(
				new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						editTitleButton.setEnabled(true);
						deleteTitleButton.setEnabled(true);
						editParagraphButton.setEnabled(true);
						deleteParagraphButton.setEnabled(true);
						if (e.getStateChange() == ItemEvent.SELECTED){
							objectToEdit = (SkillsAndExperience) e.getItem();
							titleTextField.setText(objectToEdit.getTitle());
							updateParagraphList();
						}
					}
				});
	}
	
	private void updateParagraphList(){
		paragraphDropDownList.removeAllItems();
		paragraphTextArea.setText("");
		ArrayList<CVConstruction.SkillsAndExperience> skillsAndExperienceObjects;
		if (cvObj instanceof FunctionalCV){
			skillsAndExperienceObjects = ((FunctionalCV) cvObj).getSkillsAndExperienceObjects();
		} else {
			skillsAndExperienceObjects = ((CombinedCV) cvObj).getSkillsAndExperienceObjects();
		}
		if (skillsAndExperienceObjects.isEmpty()){
			return;
		}
		ArrayList<String> paragraphs = objectToEdit.getParagraph();
		for (String object : paragraphs){
			paragraphDropDownList.addItem(object);
		}
	}
	
	public void updateList(){
		titleDropDownList.removeAllItems();
		ArrayList<CVConstruction.SkillsAndExperience> skillsAndExperienceObjects;
		if (cvObj instanceof FunctionalCV){
			skillsAndExperienceObjects = ((FunctionalCV) cvObj).getSkillsAndExperienceObjects();
		} else {
			skillsAndExperienceObjects = ((CombinedCV) cvObj).getSkillsAndExperienceObjects();
		}
		
		for (CVConstruction.SkillsAndExperience object : skillsAndExperienceObjects){
			titleDropDownList.addItem(object);
		}
		
	}
}
