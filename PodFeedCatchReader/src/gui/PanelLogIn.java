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

	/**
	 * Create the panel.
	 */
	public PanelLogIn() {
		this.initialize();
	}
	
	private void initialize(){
		
		GridBagLayout gbl_this = new GridBagLayout();
		gbl_this.columnWidths = new int[]{80, 140, 0};
		gbl_this.rowHeights = new int[]{36, 16, 28, 23, 28, 0, 0, 0};
		gbl_this.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_this.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_this);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.NORTH;
		gbc_lblName.insets = new Insets(0, 0, 5, 0);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		this.add(lblName, gbc_lblName);
		
		textFieldName = new JTextField();
		GridBagConstraints gbc_textFieldName = new GridBagConstraints();
		gbc_textFieldName.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldName.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldName.gridx = 1;
		gbc_textFieldName.gridy = 2;
		this.add(textFieldName, gbc_textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Passwort:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.VERTICAL;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 0);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 3;
		this.add(lblPassword, gbc_lblPassword);
		
		textFieldPassword = new JTextField();
		GridBagConstraints gbc_textFieldPassword = new GridBagConstraints();
		gbc_textFieldPassword.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPassword.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldPassword.gridx = 1;
		gbc_textFieldPassword.gridy = 4;
		this.add(textFieldPassword, gbc_textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnlogIn = new JButton("Einloggen");
	
		GridBagConstraints gbc_btnlogIn = new GridBagConstraints();
		gbc_btnlogIn.insets = new Insets(0, 0, 5, 0);
		gbc_btnlogIn.gridx = 1;
		gbc_btnlogIn.gridy = 5;
		this.add(btnlogIn, gbc_btnlogIn);
		
		JButton btnRegister = new JButton("Registrieren");
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.gridx = 1;
		gbc_btnRegister.gridy = 6;
		this.add(btnRegister, gbc_btnRegister);
		
	}

}
