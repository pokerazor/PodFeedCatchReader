package gui;

import java.awt.CardLayout;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;

import konfiguration.Session;
import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.Nutzer;
import nutzerVerwaltung.ZugriffsSchnittstelle;

public abstract class PanelAbstract extends JPanel {
	protected ProduzentenSchnittstelle produzentenSchnitstelle;
	protected KonsumentenSchnittstelle konsumentenSchnittstelle;
	protected Integer currentLicenseState;
	protected LoginSchnittstelle loginSchnittstelle;
	protected ZugriffsSchnittstelle zugriffsSchnittstelle;
	protected Session session;

	/**
	 * Create the panel.
	 */
	public PanelAbstract(Integer currentLicenseState, ProduzentenSchnittstelle produzentenSchnittstelle, KonsumentenSchnittstelle konsumentenSchnittstelle, 
			LoginSchnittstelle loginSchnittstelle, ZugriffsSchnittstelle zugriffsSchnittstelle, Session session) {
		this.currentLicenseState = currentLicenseState;
		this.produzentenSchnitstelle = produzentenSchnittstelle;
		this.konsumentenSchnittstelle = konsumentenSchnittstelle;
		this.loginSchnittstelle = loginSchnittstelle;
		this.zugriffsSchnittstelle = zugriffsSchnittstelle;
		this.session = session;
		initialize();
	}
	
	protected abstract void initialize();

}
