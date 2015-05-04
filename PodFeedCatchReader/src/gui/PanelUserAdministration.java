package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;

public class PanelUserAdministration extends PanelWithCardLayout {
	
	public PanelUserAdministration(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle) {
		super(currentLicenseState, produzentenSchnittstelle, konsumentenSchnittstelle);
	}


	private PanelAssignUserToGroup panelAssignUserToGroup;
	private PanelCreateGroup panelCreateGroup;
	
	public static final String ASSIGN_GROUP_PANEL = "Panel Assign Group";
	public static final String CREATE_GROUP_PANEL = "Panel Create Group";

	
	protected void initialize(){
		panelAssignUserToGroup = new PanelAssignUserToGroup(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle);
		panelCreateGroup = new PanelCreateGroup(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle);
		
		this.add(panelAssignUserToGroup, ASSIGN_GROUP_PANEL);
		this.add(panelCreateGroup, CREATE_GROUP_PANEL);
		
		this.switchCard(ASSIGN_GROUP_PANEL);
		
		panelAssignUserToGroup.getBtnCreateGroup().addActionListener(new ActionListenerSwitchCard(this, CREATE_GROUP_PANEL));
		panelCreateGroup.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, ASSIGN_GROUP_PANEL));
	}

}
