package gui;

import java.awt.CardLayout;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;

import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.ZugriffsSchnittstelle;

public abstract class PanelAbstract extends JPanel {
	protected ProduzentenSchnittstelle produzentenSchnitstelle;
	protected KonsumentenSchnittstelle konsumentenSchnittstelle;
	protected Integer currentLicenseState;
	protected LoginSchnittstelle loginSchnittstelle;
	protected ZugriffsSchnittstelle zugriffsSchnittstelle;

	/**
	 * Create the panel.
	 */
	public PanelAbstract(Integer currentLicenseState, ProduzentenSchnittstelle produzentenSchnittstelle, KonsumentenSchnittstelle konsumentenSchnittstelle, 
			LoginSchnittstelle loginSchnittstelle, ZugriffsSchnittstelle zugriffsSchnittstelle) {
		this.currentLicenseState = currentLicenseState;
		this.produzentenSchnitstelle = produzentenSchnittstelle;
		this.konsumentenSchnittstelle = konsumentenSchnittstelle;
		this.loginSchnittstelle = loginSchnittstelle;
		this.produzentenSchnitstelle =  produzentenSchnittstelle;
		initialize();
	}
	
	protected abstract void initialize();

}
