package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

import konfiguration.Session;
import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.Nutzer;
import nutzerVerwaltung.ZugriffsSchnittstelle;

public class PanelCreateGroup extends PanelAbstract {
	public PanelCreateGroup(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle, Session session) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle, session);
	}

	private JTextField textField;
	
	private JButton btnSaveGroup;
	private JButton btnCancel;

	public JTextField getTextField() {
		return textField;
	}

	public JButton getBtnSaveGroup() {
		return btnSaveGroup;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}
	
	protected void initialize() {
		setLayout(null);
		
		JLabel lblCreateGroup = new JLabel("Neue Gruppe erstellen");
		lblCreateGroup.setBounds(70, 5, 160, 17);
		lblCreateGroup.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		add(lblCreateGroup);
		
		textField = new JTextField();
		textField.setBounds(6, 27, 288, 28);
		add(textField);
		textField.setColumns(10);
		
		btnSaveGroup = new JButton("Speichern");
		btnSaveGroup.setBounds(91, 67, 117, 29);
		add(btnSaveGroup);
		
		btnCancel = new JButton("Abbrechen");
		btnCancel.setBounds(91, 108, 117, 29);
		add(btnCancel);
		
		btnSaveGroup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelCreateGroup.this.zugriffsSchnittstelle.erstelleGruppe(PanelCreateGroup.this.textField.getText());
				
			}
		});
	}

}
