package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;

import konfiguration.Session;
import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.Nutzer;
import nutzerVerwaltung.ZugriffsSchnittstelle;

public class PanelGroupAdministration extends PanelWithCardLayout {
	
	public PanelGroupAdministration(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle, Session session) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle, session);
		
		this.add(panelAssignChannelToGroup, ASSIGN_CHANNEL_TO_GROUP_PANEL );
		this.add(panelCreateChannel, CREATE_CHANNEL_PANEL);
		this.add(panelCreateGroup, CREATE_GROUP_PANEL);
		this.switchCard(ASSIGN_CHANNEL_TO_GROUP_PANEL);
	}

	public static final String ASSIGN_CHANNEL_TO_GROUP_PANEL = "Panel Assign Channel to Group";
	public static final String CREATE_CHANNEL_PANEL = "Panel Create Channel";
	public static final String CREATE_GROUP_PANEL = "Panel Create Group";
	
	private PanelAssignChannelToGroup panelAssignChannelToGroup;
	private PanelCreateGroup panelCreateGroup;
	private PanelCreateChannel panelCreateChannel;
	
	protected void initialize() {
		panelAssignChannelToGroup = new PanelAssignChannelToGroup(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle, super.session);
		panelCreateChannel = new PanelCreateChannel(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle, super.session);
		panelCreateGroup = new PanelCreateGroup(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle, super.session);
		
		
		panelCreateChannel.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, ASSIGN_CHANNEL_TO_GROUP_PANEL));
		panelCreateGroup.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, ASSIGN_CHANNEL_TO_GROUP_PANEL));
		
		panelAssignChannelToGroup.getBtnNewChannel().addActionListener(new ActionListenerSwitchCard(this, CREATE_CHANNEL_PANEL));
		panelAssignChannelToGroup.getBtnNewGroup().addActionListener(new ActionListenerSwitchCard(this, CREATE_GROUP_PANEL));
	}

}
