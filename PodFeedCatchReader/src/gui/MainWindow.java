package gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;


public class MainWindow{

	private JFrame frame;
	private final PanelMain panelMain = new PanelMain();
	private final PanelLogIn panelLogIn = new PanelLogIn();
	private PanelWithCardLayout panelCard = new PanelWithCardLayout();
	
	public final static String LOGIN_PANEL = "Panel with the Log-In things";
	public final static String MAIN_PANEL = "Panel with the Main things";
	public final static String CARD_PANEL = "Panel with the Card things";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public MainWindow() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 330, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(panelCard);
		
		panelCard.add(panelMain, MAIN_PANEL);
		panelCard.add(panelLogIn, LOGIN_PANEL); 
		
		panelCard.switchCard(LOGIN_PANEL);
	
		panelLogIn.getBtnLogIn().addActionListener(new ActionListenerSwitchCard(panelCard, MAIN_PANEL));
	}
	
}
