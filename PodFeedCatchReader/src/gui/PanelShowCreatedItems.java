package gui;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;

public class PanelShowCreatedItems extends JPanel {
	
	private JButton btnCreateItem;
	JList listItems;

	public JList getListItems() {
		return listItems;
	}

	public JButton getBtnCreateItem() {
		return btnCreateItem;
	}

	/**
	 * Create the panel.
	 */
	public PanelShowCreatedItems() {
		initilaize();
	}
	
	private void initilaize() {
		setLayout(null);
		
		btnCreateItem = new JButton("Beitrag erstellen");
		btnCreateItem.setBounds(77, 306, 145, 29);
		add(btnCreateItem);
		
		listItems = new JList();
		listItems.setBounds(6, 6, 288, 287);
		add(listItems);
	}
}
