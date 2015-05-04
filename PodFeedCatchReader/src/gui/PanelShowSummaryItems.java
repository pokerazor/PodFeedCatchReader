package gui;

import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelle;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

public class PanelShowSummaryItems extends PanelAbstract {
	
	public PanelShowSummaryItems(Integer currentLicenseState,
			ProduzentenSchnittstelle produzentenSchnittstelle,
			KonsumentenSchnittstelle konsumentenSchnittstelle) {
		super(currentLicenseState, produzentenSchnittstelle, konsumentenSchnittstelle);
		// TODO Auto-generated constructor stub
	}

	private JTextArea textArea;
	private JButton btnShowItem;
	private JButton btnSubscribeChannel;
	
	

	public JTextArea getTextArea() {
		return textArea;
	}

	public JButton getBtnShowItem() {
		return btnShowItem;
	}

	public JButton getBtnSubscribeChannel() {
		return btnSubscribeChannel;
	}
	
	protected void initialize() {
		setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(6, 6, 288, 309);
		add(textArea);
		
		btnShowItem = new JButton("Beitrag anzeigen");
		btnShowItem.setBounds(77, 327, 146, 29);
		add(btnShowItem);
		
		btnSubscribeChannel = new JButton("Channel abonnieren");
		btnSubscribeChannel.setBounds(65, 368, 169, 29);
		add(btnSubscribeChannel);
	}
}
