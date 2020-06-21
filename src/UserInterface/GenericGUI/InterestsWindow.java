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
public class InterestsWindow extends JFrame {

	private JPanel contentPane;
	private GenericCV cvObj;

	/**
	 * Create the frame.
	 * @param obj 
	 */
	public InterestsWindow(GenericCV obj) {
		cvObj = obj;
		setTitle("Interests");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dialogLabel = new JLabel("Please provide any Interests");
		dialogLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		dialogLabel.setBounds(199, 28, 338, 14);
		contentPane.add(dialogLabel);
		
		JTextArea interestsTextArea = new JTextArea();
		interestsTextArea.setBounds(10, 98, 564, 155);
		contentPane.add(interestsTextArea);
		
		JButton okButton = new JButton("OK");
		okButton.setBounds(438, 290, 112, 42);
		contentPane.add(okButton);
		
		JButton refreshButton = new JButton("refresh");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = cvObj.getInterestsParagraph().trim();
				interestsTextArea.setText(text);
			}
		});
		refreshButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		refreshButton.setBounds(68, 290, 112, 42);
		contentPane.add(refreshButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cvObj.interestsSave(interestsTextArea.getText());
				setVisible(false);
			}
		});
	}

}
