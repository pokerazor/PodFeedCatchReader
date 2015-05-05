package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelleUni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.ZugriffsSchnittstelle;

public class PanelProduceItems extends PanelWithCardLayout {
	
	public PanelProduceItems(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle);
		
		this.switchCard(SHOW_CREATED_FEEDS_PANEL);
	}

	private PanelCreateItem panelCreateItem;
	private PanelShowCreatedItems panelShowCreatedItems;
	private PanelCreateChannel panelCreateChannel;
	
	private Integer currentLicenseState;
	private ProduzentenSchnittstelleUni produzentenSchnittstelleUni;
	
	public static final String CREATE_FEED_PANEL = "Panel Create Feed";
	public static final String SHOW_CREATED_FEEDS_PANEL = "Panel with the created Feeds";
	public static final String CREATE_CHANNEL_PANEL = "Panel Create Channel";

	/**
	 * Create the panel.
	 */
	
	
	protected void initialize() {
		panelCreateItem = new PanelCreateItem(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle);
		panelShowCreatedItems = new PanelShowCreatedItems(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle);
		panelCreateChannel = new PanelCreateChannel(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle);
		
		this.add(panelCreateItem, CREATE_FEED_PANEL);
		this.add(panelShowCreatedItems, SHOW_CREATED_FEEDS_PANEL); 
		this.add(panelCreateChannel, CREATE_CHANNEL_PANEL);
		
		panelShowCreatedItems.getBtnCreateItem().addActionListener(new ActionListenerSwitchCard(this, CREATE_FEED_PANEL));
		panelCreateChannel.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, CREATE_FEED_PANEL));
		panelCreateItem.getBtnCreateChannel().addActionListener(new ActionListenerSwitchCard(this, CREATE_CHANNEL_PANEL));
		panelCreateItem.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, SHOW_CREATED_FEEDS_PANEL));
		
		panelCreateItem.getBtnSend().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

	}
	
	

}
