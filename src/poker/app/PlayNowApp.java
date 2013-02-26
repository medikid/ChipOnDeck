package poker.app;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.TextTarget;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;
import org.sikuli.api.visual.ScreenPainter;
import org.sikuli.script.App;

import poker.PokerAPI;
import poker.app.logger.Logger;

public class PlayNowApp extends PokerAPI {	
	
	
	
	public PlayNowApp() throws AWTException{
		robot = new Robot();
		MAIN_SCREEN = new DesktopScreenRegion();
		
		Logger.PrintLog("Consrtuctor", "PlayNowApp obj initiated");
	}
	
	
	public void LaunchVMWarePlayer(){
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec( this.VMWARE_PLAYER_PATH + " -X " + this.VMWARE_MACHINE_PATH );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void switchToVMWarePlayer(){
		App vmApp = new App("Windows 7 - VMware Player(Non-commercial use only)" );
		vmApp.focus(1);
	}
	
	public void Open(){
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		keyboard.type(PATH_EXE);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Logger.PrintLog("Open", "Opened Playnow App");
	}
	
	public void Close(){
		App.focusedWindow().highlight(10);
		App.close(APP_WINDOW_TITLE);
		Logger.PrintLog("Close", "Closed Playnow App");
	}
	
	public void Maximize(){	
		this.FindImageAndClickCenter("chinnu-acer", "maximize-btn", "png");		
	}
	
	public static void Minimize(){
		
	}
	
	public void Login(){
		this.FindImageAndClickCenter("chinnu-acer", "login-btn", "png");
		this.FindImageAndClickCenter("chinnu-acer", "password-fld", "png");
		this.keyboard.type(PlayNow_PASSWORD);
		this.FindImageAndClickCenter("chinnu-acer", "login-btn", "png");
	}
	
	private void SetPokerVariant(String pokerType){
		this.POKER_TYPE = pokerType.toLowerCase();
	}
	
	public void FindTables(String pokerType, Boolean practiceMode){
		this.SetPokerVariant(pokerType);
		
		switch(this.POKER_TYPE){
		case "texas holdem":
			this.FindImageAndClickCenter("chinnu-acer", "texas-holdem-btn", "png");
			break;
		}
		
		if (practiceMode == true){
			this.FindImageAndClickCenter("chinnu-acer", "practice-btn", "png");
		}
		
	}
	
	public void SelectTable(){
		this.FindImageAndClickCenter("chinnu-acer", "go-to-table-btn", "png");
	}
	
	public void JoinTable(){
		this.FindImageAndClickCenter("chinnu-acer", "join-table-btn", "png");
	}

}
