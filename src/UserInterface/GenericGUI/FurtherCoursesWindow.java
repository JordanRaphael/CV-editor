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
public class FurtherCoursesWindow extends JFrame {

	private JPanel contentPane;
	private JTextField courseTextField;
	private JTextField establishmentTextField;
	private JTextField locationTextField;
	private JTextField dateTextField;
	private GenericCV cvObj;


	/**
	 * Create the frame.
	 * @param cvObj2 
	 */
	public FurtherCoursesWindow(GenericCV obj) {
		cvObj = obj;
		setTitle("Further Courses");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please provide information reffering any other courses");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(133, 25, 364, 14);
		contentPane.add(lblNewLabel);
		
		JLabel courseLabel = new JLabel("Course :");
		courseLabel.setBounds(74, 91, 101, 14);
		courseLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(courseLabel);
		
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
		
		courseTextField = new JTextField();
		courseTextField.setBounds(139, 88, 273, 20);
		contentPane.add(courseTextField);
		courseTextField.setColumns(10);
		
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
		
		JButton addNewCourseButton = new JButton("Add another course");
		addNewCourseButton.setBounds(10, 298, 243, 39);
		contentPane.add(addNewCourseButton);
		
		JButton okButton = new JButton("OK");
		okButton.setBounds(331, 298, 243, 39);
		contentPane.add(okButton);
		
		addNewCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isAllFieldsFilled()){
					cvObj.furtherCoursesSaveFields(courseTextField.getText(),
								establishmentTextField.getText(), 
								locationTextField.getText(),
								dateTextField.getText());
					courseTextField.setText("");
					establishmentTextField.setText("");
					locationTextField.setText("");
					dateTextField.setText("");
				} else {
					checkFieldValues();
				}
			}
		});
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isAllFieldsEmpty() || isAllFieldsFilled()){
					setVisible(false);
					if (isAllFieldsFilled()){
						cvObj.furtherCoursesSaveFields(courseTextField.getText(),
								establishmentTextField.getText(), 
								locationTextField.getText(),
								dateTextField.getText());
						courseTextField.setText("");
						establishmentTextField.setText("");
						locationTextField.setText("");
						dateTextField.setText("");
					}
				} else {
					checkFieldValues();
				}
			}
		});
	}
	
	private boolean isAllFieldsEmpty(){
		return (courseTextField.getText().isEmpty()
				&& establishmentTextField.getText().isEmpty()
				&& locationTextField.getText().isEmpty()
				&& dateTextField.getText().isEmpty());
	}
	
	private boolean isAllFieldsFilled(){
		return (courseTextField.getText().isEmpty() == false
				&& establishmentTextField.getText().isEmpty() == false
				&& locationTextField.getText().isEmpty() == false
				&& dateTextField.getText().isEmpty() == false);
	}
	
	private void checkFieldValues(){
		if (courseTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please fill the course's field!");
		} else if (establishmentTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please fill the establishment's field!");
		} else if (locationTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please fill the location's field!");
		} else {
			JOptionPane.showMessageDialog(null,"Please fill the date's field!");
		}
	}
	
}
