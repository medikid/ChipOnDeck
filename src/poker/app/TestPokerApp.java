package poker.app;

import java.awt.event.KeyEvent;
import java.awt.AWTException;
import java.awt.Robot;

import org.sikuli.api.*;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.ScreenPainter;
import org.sikuli.script.*;
import org.sikuli.core.*;
import org.sikuli.ocr.*;

public class TestPokerApp {
	
	public static void main(String[] args) throws AWTException, InterruptedException{
		PlayNowApp PNApp = new PlayNowApp();
		PNApp.Open();
		Thread.sleep(12000);
		PNApp.Maximize();
		
	//	PNApp.FindImageAndClickCenter("chinnu-acer", "password-fld", "png");
//		PNApp.Login();
		PNApp.FindTables("texas holdem",  true);
		PNApp.SelectTable();
		PNApp.JoinTable();
//		PNApp.Close();
		
/*
		keyboard.keyDown(KeyModifier.WIN);
		keyboard.type("r");
		keyboard.keyUp(KeyModifier.WIN);

		Thread.sleep(5);
		keyboard.keyDown( Key.DELETE);
		keyboard.keyUp( Key.DELETE);
		keyboard.paste("C:\\Program Files (x86)\\Poker Heaven\\poker.exe");
	*/	
	}
	
}
