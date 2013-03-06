package poker.app.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JPanel;
import java.awt.Color;

public class ControllerGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControllerGUI window = new ControllerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ControllerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 951, 629);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnRun = new JMenu("Run");
		menuBar.add(mnRun);
		
		JMenuItem mntmVmware = new JMenuItem("VMWare");
		mnRun.add(mntmVmware);
		
		JMenuItem mntmPlaynow = new JMenuItem("PlayNow");
		mnRun.add(mntmPlaynow);
		
		JSeparator separator = new JSeparator();
		mnRun.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnRun.add(mntmExit);
		
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		
		JMenuItem mntmGeneralSettings = new JMenuItem("General Settings");
		mnSettings.add(mntmGeneralSettings);
		
		JMenuItem mntmTablesSettings = new JMenuItem("Tables Settings");
		mnSettings.add(mntmTablesSettings);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		menuBar.add(menuItem);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnNewButton = new JButton("PlayNow App");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JToggleButton tglbtnVmware = new JToggleButton("VMWare");
		GridBagConstraints gbc_tglbtnVmware = new GridBagConstraints();
		gbc_tglbtnVmware.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnVmware.gridx = 1;
		gbc_tglbtnVmware.gridy = 0;
		frame.getContentPane().add(tglbtnVmware, gbc_tglbtnVmware);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnSelectTables = new JButton("Select Tables");
		GridBagConstraints gbc_btnSelectTables = new GridBagConstraints();
		gbc_btnSelectTables.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelectTables.gridx = 2;
		gbc_btnSelectTables.gridy = 1;
		frame.getContentPane().add(btnSelectTables, gbc_btnSelectTables);
		
		JPanel TablesDisplayPnl = new JPanel();
		TablesDisplayPnl.setBackground(Color.GREEN);
		TablesDisplayPnl.setForeground(Color.BLACK);
		GridBagConstraints gbc_TablesDisplayPnl = new GridBagConstraints();
		gbc_TablesDisplayPnl.gridwidth = 3;
		gbc_TablesDisplayPnl.insets = new Insets(0, 0, 5, 0);
		gbc_TablesDisplayPnl.fill = GridBagConstraints.BOTH;
		gbc_TablesDisplayPnl.gridx = 0;
		gbc_TablesDisplayPnl.gridy = 2;
		frame.getContentPane().add(TablesDisplayPnl, gbc_TablesDisplayPnl);
		
		JPanel PocketCardsPnl = new JPanel();
		PocketCardsPnl.setBackground(Color.YELLOW);
		PocketCardsPnl.setForeground(Color.BLACK);
		GridBagConstraints gbc_PocketCardsPnl = new GridBagConstraints();
		gbc_PocketCardsPnl.insets = new Insets(0, 0, 5, 5);
		gbc_PocketCardsPnl.fill = GridBagConstraints.BOTH;
		gbc_PocketCardsPnl.gridx = 1;
		gbc_PocketCardsPnl.gridy = 3;
		frame.getContentPane().add(PocketCardsPnl, gbc_PocketCardsPnl);
		
		JPanel CommunityCardsPnl = new JPanel();
		CommunityCardsPnl.setBackground(Color.CYAN);
		GridBagConstraints gbc_CommunityCardsPnl = new GridBagConstraints();
		gbc_CommunityCardsPnl.insets = new Insets(0, 0, 5, 0);
		gbc_CommunityCardsPnl.fill = GridBagConstraints.BOTH;
		gbc_CommunityCardsPnl.gridx = 2;
		gbc_CommunityCardsPnl.gridy = 3;
		frame.getContentPane().add(CommunityCardsPnl, gbc_CommunityCardsPnl);
		
		JButton btnFold = new JButton("Fold");
		GridBagConstraints gbc_btnFold = new GridBagConstraints();
		gbc_btnFold.insets = new Insets(0, 0, 5, 5);
		gbc_btnFold.gridx = 1;
		gbc_btnFold.gridy = 4;
		frame.getContentPane().add(btnFold, gbc_btnFold);
		
		JButton btnCheck = new JButton("Check");
		GridBagConstraints gbc_btnCheck = new GridBagConstraints();
		gbc_btnCheck.insets = new Insets(0, 0, 5, 0);
		gbc_btnCheck.gridx = 2;
		gbc_btnCheck.gridy = 4;
		frame.getContentPane().add(btnCheck, gbc_btnCheck);
		
		JButton btnCall = new JButton("Call");
		GridBagConstraints gbc_btnCall = new GridBagConstraints();
		gbc_btnCall.insets = new Insets(0, 0, 5, 0);
		gbc_btnCall.gridx = 2;
		gbc_btnCall.gridy = 5;
		frame.getContentPane().add(btnCall, gbc_btnCall);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 7;
		frame.getContentPane().add(panel, gbc_panel);
	}

}
