package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class PanelAssignUserToGroup extends PanelAbstract {

	public PanelAssignUserToGroup(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle) {
		super(currentLicenseState, produzentenSchnittstelle, konsumentenSchnittstelle);
	}

	private JButton btnCreateGroup;
	private JButton btnSaveAssignment;
	
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
		
		JList listUsers = new JList();
		listUsers.setBounds(6, 51, 288, 172);
		add(listUsers);
		
		JLabel lblUser = new JLabel("Nutzer");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(117, 34, 61, 16);
		add(lblUser);
		
		JList listGroups = new JList();
		listGroups.setBounds(6, 245, 288, 190);
		add(listGroups);
		
		JLabel lblGroup = new JLabel("Gruppe");
		lblGroup.setBounds(117, 226, 61, 16);
		add(lblGroup);
		
		btnCreateGroup = new JButton("Neue Gruppe");
		btnCreateGroup.setBounds(93, 436, 117, 29);
		add(btnCreateGroup);
		
		btnSaveAssignment = new JButton("Zuordnung speichern");
		btnSaveAssignment.setBounds(70, 465, 163, 29);
		add(btnSaveAssignment);
	}

}
