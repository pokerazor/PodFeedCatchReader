package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;

import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.ZugriffsSchnittstelle;

public class PanelUserAdministration extends PanelWithCardLayout {
	
	public PanelUserAdministration(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle);
		
		this.switchCard(ASSIGN_GROUP_PANEL);
	}


	private PanelAssignUserToGroup panelAssignUserToGroup;
	private PanelCreateGroup panelCreateGroup;
	
	public static final String ASSIGN_GROUP_PANEL = "Panel Assign Group";
	public static final String CREATE_GROUP_PANEL = "Panel Create Group";

	
	protected void initialize(){
		panelAssignUserToGroup = new PanelAssignUserToGroup(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle);
		panelCreateGroup = new PanelCreateGroup(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle);
		
		this.add(panelAssignUserToGroup, ASSIGN_GROUP_PANEL);
		this.add(panelCreateGroup, CREATE_GROUP_PANEL);
		
		panelAssignUserToGroup.getBtnCreateGroup().addActionListener(new ActionListenerSwitchCard(this, CREATE_GROUP_PANEL));
		panelCreateGroup.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, ASSIGN_GROUP_PANEL));
	}

}
