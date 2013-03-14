package poker.app.GUI.Controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import poker.app.Window;
import poker.app.WindowManager;
import poker.app.WindowManager.WindowType;
import poker.app.GUI.Controller.ControllerGUI;
import poker.app.GUI.Displayer.GlassOverlay;
import poker.game.tools.tables.Table;
import poker.game.tools.tables.Tables;

public class Controller {
	public ControllerGUI  cGUI;
	public Tables	tables;
	public GlassOverlay	glass;
	public WindowManager wManager;
	Boolean isDisplayerEnabled = true;
	Boolean isControllerGUIEnabled = true;
	Boolean isVMWareModeEnabled = true;
	
	public Controller(){

		this.wManager = new WindowManager();
		
		if (isDisplayerEnabled){
			this.glass = new GlassOverlay();
		}
		
		if (isControllerGUIEnabled){
						
		}
	}
	
	/*
	 * GUI Related Functions
	 */
	
	public void StartGUI(){
		ControllerGUI.main(null);		
	}

	/*
	 * Window Related Functions
	 */
	public void GrabWindows(){
		this.wManager.grabWindowsByKeywordList();
	}
	
	public void TileTables(){
		this.wManager.tileTables();
	}
	
	/*
	 * Poker App related Functions
	 */
	
	
	/*
	 * Table Related Functions
	 */
	public void initializeTableObjects(){
		for(String tableTitle: this.wManager.Tables){
			Window tableWindow = this.wManager.Windows.get(tableTitle);
			Table t = new Table(tableWindow);
			t.setTableName(tableTitle);
			
			this.glass.dPanel.PaintObj.GridLines(t, 5, 6);
		}
	}
	
}
