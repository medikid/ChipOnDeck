package poker.app;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.TextTarget;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;
import org.sikuli.api.visual.ScreenPainter;
import org.sikuli.script.App;

import poker.app.logger.Logger;

public class PlayNowApp {
	private String USERNAME = "sam.vict";
	private String PASSWORD = "lubdub123";
	private String POKER_APP_PROVIDER = "Dusk Till Dawn Poker";
	private String PATH_EXE = "C:\\Program Files (x86)\\" + POKER_APP_PROVIDER +"\\poker.exe";
	private String PATH_IMAGE_FOLDER = "\\images" + "\\chinnu-acer";
	private String APP_WINDOW_TITLE = "Poker Heaven";
	private Object AppWindowTitle;
	private ScreenRegion MAIN_SCREEN;
	private Logger Logger = new Logger();
	static Mouse mouse = new DesktopMouse();
	static Keyboard keyboard = new DesktopKeyboard();
	static Canvas canvas = new DesktopCanvas();
	static ScreenPainter painter = new ScreenPainter();
	static Robot robot = null;
	
	public PlayNowApp() throws AWTException{
		robot = new Robot();
		MAIN_SCREEN = new DesktopScreenRegion();
		
		Logger.PrintLog("Consrtuctor", "PlayNowApp obj initiated");
	}
	
	public static void Launch(){
		
	}
	
	public void Open(){
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		keyboard.type(PATH_EXE);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Logger.PrintLog("Open", "Opened Playnow App");
	}
	
	public void Close(){
		App.focusedWindow().highlight(10);
		App.close(APP_WINDOW_TITLE);
		Logger.PrintLog("Close", "Closed Playnow App");
	}
	
	private String _getResourcePath(String ResourceFolder, String FileCategory, String FileName, String FileExt){
		return "/"+ResourceFolder+"/"+FileCategory+"/"+FileName+"."+FileExt;
	}
	
	
	public URL GetImageURL(String ImageCategory, String ImageName, String ImageExt){
		String _localResourcePath = this._getResourcePath("images", ImageCategory, ImageName, ImageExt);
		// Try to grab unknown profile icon from JAR file
		URL picturePath = this.getClass().getResource( _localResourcePath );
		// However, if we are running from Eclipse then no JAR file
		if (picturePath == null) {
		  try {
		    picturePath = new URL("file://" + System.getProperty("user.dir")
		        + _localResourcePath );
		  }
		  catch (MalformedURLException e) {
			System.out.println("Image cannot be found");
		  }
		}
		
		return picturePath;
	}
	
	public Target GetImageTarget(String ImageCategory, String ImageName, String ImageExt){
		URL imgURL = GetImageURL(ImageCategory, ImageName, ImageExt);
		// Define an image target on the screen               
		Target imageTarget = new ImageTarget(imgURL);
		
		Logger.PrintLog("GetImageTarget", "Image Target " + imgURL.toString() + " requested");
		return imageTarget;
	}
	
	public ScreenRegion FindImageTargetOnScreen(Target imgTarget){
		ScreenRegion sr = new DesktopScreenRegion();
		canvas.addBox(sr).display(2);
		ScreenRegion reg = null;
		reg = sr.find(imgTarget);
		canvas.addBox(reg).display(2);
		Logger.PrintLog("FindImageTargetOnScreen", "Image Target " + imgTarget.toString() + " Found at " + reg.toString() );
		
		return reg;
	}
	
	public ScreenRegion FindImageOnScreen(String ImageCategory, String ImageName, String ImageExt){
		Target imgTarget = GetImageTarget(ImageCategory, ImageName, ImageExt);
		ScreenRegion reg = FindImageTargetOnScreen(imgTarget);
		return reg;
	}
	
	public ScreenRegion FindTextOnScreen(String strToFind){
		TextTarget txtTarget = new TextTarget(strToFind);
		ScreenRegion txtImg = MAIN_SCREEN.find(txtTarget);
		return txtImg;
	}
	
	private void _imageClickCenter(ScreenRegion reg){
		Logger.PrintLog("_imageClickCenter", "Image clicked at center " + reg.getCenter().toString());
		mouse.click(reg.getCenter());
	}
	
	public void imageHighlight(ScreenRegion reg, String shape, int duration){
		switch(shape){
		case "rectangle":
			canvas.addBox(reg).display(duration);
			break;
		case "circle":
			canvas.addCircle(reg.getCenter()).display(duration);
			break;
		}		
	}
	
	public void imageBlink(ScreenRegion reg, String shape, int duration){
		Boolean isBlink = true;
		switch(shape){
			case "rectangle":
				for(int i=0; i<duration; i++){			
					if (isBlink == true){
						canvas.addBox(reg).display(1);
						isBlink = false;
					} else isBlink = true;
				}
				break;
			case "circle":
				for(int i=0; i<duration; i++){			
					if (isBlink == true){
						canvas.addCircle(reg.getCenter()).display(1);
						isBlink = false;
					} else isBlink = true;
				}
				break;
		}
		
	}
	
	public void FindImageAndClickCenter(String ImageCategory, String ImageName, String ImageExt){
		ScreenRegion sr = FindImageOnScreen(ImageCategory, ImageName, ImageExt);		
		_imageClickCenter(sr);
	}
	
	public void Maximize(){	
		this.FindImageAndClickCenter("chinnu-acer", "maximize-btn", "png");		
	}
	
	public static void Minimize(){
		
	}
	
	public void Login(){
		this.FindImageAndClickCenter("chinnu-acer", "login-btn", "png");
		this.FindImageAndClickCenter("chinnu-acer", "password-fld", "png");
		this.keyboard.type(PASSWORD);
		this.FindImageAndClickCenter("chinnu-acer", "login-btn", "png");
	}
	
	public static void SetPokerVariant(){
		
	}
	
	public void FindTables(String pokerVariant, Boolean practiceMode){
		switch(pokerVariant){
		case "texas holdem":
			this.FindImageAndClickCenter("chinnu-acer", "texas-holdem-btn", "png");
			break;
		}
		
		if (practiceMode == true){
			this.FindImageAndClickCenter("chinnu-acer", "practice-btn", "png");
		}
		
	}
	
	public void SelectTable(){
		this.FindImageAndClickCenter("chinnu-acer", "go-to-table-btn", "png");
	}
	
	public void JoinTable(){
		this.FindImageAndClickCenter("chinnu-acer", "join-table-btn", "png");
	}

}
