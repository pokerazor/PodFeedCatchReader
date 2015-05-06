package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.KonsumentenSchnittstelleFirma;
import itemSpeicher.KonsumentenSchnittstellePrivat;
import itemSpeicher.KonsumentenSchnittstelleUni;
import itemSpeicher.ProduzentenSchnittstelle;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.Nutzer;
import nutzerVerwaltung.NutzerRolle;
import nutzerVerwaltung.ZugriffsSchnittstelle;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;

import konfiguration.Konfiguration;
import konfiguration.Session;

public class MainWindow implements ActionListener{

	private JFrame frame;
	private Integer currentLicenseState;

	private PanelMain panelMain;
	private PanelLogIn panelLogIn;
	private PanelWithCardLayout panelCard;
	private ProduzentenSchnittstelle produzentenSchnittstelle;
	private KonsumentenSchnittstelle konsumentenSchnittstelle;
	private LoginSchnittstelle loginSchnittstelle;
	private ZugriffsSchnittstelle zugriffsSchnittstelle;
	private Konfiguration config;

	public final static String LOGIN_PANEL = "Panel with the Log-In things";
	public final static String MAIN_PANEL = "Panel with the Main things";
	public final static String CARD_PANEL = "Panel with the Card things";

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public MainWindow(int currentLicenceState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle,
			LoginSchnittstelle loginSchnittstelle,
			ZugriffsSchnittstelle zugriffsSchnittstelle,
			Konfiguration config) {
		this.currentLicenseState = currentLicenceState;
		this.konsumentenSchnittstelle = konsumentenSchnittstelle;
		this.produzentenSchnittstelle = produzentenSchnittstelle;
		this.loginSchnittstelle = loginSchnittstelle;
		this.zugriffsSchnittstelle = zugriffsSchnittstelle;
		this.config = config;
		initialize();
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 331, 613);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
		panelLogIn = new PanelLogIn(this.currentLicenseState,
				this.produzentenSchnittstelle, this.konsumentenSchnittstelle,
				this.loginSchnittstelle, this.zugriffsSchnittstelle, null);
		panelCard = new PanelWithCardLayout(this.currentLicenseState,
				this.produzentenSchnittstelle, this.konsumentenSchnittstelle,
				this.loginSchnittstelle, this.zugriffsSchnittstelle, null);

		frame.getContentPane().add(panelCard);


		panelCard.add(panelLogIn, LOGIN_PANEL);

		panelCard.switchCard(LOGIN_PANEL);

		panelLogIn.getBtnRegister().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int userID = MainWindow.this.loginSchnittstelle.neuenNutzerAnlegen(panelLogIn.getTextFieldName().getText(), panelLogIn.getTextFieldPassword().getText(), NutzerRolle.Konsument);
				MainWindow.this.panelLogIn.getLblInfo().setText(
						"Deine Nutzer-ID ist " + userID);
			}
		});

		panelLogIn.getBtnLogIn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Nutzer currentUser = MainWindow.this.loginSchnittstelle.logInVerifizieren(
							Integer.parseInt(panelLogIn.getTextFieldName()
									.getText()), panelLogIn
									.getTextFieldPassword().getText());
					if (currentUser != null) {
						MainWindow.this.createNewSession(currentUser);
					} else {
						MainWindow.this.panelLogIn.getLblInfo().setText(
								"Login-Daten sind falsch");
					}
				} catch (NumberFormatException exception) {
					MainWindow.this.panelLogIn.getLblInfo().setText(
							"ID ist keine Zahl");
				}

			}
		});
		
		panelLogIn.getBtnInsertKey().addActionListener(this);}
	
	private void createNewSession(Nutzer currentUser) {
		Session newSession = new Session(currentUser);
		panelMain = new PanelMain(this.currentLicenseState,
				this.produzentenSchnittstelle, this.konsumentenSchnittstelle,
				this.loginSchnittstelle, this.zugriffsSchnittstelle, newSession);
		
		panelCard.add(panelMain, MAIN_PANEL);
		panelMain.getBtnNewWindow().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainWindow(currentLicenseState, produzentenSchnittstelle,
						konsumentenSchnittstelle, loginSchnittstelle,
						zugriffsSchnittstelle, config);
			}
		});
		
		MainWindow.this.panelCard.switchCard(MAIN_PANEL);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		config.setCurrentLicenseState(-1);
		config = new Konfiguration();
		this.frame.dispose();
		
	}

}
