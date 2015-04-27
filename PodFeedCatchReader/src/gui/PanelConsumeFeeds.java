package gui;

public class PanelConsumeFeeds extends PanelWithCardLayout {
	
	private PanelShowFeed panelShowFeed;
	private PanelSubscribeChannel panelSubscribeChannel;
	private PanelShowSummaryFeeds panelShowSummaryFeeds;
	
	public static final String SHOW_FEED_PANEL = "Panel Show Feed";
	public static final String SUBSCRIBE_CHANNEL_PANEL = "Panel Subscribe Channel";
	public static final String SHOW_SUMMARY_FEEDS_PANEL = "Panel Show Summary Feeds";

	/**
	 * Create the panel.
	 */
	public PanelConsumeFeeds() {
		initialize();
	}
	
	private void initialize() {
		panelShowFeed = new PanelShowFeed();
		panelSubscribeChannel = new PanelSubscribeChannel();
		panelShowSummaryFeeds = new PanelShowSummaryFeeds();
		
		this.add(panelShowFeed, SHOW_FEED_PANEL);
		this.add(panelShowSummaryFeeds, SHOW_SUMMARY_FEEDS_PANEL);
		this.add(panelSubscribeChannel, SUBSCRIBE_CHANNEL_PANEL);
		
		this.switchCard(SHOW_SUMMARY_FEEDS_PANEL);
		
		panelShowSummaryFeeds.getBtnShowFeed().addActionListener(new ActionListenerSwitchCard(this, SHOW_FEED_PANEL));
		panelShowSummaryFeeds.getBtnSubscribeChannel().addActionListener(new ActionListenerSwitchCard(this, SUBSCRIBE_CHANNEL_PANEL));
		panelShowFeed.getBtnBack().addActionListener(new ActionListenerSwitchCard(this, SHOW_SUMMARY_FEEDS_PANEL));
		panelSubscribeChannel.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, SHOW_SUMMARY_FEEDS_PANEL));
			
	}
}
