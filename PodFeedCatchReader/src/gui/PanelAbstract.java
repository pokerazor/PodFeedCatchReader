package gui;

import java.awt.CardLayout;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;

public abstract class PanelAbstract extends JPanel {
	protected ProduzentenSchnittstelle produzentenSchnitstelle;
	protected KonsumentenSchnittstelle konsumentenSchnittstelle;
	protected Integer currentLicenseState;

	/**
	 * Create the panel.
	 */
	public PanelAbstract(Integer currentLicenseState, ProduzentenSchnittstelle produzentenSchnittstelle, KonsumentenSchnittstelle konsumentenSchnittstelle) {
		this.currentLicenseState = currentLicenseState;
		this.produzentenSchnitstelle = produzentenSchnittstelle;
		this.konsumentenSchnittstelle = konsumentenSchnittstelle;
		initialize();
	}
	
	public PanelAbstract(Integer currentLicenseState, ProduzentenSchnittstelle produzentenSchnittstelle, KonsumentenSchnittstelle konsumentenSchnittstelle, boolean isCardLayout) {
		this.currentLicenseState = currentLicenseState;
		this.produzentenSchnitstelle = produzentenSchnittstelle;
		this.konsumentenSchnittstelle = konsumentenSchnittstelle;
		if (isCardLayout == true) {
			setLayout(new CardLayout(0, 0));
		}
		initialize();
	}
	
	protected abstract void initialize();

}
