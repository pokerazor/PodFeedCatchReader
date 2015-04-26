package gui;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;

public class PanelShowCreatedFeeds extends JPanel {
	
	private JButton btnCreateFeed;
	JList listFeeds;

	public JList getListFeeds() {
		return listFeeds;
	}

	public JButton getBtnCreateFeed() {
		return btnCreateFeed;
	}

	/**
	 * Create the panel.
	 */
	public PanelShowCreatedFeeds() {
		initilaize();
	}
	
	private void initilaize() {
		setLayout(null);
		
		btnCreateFeed = new JButton("Feed erstellen");
		btnCreateFeed.setBounds(94, 306, 117, 29);
		add(btnCreateFeed);
		
		listFeeds = new JList();
		listFeeds.setBounds(6, 6, 288, 287);
		add(listFeeds);
	}
}
