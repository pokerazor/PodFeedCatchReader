package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import konfiguration.Session;
import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.Nutzer;
import nutzerVerwaltung.ZugriffsSchnittstelle;

public class PanelCreateChannel extends PanelAbstract {
	public PanelCreateChannel(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle, Session session) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle, null);
	}


	private JTextField textField;
	
	private JButton btnSave;
	private JButton btnCancel;
	private JLabel lblInfo;

	public JTextField getTextField() {
		return textField;
	}



	public JButton getBtnSave() {
		return btnSave;
	}



	public JButton getBtnCancel() {
		return btnCancel;
	}
	
	

	
	public JLabel getLblInfo() {
		return lblInfo;
	}



	protected void initialize() {
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
		
		lblInfo = new JLabel("Bitte Channelnamen angeben!");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(6, 148, 288, 16);
		add(lblInfo);
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String neuerChannelName = textField.getText();
				if (neuerChannelName.length() == 0) {
					lblInfo.setText("Der Name darf nicht Nichts sein!");
				} else {
					produzentenSchnitstelle.erstelleChannel(neuerChannelName);
					System.out.println("Neuen Channel erstellt: " + neuerChannelName);
				}
				
			}
		});
	}
}
