package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JButton;

import konfiguration.Session;
import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.ZugriffsSchnittstelle;

public class PanelShowItem extends PanelAbstract {

	public PanelShowItem(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle, Session session) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle, null);
	}

	private JTextPane textPaneItems;
	private JButton btnBack;

	public JTextPane getTextPaneItems() {
		return textPaneItems;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	protected void initialize() {
		setLayout(null);

		textPaneItems = new JTextPane();
		textPaneItems.setEditable(false);
		textPaneItems.setBounds(6, 6, 288, 431);
		add(textPaneItems);

		btnBack = new JButton("Zurück");
		btnBack.setBounds(92, 465, 117, 29);
		add(btnBack);

		JButton btnComment = new JButton("Kommentieren");
		btnComment.setBounds(92, 439, 117, 29);
		add(btnComment);
	}

}
