package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;

import konfiguration.Session;
import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.ZugriffsSchnittstelle;

public class PanelUserAdministration extends PanelWithCardLayout {
	
	public PanelUserAdministration(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle, Session session) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle, session);
		
		this.add(panelAssignUserToGroup, ASSIGN_GROUP_PANEL);
		this.add(panelCreateGroup, CREATE_GROUP_PANEL);
		
		this.switchCard(ASSIGN_GROUP_PANEL);
	}


	private PanelAssignUserToGroup panelAssignUserToGroup;
	private PanelCreateGroup panelCreateGroup;
	
	public static final String ASSIGN_GROUP_PANEL = "Panel Assign Group";
	public static final String CREATE_GROUP_PANEL = "Panel Create Group";

	
	protected void initialize(){
		//if (this.zugriffsSchnittstelle == null){ System.out.println("ttttt");}
		panelAssignUserToGroup = new PanelAssignUserToGroup(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle, super.session);
		panelCreateGroup = new PanelCreateGroup(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle, super.session);
		
		panelAssignUserToGroup.getBtnCreateGroup().addActionListener(new ActionListenerSwitchCard(this, CREATE_GROUP_PANEL));
		panelCreateGroup.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, ASSIGN_GROUP_PANEL));
	}

}
