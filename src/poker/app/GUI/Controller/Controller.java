package poker.app.GUI.Controller;

import poker.app.WindowManager;
import poker.app.GUI.Controller.ControllerGUI;
import poker.app.GUI.Displayer.GlassOverlay;
import poker.app.table.Tables;

public class Controller {
	ControllerGUI  controllerGUI;
	Tables	tables;
	GlassOverlay	displayer;
	WindowManager wManager;
	
	public Controller(Boolean isDisplayerEnabled, Boolean isControllerGUIEnabled){
		if (isDisplayerEnabled){
			displayer = new GlassOverlay();
		}
		
		if (isControllerGUIEnabled){
			controllerGUI = new ControllerGUI();
			controllerGUI.main(null);
		}
		
		wManager = new WindowManager();
		
		
	}
	
	public void main(String[] args){
		new Controller(true, true);
	}
	

	
}
