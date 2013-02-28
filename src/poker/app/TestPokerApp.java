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
import java.util.List;

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
import org.sikuli.api.visual.ScreenPainter;
import org.sikuli.core.*;
import org.sikuli.ocr.*;
import org.sikuli.script.Region;

import poker.PokerAPI;
import poker.User32;
import poker.app.Timer.TimerListener;
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
		
		//WindowManager wm = new WindowManager();
		//wm.findAllWindows("Poker | PlayNow.com");
		
		EnumAllWindows.main(null);
		/*
		//wm.tileWindows();
		//String title = "Table 2 - MicroBBJ/LotC-C 24 - Table: 11736250 - Poker | PlayNow.com - [Windows 7]";
		//int wInd = wm.getWindowByTitle(title);
		
		List<Rectangle> rects = wm.getDesktopGrid(4);
		
		int wInd = 0;
		Rectangle r = new Rectangle(0,0,500,500);
		Window w = wm.Windows.get(wInd);
		wm.setWindowActive(w.getWindowHandle());
		w.moveNfit(r);
//		wm.fitNmoveWindow(w.getWindowHandle(), rects.get(wInd), true);
//		wm.fitNmoveWindow(w.getWindowHandle(), new Rectangle(0,0,500,500), true);
		System.out.println("Window " + w.getWindowTitle() + " is retrieved with hwnd of " + w.getWindowHandle().toString());
		
		int wInd1 = 1;
		Rectangle r1 = new Rectangle(500, 0, 500, 500);
		Window w1 = wm.Windows.get(wInd1);
		wm.setWindowActive(w1.getWindowHandle());
		w1.moveNfit(r1);
	//	wm.user32.MoveWindow(w1.getWindowHandle(), 0, 0, 500, 500, true);
//		wm.fitNmoveWindow(w1.getWindowHandle(), rects.get(wInd1), true);
//		wm.fitNmoveWindow(w1.getWindowHandle(), new Rectangle(500,0,500,500), true);
		System.out.println("Window " + w1.getWindowTitle() + " is retrieved with hwnd of " + w1.getWindowHandle().toString());
		
		int wInd2 = 2;
		Rectangle r2 = new Rectangle(0, 500, 500, 500);
		Window w2 = wm.Windows.get(wInd2);
		wm.setWindowActive(w2.getWindowHandle());
		w2.moveNfit(r2);
	//	w2.mouseGlideDrag(new Point(w2.getCorner("leftUpperCorner")), new Point(0, 500));
	//	wm.user32.SetWindowPos(w2.getindowHandle(), User32.HWND_TOPMOST, 0, 500, 500, 500, User32.SWP_DRAWFRAME);
//		wm.fitNmoveWindow(w2.getWindowHandle(), rects.get(wInd2), true);
//		wm.fitNmoveWindow(w2.getWindowHandle(), new Rectangle(0,500,500,500), true);
		System.out.println("Window " + w2.getWindowTitle() + " is retrieved with hwnd of " + w2.getWindowHandle().toString());
		
		int wInd3 = 3;
		Rectangle r3 = new Rectangle(500, 500, 500, 500);
		Window w3 = wm.Windows.get(wInd3);
		w3.moveNfit(r3);
//		wm.setWindowActive(w3.getWindowHandle());
//		wm.fitNmoveWindow(w3.getWindowHandle(), rects.get(wInd3), true);
//		wm.user32.MoveWindow(w3.getWindowHandle(), 500, 500, 500, 500, true);
//		wm.fitNmoveWindow(w3.getWindowHandle(), new Rectangle(500,500,500,500), true);
		System.out.println("Window " + w3.getWindowTitle() + " is retrieved with hwnd of " + w3.getWindowHandle().toString());
		
		*/
		
		/*
		//w.resize(500, 500);
		w1.move(0, 0);
		w1.resize(500, 450);
		//w.mouseGlide(new Point(476, 251), new Point(1176, 951));
		
		Thread.sleep(3000);
		w2.focus();
		Thread.sleep(5000);
		//w.resize(500, 500);
		w2.move(510, 0);
		w2.resize(500, 450);
		//w.mouseGlide(new Point(476, 251), new Point(1176, 951));
		
		Thread.sleep(3000);
		*/
	}
	
}
