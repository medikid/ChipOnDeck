package poker.app.test;

import poker.app.WindowManager;
import poker.app.GUI.Displayer.*;

public class Controller {
	WindowManager wManager;
	ControllerGUI GUI;
	GlassOverlay glassPanel;
	
	public Controller(){
		this.INIT();
	}
	
	public void INIT(){
		wManager = new WindowManager();
		glassPanel = new GlassOverlay();
		GUI = new ControllerGUI();
	}
	
	public void main(String[] args){
		new Controller();
	}

}
