package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import konfiguration.Session;
import nutzerVerwaltung.Gruppe;
import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.Nutzer;
import nutzerVerwaltung.ZugriffsSchnittstelle;

public class PanelAssignUserToGroup extends PanelAbstract {

	public PanelAssignUserToGroup(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle,
			Session session) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle, null);
	}

	private JButton btnCreateGroup;
	private JButton btnSaveAssignment;
	private JList<Nutzer> listUsers;
	private JList<Gruppe> listGroups;
	private JLabel lblInfo;

	public JButton getBtnCreateGroup() {
		return btnCreateGroup;
	}

	public JButton getBtnSaveAssignment() {
		return btnSaveAssignment;
	}

	protected void initialize() {
		setForeground(Color.LIGHT_GRAY);
		setLayout(null);

		JLabel lblHeading = new JLabel("Nutzer zu Gruppe hinzufügen");
		lblHeading.setBounds(44, 5, 212, 17);
		lblHeading.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		add(lblHeading);

		listUsers = new JList<Nutzer>();
		listUsers.setBounds(6, 51, 288, 172);
		add(listUsers);

		JLabel lblUser = new JLabel("Nutzer");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(117, 34, 61, 16);
		add(lblUser);

		listGroups = new JList<Gruppe>();
		listGroups.setBounds(6, 245, 288, 165);
		add(listGroups);

		JLabel lblGroup = new JLabel("Gruppe");
		lblGroup.setBounds(117, 226, 61, 16);
		add(lblGroup);

		btnCreateGroup = new JButton("Neue Gruppe");
		btnCreateGroup.setBounds(160, 422, 117, 29);
		add(btnCreateGroup);

		btnSaveAssignment = new JButton("Zuordnung speichern");
		btnSaveAssignment.setBounds(68, 451, 163, 29);
		add(btnSaveAssignment);
		
		JButton btnRefresh = new JButton("Aktualisieren");
		btnRefresh.setBounds(6, 422, 117, 29);
		add(btnRefresh);
		
		lblInfo = new JLabel("");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(19, 478, 261, 16);
		add(lblInfo);
		
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshListUsers();
				refreshListGroups();
			}
		});
		
		btnSaveAssignment.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if((PanelAssignUserToGroup.this.zugriffsSchnittstelle.weiseGruppeZu
					(PanelAssignUserToGroup.this.listGroups.getSelectedValue().getGruppenID(), 
							PanelAssignUserToGroup.this.listUsers.getSelectedValue().getNutzerID())) == true){
					lblInfo.setText("Gruppe zugewiesen");
				} else {
					lblInfo.setText("Fehler!");
				}
				
			}
		});
	}
	
	public void refreshListUsers() {
		this.listUsers.setListData(this.zugriffsSchnittstelle.gibAlleNutzer());
	}
	
	public void refreshListGroups() {
		this.listGroups.setListData(this.zugriffsSchnittstelle.gibAlleGruppen());
	}

}
