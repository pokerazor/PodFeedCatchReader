package gui;

public class PanelConsumeItems extends PanelWithCardLayout {
	
	private PanelShowItem panelShowItem;
	private PanelSubscribeChannel panelSubscribeChannel;
	private PanelShowSummaryItems panelShowSummaryItems;
	private Integer currentLicenseState;
	
	public static final String SHOW_FEED_PANEL = "Panel Show Feed";
	public static final String SUBSCRIBE_CHANNEL_PANEL = "Panel Subscribe Channel";
	public static final String SHOW_SUMMARY_FEEDS_PANEL = "Panel Show Summary Feeds";

	/**
	 * Create the panel.
	 */
	public PanelConsumeItems(Integer currentLicenseState) {
		this.currentLicenseState = currentLicenseState;
		initialize();
	}
	
	private void initialize() {
		panelShowItem = new PanelShowItem();
		panelSubscribeChannel = new PanelSubscribeChannel(this.currentLicenseState);
		panelShowSummaryItems = new PanelShowSummaryItems();
		
		this.add(panelShowItem, SHOW_FEED_PANEL);
		this.add(panelShowSummaryItems, SHOW_SUMMARY_FEEDS_PANEL);
		this.add(panelSubscribeChannel, SUBSCRIBE_CHANNEL_PANEL);
		
		this.switchCard(SHOW_SUMMARY_FEEDS_PANEL);
		
		panelShowSummaryItems.getBtnShowItem().addActionListener(new ActionListenerSwitchCard(this, SHOW_FEED_PANEL));
		panelShowSummaryItems.getBtnSubscribeChannel().addActionListener(new ActionListenerSwitchCard(this, SUBSCRIBE_CHANNEL_PANEL));
		panelShowItem.getBtnBack().addActionListener(new ActionListenerSwitchCard(this, SHOW_SUMMARY_FEEDS_PANEL));
		panelSubscribeChannel.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, SHOW_SUMMARY_FEEDS_PANEL));
			
	}
}
