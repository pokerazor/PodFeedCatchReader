package gui;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class PanelShowSummaryFeeds extends JPanel {
	
	private JTextArea textArea;
	private JButton btnShowFeed;
	private JButton btnSubscribeChannel;
	
	

	public JTextArea getTextArea() {
		return textArea;
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
		
		textArea = new JTextArea();
		textArea.setBounds(6, 6, 288, 309);
		add(textArea);
		
		btnShowFeed = new JButton("Feed anzeigen");
		btnShowFeed.setBounds(88, 327, 117, 29);
		add(btnShowFeed);
		
		btnSubscribeChannel = new JButton("Channel abonnieren");
		btnSubscribeChannel.setBounds(65, 368, 169, 29);
		add(btnSubscribeChannel);
	}
}
