package gui;

import java.awt.CardLayout;
import java.awt.Color;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;

import konfiguration.Konfiguration;
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
		if (this.currentLicenseState == Konfiguration.LICENSE_STATE_PRIVATE)
			this.setBackground(new Color(123,239,158));
		if (this.currentLicenseState == Konfiguration.LICENSE_STATE_EDUCATION)
			this.setBackground(new Color(176,209,246));
		if (this.currentLicenseState == Konfiguration.LICENSE_STATE_BUSINESS)
			this.setBackground(new Color(255,75,75));
			
	}
	
	protected abstract void initialize();

}
