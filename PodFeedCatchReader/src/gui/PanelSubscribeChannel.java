package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import itemSpeicher.Channel;
import itemSpeicher.KonsumentenSchnittstelle;
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
		txtUrl.setBounds(6, 319, 288, 28);
		add(txtUrl);
		txtUrl.setColumns(10);
		
		btnSubscribe = new JButton("Abonnieren");
		btnSubscribe.setBounds(91, 385, 117, 29);
		add(btnSubscribe);
		
		btnCancel = new JButton("Abbrechen");
		btnCancel.setBounds(91, 413, 117, 29);
		add(btnCancel);
		
		btnRefreshListChannels = new JButton("Aktualisieren");
		btnRefreshListChannels.setBounds(91, 344, 117, 29);
		add(btnRefreshListChannels);
		
		btnRefreshListChannels.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshChannelList();
				
			}
		});
		
		btnSubscribe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((KonsumentenSchnittstelleUni) PanelSubscribeChannel.this.konsumentenSchnittstelle).ChannelAbonnierenVerzeichnis
					(PanelSubscribeChannel.this.session.getCurrentUser().getNutzerID(), listChannels.getSelectedValue().getId());
				
			}
		});
		
	}
	
	public void refreshChannelList() {
		this.listChannels.setListData(this.produzentenSchnitstelle.getChannelVerzeichnis().getChannels());
	}

}
