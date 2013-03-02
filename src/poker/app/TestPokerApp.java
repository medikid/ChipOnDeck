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
import poker.app.table.PNTable;
import poker.app.table.TableRegion;

public class TestPokerApp  {
	public Point startPoint;
	int rule = AlphaComposite.SRC_OVER;
    float alpha = 0.85F;


	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		TestPokerApp tpa = new TestPokerApp();
		DesktopScreen desktop = new DesktopScreen(0);		
		ScreenRegion sr = new DesktopScreenRegion(desktop.getBounds().x, desktop.getBounds().y, desktop.getBounds().width, desktop.getBounds().height);
				
		TableRegion tr = new TableRegion(sr);
		tr.setTableFrame();
		tr.hightlightTableFrame(1);
//		tr.deriveTableFrameGrids();
		tr.derivePlayerDash();
		
		

		
				
		
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
