package poker.app;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.sikuli.api.robot.Key;
import org.sikuli.api.robot.KeyModifier;
import org.sikuli.api.visual.ScreenRegionCanvas;

import poker.API.PokerAPI;

public class VMWare extends PokerAPI {
	public enum PLAY_MODE { UNITY_MODE, FULLSCREEN_MODE }
	
	public VMWare() throws AWTException{
		super();
	}
	
	public void open(PLAY_MODE mode){
		Runtime rt = Runtime.getRuntime();
		try {
			switch(mode){
			case FULLSCREEN_MODE:
				rt.exec( VMWARE_PLAYER_PATH + " -X " + VMWARE_MACHINE_PATH );
				break;
			case UNITY_MODE:
				rt.exec( VMWARE_PLAYER_PATH + " -U " + VMWARE_MACHINE_PATH );
				break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(){
		
	}
	
	public void activateMenu() throws AWTException{	
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SHIFT);
		
		robot.keyPress(KeyEvent.VK_U);
		robot.keyRelease(KeyEvent.VK_U);
		
		robot.delay(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}
	
	public void openMenu(String menuName) throws AWTException{
		switch(menuName){
			case "run":
				this.activateMenu();
				robot.delay(2000);
				 robot.keyPress(KeyEvent.VK_R);
				 robot.keyRelease(KeyEvent.VK_R);
				 
				 robot.delay(2000);
				 this.FindImageAndClickCenter("system", "run-open-field", "png");
				 robot.delay(1000);
				 keyboard.type(PATH_EXE);
				 
				 robot.delay(1000);
				 robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			break;
		}
	}
	
	public void powerOn(){
		
	}
	
	public void powerOff(){
		
	}
	
	public void startUnityMode(){
		
	}
	
	public void stopUnityMode(){
		
	}
	
	public void launchOS(){
		
	}
	
	public boolean isVMWareOpen(){
		boolean VMWareOpen = false;
		
		return VMWareOpen;
	}
	
	public boolean isUnityMode(){
		boolean UnityMode = false;
		
		return UnityMode;
	}
	

}
