package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import java.awt.CardLayout;

import javax.swing.JPanel;

import konfiguration.Session;
import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.Nutzer;
import nutzerVerwaltung.ZugriffsSchnittstelle;

public class PanelWithCardLayout extends PanelAbstract {
	
	public PanelWithCardLayout(Integer currentLicenseState, ProduzentenSchnittstelle produzentenSchnittstelle, KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle, ZugriffsSchnittstelle zugriffsSchnittstelle, Session session){
		super(currentLicenseState, produzentenSchnittstelle, konsumentenSchnittstelle, loginSchnittstelle, zugriffsSchnittstelle, session);
		
		setLayout(new CardLayout(0, 0));
	}
	

	/**
	 * Switch Card of Panel's CardLayout
	 * @param panelName Name of Card. Use Constants which are defined in the Panel classes
	 */
	public void switchCard(String panelName){
		CardLayout cardLayout = (CardLayout) this.getLayout();
		cardLayout.show(this, panelName);
	}


	@Override
	protected void initialize() {
		
	}

}
