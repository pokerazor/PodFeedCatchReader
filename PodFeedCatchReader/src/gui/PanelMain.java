package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JMenuBar;

import java.awt.Button;

import javax.swing.JList;

import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.ZugriffsSchnittstelle;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.CardLayout;

import konfiguration.Konfiguration;

public class PanelMain extends PanelAbstract {
	public PanelMain(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle) {
		super(currentLicenseState, produzentenSchnittstelle,
				konsumentenSchnittstelle, loginSchnittstelle,
				zugriffsSchnittstelle);
	}
	
	protected void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{330, 0};
		gridBagLayout.rowHeights = new int[]{550, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(tabbedPane, gbc);
		
		PanelConsumeItems panelConsumeItems = new PanelConsumeItems(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle);
		tabbedPane.addTab("Feeds", null, panelConsumeItems, null);
		
		if (currentLicenseState.intValue() == Konfiguration.LICENSE_STATE_BUSINESS.intValue() || currentLicenseState.intValue() == Konfiguration.LICENSE_STATE_EDUCATION.intValue()) {
			PanelProduceItems panelProduceItems = new PanelProduceItems(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle);
			tabbedPane.addTab("Feed erstellen", null, panelProduceItems, null);
		}
		
		if (currentLicenseState.intValue() == Konfiguration.LICENSE_STATE_BUSINESS.intValue()) {
			PanelUserAdministration panelUserAdministration = new PanelUserAdministration(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle);
			tabbedPane.addTab("Nutzerverwaltung", null, panelUserAdministration, null);
			
			PanelGroupAdministration panelGroupAdministration =  new PanelGroupAdministration(super.currentLicenseState, super.produzentenSchnitstelle, super.konsumentenSchnittstelle, super.loginSchnittstelle, super.zugriffsSchnittstelle);
			tabbedPane.addTab("Channelzuweisung", null, panelGroupAdministration, null);
		}
	}
	
}
