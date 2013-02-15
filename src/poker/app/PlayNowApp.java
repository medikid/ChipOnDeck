package poker.app;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
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

public class PlayNowApp {
	String USERNAME = "ragavgroups";
	String PASSWORD = "Ragav76";
	String PATH_EXE = "C:\\Program Files (x86)\\Poker Heaven\\poker.exe";
	String PATH_IMAGE_FOLDER = "\\images" + "\\chinnu-acer";
	String APP_WINDOW_TITLE = "Poker Heaven";
	private Object AppWindowTitle;
	static Mouse mouse = new DesktopMouse();
	static Keyboard keyboard = new DesktopKeyboard();
	static Canvas canvas = new DesktopCanvas();
	static ScreenPainter painter = new ScreenPainter();
	static String PokerHeavenApp = "C:\\Program Files (x86)\\Poker Heaven\\poker.exe";
	static Robot robot = null;
	
	public PlayNowApp() throws AWTException{
		robot = new Robot();
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
		
		keyboard.type(PokerHeavenApp);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
	}
	
	public void Close(){
		App.focusedWindow().highlight(10);
		App.close(APP_WINDOW_TITLE);
		
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
		URL maxButton = GetImageURL(ImageCategory,ImageName, ImageExt);
		// Define an image target on the screen               
		Target imageTarget = new ImageTarget(maxButton);
		return imageTarget;
	}
	
	public ScreenRegion FindImageOnScreen(String ImageCategory, String ImageName, String ImageExt){
		URL maxButton = GetImageURL(ImageCategory,ImageName, ImageExt);
//		File maxButton = new File("D:\\wamp\\www\\poker\\src\\images\\maximize-btn.png");
		ScreenRegion s = new DesktopScreenRegion();	
		
		// Define an image target on the screen               
		Target imageTarget = new ImageTarget(maxButton);
		// Issue the find command and get a new screen region
		// 'r' corresponding to the screen region occupied
		// by the found target
		ScreenRegion r = s.find(imageTarget);
		
		return r;
	}
	
	public ScreenRegion FindTextOnScreen(String strToFind){
		TextTarget txtTarget = new TextTarget(strToFind);
		ScreenRegion sr = new DesktopScreenRegion();
		ScreenRegion txtImg = sr.find(txtTarget);
		return txtImg;
	}
	
	private void _imageClickCenter(ScreenRegion reg){
		mouse.click(reg.getCenter());
	}
	
	public void imageHightlight(ScreenRegion reg, String shape, int duration){
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
		ScreenRegion sr = this.FindImageOnScreen(ImageCategory,ImageName, ImageExt);
		_imageClickCenter(sr);
	}
	
	public void Maximize(){	
		ScreenRegion sr = FindImageOnScreen("chinnu-acer", "maximize-btn", "png");
		_imageClickCenter(sr);
		imageBlink(sr, "rectangle", 10);
	}
	
	public static void Minimize(){
		
	}
	
	public void Login(){
		FindImageAndClickCenter("chinnu-acer", "loginnow-btn", "png");
		FindImageAndClickCenter("chinnu-acer", "password-field", "png");
		keyboard.type(PASSWORD);
		FindImageAndClickCenter("chinnu-acer", "loginnow-btn", "png");
	}
	
	public static void SetPokerVariant(){
		
	}
	
	public static void FindTables(){
		
	}
	
	public static void SelectTable(){
	
	}
	
	public static void JoinTable(){
		
	}

}
