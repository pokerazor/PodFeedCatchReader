package gui;

import itemSpeicher.Channel;
import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstellePrivat;
import itemSpeicher.ProduzentenSchnittstelleFirma;
import itemSpeicher.ProduzentenSchnittstelleUni;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Panel;
import java.awt.List;

import javax.swing.JList;
import javax.swing.JButton;

import nutzerVerwaltung.Gruppe;
import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.Nutzer;
import nutzerVerwaltung.ZugriffsSchnittstelle;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import konfiguration.Session;

public class PanelAssignChannelToGroup extends PanelAbstract {

	public PanelAssignChannelToGroup(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle,
			Session session) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle, session);
	}

	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnNewChannel;
	private JButton btnNewGroup;
	private JList<Gruppe> listGroups;
	private JList<Channel> listChannels;
	private JLabel lblChannel;
	private JLabel lblGroup;
	private JLabel lblInfo;

	public JButton getBtnSave() {
		return btnSave;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JButton getBtnNewChannel() {
		return btnNewChannel;
	}

	public JButton getBtnNewGroup() {
		return btnNewGroup;
	}

	protected void initialize() {
		setLayout(null);

		JLabel lblHeading = new JLabel("Channel zu Gruppe zuweisen");
		lblHeading.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setBounds(26, 6, 248, 16);
		add(lblHeading);

		listChannels = new JList<Channel>();
		listChannels.setBounds(10, 54, 280, 137);
		add(listChannels);

		lblChannel = new JLabel("Channel");
		lblChannel.setHorizontalAlignment(SwingConstants.CENTER);
		lblChannel.setBounds(90, 32, 119, 16);
		add(lblChannel);

		lblGroup = new JLabel("Gruppe");
		lblGroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroup.setBounds(119, 231, 61, 16);
		add(lblGroup);

		listGroups = new JList<Gruppe>();
		listGroups.setBounds(10, 254, 284, 137);
		add(listGroups);

		btnSave = new JButton("Speichern");
		btnSave.setBounds(10, 465, 117, 29);
		add(btnSave);

		btnCancel = new JButton("Abbrechen");
		btnCancel.setBounds(173, 465, 117, 29);
		add(btnCancel);

		btnNewChannel = new JButton("Neuer Channel");
		btnNewChannel.setBounds(92, 203, 117, 29);
		add(btnNewChannel);

		btnNewGroup = new JButton("Neue Gruppe");
		btnNewGroup.setBounds(92, 413, 117, 29);
		add(btnNewGroup);
		
		JButton btnRefresh = new JButton("Aktualisieren");
		btnRefresh.setBounds(92, 441, 117, 29);
		add(btnRefresh);
		
		lblInfo = new JLabel("New label");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(67, 395, 166, 16);
		add(lblInfo);
		
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshListGroups();
				refreshListUsers();
				
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(((ProduzentenSchnittstelleFirma)produzentenSchnitstelle).abonniereChannelFuerGruppe
					(listChannels.getSelectedValue().getId(), listGroups.getSelectedValue().getGruppenID()) == true) {
					lblInfo.setText("Channel zugewiesen");
				} else {
					lblInfo.setText("Fehler!");
				}
				
			}
		});

	}
	
	public void refreshListUsers() {
		this.listChannels.setListData(this.produzentenSchnitstelle.getChannelVerzeichnis().getChannels());
	}
	
	public void refreshListGroups() {
		this.listGroups.setListData(this.zugriffsSchnittstelle.gibAlleGruppen());
	}
}
