package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JList;

import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.ZugriffsSchnittstelle;

public class PanelCreateItem extends PanelAbstract {
	
	public PanelCreateItem(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle);
	}


	private JLabel lblCreateItem;
	private JTextPane textPaneFeed;
	
	private JButton btnSend;
	private JButton btnCancel;
	private JList listChannels;
	private JButton btnCreateChannel;
	
	public JLabel getLblCreateItem() {
		return lblCreateItem;
	}

	public JTextPane getTextPanePane() {
		return textPaneFeed;
	}

	public JButton getBtnSend() {
		return btnSend;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}
	
	public JButton getBtnCreateChannel() {
		return btnCreateChannel;
	}

	
	protected void initialize() {
		setLayout(null);
		
		lblCreateItem = new JLabel("Beitrag erstellen");
		lblCreateItem.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblCreateItem.setBounds(85, 6, 130, 16);
		add(lblCreateItem);
		
		textPaneFeed = new JTextPane();
		textPaneFeed.setBounds(10, 28, 284, 102);
		add(textPaneFeed);
		
		btnSend = new JButton("Absenden");
		btnSend.setBounds(92, 351, 117, 29);
		add(btnSend);
		
		btnCancel = new JButton("Abbrechen");
		btnCancel.setBounds(90, 392, 117, 29);
		add(btnCancel);
		
		listChannels = new JList();
		listChannels.setBounds(10, 142, 284, 141);
		add(listChannels);
		
		btnCreateChannel = new JButton("Channel erstellen");
		btnCreateChannel.setBounds(66, 286, 168, 29);
		add(btnCreateChannel);
	}
}
