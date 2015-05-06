package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;
import javafx.scene.layout.Border;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;

import konfiguration.Konfiguration;
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

	private JTextArea textArea;
	private JButton btnBack;
	private JButton btnberSocialmediaTeilen;

	public JTextArea getTextArea() {
		return textArea;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	protected void initialize() {
		setLayout(null);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(6, 6, 288, 389);
		textArea.setLineWrap(true);
		add(textArea);

		btnBack = new JButton("Zurück");
		btnBack.setBounds(92, 465, 117, 29);
		add(btnBack);

		JButton btnComment = new JButton("Kommentieren");
		btnComment.setBounds(92, 407, 117, 29);
		add(btnComment);
		
		if (currentLicenseState == Konfiguration.LICENSE_STATE_PRIVATE) {
			btnberSocialmediaTeilen = new JButton("Über Social-Media teilen");
			btnberSocialmediaTeilen.setBounds(60, 437, 180, 29);
			add(btnberSocialmediaTeilen);
		}
	}

}
