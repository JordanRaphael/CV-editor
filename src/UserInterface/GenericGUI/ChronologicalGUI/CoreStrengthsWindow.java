package UserInterface.GenericGUI.ChronologicalGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import CVConstruction.ChronologicalCV;
import CVConstruction.GenericCV;

@SuppressWarnings("serial")
public class CoreStrengthsWindow extends JFrame {

	private JPanel contentPane;
	private GenericCV cvObj;

	/**
	 * Create the frame.
	 * @param obj 
	 */
	public CoreStrengthsWindow(GenericCV obj) {
		cvObj = obj;
		setTitle("Core Strengths");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dialogLabel = new JLabel("Please provide any Core Strengths");
		dialogLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		dialogLabel.setBounds(187, 22, 338, 29);
		contentPane.add(dialogLabel);
		
		JTextArea coreStrengthsTextArea = new JTextArea();
		coreStrengthsTextArea.setBounds(10, 98, 564, 155);
		contentPane.add(coreStrengthsTextArea);
		
		JButton okButton = new JButton("OK");
		okButton.setBounds(438, 290, 112, 42);
		contentPane.add(okButton);
		
		JButton refreshButton = new JButton("refresh");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChronologicalCV cv = (ChronologicalCV) cvObj;
				String text = cv.getCoreStrengthsParagraph().trim();
				coreStrengthsTextArea.setText(text);
			}
		});
		refreshButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		refreshButton.setBounds(46, 290, 112, 42);
		contentPane.add(refreshButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((ChronologicalCV) cvObj).coreStrengthsSave(coreStrengthsTextArea.getText());
				setVisible(false);
			}
		});
	}

}
