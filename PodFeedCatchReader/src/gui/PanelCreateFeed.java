package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JList;

public class PanelCreateFeed extends JPanel {
	
	private JLabel lblCreateFeed;
	private JTextPane textPaneFeed;
	
	private JButton btnSend;
	private JButton btnCancel;
	private JList listChannels;
	private JButton btnCreateChannel;
	
	public JLabel getLblCreateFeed() {
		return lblCreateFeed;
	}

	public JTextPane getTextPanePane() {
		return textPaneFeed;
	}

	public JButton getBtnSend() {
		return btnSend;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}
	
	public JButton getBtnCreateChannel() {
		return btnCreateChannel;
	}

	/**
	 * Create the panel.
	 */
	public PanelCreateFeed() {
		initialize();

	}
	
	private void initialize() {
		setLayout(null);
		
		lblCreateFeed = new JLabel("Feed erstellen");
		lblCreateFeed.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblCreateFeed.setBounds(92, 6, 115, 16);
		add(lblCreateFeed);
		
		textPaneFeed = new JTextPane();
		textPaneFeed.setBounds(10, 28, 284, 102);
		add(textPaneFeed);
		
		btnSend = new JButton("Absenden");
		btnSend.setBounds(92, 351, 117, 29);
		add(btnSend);
		
		btnCancel = new JButton("Abbrechen");
		btnCancel.setBounds(90, 392, 117, 29);
		add(btnCancel);
		
		listChannels = new JList();
		listChannels.setBounds(10, 142, 284, 141);
		add(listChannels);
		
		btnCreateChannel = new JButton("Channel erstellen");
		btnCreateChannel.setBounds(66, 286, 168, 29);
		add(btnCreateChannel);
	}
}
