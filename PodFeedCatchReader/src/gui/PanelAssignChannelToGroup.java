package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Panel;
import java.awt.List;

import javax.swing.JList;
import javax.swing.JButton;

import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.Nutzer;
import nutzerVerwaltung.ZugriffsSchnittstelle;

import java.awt.Button;

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

		JList listChannel = new JList();
		listChannel.setBounds(10, 54, 280, 155);
		add(listChannel);

		JLabel lblNewLabel = new JLabel("Channel");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(90, 32, 119, 16);
		add(lblNewLabel);

		JLabel lblGroup = new JLabel("Gruppe");
		lblGroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroup.setBounds(119, 242, 61, 16);
		add(lblGroup);

		JList listGroup = new JList();
		listGroup.setBounds(6, 265, 284, 155);
		add(listGroup);

		btnSave = new JButton("Speichern");
		btnSave.setBounds(10, 454, 117, 29);
		add(btnSave);

		btnCancel = new JButton("Abbrechen");
		btnCancel.setBounds(173, 454, 117, 29);
		add(btnCancel);

		btnNewChannel = new JButton("Neuer Channel");
		btnNewChannel.setBounds(92, 212, 117, 29);
		add(btnNewChannel);

		btnNewGroup = new JButton("Neue Gruppe");
		btnNewGroup.setBounds(92, 424, 117, 29);
		add(btnNewGroup);

	}
}
