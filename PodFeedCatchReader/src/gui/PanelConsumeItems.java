package gui;

import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.ZugriffsSchnittstelle;
import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

public class PanelConsumeItems extends PanelWithCardLayout {
	
	public PanelConsumeItems(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle);
		
		this.switchCard(SHOW_SUMMARY_FEEDS_PANEL);
	}

	private PanelShowItem panelShowItem;
	private PanelSubscribeChannel panelSubscribeChannel;
	private PanelShowSummaryItems panelShowSummaryItems;
	
	public static final String SHOW_FEED_PANEL = "Panel Show Feed";
	public static final String SUBSCRIBE_CHANNEL_PANEL = "Panel Subscribe Channel";
	public static final String SHOW_SUMMARY_FEEDS_PANEL = "Panel Show Summary Feeds";

	
	
	protected void initialize() {
		panelShowItem = new PanelShowItem(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle);
		panelSubscribeChannel = new PanelSubscribeChannel(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle);
		panelShowSummaryItems = new PanelShowSummaryItems(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle);
		
		this.add(panelShowItem, SHOW_FEED_PANEL);
		this.add(panelShowSummaryItems, SHOW_SUMMARY_FEEDS_PANEL);
		this.add(panelSubscribeChannel, SUBSCRIBE_CHANNEL_PANEL);
		
		panelShowSummaryItems.getBtnShowItem().addActionListener(new ActionListenerSwitchCard(this, SHOW_FEED_PANEL));
		panelShowSummaryItems.getBtnSubscribeChannel().addActionListener(new ActionListenerSwitchCard(this, SUBSCRIBE_CHANNEL_PANEL));
		panelShowItem.getBtnBack().addActionListener(new ActionListenerSwitchCard(this, SHOW_SUMMARY_FEEDS_PANEL));
		panelSubscribeChannel.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, SHOW_SUMMARY_FEEDS_PANEL));
			
	}
}
