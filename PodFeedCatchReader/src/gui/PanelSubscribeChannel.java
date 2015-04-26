package gui;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelSubscribeChannel extends JPanel {
	private JTextField txtUrl;
	private JButton btnSubscribe;
	private JButton btnCancel;

	public JTextField getTxtUrl() {
		return txtUrl;
	}

	public JButton getBtnSubscribe() {
		return btnSubscribe;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	/**
	 * Create the panel.
	 */
	public PanelSubscribeChannel() {
		initiliaze();
	}
	
	private void initiliaze() {
		setLayout(null);
		
		JList list = new JList();
		list.setBounds(6, 6, 288, 301);
		add(list);
		
		txtUrl = new JTextField();
		txtUrl.setText("URL");
		txtUrl.setBounds(6, 319, 288, 28);
		add(txtUrl);
		txtUrl.setColumns(10);
		
		btnSubscribe = new JButton("Abonnieren");
		btnSubscribe.setBounds(91, 359, 117, 29);
		add(btnSubscribe);
		
		btnCancel = new JButton("Abbrechen");
		btnCancel.setBounds(91, 400, 117, 29);
		add(btnCancel);
	}

}
