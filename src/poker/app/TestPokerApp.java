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
import java.awt.Robot;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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
		
		EnumAllWindows.main(null);
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
