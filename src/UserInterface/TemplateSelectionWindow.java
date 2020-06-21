package UserInterface;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import CVConstruction.ChronologicalCV;
import CVConstruction.CombinedCV;
import CVConstruction.FunctionalCV;
import UserInterface.GenericGUI.ChronologicalGUI.ChronologicalGUI;
import UserInterface.GenericGUI.CombinedGUI.CombinedGUI;
import UserInterface.GenericGUI.FunctionalGUI.FunctionalGUI;

@SuppressWarnings("serial")
public class TemplateSelectionWindow extends JFrame {

	private JPanel contentPane;
	JRadioButton functionalRadioButton = new JRadioButton("Functional CV Template");
	JRadioButton chronologicalRadioButton = new JRadioButton("Chronological CV Template");
	JRadioButton combinedRadioButton = new JRadioButton("Combined CV Template");

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemplateSelectionWindow frame = new TemplateSelectionWindow();
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
	public TemplateSelectionWindow() {
		setTitle("Template Selection");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		functionalRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		functionalRadioButton.setBounds(44, 43, 250, 42);
		contentPane.add(functionalRadioButton);
		functionalRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chronologicalRadioButton.setSelected(false);
				combinedRadioButton.setSelected(false);
			}
		});
		
		
		chronologicalRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		chronologicalRadioButton.setBounds(44, 140, 277, 42);
		contentPane.add(chronologicalRadioButton);
		chronologicalRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				functionalRadioButton.setSelected(false);
				combinedRadioButton.setSelected(false);
			}
		});
		
		
		combinedRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		combinedRadioButton.setBounds(44, 233, 250, 42);
		contentPane.add(combinedRadioButton);
		combinedRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				functionalRadioButton.setSelected(false);
				chronologicalRadioButton.setSelected(false);
			}
		});
		
		JButton nextButton = new JButton("Next");
		nextButton.setBounds(426, 285, 104, 42);
		contentPane.add(nextButton);
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(functionalRadioButton.isSelected() == false && chronologicalRadioButton.isSelected() == false && combinedRadioButton.isSelected() == false)	
				{			
					JOptionPane.showMessageDialog(null,"Please choose between the 3 options!");
				} else {
					if (functionalRadioButton.isSelected()){
						FunctionalCV functionalCV = new FunctionalCV();
						functionalCV.setTemplateSelection("functional");
						FunctionalGUI functionalGUI = new FunctionalGUI(functionalCV);
						functionalGUI.setVisible(true);
					} else if (chronologicalRadioButton.isSelected()){
						ChronologicalCV chronologicalCV = new ChronologicalCV();
						chronologicalCV.setTemplateSelection("chronological");
						ChronologicalGUI chronologicalGUI = new ChronologicalGUI(chronologicalCV);
						chronologicalGUI.setVisible(true);
					} else {
						CombinedCV combinedCV = new CombinedCV();
						combinedCV.setTemplateSelection("combined");
						CombinedGUI combinedGUI = new CombinedGUI(combinedCV);
						combinedGUI.setVisible(true);
					}
					setVisible(false);
				}
				
			}
		});
	}
}
