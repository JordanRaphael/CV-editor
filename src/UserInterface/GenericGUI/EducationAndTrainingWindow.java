package UserInterface.GenericGUI;

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

import CVConstruction.GenericCV;

@SuppressWarnings("serial")
public class EducationAndTrainingWindow extends JFrame {

	private JPanel contentPane;
	private JTextField qualificationTextField;
	private JTextField establishmentTextField;
	private JTextField locationTextField;
	private JTextField dateTextField;
	private GenericCV cvObj;

	
	/**
	 * Create the frame.
	 * @param cvObj2 
	 */
	public EducationAndTrainingWindow(GenericCV obj) {
		cvObj = obj;
		setTitle("Education and training");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dialogLabel = new JLabel("Please provide information reffering your education and training");
		dialogLabel.setBounds(82, 11, 474, 33);
		dialogLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(dialogLabel);
		
		JLabel qualificationLabel = new JLabel("Qualification :");
		qualificationLabel.setBounds(42, 91, 101, 14);
		qualificationLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(qualificationLabel);
		
		JLabel establishmentLabel = new JLabel("Establishment :");
		establishmentLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		establishmentLabel.setBounds(38, 138, 101, 14);
		contentPane.add(establishmentLabel);
		
		JLabel locationLabel = new JLabel("Location :");
		locationLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		locationLabel.setBounds(68, 187, 101, 14);
		contentPane.add(locationLabel);
		
		JLabel dateLabel = new JLabel("Date :");
		dateLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		dateLabel.setBounds(90, 229, 101, 14);
		contentPane.add(dateLabel);
		
		qualificationTextField = new JTextField();
		qualificationTextField.setBounds(139, 88, 273, 20);
		contentPane.add(qualificationTextField);
		qualificationTextField.setColumns(10);
		
		establishmentTextField = new JTextField();
		establishmentTextField.setColumns(10);
		establishmentTextField.setBounds(139, 135, 273, 20);
		contentPane.add(establishmentTextField);
		
		locationTextField = new JTextField();
		locationTextField.setColumns(10);
		locationTextField.setBounds(139, 184, 273, 20);
		contentPane.add(locationTextField);
		
		dateTextField = new JTextField();
		dateTextField.setColumns(10);
		dateTextField.setBounds(139, 226, 273, 20);
		contentPane.add(dateTextField);
		
		JButton addNewEducationAndTraningButton = new JButton("Add another education and training");
		addNewEducationAndTraningButton.setBounds(10, 298, 243, 39);
		contentPane.add(addNewEducationAndTraningButton);
		
		JButton okButton = new JButton("OK");
		okButton.setBounds(331, 298, 243, 39);
		contentPane.add(okButton);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isAllFieldsFilled() || isAllFieldsEmpty()){
					setVisible(false);
					if (isAllFieldsFilled()){
						cvObj.educationAndTrainingSaveFields(qualificationTextField.getText(),
								establishmentTextField.getText(), locationTextField.getText(),
								dateTextField.getText());
						qualificationTextField.setText("");
						establishmentTextField.setText("");
						locationTextField.setText("");
						dateTextField.setText("");
					}
				}
				else{
					checkFieldValues();
				}
			}
		});
		
		addNewEducationAndTraningButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isAllFieldsFilled()){
					cvObj.educationAndTrainingSaveFields(qualificationTextField.getText(),
							establishmentTextField.getText(), locationTextField.getText(),
							dateTextField.getText());
					qualificationTextField.setText("");
					establishmentTextField.setText("");
					locationTextField.setText("");
					dateTextField.setText("");
				} else {
					checkFieldValues();
				}
			}
		});
		
	}
	
	private boolean isAllFieldsEmpty(){
		return (qualificationTextField.getText().isEmpty()
				&& establishmentTextField.getText().isEmpty()
				&& locationTextField.getText().isEmpty()
				&& dateTextField.getText().isEmpty());
	}
	
	private boolean isAllFieldsFilled(){
		return (qualificationTextField.getText().isEmpty() == false
				&& establishmentTextField.getText().isEmpty() == false
				&& locationTextField.getText().isEmpty() == false
				&& dateTextField.getText().isEmpty() == false);
	}
	
	private void checkFieldValues(){
		if (qualificationTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please fill the qualification's field!");
		} else if (establishmentTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please fill the establishment's field!");
		} else if (locationTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please fill the location's field!");
		} else {
			JOptionPane.showMessageDialog(null,"Please fill the date's field!");
		}
	}

}
