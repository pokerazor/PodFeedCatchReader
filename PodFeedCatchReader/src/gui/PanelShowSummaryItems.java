package gui;

import itemSpeicher.Item;
import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.KonsumentenSchnittstellePrivat;
import itemSpeicher.KonsumentenSchnittstelleUni;
import itemSpeicher.KonsumentenSchnittstelleFirma;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

import konfiguration.Konfiguration;
import konfiguration.Session;
import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.ZugriffsSchnittstelle;

import javax.swing.JList;

public class PanelShowSummaryItems extends PanelAbstract {
	
	public PanelShowSummaryItems(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle, Session session) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle, session);
	}
	private JButton btnShowItem;
	private JButton btnSubscribeChannel;
	private JList<Item> listItems;
	private JButton btnRefreshItemList;
	
	

	public JButton getBtnRefreshItemList() {
		return btnRefreshItemList;
	}

	public JButton getBtnShowItem() {
		return btnShowItem;
	}

	public JButton getBtnSubscribeChannel() {
		return btnSubscribeChannel;
	}
	
	protected void initialize() {
		setLayout(null);
		
		btnShowItem = new JButton("Beitrag anzeigen");
		btnShowItem.setBounds(77, 359, 146, 29);
		add(btnShowItem);
		
		btnSubscribeChannel = new JButton("Channel abonnieren");
		btnSubscribeChannel.setBounds(65, 387, 169, 29);
		add(btnSubscribeChannel);
		
		listItems = new JList<Item>();
		listItems.setBounds(6, 6, 288, 316);
		add(listItems);
		
		btnRefreshItemList = new JButton("Aktualisieren");
		btnRefreshItemList.setBounds(91, 323, 117, 29);
		add(btnRefreshItemList);
	}
	
	public void refreshListItems() {
		if (this.currentLicenseState == Konfiguration.LICENSE_STATE_PRIVATE)
			this.listItems.setListData(((KonsumentenSchnittstellePrivat)this.konsumentenSchnittstelle).
					gibAlleTextItemsZuNuzer(session.getCurrentUser().getNutzerID()));
		if (this.currentLicenseState == Konfiguration.LICENSE_STATE_EDUCATION)
			this.listItems.setListData(((KonsumentenSchnittstelleUni)this.konsumentenSchnittstelle).
					gibAlleItemsZuNuzer(session.getCurrentUser().getNutzerID()));
		if (this.currentLicenseState == Konfiguration.LICENSE_STATE_BUSINESS)
			this.listItems.setListData(((KonsumentenSchnittstellePrivat)this.konsumentenSchnittstelle).
					gibAlleTextItemsZuNuzer(session.getCurrentUser().getNutzerID()));
	}
}
