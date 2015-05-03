package gui;

public class PanelProduceItems extends PanelWithCardLayout {
	
	private PanelCreateItem panelCreateItem;
	private PanelShowCreatedItems panelShowCreatedItems;
	private PanelCreateChannel panelCreateChannel;
	
	private Integer currentLicenseState;
	
	public static final String CREATE_FEED_PANEL = "Panel Create Feed";
	public static final String SHOW_CREATED_FEEDS_PANEL = "Panel with the created Feeds";
	public static final String CREATE_CHANNEL_PANEL = "Panel Create Channel";

	/**
	 * Create the panel.
	 */
	public PanelProduceItems(Integer currentLicenseState) {
		this.currentLicenseState = currentLicenseState;
		initilalize();
	}
	
	private void initilalize() {
		panelCreateItem = new PanelCreateItem();
		panelShowCreatedItems = new PanelShowCreatedItems();
		panelCreateChannel = new PanelCreateChannel();
		
		this.add(panelCreateItem, CREATE_FEED_PANEL);
		this.add(panelShowCreatedItems, SHOW_CREATED_FEEDS_PANEL); 
		this.add(panelCreateChannel, CREATE_CHANNEL_PANEL);
		
		this.switchCard(SHOW_CREATED_FEEDS_PANEL);
		
		panelShowCreatedItems.getBtnCreateItem().addActionListener(new ActionListenerSwitchCard(this, CREATE_FEED_PANEL));
		panelCreateChannel.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, CREATE_FEED_PANEL));
		panelCreateItem.getBtnCreateChannel().addActionListener(new ActionListenerSwitchCard(this, CREATE_CHANNEL_PANEL));
		panelCreateItem.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, SHOW_CREATED_FEEDS_PANEL));

	}
	
	

}
