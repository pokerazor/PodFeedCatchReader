package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

import konfiguration.Konfiguration;

public class PanelSubscribeChannel extends PanelAbstract {
	public PanelSubscribeChannel(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle) {
		super(currentLicenseState, produzentenSchnittstelle, konsumentenSchnittstelle);
	}

	private JTextField txtUrl;
	private JButton btnSubscribe;
	private JButton btnCancel;

	public JTextField getTxtUrl() {
		return txtUrl;
	}

	public JButton getBtnSubscribe() {
		return btnSubscribe;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}
	
	protected void initialize() {
		setLayout(null);
		
		if (this.currentLicenseState.intValue() == Konfiguration.LICENSE_STATE_EDUCATION.intValue()) {
			JList list = new JList();
			list.setBounds(6, 6, 288, 301);
			add(list);
		}
		
		txtUrl = new JTextField();
		txtUrl.setText("URL");
		txtUrl.setBounds(6, 319, 288, 28);
		add(txtUrl);
		txtUrl.setColumns(10);
		
		btnSubscribe = new JButton("Abonnieren");
		btnSubscribe.setBounds(91, 359, 117, 29);
		add(btnSubscribe);
		
		btnCancel = new JButton("Abbrechen");
		btnCancel.setBounds(91, 400, 117, 29);
		add(btnCancel);
	}

}
