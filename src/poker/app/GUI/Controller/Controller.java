package poker.app.GUI.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import poker.app.Window;
import poker.app.WindowManager;
import poker.app.WindowManager.WindowType;
import poker.app.GUI.Controller.ControllerGUI;
import poker.app.GUI.Displayer.GlassOverlay;
import poker.game.tools.tables.Tables;

public class Controller {
	ControllerGUI  controllerGUI;
	Tables	tables;
	GlassOverlay	displayer;
	public WindowManager wManager;
	
	public Controller(Boolean isDisplayerEnabled, Boolean isControllerGUIEnabled){

		this.wManager = new WindowManager();
		
		if (isDisplayerEnabled){
			this.displayer = new GlassOverlay();
		}
		
		if (isControllerGUIEnabled){
			this.controllerGUI = new ControllerGUI();
			this.controllerGUI.main(null);
		}
		
		
		
	}
	
	public void main(String[] args){
		new Controller(true, true);
	}
	
	public void GrabAllWindows(){
		Map<WindowType, String> kwList = new HashMap<WindowType, String>();
		kwList.put(WindowType.LOBBY, "Poker | PlayNow.com");
		kwList.put(WindowType.VMWARE, "VMWare");
		kwList.put(WindowType.TABLE, "Table:");
		
		//this.wManager.Windows = this.wManager.getWindows(WindowType.TABLE, "Table");
		
		this.wManager.grabWindowsByKeywordList();
		System.out.println(this.wManager.toString());
	}
	

	
}
