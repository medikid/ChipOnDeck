package poker.test;

import poker.app.GUI.Controller.Controller;
import poker.app.GUI.Controller.ControllerGUI;
import poker.app.GUI.Controller.TablesDisplayPanel;
import poker.app.GUI.Displayer.GlassOverlay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import java.awt.AWTException;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.io.File;
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
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout.Constraints;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

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

import com.sun.jna.platform.win32.Netapi32Util.User;
import com.sun.jna.platform.win32.WinDef.HWND;

import poker.API.PokerAPI;
import poker.API.User32;
import poker.utils.Timer.TimerListener;
import poker.app.VMWare.PLAY_MODE;
import poker.app.Window;
import poker.app.WindowManager;
import poker.app.WindowManager.WindowType;
import poker.app.XML.SessionParser;
import poker.app.config.AppConfig;
import poker.game.tools.tables.ETableType;
import poker.game.tools.tables.PNTable;
import poker.game.tools.tables.Table;
import poker.game.tools.tables.TableRegion;
import poker.resources.Image;

public class TestPokerApp  {
	public Point startPoint;
	int rule = AlphaComposite.SRC_OVER;
    float alpha = 0.85F;
	
	
		public String s;
		
		public void setString(String S){
			this.s = S;
		}
		public String getString(){
			return this.s;
		}
	
	

	@SuppressWarnings({ "unused", "static-access" })
	public static void main(String[] args) throws Exception {
		TestPokerApp tpa = new TestPokerApp();
		
		//ControllerGUI.main(null);
		
		Controller c = new Controller();
		c.GrabWindows();
		c.TileTables();
		c.initializeTableObjects();
		
		
		//Window w =new Window(WindowType.TABLE, "Table:", null, new Rectangle(0, 0, 918, 720));
		//TableRegion t = new TableRegion(w);
		
		
		/*
		c.displayer.dPanel.add(jp, BorderLayout.SOUTH);
		jp.setVisible(true);
		c.displayer.dPanel.revalidate();
		c.displayer.dPanel.repaint();
		*/
	
	}
	
	
}
