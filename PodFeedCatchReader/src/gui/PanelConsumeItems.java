package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import konfiguration.Konfiguration;
import konfiguration.Session;
import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.Nutzer;
import nutzerVerwaltung.ZugriffsSchnittstelle;
import itemSpeicher.Item;
import itemSpeicher.ItemArt;
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
		
		this.add(panelShowItem, SHOW_ITEM_PANEL);
		this.add(panelShowSummaryItems, SHOW_SUMMARY_ITEMS_PANEL);
		if (panelSubscribeChannel != null) this.add(panelSubscribeChannel, SUBSCRIBE_CHANNEL_PANEL);
		this.switchCard(SHOW_SUMMARY_ITEMS_PANEL);
	}

	private PanelShowItem panelShowItem;
	private PanelSubscribeChannel panelSubscribeChannel;
	private PanelShowSummaryItems panelShowSummaryItems;
	
	public static final String SHOW_ITEM_PANEL = "Panel Show item";
	public static final String SUBSCRIBE_CHANNEL_PANEL = "Panel Subscribe Channel";
	public static final String SHOW_SUMMARY_ITEMS_PANEL = "Panel Show Summary items";

	
	
	protected void initialize() {
		panelShowItem = new PanelShowItem(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle, super.session);
		
		panelShowSummaryItems = new PanelShowSummaryItems(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle, super.session);
		
		panelShowItem.getBtnBack().addActionListener(new ActionListenerSwitchCard(this, SHOW_SUMMARY_ITEMS_PANEL));
		
		if (currentLicenseState == Konfiguration.LICENSE_STATE_PRIVATE || currentLicenseState == Konfiguration.LICENSE_STATE_EDUCATION) {
			panelSubscribeChannel = new PanelSubscribeChannel(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle, super.session);
			panelShowSummaryItems.getBtnSubscribeChannel().addActionListener(new ActionListenerSwitchCard(this, SUBSCRIBE_CHANNEL_PANEL));
			panelSubscribeChannel.getBtnCancel().addActionListener(new ActionListenerSwitchCard(this, SHOW_SUMMARY_ITEMS_PANEL));
			
		}
		
		panelShowSummaryItems.getBtnShowItem().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Item selectedItem = panelShowSummaryItems.getListItems().getSelectedValue();
				if (selectedItem != null) {
					String itemInhalt = "";
					if (selectedItem.getArt() == ItemArt.Text) itemInhalt = selectedItem.getInhalt();
					if (selectedItem.getArt() == ItemArt.Video) itemInhalt = "Hier würde das Video vom Item " + selectedItem.getInhalt() + " erscheinen.";
					if (selectedItem.getArt() == ItemArt.Audio) itemInhalt = "Hier würde die Audiodatei vom Item " + selectedItem.getInhalt() + " erscheinen.";
					panelShowItem.getTextArea().setText(itemInhalt);
					switchCard(SHOW_ITEM_PANEL);
				}
				
			}
		});
		
		
			
	}
}
