package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import konfiguration.Session;
import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.Nutzer;
import nutzerVerwaltung.ZugriffsSchnittstelle;
import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.KonsumentenSchnittstellePrivat;
import itemSpeicher.KonsumentenSchnittstelleUni;
import itemSpeicher.KonsumentenSchnittstelleFirma;
import itemSpeicher.ProduzentenSchnittstelle;

public class PanelConsumeItems extends PanelWithCardLayout {
	
	public PanelConsumeItems(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle, Session session) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle, session);
		
		this.add(panelShowItem, SHOW_item_PANEL);
		this.add(panelShowSummaryItems, SHOW_SUMMARY_items_PANEL);
		this.add(panelSubscribeChannel, SUBSCRIBE_CHANNEL_PANEL);
		this.switchCard(SHOW_SUMMARY_items_PANEL);
	}

	private PanelShowItem panelShowItem;
	private PanelSubscribeChannel panelSubscribeChannel;
	private PanelShowSummaryItems panelShowSummaryItems;
	
	public static final String SHOW_item_PANEL = "Panel Show item";
	public static final String SUBSCRIBE_CHANNEL_PANEL = "Panel Subscribe Channel";
	public static final String SHOW_SUMMARY_items_PANEL = "Panel Show Summary items";

	
	
	protected void initialize() {
		panelShowItem = new PanelShowItem(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle, super.session);
		panelSubscribeChannel = new PanelSubscribeChannel(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle, super.session);
		panelShowSummaryItems = new PanelShowSummaryItems(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle, super.session);
		
		panelShowSummaryItems.getBtnShowItem().addActionListener(new ActionListenerSwitchCard(this, SHOW_item_PANEL));
		panelShowSummaryItems.getBtnSubscribeChannel().addActionListener(new ActionListenerSwitchCard(this, SUBSCRIBE_CHANNEL_PANEL));
		panelShowItem.getBtnBack().addActionListener(new ActionListenerSwitchCard(this, SHOW_SUMMARY_items_PANEL));
		panelSubscribeChannel.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, SHOW_SUMMARY_items_PANEL));
		
		panelShowSummaryItems.getBtnRefreshItemList().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelShowSummaryItems.refreshListItems();
			}
		});
		
		panelSubscribeChannel.getBtnSubscribe().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((KonsumentenSchnittstelleUni) PanelConsumeItems.this.konsumentenSchnittstelle).ChannelAbonnierenVerzeichnis
					(PanelConsumeItems.this.session.getCurrentUser().getNutzerID(), panelSubscribeChannel.getListChannels().getSelectedValue().getId());
				
			}
		});
			
	}
}
