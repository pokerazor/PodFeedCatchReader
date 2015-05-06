package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import itemSpeicher.Channel;
import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.KonsumentenSchnittstellePrivat;
import itemSpeicher.KonsumentenSchnittstelleUni;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.ZugriffsSchnittstelle;
import konfiguration.Session;
import konfiguration.Konfiguration;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PanelSubscribeChannel extends PanelAbstract {
	public PanelSubscribeChannel(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle, Session session) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle, session);
	}

	private JTextField txtUrl;
	private JButton btnSubscribe;
	private JButton btnCancel;
	private JList<Channel> listChannels;
	private JButton btnRefreshListChannels;
	private JButton btnSubscribeURL;
	private JLabel lblInfo;

	public JTextField getTxtUrl() {
		return txtUrl;
	}

	public JButton getBtnSubscribe() {
		return btnSubscribe;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}
	
	
	
	public JList<Channel> getListChannels() {
		return listChannels;
	}

	protected void initialize() {
		setLayout(null);
		
		if (this.currentLicenseState.intValue() == Konfiguration.LICENSE_STATE_EDUCATION.intValue()) {
			listChannels = new JList<Channel>();
			listChannels.setBounds(6, 6, 288, 301);
			add(listChannels);
		}
		
		txtUrl = new JTextField();
		txtUrl.setText("URL");
		txtUrl.setBounds(6, 384, 288, 28);
		add(txtUrl);
		txtUrl.setColumns(10);
		
		btnSubscribe = new JButton("Abonnieren");
		btnSubscribe.setBounds(91, 351, 117, 29);
		add(btnSubscribe);
		
		btnCancel = new JButton("Abbrechen");
		btnCancel.setBounds(91, 465, 117, 29);
		add(btnCancel);
		
		btnRefreshListChannels = new JButton("Aktualisieren");
		btnRefreshListChannels.setBounds(91, 321, 117, 29);
		add(btnRefreshListChannels);
		
		btnSubscribeURL = new JButton("URL Abonnieren");
		btnSubscribeURL.setBounds(75, 411, 144, 29);
		add(btnSubscribeURL);
		
		lblInfo = new JLabel("");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(43, 440, 214, 16);
		add(lblInfo);
		
		btnRefreshListChannels.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshChannelList();
				
			}
		});
		
		btnSubscribe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (((KonsumentenSchnittstelleUni) konsumentenSchnittstelle).ChannelAbonnierenVerzeichnis
					(session.getCurrentUser().getNutzerID(), listChannels.getSelectedValue().getId()) == true) {
					lblInfo.setText("Channel abonniert!");
					
				}
				
			}
		});
		
		btnSubscribeURL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentLicenseState == Konfiguration.LICENSE_STATE_PRIVATE) {
					if (((KonsumentenSchnittstellePrivat) konsumentenSchnittstelle).ChannelAbonnierenURL(session.getCurrentUser().getNutzerID(),
							txtUrl.getText()) == true) {
						lblInfo.setText("Channel per URL abonniert!");
					}
				}
				
			}
		});
		
	}
	
	public void refreshChannelList() {
		this.listChannels.setListData(this.produzentenSchnitstelle.getChannelVerzeichnis().getChannels());
	}

}
