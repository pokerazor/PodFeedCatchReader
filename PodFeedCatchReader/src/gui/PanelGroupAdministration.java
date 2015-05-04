package gui;

import javax.swing.JPanel;

public class PanelGroupAdministration extends PanelWithCardLayout {
	
	public static final String ASSIGN_CHANNEL_TO_GROUP_PANEL = "Panel Assign Channel to Group";
	public static final String CREATE_CHANNEL_PANEL = "Panel Create Channel";
	public static final String CREATE_GROUP_PANEL = "Panel Create Group";
	
	private PanelAssignChannelToGroup panelAssignChannelToGroup;
	private PanelCreateGroup panelCreateGroup;
	private PanelCreateChannel panelCreateChannel;

	/**
	 * Create the panel.
	 */
	public PanelGroupAdministration() {
		initiliaze();
	}
	
	private void initiliaze() {
		panelAssignChannelToGroup = new PanelAssignChannelToGroup();
		panelCreateChannel = new PanelCreateChannel();
		panelCreateGroup = new PanelCreateGroup();
		
		this.add(panelAssignChannelToGroup, ASSIGN_CHANNEL_TO_GROUP_PANEL );
		this.add(panelCreateChannel, CREATE_CHANNEL_PANEL);
		this.add(panelCreateGroup, CREATE_GROUP_PANEL);
		
		this.switchCard(ASSIGN_CHANNEL_TO_GROUP_PANEL);
		
		panelCreateChannel.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, ASSIGN_CHANNEL_TO_GROUP_PANEL));
		panelCreateGroup.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, ASSIGN_CHANNEL_TO_GROUP_PANEL));
		
		panelAssignChannelToGroup.getBtnNewChannel().addActionListener(new ActionListenerSwitchCard(this, CREATE_CHANNEL_PANEL));
		panelAssignChannelToGroup.getBtnNewGroup().addActionListener(new ActionListenerSwitchCard(this, CREATE_GROUP_PANEL));
	}

}
