package gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JMenuBar;
import java.awt.Button;
import javax.swing.JList;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.CardLayout;

public class PanelMain extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMain() {
		initialize();
	}
	
	private void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{330, 0};
		gridBagLayout.rowHeights = new int[]{530, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(tabbedPane, gbc);
		
		PanelConsumeFeeds panelConsumeFeeds = new PanelConsumeFeeds();
		tabbedPane.addTab("Feeds", null, panelConsumeFeeds, null);
		
		PanelProduceFeeds panelProduceFeeds = new PanelProduceFeeds();
		tabbedPane.addTab("Feed erstellen", null, panelProduceFeeds, null);
		
		PanelOrganizeUsers panelOrganizeUsers = new PanelOrganizeUsers();
		tabbedPane.addTab("Nutzerverwaltung", null, panelOrganizeUsers, null);
	}
	
}
