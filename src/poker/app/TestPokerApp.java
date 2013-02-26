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

		String ImageCategory = "chinnu-acer";
		String ImageName = "maximize-btn";
		String ImageExt = "png";
		
		
	
		PokerAPI pki = new PokerAPI();
		Target imgTarget = pki.GetImageTarget(ImageCategory, ImageName, ImageExt);
		System.out.println("Image target is " + imgTarget.toString());
		ScreenRegion sr = pki.getDesktopScreen();
		ScreenRegion match = sr.find(imgTarget);
		pki.imageHighlight(match, "rectangle", 10);
				//		System.out.println("Screen bounds are " + sr.toString() ); //+ " and Image found at " + match.toString());
//		pki.FindImageTargetOnScreen(imgTarget);
   
	}
	
}
