package poker;

import java.awt.Canvas;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
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
import org.sikuli.api.robot.desktop.DesktopScreen;
import org.sikuli.api.visual.DesktopCanvas;
import org.sikuli.api.visual.ScreenPainter;
import org.sikuli.api.visual.ScreenRegionCanvas;

import poker.app.ScreenRegionSelector;
import poker.app.Timer;
import poker.app.Timer.TimerListener;
import poker.app.logger.Logger;

public class PokerAPI {

	public static String PlayNow_USERNAME = "ragavgroups";
	public static  String PlayNow_PASSWORD = "Ragav76";
	public static  String POKER_APP_PROVIDER = "Poker PlayNow.com";
	public static  String PATH_EXE = "C:\\Program Files\\" + POKER_APP_PROVIDER +"\\poker.exe";
	public static  String VMWARE_PLAYER_PATH = "F:\\VMware\\VMWare Player\\vmplayer";
	public static  String VMWARE_MACHINE_PATH = "\"F:\\VMware\\VMWare Machines\\Windows 7\\Windows 7.vmx";
	
	public static  String POKER_TYPE;
	public static  String PATH_IMAGE_FOLDER = "\\images" + "\\chinnu-acer";
	public static  String APP_WINDOW_TITLE = "Poker | PlayNow.com";
	public static  Object AppWindowTitle;	

	protected DesktopScreen desktopScreen = new DesktopScreen(0);
	protected ScreenRegion MAIN_SCREEN = new DesktopScreenRegion();	
	protected Logger Logger = new Logger();
	protected static Mouse mouse = new DesktopMouse();
	protected static Keyboard keyboard = new DesktopKeyboard();
	protected static ScreenRegionCanvas screenRegionCanvas;
	protected static DesktopCanvas desktopRegionCanvas = new DesktopCanvas();
	protected static ScreenPainter painter = new ScreenPainter();
	protected static Robot robot = null;
	public DesktopScreenRegion selectedScreenRegion;
	
	public PokerAPI(){
		this.setDesktopScreen();
	}
	
	public void main(String[] args){
		
	}		
	
	public void setDesktopScreen(){
		this.MAIN_SCREEN.setBounds(desktopScreen.getBounds());	
	}
	
	public ScreenRegion getDesktopScreen(){
		return this.MAIN_SCREEN;
	}
	
	public DesktopScreenRegion selectScreenRegion(String promptText) throws InterruptedException{		
		final ScreenRegionSelector srs = new ScreenRegionSelector(promptText);
		final Timer _timer = new Timer(20);
		_timer.addTimerListener(new TimerListener(){
			@Override
			public void onTimerTick() {
				srs.updateTimerLabel( (20 - _timer.getTick() ));
				System.out.println("TestPokerApp: OnTImerTick called");
			}


			@Override
			public void onTimerStart() {
				// TODO Auto-generated method stub
				System.out.println("TestPokerApp: OnTImerStart called");
			}


			@Override
			public void onTimerStop() {				
				selectedScreenRegion = srs.getSelectedArea();
				srs.close();
				System.out.println("TestPokerApp: OnTImerStop called");
			}


			@Override
			public void onTimerAlarm() {
				// TODO Auto-generated method stub
				System.out.println("TestPokerApp: OnTImerAlarm called");
			}
			});
		_timer.start();
		Thread.sleep(21000);
	
		
		return selectedScreenRegion;	
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
		
//		Logger.PrintLog("GetImageTarget", "Image Target " + imgURL.toString() + " requested");
		return imageTarget;
	}
	
	public ScreenRegion FindImageTargetOnScreen(Target imgTarget){		
		ScreenRegion reg = this.MAIN_SCREEN.find(imgTarget);
		screenRegionCanvas = new ScreenRegionCanvas(this.MAIN_SCREEN);
		screenRegionCanvas.addBox(reg).display(2);
//		Logger.PrintLog("FindImageTargetOnScreen", "Image Target " + imgTarget.toString() + " Found at " + reg.toString() );
		System.out.println("FindImageTargetOnScreen" + "Image Target " + imgTarget.toString() + " Found at " + reg.toString() );
		return reg;
	}
	
	public ScreenRegion FindImageTargetInsideThisRegion(ScreenRegion targetRegion, Target imgTarget){
		ScreenRegion reg = null;
		reg = targetRegion.find(imgTarget);
		screenRegionCanvas = new ScreenRegionCanvas(targetRegion);
		screenRegionCanvas.addBox(reg).display(10);
//		Logger.PrintLog("FindImageTargetOnScreen", "Image Target " + imgTarget.toString() + " Found at " + reg.toString() );
		System.out.println("FindImageTargetOnScreen" + "Image Target " + imgTarget.toString() + " Found at " + reg.toString() );
		return reg;
	}
	
	public ScreenRegion FindImageOnScreen(String ImageCategory, String ImageName, String ImageExt){
		Target imgTarget = this.GetImageTarget(ImageCategory, ImageName, ImageExt);
		ScreenRegion reg = this.FindImageTargetOnScreen(imgTarget);
		return reg;
	}
	
	public ScreenRegion FindTextOnScreen(String strToFind){
		TextTarget txtTarget = new TextTarget(strToFind);
		ScreenRegion txtImg = this.MAIN_SCREEN.find(txtTarget);
		return txtImg;
	}
	
	protected void _imageClickCenter(ScreenRegion reg){
//		Logger.PrintLog("_imageClickCenter", "Image clicked at center " + reg.getCenter().toString());
		mouse.click(reg.getCenter());
	}
	
	public void imageHighlight(ScreenRegion reg, String shape, int duration){
		switch(shape){
		case "rectangle":
			desktopRegionCanvas.addBox(reg).display(duration);
			break;
		case "circle":
			desktopRegionCanvas.addCircle(reg.getCenter()).display(duration);
			break;
		}		
	}
	
	public void imageBlink(ScreenRegion reg, String shape, int duration){
		Boolean isBlink = true;
		switch(shape){
			case "rectangle":
				for(int i=0; i<duration; i++){			
					if (isBlink == true){
						desktopRegionCanvas.addBox(reg).display(1);
						isBlink = false;
					} else isBlink = true;
				}
				break;
			case "circle":
				for(int i=0; i<duration; i++){			
					if (isBlink == true){
						desktopRegionCanvas.addCircle(reg.getCenter()).display(1);
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
		this.keyboard.type(PlayNow_PASSWORD);
		this.FindImageAndClickCenter("chinnu-acer", "login-btn", "png");
	}
	
	private void SetPokerVariant(String pokerType){
		this.POKER_TYPE = pokerType.toLowerCase();
	}
	
	public void FindTables(String pokerType, Boolean practiceMode){
		this.SetPokerVariant(pokerType);
		
		switch(this.POKER_TYPE){
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
	
	public void regionChanged(ScreenRegion screenReg){
		
	}
	
	public void regionChangedEventHandler(){
		
	}

}
