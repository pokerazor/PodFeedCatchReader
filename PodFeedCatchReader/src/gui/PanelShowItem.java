package gui;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class PanelShowItem extends JPanel {
	
	private JTextPane textPaneFeed;
	private JButton btnBack;

	public JTextPane getTextPaneFeed() {
		return textPaneFeed;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	/**
	 * Create the panel.
	 */
	public PanelShowItem() {
		initialize();
	}
	
	private void initialize(){
		setLayout(null);
		
		textPaneFeed = new JTextPane();
		textPaneFeed.setEditable(false);
		textPaneFeed.setBounds(6, 6, 288, 431);
		add(textPaneFeed);
		
		btnBack = new JButton("Zurück");
		btnBack.setBounds(92, 449, 117, 29);
		add(btnBack);
	}

}
