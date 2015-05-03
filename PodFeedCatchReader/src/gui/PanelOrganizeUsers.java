package gui;

import javax.swing.JPanel;

public class PanelOrganizeUsers extends PanelWithCardLayout {
	
	private PanelAssignGroup panelAssignGroup = new PanelAssignGroup();
	private PanelCreateGroup panelCreateGroup = new PanelCreateGroup();
	
	private Integer currentLicenseState;
	
	public static final String ASSIGN_GROUP_PANEL = "Panel Assign Group";
	public static final String CREATE_GROUP_PANEL = "Panel Create Group";

	/**
	 * Create the panel.
	 */
	public PanelOrganizeUsers(Integer currentLicenseState) {
		this.currentLicenseState = currentLicenseState;
		initialize();
	}
	
	private void initialize() {
		this.add(panelAssignGroup, ASSIGN_GROUP_PANEL);
		this.add(panelCreateGroup, CREATE_GROUP_PANEL);
		
		this.switchCard(ASSIGN_GROUP_PANEL);
		
		panelAssignGroup.getBtnCreateGroup().addActionListener(new ActionListenerSwitchCard(this, CREATE_GROUP_PANEL));
		panelCreateGroup.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, ASSIGN_GROUP_PANEL));
	}

}
