package UserInterface;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import CVConstruction.ChronologicalCV;
import CVConstruction.CombinedCV;
import CVConstruction.FunctionalCV;
import CVConstruction.GenericCV;
import Comparator.Comparison;
import Parser.Input.InputParser;
import Parser.Input.InputParserLatex;
import Parser.Input.InputParserTXT;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JPanel contentPane;
	String fileName = "readTXT.txt";
	String line = null;
	String typeOfCV = null;
	String professionalProfileParagraph = "";
	GenericCV genericCV = new GenericCV();
	FunctionalCV functionalCV = new FunctionalCV();
	ChronologicalCV chronologicalCV = new ChronologicalCV();
	CombinedCV combinedCV = new CombinedCV();
	boolean isBetweenProffesionalProfileAndSkillsAndExperience = false;
	private JTextField fileName1TextField;
	private JTextField fileName2TextField;
	private JComboBox<String> templateComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("CVEditor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("Create CV");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TemplateSelectionWindow.createWindow();
			}
		});
		btnNewButton.setBounds(85, 235, 146, 45);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(350, 235, 146, 45);
		contentPane.add(btnExit);
		
		JButton compareCVButton = new JButton("Compare CV");
		compareCVButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (fileName1TextField.getText().isEmpty() || fileName2TextField.getText().isEmpty()) { 
					JOptionPane.showMessageDialog(null, "Please insert the filenames."); 
					return;
				}
				
				String format = fileName1TextField.getText().split("\\.")[1];
				
				GenericCV cv1;
				GenericCV cv2;
				
				if (templateComboBox.getSelectedItem().equals("Functional")){
					cv1 = new FunctionalCV();
					cv2 = new FunctionalCV();
				} else if (templateComboBox.getSelectedItem().equals("Chronological")){
					cv1 = new ChronologicalCV();
					cv2 = new ChronologicalCV();
				} else {
					cv1 = new CombinedCV();
					cv2 = new CombinedCV();
				}
				
				if (format.equals("txt")){
					InputParser parser = new InputParserTXT(cv1,fileName1TextField.getText());
					parser.readFromFile();
				} else {
					InputParser parser = new InputParserLatex(cv1,fileName1TextField.getText());
					parser.readFromFile();
				}
				
				format = fileName2TextField.getText().split("\\.")[1];
				
				if (format.equals("txt")){
					InputParser parser = new InputParserTXT(cv2,fileName2TextField.getText());
					parser.readFromFile();
				} else {
					InputParser parser = new InputParserLatex(cv2,fileName2TextField.getText());
					parser.readFromFile();
				}
				Comparison comparator = new Comparison(cv1,cv2);
				comparator.compareCV();
			}
		});
		compareCVButton.setBounds(10, 60, 146, 45);
		contentPane.add(compareCVButton);
		
		fileName1TextField = new JTextField();
		fileName1TextField.setText("compare1.txt");
		fileName1TextField.setBounds(206, 54, 191, 20);
		contentPane.add(fileName1TextField);
		fileName1TextField.setColumns(10);
		
		fileName2TextField = new JTextField();
		fileName2TextField.setText("compare2.txt");
		fileName2TextField.setBounds(206, 97, 191, 20);
		contentPane.add(fileName2TextField);
		fileName2TextField.setColumns(10);
		
		JLabel chooseLabel = new JLabel("<html>What type of CVs would<br>you like to compare?</html>", SwingConstants.CENTER);
		chooseLabel.setBounds(398, 11, 176, 45);
		contentPane.add(chooseLabel);
		
		String[] typesOfCV = new String[] {"Functional", "Chronological","Combined"};
		
		templateComboBox = new JComboBox<String>();
		templateComboBox.setBounds(419, 72, 142, 20);
		contentPane.add(templateComboBox);
		
		for (String str : typesOfCV){
			templateComboBox.addItem(str);
		}
		
		
	}
	
	public static int mergeOptionDialog(String option1, String option2, String message){
		int choice = JOptionPane.showOptionDialog(null,
												message,
												"Choose an option",
												JOptionPane.YES_NO_OPTION,
												JOptionPane.INFORMATION_MESSAGE,
												null,
												new Object[] {option1,option2,"Merge"},
												option1);
		return choice;
	}
	
	public static int optionDialog(String option1, String option2, String message){
		int choice = JOptionPane.showOptionDialog(null,
												message,
												"",
												JOptionPane.YES_NO_OPTION,
												JOptionPane.INFORMATION_MESSAGE,
												null,
												new Object[] {option1,option2},
												option1);
		return choice;
	}
	
	public static int chooseDialog(Object item){
		int choice = JOptionPane.showConfirmDialog(null,
											item, 
											"Do you want to add this bullet to your CV?", 
											JOptionPane.YES_NO_OPTION);
		
		return choice;
	}
	
	public static void dialogMessage(String message){
		JOptionPane.showMessageDialog(null, message);
	}
}
