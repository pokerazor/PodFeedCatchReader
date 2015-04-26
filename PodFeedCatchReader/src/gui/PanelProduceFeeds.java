package gui;

public class PanelProduceFeeds extends PanelWithCardLayout {
	
	private PanelCreateFeed panelCreateFeed;
	private PanelShowCreatedFeeds panelShowCreatedFeeds;
	private PanelCreateChannel panelCreateChannel;
	
	public static final String CREATE_FEED_PANEL = "Panel Create Feed";
	public static final String SHOW_CREATED_FEEDS_PANEL = "Panel with the created Feeds";
	public static final String CREATE_CHANNEL_PANEL = "Panel Create Channel";

	/**
	 * Create the panel.
	 */
	public PanelProduceFeeds() {
		initilalize();
	}
	
	private void initilalize() {
		panelCreateFeed = new PanelCreateFeed();
		panelShowCreatedFeeds = new PanelShowCreatedFeeds();
		panelCreateChannel = new PanelCreateChannel();
		
		this.add(panelCreateFeed, CREATE_FEED_PANEL);
		this.add(panelShowCreatedFeeds, SHOW_CREATED_FEEDS_PANEL); 
		this.add(panelCreateChannel, CREATE_CHANNEL_PANEL);
		
		this.switchCard(SHOW_CREATED_FEEDS_PANEL);
		
		panelShowCreatedFeeds.getBtnCreateFeed().addActionListener(new ActionListenerSwitchCard(this, CREATE_FEED_PANEL));
		panelCreateChannel.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, CREATE_FEED_PANEL));
		panelCreateFeed.getBtnCreateChannel().addActionListener(new ActionListenerSwitchCard(this, CREATE_CHANNEL_PANEL));
		panelCreateFeed.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, SHOW_CREATED_FEEDS_PANEL));

	}
	
	

}
