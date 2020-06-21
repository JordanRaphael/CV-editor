package UserInterface.GenericGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import CVConstruction.GenericCV;

@SuppressWarnings("serial")
public class ProfessionalProfileWindow extends JFrame {

	private JPanel contentPane;
	private GenericCV cvObj;

	/**
	 * Create the frame.
	 * @param obj 
	 */
	public ProfessionalProfileWindow(GenericCV obj) {
		cvObj = obj;
		setTitle("Professional Profile");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dialogLabel = new JLabel("Please provide your professional profile description");
		dialogLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		dialogLabel.setBounds(139, 28, 338, 14);
		contentPane.add(dialogLabel);
		
		JTextArea professionalProfileDescriptionTextArea = new JTextArea();
		professionalProfileDescriptionTextArea.setBounds(10, 98, 564, 155);
		contentPane.add(professionalProfileDescriptionTextArea);
		
		JButton okButton = new JButton("OK");
		okButton.setBounds(438, 290, 112, 42);
		contentPane.add(okButton);
		
		JButton refreshButton = new JButton("refresh");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = cvObj.getProfessionalProfileParagraph().trim();
				professionalProfileDescriptionTextArea.setText(text);
			}
		});
		refreshButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		refreshButton.setBounds(60, 290, 112, 42);
		contentPane.add(refreshButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cvObj.professionalProfileSaveFields(professionalProfileDescriptionTextArea.getText());
				setVisible(false);
			}
		});
	}
}
