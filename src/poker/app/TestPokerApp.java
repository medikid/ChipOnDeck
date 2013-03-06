package poker.app;

import poker.app.GUI.GlassOverlay;

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
import java.awt.Graphics2D;
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

import poker.PokerAPI;
import poker.User32;
import poker.Images;
import poker.app.Timer.TimerListener;
import poker.app.VMWare.PLAY_MODE;
import poker.app.WindowManager.WindowType;
import poker.app.table.ETableType;
import poker.app.table.PNTable;
import poker.app.table.Table;
import poker.app.table.TableRegion;

public class TestPokerApp  {
	public Point startPoint;
	int rule = AlphaComposite.SRC_OVER;
    float alpha = 0.85F;


	@SuppressWarnings({ "unused", "static-access" })
	public static void main(String[] args) throws Exception {
		TestPokerApp tpa = new TestPokerApp();
		GlassOverlay gO = new GlassOverlay();
		gO.main(null);
		//poker.app.test.ControllerGUI.main(null);
		
	}
	
	
	
}
