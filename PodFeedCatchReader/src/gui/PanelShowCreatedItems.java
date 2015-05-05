package gui;

import itemSpeicher.Item;
import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;

import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.ZugriffsSchnittstelle;

public class PanelShowCreatedItems extends PanelAbstract {
	
	public PanelShowCreatedItems(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle);
	}

	private JButton btnCreateItem;
	JList<Item> listItems;

	public JList getListItems() {
		return listItems;
	}

	public JButton getBtnCreateItem() {
		return btnCreateItem;
	}
	
	protected void initialize() {
		setLayout(null);
		
		btnCreateItem = new JButton("Beitrag erstellen");
		btnCreateItem.setBounds(77, 306, 145, 29);
		add(btnCreateItem);
		
		listItems = new JList<Item>();
		listItems.setBounds(6, 6, 288, 287);
		add(listItems);
	}
	
	public void refreshListItems() {
		//this.listItems.setListData(this.produzentenSchnitstelle.getChannelVerzeichnis().getChannels());
	}
}
