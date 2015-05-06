package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;

import konfiguration.Session;
import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.ZugriffsSchnittstelle;

public class PanelShowUsers extends PanelAbstract {

	public PanelShowUsers(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle, Session session) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle, session);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}


}
