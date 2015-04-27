package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelLogIn extends JPanel {
	
	private JTextField textFieldName;
	private JTextField textFieldPassword;
	
	private JButton btnLogIn;
	private JButton btnRegister;

	public JButton getBtnLogIn() {
		return btnLogIn;
	}

	public JButton getBtnRegister() {
		return btnRegister;
	}

	/**
	 * Create the panel.
	 */
	public PanelLogIn() {
		this.initialize();
	}
	
	private void initialize(){
		setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(145, 36, 40, 16);
		this.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(98, 57, 134, 28);
		this.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Passwort:");
		lblPassword.setBounds(135, 90, 60, 18);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(98, 113, 134, 28);
		this.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		btnLogIn = new JButton("Einloggen");
		btnLogIn.setBounds(112, 146, 106, 29);
		this.add(btnLogIn);
		
		btnRegister = new JButton("Registrieren");
		btnRegister.setBounds(105, 180, 119, 29);
		this.add(btnRegister);
		
	}

}
