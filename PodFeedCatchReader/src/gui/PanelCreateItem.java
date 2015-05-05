package gui;

import itemSpeicher.Channel;
import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JList;

import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.ZugriffsSchnittstelle;

import javax.swing.JRadioButton;

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
	private JList<Channel> listChannels;
	private JButton btnCreateChannel;
	private JRadioButton rdbtnItemTypeText;
	private JRadioButton rdbtnItemTypeAudio;
	private JRadioButton rdbtnItemTypeVideo;
	private JButton btnRefreshChannelList;
	
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
	
	

	
	public JList<Channel> getListChannels() {
		return listChannels;
	}

	public JButton getBtnRefreshChannelList() {
		return btnRefreshChannelList;
	}

	public JTextPane getTextPaneFeed() {
		return textPaneFeed;
	}

	public JRadioButton getRdbtnItemTypeText() {
		return rdbtnItemTypeText;
	}

	public JRadioButton getRdbtnItemTypeAudio() {
		return rdbtnItemTypeAudio;
	}

	public JRadioButton getRdbtnItemTypeVideo() {
		return rdbtnItemTypeVideo;
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
		btnSend.setBounds(85, 437, 117, 29);
		add(btnSend);
		
		btnCancel = new JButton("Abbrechen");
		btnCancel.setBounds(85, 465, 117, 29);
		add(btnCancel);
		
		listChannels = new JList<Channel>();
		listChannels.setBounds(10, 142, 284, 141);
		add(listChannels);
		
		btnCreateChannel = new JButton("Channel erstellen");
		btnCreateChannel.setBounds(66, 402, 168, 29);
		add(btnCreateChannel);
		
		ButtonGroup buttonGroupItemType = new ButtonGroup();
		
		rdbtnItemTypeText = new JRadioButton("Text");
		rdbtnItemTypeText.setBounds(66, 283, 200, 29);
		add(rdbtnItemTypeText);
		
		buttonGroupItemType.add(rdbtnItemTypeText);
		
		rdbtnItemTypeAudio = new JRadioButton("Audio");
		rdbtnItemTypeAudio.setBounds(66, 310, 200, 29);
		add(rdbtnItemTypeAudio);
		
		buttonGroupItemType.add(rdbtnItemTypeAudio);
		
		rdbtnItemTypeVideo = new JRadioButton("Video");
		rdbtnItemTypeVideo.setBounds(66, 340, 216, 23);
		add(rdbtnItemTypeVideo);
		
		buttonGroupItemType.add(rdbtnItemTypeVideo);
		
		btnRefreshChannelList = new JButton("Channelliste aktualisieren");
		btnRefreshChannelList.setBounds(45, 375, 209, 29);
		add(btnRefreshChannelList);
	}
	
	public void refreshChannelList() {
		this.listChannels.setListData(this.produzentenSchnitstelle.getChannelVerzeichnis().getChannels());
	}
}
