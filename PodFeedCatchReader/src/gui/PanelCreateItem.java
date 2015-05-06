package gui;

import itemSpeicher.Channel;
import itemSpeicher.ItemArt;
import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JList;

import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.Nutzer;
import nutzerVerwaltung.ZugriffsSchnittstelle;

import javax.swing.JRadioButton;

import konfiguration.Konfiguration;
import konfiguration.Session;

import javax.swing.SwingConstants;

public class PanelCreateItem extends PanelAbstract {

	public PanelCreateItem(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle, Session session) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle, session);
	}

	private JLabel lblCreateItem;
	private JTextPane textPaneitem;

	private JButton btnSend;
	private JButton btnCancel;
	private JList<Channel> listChannels;
	private JButton btnCreateChannel;
	private JRadioButton rdbtnItemTypeText;
	private JRadioButton rdbtnItemTypeAudio;
	private JRadioButton rdbtnItemTypeVideo;
	private JButton btnRefreshChannelList;
	private JLabel lblInfo;

	public JLabel getLblCreateItem() {
		return lblCreateItem;
	}

	public JTextPane getTextPanePane() {
		return textPaneitem;
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

	public JTextPane getTextPaneitem() {
		return textPaneitem;
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

		textPaneitem = new JTextPane();
		textPaneitem.setBounds(10, 28, 284, 102);
		add(textPaneitem);

		btnSend = new JButton("Absenden");
		btnSend.setBounds(85, 437, 117, 29);
		add(btnSend);

		btnCancel = new JButton("Abbrechen");
		btnCancel.setBounds(85, 465, 117, 29);
		add(btnCancel);

		listChannels = new JList<Channel>();
		listChannels.setBounds(10, 142, 284, 117);
		add(listChannels);

		btnCreateChannel = new JButton("Channel erstellen");
		btnCreateChannel.setBounds(66, 375, 168, 29);
		add(btnCreateChannel);

		ButtonGroup buttonGroupItemType = new ButtonGroup();

		rdbtnItemTypeText = new JRadioButton("Text");
		rdbtnItemTypeText.setBounds(66, 260, 200, 29);
		add(rdbtnItemTypeText);

		buttonGroupItemType.add(rdbtnItemTypeText);
		if (currentLicenseState == Konfiguration.LICENSE_STATE_EDUCATION || currentLicenseState == Konfiguration.LICENSE_STATE_BUSINESS){
			rdbtnItemTypeAudio = new JRadioButton("Audio");
			rdbtnItemTypeAudio.setBounds(66, 288, 200, 29);
			add(rdbtnItemTypeAudio);

			buttonGroupItemType.add(rdbtnItemTypeAudio);
		}
		
		if (currentLicenseState == Konfiguration.LICENSE_STATE_EDUCATION) {
			rdbtnItemTypeVideo = new JRadioButton("Video");
			rdbtnItemTypeVideo.setBounds(66, 317, 216, 23);
			add(rdbtnItemTypeVideo);
	
			buttonGroupItemType.add(rdbtnItemTypeVideo);
		}

		btnRefreshChannelList = new JButton("Channelliste aktualisieren");
		btnRefreshChannelList.setBounds(45, 347, 209, 29);
		add(btnRefreshChannelList);

		rdbtnItemTypeText.setSelected(true);

		lblInfo = new JLabel("");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(10, 409, 284, 16);
		add(lblInfo);

		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ItemArt itemArt = ItemArt.Text;
				if (rdbtnItemTypeAudio != null) {
					if (rdbtnItemTypeAudio.isSelected()) {
						itemArt = ItemArt.Audio;
					}
				}
				if (rdbtnItemTypeVideo != null) {
					if (rdbtnItemTypeVideo.isSelected()) {
						itemArt = ItemArt.Video;
					}
				}
				if (listChannels.getSelectedValue() != null) {
					if (produzentenSchnitstelle.erstelleItem(itemArt,
							textPaneitem.getText(),
							((Channel) listChannels.getSelectedValue()).getId()) == true) {
						lblInfo.setText("Item wurde erstellt");
					} else {
						lblInfo.setText("Fehler!");
					}
				}
			}
		});

		btnRefreshChannelList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				refreshChannelList();

			}
		});
	}

	public void refreshChannelList() {
		this.listChannels.setListData(this.produzentenSchnitstelle
				.getChannelVerzeichnis().getChannels());
	}
}
