package poker.app.GUI.Controller;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class ControllerGUI implements ActionListener {

	private JFrame frmChipondeckController;
	private JTextField textFieldActionCash;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControllerGUI window = new ControllerGUI();
					window.frmChipondeckController.setVisible(true);
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
		frmChipondeckController = new JFrame();
		frmChipondeckController.setBackground(Color.WHITE);
		frmChipondeckController.setTitle("ChipOnDeck Controller");
		frmChipondeckController.setBounds(100, 100, 964, 745);
		frmChipondeckController.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmChipondeckController.setJMenuBar(menuBar);
		
		JMenu mnRun = new JMenu("Run");
		mnRun.setMnemonic('R');
		menuBar.add(mnRun);
		
		JMenuItem mntmVmware = new JMenuItem("VMWare");
		mnRun.add(mntmVmware);
		
		JMenuItem mntmPokerapp = new JMenuItem("PokerApp");
		mnRun.add(mntmPokerapp);
		
		JSeparator separator = new JSeparator();
		mnRun.add(separator);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnRun.add(mntmClose);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnRun.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setMnemonic('E');
		menuBar.add(mnEdit);
		
		JMenu mnView = new JMenu("View");
		mnView.setMnemonic('V');
		menuBar.add(mnView);
		
		JMenu mnViewMode = new JMenu("View Mode");
		mnView.add(mnViewMode);
		
		JMenuItem mntmFullscreen = new JMenuItem("FullScreen");
		mnViewMode.add(mntmFullscreen);
		
		JMenuItem mntmMinimize = new JMenuItem("Minimize");
		mnViewMode.add(mntmMinimize);
		
		JMenuItem mntmMaximize = new JMenuItem("Maximize");
		mnViewMode.add(mntmMaximize);
		
		JMenu mnSettings = new JMenu("Settings");
		mnSettings.setMnemonic('S');
		menuBar.add(mnSettings);
		
		JMenuItem mntmGeneralSettings = new JMenuItem("General Settings");
		mnSettings.add(mntmGeneralSettings);
		
		JMenu mnTableSettings = new JMenu("Table Settings");
		mnSettings.add(mnTableSettings);
		
		JCheckBoxMenuItem chckbxmntmLimit = new JCheckBoxMenuItem("LIMIT");
		mnTableSettings.add(chckbxmntmLimit);
		
		JSeparator separator_1 = new JSeparator();
		mnTableSettings.add(separator_1);
		
		JCheckBoxMenuItem checkBoxMenuItem_1 = new JCheckBoxMenuItem("0.02 - 0.04");
		mnTableSettings.add(checkBoxMenuItem_1);
		
		JCheckBoxMenuItem checkBoxMenuItem_2 = new JCheckBoxMenuItem("0.05 - 0.10");
		mnTableSettings.add(checkBoxMenuItem_2);
		
		JCheckBoxMenuItem checkBoxMenuItem_3 = new JCheckBoxMenuItem("0.15 - 0.30");
		mnTableSettings.add(checkBoxMenuItem_3);
		
		JCheckBoxMenuItem checkBoxMenuItem_4 = new JCheckBoxMenuItem("0.25 - 0.50");
		mnTableSettings.add(checkBoxMenuItem_4);
		
		JCheckBoxMenuItem checkBoxMenuItem_5 = new JCheckBoxMenuItem("0.50 - 1.00");
		mnTableSettings.add(checkBoxMenuItem_5);
		
		JSeparator separator_2 = new JSeparator();
		mnTableSettings.add(separator_2);
		
		JMenuItem mntmNoLimit = new JMenuItem("NO LIMIT");
		mnTableSettings.add(mntmNoLimit);
		
		JSeparator separator_3 = new JSeparator();
		mnTableSettings.add(separator_3);
		
		JCheckBoxMenuItem checkBoxMenuItem_6 = new JCheckBoxMenuItem("0.02 - 0.04");
		mnTableSettings.add(checkBoxMenuItem_6);
		
		JCheckBoxMenuItem checkBoxMenuItem_7 = new JCheckBoxMenuItem("0.05 - 0.10");
		mnTableSettings.add(checkBoxMenuItem_7);
		
		JCheckBoxMenuItem checkBoxMenuItem_8 = new JCheckBoxMenuItem("0.15 - 0.30");
		mnTableSettings.add(checkBoxMenuItem_8);
		
		JCheckBoxMenuItem checkBoxMenuItem_9 = new JCheckBoxMenuItem("0.25 - 0.50");
		mnTableSettings.add(checkBoxMenuItem_9);
		
		JCheckBoxMenuItem checkBoxMenuItem_10 = new JCheckBoxMenuItem("0.50 - 1.00");
		mnTableSettings.add(checkBoxMenuItem_10);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('H');
		menuBar.add(mnHelp);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmChipondeckController.getContentPane().setLayout(gridBagLayout);
		
		JToggleButton tglbtnVmware = new JToggleButton("VMWare");
		GridBagConstraints gbc_tglbtnVmware = new GridBagConstraints();
		gbc_tglbtnVmware.fill = GridBagConstraints.BOTH;
		gbc_tglbtnVmware.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnVmware.gridx = 0;
		gbc_tglbtnVmware.gridy = 0;
		frmChipondeckController.getContentPane().add(tglbtnVmware, gbc_tglbtnVmware);
		tglbtnVmware.setActionCommand("SetVMWareMode");
		tglbtnVmware.addActionListener(this);
		
		JButton btnGrabWindows = new JButton("GrabWindows");
		GridBagConstraints gbc_btnGrabWindows = new GridBagConstraints();
		gbc_btnGrabWindows.fill = GridBagConstraints.BOTH;
		gbc_btnGrabWindows.insets = new Insets(0, 0, 5, 5);
		gbc_btnGrabWindows.gridx = 1;
		gbc_btnGrabWindows.gridy = 0;
		frmChipondeckController.getContentPane().add(btnGrabWindows, gbc_btnGrabWindows);
		btnGrabWindows.setActionCommand("GrabWindows");
		btnGrabWindows.addActionListener(this);
		
		JButton btnBtn = new JButton("Btn");
		GridBagConstraints gbc_btnBtn = new GridBagConstraints();
		gbc_btnBtn.fill = GridBagConstraints.BOTH;
		gbc_btnBtn.insets = new Insets(0, 0, 5, 5);
		gbc_btnBtn.gridx = 2;
		gbc_btnBtn.gridy = 0;
		frmChipondeckController.getContentPane().add(btnBtn, gbc_btnBtn);
		btnBtn.addActionListener(this);
		
		JComboBox comboBox_SelectWindow = new JComboBox();
		GridBagConstraints gbc_comboBox_SelectWindow = new GridBagConstraints();
		gbc_comboBox_SelectWindow.gridwidth = 2;
		gbc_comboBox_SelectWindow.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_SelectWindow.fill = GridBagConstraints.BOTH;
		gbc_comboBox_SelectWindow.gridx = 3;
		gbc_comboBox_SelectWindow.gridy = 0;
		frmChipondeckController.getContentPane().add(comboBox_SelectWindow, gbc_comboBox_SelectWindow);
		
		JComboBox comboBox_PlayerStatus = new JComboBox();
		GridBagConstraints gbc_comboBox_PlayerStatus = new GridBagConstraints();
		gbc_comboBox_PlayerStatus.gridwidth = 2;
		gbc_comboBox_PlayerStatus.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_PlayerStatus.fill = GridBagConstraints.BOTH;
		gbc_comboBox_PlayerStatus.gridx = 5;
		gbc_comboBox_PlayerStatus.gridy = 0;
		frmChipondeckController.getContentPane().add(comboBox_PlayerStatus, gbc_comboBox_PlayerStatus);
		
		JButton btnPokerApp = new JButton("PokerApp");
		GridBagConstraints gbc_btnPokerApp = new GridBagConstraints();
		gbc_btnPokerApp.fill = GridBagConstraints.BOTH;
		gbc_btnPokerApp.insets = new Insets(0, 0, 5, 5);
		gbc_btnPokerApp.gridx = 0;
		gbc_btnPokerApp.gridy = 1;
		frmChipondeckController.getContentPane().add(btnPokerApp, gbc_btnPokerApp);
		
		JButton btnTableSelection = new JButton("TableSelection");
		GridBagConstraints gbc_btnTableSelection = new GridBagConstraints();
		gbc_btnTableSelection.fill = GridBagConstraints.BOTH;
		gbc_btnTableSelection.insets = new Insets(0, 0, 5, 5);
		gbc_btnTableSelection.gridx = 1;
		gbc_btnTableSelection.gridy = 1;
		frmChipondeckController.getContentPane().add(btnTableSelection, gbc_btnTableSelection);
		
		JButton btnGo_Comboboxes = new JButton("GO");
		GridBagConstraints gbc_btnGo_Comboboxes = new GridBagConstraints();
		gbc_btnGo_Comboboxes.fill = GridBagConstraints.BOTH;
		gbc_btnGo_Comboboxes.gridheight = 2;
		gbc_btnGo_Comboboxes.insets = new Insets(0, 0, 5, 0);
		gbc_btnGo_Comboboxes.gridx = 7;
		gbc_btnGo_Comboboxes.gridy = 0;
		frmChipondeckController.getContentPane().add(btnGo_Comboboxes, gbc_btnGo_Comboboxes);
		
		JButton btnBtn_1 = new JButton("Btn2");
		GridBagConstraints gbc_btnBtn_1 = new GridBagConstraints();
		gbc_btnBtn_1.fill = GridBagConstraints.BOTH;
		gbc_btnBtn_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnBtn_1.gridx = 2;
		gbc_btnBtn_1.gridy = 1;
		frmChipondeckController.getContentPane().add(btnBtn_1, gbc_btnBtn_1);
		
		JComboBox comboBox_SelectWindowAction = new JComboBox();
		GridBagConstraints gbc_comboBox_SelectWindowAction = new GridBagConstraints();
		gbc_comboBox_SelectWindowAction.gridwidth = 2;
		gbc_comboBox_SelectWindowAction.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_SelectWindowAction.fill = GridBagConstraints.BOTH;
		gbc_comboBox_SelectWindowAction.gridx = 3;
		gbc_comboBox_SelectWindowAction.gridy = 1;
		frmChipondeckController.getContentPane().add(comboBox_SelectWindowAction, gbc_comboBox_SelectWindowAction);
		
		JComboBox comboBox_PlayerAction = new JComboBox();
		GridBagConstraints gbc_comboBox_PlayerAction = new GridBagConstraints();
		gbc_comboBox_PlayerAction.gridwidth = 2;
		gbc_comboBox_PlayerAction.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_PlayerAction.fill = GridBagConstraints.BOTH;
		gbc_comboBox_PlayerAction.gridx = 5;
		gbc_comboBox_PlayerAction.gridy = 1;
		frmChipondeckController.getContentPane().add(comboBox_PlayerAction, gbc_comboBox_PlayerAction);
		
		Panel panelTablesDisplay = new Panel();
		panelTablesDisplay.setBackground(Color.ORANGE);
		GridBagConstraints gbc_panelTablesDisplay = new GridBagConstraints();
		gbc_panelTablesDisplay.fill = GridBagConstraints.BOTH;
		gbc_panelTablesDisplay.gridheight = 4;
		gbc_panelTablesDisplay.gridwidth = 8;
		gbc_panelTablesDisplay.insets = new Insets(0, 0, 5, 0);
		gbc_panelTablesDisplay.gridx = 0;
		gbc_panelTablesDisplay.gridy = 3;
		frmChipondeckController.getContentPane().add(panelTablesDisplay, gbc_panelTablesDisplay);
		
		JPanel panelPocket = new JPanel();
		panelPocket.setBackground(Color.PINK);
		GridBagConstraints gbc_panelPocket = new GridBagConstraints();
		gbc_panelPocket.gridwidth = 2;
		gbc_panelPocket.insets = new Insets(0, 0, 5, 5);
		gbc_panelPocket.fill = GridBagConstraints.BOTH;
		gbc_panelPocket.gridx = 0;
		gbc_panelPocket.gridy = 7;
		frmChipondeckController.getContentPane().add(panelPocket, gbc_panelPocket);
		
		JPanel panelCommunity = new JPanel();
		panelCommunity.setBackground(Color.GREEN);
		GridBagConstraints gbc_panelCommunity = new GridBagConstraints();
		gbc_panelCommunity.gridwidth = 6;
		gbc_panelCommunity.insets = new Insets(0, 0, 5, 5);
		gbc_panelCommunity.fill = GridBagConstraints.BOTH;
		gbc_panelCommunity.gridx = 2;
		gbc_panelCommunity.gridy = 7;
		frmChipondeckController.getContentPane().add(panelCommunity, gbc_panelCommunity);
		
		JLabel lblBet = new JLabel("Bet");
		GridBagConstraints gbc_lblBet = new GridBagConstraints();
		gbc_lblBet.fill = GridBagConstraints.BOTH;
		gbc_lblBet.insets = new Insets(0, 0, 5, 5);
		gbc_lblBet.gridx = 0;
		gbc_lblBet.gridy = 9;
		frmChipondeckController.getContentPane().add(lblBet, gbc_lblBet);
		
		JLabel lblPot = new JLabel("Pot");
		GridBagConstraints gbc_lblPot = new GridBagConstraints();
		gbc_lblPot.fill = GridBagConstraints.BOTH;
		gbc_lblPot.insets = new Insets(0, 0, 5, 5);
		gbc_lblPot.gridx = 1;
		gbc_lblPot.gridy = 9;
		frmChipondeckController.getContentPane().add(lblPot, gbc_lblPot);
		
		JLabel lblBetpPot = new JLabel("BetPpot");
		GridBagConstraints gbc_lblBetpPot = new GridBagConstraints();
		gbc_lblBetpPot.fill = GridBagConstraints.BOTH;
		gbc_lblBetpPot.insets = new Insets(0, 0, 5, 5);
		gbc_lblBetpPot.gridx = 2;
		gbc_lblBetpPot.gridy = 9;
		frmChipondeckController.getContentPane().add(lblBetpPot, gbc_lblBetpPot);
		
		JLabel lblCash = new JLabel("Cash");
		GridBagConstraints gbc_lblCash = new GridBagConstraints();
		gbc_lblCash.fill = GridBagConstraints.BOTH;
		gbc_lblCash.insets = new Insets(0, 0, 5, 5);
		gbc_lblCash.gridx = 3;
		gbc_lblCash.gridy = 9;
		frmChipondeckController.getContentPane().add(lblCash, gbc_lblCash);
		
		JButton btnXBet = new JButton("x Bet");
		GridBagConstraints gbc_btnXBet = new GridBagConstraints();
		gbc_btnXBet.fill = GridBagConstraints.BOTH;
		gbc_btnXBet.insets = new Insets(0, 0, 5, 5);
		gbc_btnXBet.gridx = 4;
		gbc_btnXBet.gridy = 9;
		frmChipondeckController.getContentPane().add(btnXBet, gbc_btnXBet);
		
		JButton btnNone = new JButton("None");
		GridBagConstraints gbc_btnNone = new GridBagConstraints();
		gbc_btnNone.fill = GridBagConstraints.BOTH;
		gbc_btnNone.insets = new Insets(0, 0, 5, 5);
		gbc_btnNone.gridx = 5;
		gbc_btnNone.gridy = 9;
		frmChipondeckController.getContentPane().add(btnNone, gbc_btnNone);
		
		JButton btnFold = new JButton("FOLD");
		GridBagConstraints gbc_btnFold = new GridBagConstraints();
		gbc_btnFold.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFold.gridwidth = 2;
		gbc_btnFold.insets = new Insets(0, 0, 5, 0);
		gbc_btnFold.gridx = 6;
		gbc_btnFold.gridy = 9;
		frmChipondeckController.getContentPane().add(btnFold, gbc_btnFold);
		
		textFieldActionCash = new JTextField();
		textFieldActionCash.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldActionCash.setFont(textFieldActionCash.getFont().deriveFont(textFieldActionCash.getFont().getSize() + 30f));
		GridBagConstraints gbc_textFieldActionCash = new GridBagConstraints();
		gbc_textFieldActionCash.gridheight = 3;
		gbc_textFieldActionCash.gridwidth = 4;
		gbc_textFieldActionCash.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldActionCash.fill = GridBagConstraints.BOTH;
		gbc_textFieldActionCash.gridx = 0;
		gbc_textFieldActionCash.gridy = 10;
		frmChipondeckController.getContentPane().add(textFieldActionCash, gbc_textFieldActionCash);
		textFieldActionCash.setColumns(10);
		
		JButton btnPBet = new JButton("% Bet");
		GridBagConstraints gbc_btnPBet = new GridBagConstraints();
		gbc_btnPBet.fill = GridBagConstraints.BOTH;
		gbc_btnPBet.insets = new Insets(0, 0, 5, 5);
		gbc_btnPBet.gridx = 4;
		gbc_btnPBet.gridy = 10;
		frmChipondeckController.getContentPane().add(btnPBet, gbc_btnPBet);
		
		JToggleButton tglbtnMin = new JToggleButton("Min");
		GridBagConstraints gbc_tglbtnMin = new GridBagConstraints();
		gbc_tglbtnMin.fill = GridBagConstraints.BOTH;
		gbc_tglbtnMin.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnMin.gridx = 5;
		gbc_tglbtnMin.gridy = 10;
		frmChipondeckController.getContentPane().add(tglbtnMin, gbc_tglbtnMin);
		
		JButton btnCheck = new JButton("CHECK");
		GridBagConstraints gbc_btnCheck = new GridBagConstraints();
		gbc_btnCheck.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCheck.gridwidth = 2;
		gbc_btnCheck.insets = new Insets(0, 0, 5, 0);
		gbc_btnCheck.gridx = 6;
		gbc_btnCheck.gridy = 10;
		frmChipondeckController.getContentPane().add(btnCheck, gbc_btnCheck);
		
		JButton btnXPot = new JButton("x Pot");
		GridBagConstraints gbc_btnXPot = new GridBagConstraints();
		gbc_btnXPot.fill = GridBagConstraints.BOTH;
		gbc_btnXPot.insets = new Insets(0, 0, 5, 5);
		gbc_btnXPot.gridx = 4;
		gbc_btnXPot.gridy = 11;
		frmChipondeckController.getContentPane().add(btnXPot, gbc_btnXPot);
		
		JToggleButton tglbtnMed = new JToggleButton("Med");
		GridBagConstraints gbc_tglbtnMed = new GridBagConstraints();
		gbc_tglbtnMed.fill = GridBagConstraints.BOTH;
		gbc_tglbtnMed.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnMed.gridx = 5;
		gbc_tglbtnMed.gridy = 11;
		frmChipondeckController.getContentPane().add(tglbtnMed, gbc_tglbtnMed);
		
		JButton btnCall = new JButton("CALL");
		GridBagConstraints gbc_btnCall = new GridBagConstraints();
		gbc_btnCall.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCall.gridwidth = 2;
		gbc_btnCall.insets = new Insets(0, 0, 5, 0);
		gbc_btnCall.gridx = 6;
		gbc_btnCall.gridy = 11;
		frmChipondeckController.getContentPane().add(btnCall, gbc_btnCall);
		
		JButton btnPPot = new JButton("% Pot");
		GridBagConstraints gbc_btnPPot = new GridBagConstraints();
		gbc_btnPPot.fill = GridBagConstraints.BOTH;
		gbc_btnPPot.insets = new Insets(0, 0, 5, 5);
		gbc_btnPPot.gridx = 4;
		gbc_btnPPot.gridy = 12;
		frmChipondeckController.getContentPane().add(btnPPot, gbc_btnPPot);
		
		JToggleButton tglbtnMax = new JToggleButton("Max");
		GridBagConstraints gbc_tglbtnMax = new GridBagConstraints();
		gbc_tglbtnMax.fill = GridBagConstraints.BOTH;
		gbc_tglbtnMax.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnMax.gridx = 5;
		gbc_tglbtnMax.gridy = 12;
		frmChipondeckController.getContentPane().add(tglbtnMax, gbc_tglbtnMax);
		
		JButton btnBetRaise = new JButton("BET / RAISE");
		GridBagConstraints gbc_btnBetRaise = new GridBagConstraints();
		gbc_btnBetRaise.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBetRaise.insets = new Insets(0, 0, 5, 0);
		gbc_btnBetRaise.gridwidth = 2;
		gbc_btnBetRaise.gridx = 6;
		gbc_btnBetRaise.gridy = 12;
		frmChipondeckController.getContentPane().add(btnBetRaise, gbc_btnBetRaise);
		
		JSlider slider = new JSlider();
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.fill = GridBagConstraints.BOTH;
		gbc_slider.gridwidth = 6;
		gbc_slider.insets = new Insets(0, 0, 5, 5);
		gbc_slider.gridx = 0;
		gbc_slider.gridy = 14;
		frmChipondeckController.getContentPane().add(slider, gbc_slider);
		
		JToggleButton tglbtnAutoplay = new JToggleButton("AutoPlay");
		GridBagConstraints gbc_tglbtnAutoplay = new GridBagConstraints();
		gbc_tglbtnAutoplay.fill = GridBagConstraints.BOTH;
		gbc_tglbtnAutoplay.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnAutoplay.gridwidth = 2;
		gbc_tglbtnAutoplay.gridx = 6;
		gbc_tglbtnAutoplay.gridy = 14;
		frmChipondeckController.getContentPane().add(tglbtnAutoplay, gbc_tglbtnAutoplay);
		
		Canvas canvas = new Canvas();
		GridBagConstraints gbc_canvas = new GridBagConstraints();
		gbc_canvas.fill = GridBagConstraints.BOTH;
		gbc_canvas.gridwidth = 6;
		gbc_canvas.insets = new Insets(0, 0, 0, 5);
		gbc_canvas.gridx = 0;
		gbc_canvas.gridy = 15;
		frmChipondeckController.getContentPane().add(canvas, gbc_canvas);
		
		JButton btnGo = new JButton("GO");
		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.fill = GridBagConstraints.BOTH;
		gbc_btnGo.gridwidth = 2;
		gbc_btnGo.gridx = 6;
		gbc_btnGo.gridy = 15;
		frmChipondeckController.getContentPane().add(btnGo, gbc_btnGo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		System.out.println("You clicked a button " + clickedButton.getActionCommand());
	}

}
