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
public class GeneralInformationWindow extends JFrame {

	private static JPanel contentPane;
	private static JTextField nameTextField;
	private static JTextField addressTextField;
	private static JTextField emailTextField;
	private static JTextField homeTelephoneTextField;
	private static JTextField mobileTelephoneTextField;
	private GenericCV cvObj;


	/**
	 * Create the frame.
	 * @param obj 
	 */
	public GeneralInformationWindow(GenericCV obj) {
		cvObj = obj;
		
		setTitle("Basic Information");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel dialogLabel = new JLabel("Please provide the requested information");
		dialogLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		dialogLabel.setBounds(168, 11, 290, 23);
		contentPane.add(dialogLabel);
		
		JLabel nameLabel = new JLabel("Name :");
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		nameLabel.setBounds(50, 52, 58, 23);
		contentPane.add(nameLabel);
		
		JLabel addressLabel = new JLabel("Address :");
		addressLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		addressLabel.setBounds(50, 115, 98, 14);
		contentPane.add(addressLabel);
		
		JLabel telephoneLabel = new JLabel("Telephone : ");
		telephoneLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		telephoneLabel.setBounds(50, 178, 159, 14);
		contentPane.add(telephoneLabel);
		
		JLabel homeTelephoneLabel = new JLabel("(Home)");
		homeTelephoneLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		homeTelephoneLabel.setBounds(60, 203, 46, 14);
		contentPane.add(homeTelephoneLabel);
		
		JLabel mobileTelephoneLabel = new JLabel("(Mobile) ");
		mobileTelephoneLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		mobileTelephoneLabel.setBounds(61, 238, 117, 14);
		contentPane.add(mobileTelephoneLabel);
		
		JLabel emailLabel = new JLabel("Email :");
		emailLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		emailLabel.setBounds(50, 287, 46, 14);
		contentPane.add(emailLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(118, 55, 190, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(118, 113, 190, 20);
		contentPane.add(addressTextField);
		addressTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(118, 285, 190, 20);
		contentPane.add(emailTextField);
		emailTextField.setColumns(10);
		
		homeTelephoneTextField = new JTextField();
		homeTelephoneTextField.setBounds(118, 203, 190, 20);
		contentPane.add(homeTelephoneTextField);
		homeTelephoneTextField.setColumns(10);
		
		mobileTelephoneTextField = new JTextField();
		mobileTelephoneTextField.setBounds(118, 236, 190, 20);
		contentPane.add(mobileTelephoneTextField);
		mobileTelephoneTextField.setColumns(10);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nameTextField.getText().isEmpty() == false
						&& addressTextField.getText().isEmpty() == false
						&& homeTelephoneTextField.getText().isEmpty() == false
						&& mobileTelephoneTextField.getText().isEmpty() == false
						&& emailTextField.getText().isEmpty() == false){
					setVisible(false);
					cvObj.generalInformationSaveFields(nameTextField.getText(),
							addressTextField.getText(), homeTelephoneTextField.getText(),
							mobileTelephoneTextField.getText(), emailTextField.getText());
				} else {
					checkFieldValues();
					
				}
				
			}
		});
		okButton.setBounds(448, 310, 108, 40);
		contentPane.add(okButton);
		
		JButton refreshButton = new JButton("Refresh");
		refreshButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameTextField.setText(cvObj.getGeneralInformationName().trim());
				addressTextField.setText(cvObj.getGeneralInformationAddress().trim());
				homeTelephoneTextField.setText(cvObj.getGeneralInformationHomeTelephone().trim());
				mobileTelephoneTextField.setText(cvObj.getGeneralInformationMobileTelephone().trim());
				emailTextField.setText(cvObj.getGeneralInformationEmail().trim());
			}
		});
		refreshButton.setBounds(448, 45, 108, 30);
		contentPane.add(refreshButton);
		
	}
	
	private void checkFieldValues(){
		if (nameTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please fill the name's field!");
		} else if (addressTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please fill the address's field!");
		} else if (homeTelephoneTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please fill the home's field!");
		} else if (mobileTelephoneTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please fill the mobile's field!");
		} else {
			JOptionPane.showMessageDialog(null,"Please fill the email's field!");
		}
	}
	
	public static void updateFields(String newName, String newAddress, int newHomeTelephone,int newMobileTelephone, String newEmail){
		nameTextField.setText(newName);
		addressTextField.setText(newAddress);
		homeTelephoneTextField.setText(""+newHomeTelephone);
		mobileTelephoneTextField.setText(""+newMobileTelephone);
		emailTextField.setText(newEmail);
	}
}
