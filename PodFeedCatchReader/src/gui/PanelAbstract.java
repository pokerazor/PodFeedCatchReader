package gui;

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
		this.initialize();
	}
	
	protected abstract void initialize();

}
