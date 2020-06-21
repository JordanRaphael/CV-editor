package UserInterface.GenericGUI;

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

import CVConstruction.FurtherCourses;
import CVConstruction.GenericCV;

@SuppressWarnings("serial")
public class FurtherCoursesEdit extends JFrame {

	private JPanel contentPane;
	private JTextField courseTextField;
	private JTextField establishmentTextField;
	private JTextField locationTextField;
	private JTextField dateTextField;
	private GenericCV cvObj;
	private JComboBox<FurtherCourses> dropDownList;
	private FurtherCourses objectToEdit;


	/**
	 * Create the frame.
	 * @param obj 
	 **/

	public FurtherCoursesEdit(GenericCV obj) {
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
		
		JLabel courseLabel = new JLabel("Course :");
		courseLabel.setBounds(40, 126, 101, 14);
		courseLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(courseLabel);
		
		JLabel establishmentLabel = new JLabel("Establishment :");
		establishmentLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		establishmentLabel.setBounds(36, 173, 101, 14);
		contentPane.add(establishmentLabel);
		
		JLabel locationLabel = new JLabel("Location :");
		locationLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		locationLabel.setBounds(66, 222, 101, 14);
		contentPane.add(locationLabel);
		
		JLabel dateLabel = new JLabel("Date :");
		dateLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		dateLabel.setBounds(88, 264, 101, 14);
		contentPane.add(dateLabel);
		
		courseTextField = new JTextField();
		courseTextField.setBounds(137, 123, 273, 20);
		contentPane.add(courseTextField);
		courseTextField.setColumns(10);
		
		establishmentTextField = new JTextField();
		establishmentTextField.setColumns(10);
		establishmentTextField.setBounds(137, 170, 273, 20);
		contentPane.add(establishmentTextField);
		
		locationTextField = new JTextField();
		locationTextField.setColumns(10);
		locationTextField.setBounds(137, 219, 273, 20);
		contentPane.add(locationTextField);
		
		dateTextField = new JTextField();
		dateTextField.setColumns(10);
		dateTextField.setBounds(137, 261, 273, 20);
		contentPane.add(dateTextField);
		
		JButton editButton = new JButton("Edit");
		editButton.setBounds(519, 259, 114, 53);
		contentPane.add(editButton);
		editButton.setEnabled(false);
		
		dropDownList = new JComboBox<FurtherCourses>();
		dropDownList.setBounds(224, 71, 218, 20);
		contentPane.add(dropDownList);
		
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cvObj.updateFurtherCourses(objectToEdit,courseTextField.getText(),
						establishmentTextField.getText(),locationTextField.getText(),
						dateTextField.getText());
				updateList();
			}
		});
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setEnabled(false);
		deleteButton.setBounds(519, 107, 114, 53);
		contentPane.add(deleteButton);
		
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cvObj.deleteFurtherCourses(objectToEdit);
				courseTextField.setText("");
				establishmentTextField.setText("");
				locationTextField.setText("");
				dateTextField.setText("");
				updateList();
			}
		});
		
		dropDownList.addItemListener(
				new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						editButton.setEnabled(true);
						deleteButton.setEnabled(true);
						if (e.getStateChange() == ItemEvent.SELECTED){
							objectToEdit = (FurtherCourses) e.getItem();
							courseTextField.setText(objectToEdit.getCourse());
							establishmentTextField.setText(objectToEdit.getEstablishment());
							locationTextField.setText(objectToEdit.getLocation());
							dateTextField.setText(objectToEdit.getDate());
						}
					}
				});
	}
	
	public void updateList(){
		dropDownList.removeAllItems();
		ArrayList<CVConstruction.FurtherCourses> furtherCoursesObjects = cvObj.getFurtherCoursesObjects();
		for (CVConstruction.FurtherCourses object : furtherCoursesObjects){
			dropDownList.addItem(object);
		}
	}

}
