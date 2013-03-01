package poker.app;


import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

import java.awt.AWTException;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.eclipse.swt.widgets.Display;
import org.sikuli.api.*;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.robot.desktop.DesktopScreen;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;
import org.sikuli.api.visual.ScreenPainter;
import org.sikuli.core.*;
import org.sikuli.ocr.*;
import org.sikuli.script.Region;

import poker.PokerAPI;
import poker.User32;
import poker.app.Timer.TimerListener;
import poker.app.VMWare.PLAY_MODE;
import poker.app.WindowManager.WindowType;
import poker.app.table.PlayNowTable;

public class TestPokerApp  {
	public Point startPoint;
	int rule = AlphaComposite.SRC_OVER;
    float alpha = 0.85F;


	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		TestPokerApp tpa = new TestPokerApp();
		DesktopScreen desktop = new DesktopScreen(0);
		DesktopMouse mouse = new DesktopMouse();
		System.out.println("The screen size is " + desktop.getBounds().toString() +"The mouse is at position " + mouse.getLocation().toString());
		
		ScreenRegion sr = new DesktopScreenRegion(0, 0, 1300, 750);
		/*
		Canvas c = new DesktopCanvas();
		c.addBox(sr).display(3);
		
		PokerAPI pki = new PokerAPI();
		Target instant_hand_replay_btn = pki.GetImageTarget("chinnu-acer", "instant-hand-replay-btn", "png");
		Target chips_tray = pki.GetImageTarget("chinnu-acer", "chips-tray", "png");
		Target chat_send_box = pki.GetImageTarget("chinnu-acer", "chat-send-box", "png");
		Target announcer_chair = pki.GetImageTarget("chinnu-acer", "announcer-chair", "png");
		
		List<ScreenRegion> matches = new ArrayList<ScreenRegion>();
		ScreenRegion ihrb = sr.find(instant_hand_replay_btn);
		ScreenRegion csb = sr.find(chat_send_box);
		ScreenRegion ac = sr.find(announcer_chair);
		
		ScreenRegion tableFrame = new DesktopScreenRegion(
						ihrb.getBounds().x,
						ihrb.getBounds().y,
						(ac.getBounds().x + ac.getBounds().width) - ihrb.getBounds().x,
						(csb.getBounds().y + csb.getBounds().height) - ihrb.getBounds().y);
		c.addBox(ihrb).display(3);
		c.addBox(csb).display(3);
		c.addBox(ac).display(3);
		c.addBox(tableFrame).display(3);
		
		
		
		*/
		
		PlayNowApp pna = new PlayNowApp();
	//	pna.Open();
		WindowManager wm = new WindowManager();
		wm.refresh();		
		wm.setWindowActive(WindowType.VMWARE, "VMware Player");
		
		
	}
	
}
