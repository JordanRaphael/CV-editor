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
public class AdditionalInformationWindow extends JFrame {

	private JPanel contentPane;
	private GenericCV cvObj;

	
	/**
	 * Create the frame.
	 * @param cvObj2 
	 */
	public AdditionalInformationWindow(GenericCV obj) {
		cvObj = obj;
		setTitle("Additional Information");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dialogLabel = new JLabel("Please provide any additional information");
		dialogLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		dialogLabel.setBounds(147, 28, 338, 14);
		contentPane.add(dialogLabel);
		
		JTextArea additionalInformationTextArea = new JTextArea();
		additionalInformationTextArea.setBounds(10, 98, 564, 155);
		contentPane.add(additionalInformationTextArea);
		
		JButton okButton = new JButton("OK");
		okButton.setBounds(438, 290, 112, 42);
		contentPane.add(okButton);
		
		JButton refreshButton = new JButton("refresh");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = cvObj.getAdditionalInformationParagraph().trim();
				additionalInformationTextArea.setText(text);
			}
		});
		refreshButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		refreshButton.setBounds(52, 290, 112, 42);
		contentPane.add(refreshButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cvObj.additionalInformationSave(additionalInformationTextArea.getText());
				setVisible(false);
			}
		});
	}
	
}
