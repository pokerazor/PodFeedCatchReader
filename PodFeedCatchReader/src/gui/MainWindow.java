package gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;

import konfiguration.Konfiguration;


public class MainWindow{

	private JFrame frame;
	private Integer currentLicenseState;
	
	private PanelMain panelMain;
	private PanelLogIn panelLogIn;
	private PanelWithCardLayout panelCard;
	
	public final static String LOGIN_PANEL = "Panel with the Log-In things";
	public final static String MAIN_PANEL = "Panel with the Main things";
	public final static String CARD_PANEL = "Panel with the Card things";
	private JButton btnNewWindow;
	
	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public MainWindow(int currentLicenceState, ProduzentenSchnittstelle produzentenSchnittstelle, KonsumentenSchnittstelle konsumentenSchnittstelle) {
		this.currentLicenseState = currentLicenceState;
		
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
		
		panelMain = new PanelMain(currentLicenseState);
		panelLogIn = new PanelLogIn();
		panelCard = new PanelWithCardLayout();
		
		frame.getContentPane().add(panelCard);
		
		panelCard.add(panelMain, MAIN_PANEL);
		
		btnNewWindow = new JButton("Neues Fenster");
		GridBagConstraints gbc_btnNewWindow = new GridBagConstraints();
		gbc_btnNewWindow.gridx = 0;
		gbc_btnNewWindow.gridy = 1;
		panelMain.add(btnNewWindow, gbc_btnNewWindow);
		panelCard.add(panelLogIn, LOGIN_PANEL); 
		
		panelCard.switchCard(LOGIN_PANEL);
	
		panelLogIn.getBtnLogIn().addActionListener(new ActionListenerSwitchCard(panelCard, MAIN_PANEL));
		btnNewWindow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainWindow(currentLicenseState);
			}
		});
	}
	
}
