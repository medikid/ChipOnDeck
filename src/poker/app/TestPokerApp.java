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
import java.net.InetAddress;
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
import org.sikuli.api.visual.ScreenRegionCanvas;
import org.sikuli.core.*;
import org.sikuli.ocr.*;
import org.sikuli.script.Region;

import poker.PokerAPI;
import poker.User32;
import poker.Images;
import poker.app.Timer.TimerListener;
import poker.app.VMWare.PLAY_MODE;
import poker.app.WindowManager.WindowType;
import poker.app.table.PlayNowTable;
import poker.app.table.TableRegion;

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
		ScreenRegionCanvas canvas = new DesktopCanvas();
		StyledRectangleTarget t1 = new StyledRectangleTarget(Images.PlayerDashTemplate1); //10 matches found
		StyledRectangleTarget t2 = new StyledRectangleTarget(Images.PlayerDashTemplate2); // 1 match
		StyledRectangleTarget t3 = new StyledRectangleTarget(Images.PlayerDashTemplate3); // 0 matches
		StyledRectangleTarget t4 = new StyledRectangleTarget(Images.PlayerDashTemplate4); // 0 matches
		StyledRectangleTarget t5 = new StyledRectangleTarget(Images.PlayerDashTemplate5); // 15 matches
		StyledRectangleTarget t6 = new StyledRectangleTarget(Images.PlayerDashTemplate6); //11matches
		StyledRectangleTarget t7 = new StyledRectangleTarget(Images.PlayerDashTemplate7); 
		StyledRectangleTarget t8 = new StyledRectangleTarget(Images.PlayerDashTemplate8); 
		StyledRectangleTarget t9 = new StyledRectangleTarget(Images.PlayerDashTemplate10); 
		Target t10 = new ImageTarget(Images.PlayerDashTemplate10); // 9 matches with min score of 0.95
		Target t11 = new ImageTarget(Images.PlayerDashTemplate7);

		
		t10.setMinScore(0.94);
//		List<ScreenRegion> tmatches = t10.doFindAll(sr);
		List<ScreenRegion> matches = sr.findAll(t10);
		System.out.println("Found " + String.valueOf(matches.size()) + " matches with min score of " + String.valueOf(t10.getMinScore()) );
		
		for(ScreenRegion match : matches){
			canvas.addBox(match).display(3);
			canvas.addLabel(match, String.valueOf(match.getScore()) );
		}
		*/
		
		TableRegion tr = new TableRegion(sr);
		tr.setTableFrame();
		tr.hightlightTableFrame(5);
		tr.deriveTableFrameGrids();
//		tr.derivePlayerDash();
		
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
		
				
		
	}
	
	public String getComputerName(){
		String computerName = null;
		try {
		    computerName = InetAddress.getLocalHost().getHostName();
		    System.out.println("COmputer name is " + computerName.toString());
		} catch(Exception ex) {
		   
		}
		
		return computerName;
	}
	
}
