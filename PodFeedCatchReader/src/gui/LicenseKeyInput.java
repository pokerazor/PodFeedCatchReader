package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import konfiguration.Konfiguration;

public class LicenseKeyInput extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtLicensekey;
	private Konfiguration owner;
	
	public void DisplayLicenseQuestion(Konfiguration owner){
		LicenseKeyInput dialog = new LicenseKeyInput(owner);
//		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);	
		dialog.setAlwaysOnTop(true);
	}

	/**
	 * Create the dialog.
	 */
	public LicenseKeyInput(final Konfiguration owner) {
		this.owner=owner;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			txtLicensekey = new JTextField();
			txtLicensekey.setText("LicenseKey");
			contentPanel.add(txtLicensekey);
			txtLicensekey.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				final JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		txtLicensekey.setText(Konfiguration.LICENSE_KEY_EDUCATION);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (owner.setCurrentLicenseState(owner.checkLicenseKey(txtLicensekey.getText())) == true) {
			this.dispose();
		}
	}

}
