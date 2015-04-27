package gui;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;

public class PanelShowSummaryFeeds extends JPanel {
	private JButton btnShowFeed;
	private JButton btnSubscribeChannel;
	private JList listFeeds;
	
	

	public JList getListFeeds() {
		return listFeeds;
	}

	public JButton getBtnShowFeed() {
		return btnShowFeed;
	}

	public JButton getBtnSubscribeChannel() {
		return btnSubscribeChannel;
	}

	/**
	 * Create the panel.
	 */
	public PanelShowSummaryFeeds() {
		initialize();
	}
	
	private void initialize() {
		setLayout(null);
		
		btnShowFeed = new JButton("Feed anzeigen");
		btnShowFeed.setBounds(88, 327, 117, 29);
		add(btnShowFeed);
		
		btnSubscribeChannel = new JButton("Channel abonnieren");
		btnSubscribeChannel.setBounds(65, 368, 169, 29);
		add(btnSubscribeChannel);
		
		listFeeds = new JList();
		listFeeds.setBounds(6, 6, 288, 315);
		add(listFeeds);
	}
}
