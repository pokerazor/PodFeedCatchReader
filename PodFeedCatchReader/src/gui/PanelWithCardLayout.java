package gui;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class PanelWithCardLayout extends JPanel {
	
	public PanelWithCardLayout(){
		this.setLayout(new CardLayout(0, 0));
	}

	/**
	 * Switch Cards of Window's CardLayout
	 * @param panelName Name of Card. Use Constants which are defined as constants in MainWindow
	 */
	public void switchCard(String panelName){
		CardLayout cardLayout = (CardLayout) this.getLayout();
		cardLayout.show(this, panelName);
	}

}
