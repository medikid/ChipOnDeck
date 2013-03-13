package poker.API;

import java.awt.AWTException;
import java.awt.Robot;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.robot.desktop.DesktopScreen;
import org.sikuli.api.visual.DesktopCanvas;
import org.sikuli.api.visual.ScreenPainter;
import org.sikuli.api.visual.ScreenRegionCanvas;

import poker.app.logger.Logger;

public class PokerAPIConstants {
	
	//APP RELATED CONSTANTS
	public static final String PlayNow_USERNAME = "ragavgroups";
	public static final String PlayNow_PASSWORD = "Ragav76";
	public static final String POKER_APP_PROVIDER = "Poker PlayNow.com";
	public static final String PATH_EXE = "C:\\Program Files\\" + POKER_APP_PROVIDER +"\\poker.exe";
	public static final String VMWARE_PLAYER_PATH = "F:\\VMware\\VMWare Player\\vmplayer";
	public static final String VMWARE_MACHINE_PATH = "\"F:\\VMware\\VMWare Machines\\Windows 7\\Windows 7.vmx";
	
	
	
	public static String POKER_TYPE = null;
	public static final  String PATH_IMAGE_FOLDER = "\\images" + "\\chinnu-acer";
	public static final  String APP_WINDOW_TITLE = "Poker | PlayNow.com";
	public static  Object AppWindowTitle = null;	

	public static DesktopScreen desktopScreen = null;
	public static ScreenRegion MAIN_SCREEN = null;	
	public Logger Logger = null;
	public static Mouse mouse = null;
	public static Keyboard keyboard = null;
	public static ScreenRegionCanvas canvas = null;
	public static DesktopCanvas desktopRegionCanvas = null;
	public static ScreenPainter painter = null;
	public static Robot robot = null;
	public static DesktopScreenRegion selectedScreenRegion = null;	

	
}
