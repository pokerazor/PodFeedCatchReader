package gui;

import itemSpeicher.ItemArt;
import itemSpeicher.Channel;
import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelleUni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import konfiguration.Session;
import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.ZugriffsSchnittstelle;

public class PanelProduceItems extends PanelWithCardLayout {
	
	public PanelProduceItems(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle, Session currentSession) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle, currentSession);
		
		this.add(panelCreateItem, CREATE_item_PANEL);
		this.add(panelShowCreatedItems, SHOW_CREATED_itemS_PANEL); 
		this.add(panelCreateChannel, CREATE_CHANNEL_PANEL);
		this.switchCard(SHOW_CREATED_itemS_PANEL);
	}

	private PanelCreateItem panelCreateItem;
	private PanelShowCreatedItems panelShowCreatedItems;
	private PanelCreateChannel panelCreateChannel;
	
	private Integer currentLicenseState;
	private ProduzentenSchnittstelleUni produzentenSchnittstelleUni;
	
	public static final String CREATE_item_PANEL = "Panel Create item";
	public static final String SHOW_CREATED_itemS_PANEL = "Panel with the created items";
	public static final String CREATE_CHANNEL_PANEL = "Panel Create Channel";

	/**
	 * Create the panel.
	 */
	
	
	protected void initialize() {
		panelCreateItem = new PanelCreateItem(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle, super.session);
		panelShowCreatedItems = new PanelShowCreatedItems(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle, super.session);
		panelCreateChannel = new PanelCreateChannel(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle, super.session);
		
		this.add(panelCreateItem, CREATE_item_PANEL);
		this.add(panelShowCreatedItems, SHOW_CREATED_itemS_PANEL); 
		this.add(panelCreateChannel, CREATE_CHANNEL_PANEL);
		
		panelShowCreatedItems.getBtnCreateItem().addActionListener(new ActionListenerSwitchCard(this, CREATE_item_PANEL));
		panelCreateChannel.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, CREATE_item_PANEL));
		panelCreateItem.getBtnCreateChannel().addActionListener(new ActionListenerSwitchCard(this, CREATE_CHANNEL_PANEL));
		panelCreateItem.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, SHOW_CREATED_itemS_PANEL));

	}
	
	

}
