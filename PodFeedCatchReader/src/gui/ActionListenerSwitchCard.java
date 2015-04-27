package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListenter which steers switching of the cards
 */
public class ActionListenerSwitchCard implements ActionListener{
	
	private String targetCard;
	private PanelWithCardLayout panelWithCardLayout;
	
	public ActionListenerSwitchCard(PanelWithCardLayout panel, String targetCard) {
		this.targetCard = targetCard;
		this.panelWithCardLayout = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panelWithCardLayout.switchCard(targetCard);
	}
	
}
