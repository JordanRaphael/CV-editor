package UserInterface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import CVConstruction.CombinedCV;
import CVConstruction.FunctionalCV;
import CVConstruction.GenericCV;
import UserInterface.GenericGUI.FunctionalGUI.SkillsAndExperienceWindow;

@SuppressWarnings("serial")
public class SpecificationsWindow extends JFrame {

	private JPanel contentPane;
	private GenericCV cvObj;

	
	/**
	 * Create the frame.
	 * @param obj 
	 */
	public SpecificationsWindow(GenericCV obj) {
		cvObj = obj;
		setTitle("Specifications");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dialogLabel = new JLabel("Please provide the required specifications");
		dialogLabel.setBounds(98, 11, 270, 26);
		dialogLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(dialogLabel);
		
		JTextArea paragraphTextArea = new JTextArea();
		paragraphTextArea.setBounds(10, 48, 414, 134);
		contentPane.add(paragraphTextArea);
		
		JButton okButton = new JButton("OK");
		okButton.setBounds(20, 193, 141, 44);
		contentPane.add(okButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (paragraphTextArea.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please provide the required information!");
				} else {
					SkillsAndExperienceWindow.enableOkButton();
					SkillsAndExperienceWindow.changeSpecificationsButtonName();
					if (cvObj.getTemplateSelection().equals("functional")){
						((FunctionalCV) cvObj).skillsAndExperienceSaveParagraph(
								paragraphTextArea.getText());
						
					} else {
						((CombinedCV) cvObj).skillsAndExperienceSaveParagraph(
								paragraphTextArea.getText());
					}
					setVisible(false);
					paragraphTextArea.setText("");
				}
			}
		});
		
		JButton closeButton = new JButton("CLOSE");
		closeButton.setBounds(271, 193, 141, 44);
		contentPane.add(closeButton);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
	}

}
