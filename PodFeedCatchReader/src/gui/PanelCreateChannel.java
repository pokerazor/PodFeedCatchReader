package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelCreateChannel extends JPanel {
	private JTextField textField;
	
	private JButton btnSave;
	private JButton btnCancel;

	public JTextField getTextField() {
		return textField;
	}



	public JButton getBtnSave() {
		return btnSave;
	}



	public JButton getBtnCancel() {
		return btnCancel;
	}



	/**
	 * Create the panel.
	 */
	public PanelCreateChannel() {
		initialize();
	}
	
	private void initialize() {
		setLayout(null);
		
		JLabel lblHeading = new JLabel("Channel erstellen");
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblHeading.setBounds(71, 5, 158, 16);
		add(lblHeading);
		
		textField = new JTextField();
		textField.setBounds(6, 33, 288, 28);
		add(textField);
		textField.setColumns(10);
		
		btnSave = new JButton("Speichern");
		btnSave.setBounds(87, 66, 117, 29);
		add(btnSave);
		
		btnCancel = new JButton("Abbrechen");
		btnCancel.setBounds(87, 107, 117, 29);
		add(btnCancel);
	}
}
