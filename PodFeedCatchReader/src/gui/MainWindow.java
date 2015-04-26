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
	private JPanel panelCard = new JPanel();
	
	public final static String LOGINPANEL = "Panel with the Log-In things";
	public final static String MAINPANEL = "Panel with the Main things";
	public final static String CARDPANEL = "Panel with the Card things";
	

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
		frame.setBounds(100, 100, 300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(panelCard);
		panelCard.setLayout(new CardLayout(0, 0));
		
		panelCard.add(panelMain, MAINPANEL);
		panelCard.add(panelLogIn, LOGINPANEL); 
		
		switchCard(LOGINPANEL);
	
		panelLogIn.getBtnLogIn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchCard(MAINPANEL);
			}
		});
	}
	
	/**
	 * Switch Cards of Window's CardLayout
	 * @param panelName Name of Card. Use Constants which are defined as constants in MainWindow
	 */
	public void switchCard(String panelName){
		CardLayout cardLayout = (CardLayout) panelCard.getLayout();
		cardLayout.show(panelCard, panelName);
	}
	
}
