package poker.app;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.sikuli.api.DefaultScreenLocation;
import org.sikuli.api.Relative;
import org.sikuli.api.Screen;
import org.sikuli.api.ScreenLocation;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.script.App;
import org.sikuli.script.Region;

import poker.app.WindowManager.WindowType;

import com.sun.jna.platform.win32.WinDef.HWND;

public class Window {
	public App app;
	public Rectangle window;
	public String windowTitle;
	public WindowType windowType;
	public int windowNumber;
	public DesktopMouse mouse;
	public DesktopKeyboard keyboard;
	public Robot robot;
	public  HWND hWnd;
	
	
	public Window(WindowType WType, String WindowTitle) throws AWTException{
		app = new App(WindowTitle);
		mouse = new DesktopMouse();
		keyboard = new DesktopKeyboard();
		robot = new Robot();
		this.setWindowType(WType);
		this.setWindowTitle(WindowTitle);
		this.setWindowRegion();
		
	}
	
	public Window(WindowType WType, String WindowTitle, HWND hWnd) throws AWTException{
		app = new App(WindowTitle);
		mouse = new DesktopMouse();
		keyboard = new DesktopKeyboard();
		robot = new Robot();
		this.setWindowType(WType);
		this.setWindowHandle(hWnd);
		this.setWindowTitle(WindowTitle);
		this.setWindowRegion();
		
	}
	
	public Window(WindowType WType, String WindowTitle, HWND hWnd, Rectangle rect) throws AWTException{
		app = new App(WindowTitle);
		mouse = new DesktopMouse();
		keyboard = new DesktopKeyboard();
		robot = new Robot();
		this.setWindowType(WType);
		this.setWindowHandle(hWnd);
		this.setWindowTitle(WindowTitle);
		this.setWindowRegion(rect);
		
	}
	
	public void setWindowHandle(HWND hWindow){
		this.hWnd = hWindow;
	}
	
	public HWND getWindowHandle(){
		return this.hWnd;
	}
	
	public void setWindowTitle(String WindowTitle){
		this.windowTitle = WindowTitle;
	}
	
	public String getWindowTitle(){
		return this.windowTitle;
	}
	
	public void setWindowType(WindowType WType){
		this.windowType = WType;
	}
	
	public WindowType getWindowType(){
		return this.windowType;
	}
	
	public void setWindowRegion(){
		//this.window = app.window(0);
	}
	
	public void setWindowRegion(Rectangle rect){
		this.window = rect;
		System.out.println("Window window region is set to rect" + rect.toString());
	}
	
	public Rectangle getWindowRegion(){
		return this.window;
	}
	
	public void focus(){
		app.focus();
	}
	
	public Point getCorner(String cornerName){
		Point corner = null;
		switch(cornerName){
			case "leftUpperCorner":
				corner = new Point(this.app.window(0).x, this.app.window(0).y);
				break;
			case "rightUpperCorner":
				corner = new Point(this.app.window(0).x + this.app.window(0).w, this.app.window(0).y);
				break;
			case "leftBottomCorner":
				corner = new Point(this.app.window(0).x, this.app.window(0).y + this.app.window(0).h);
				break;
			case "rightBottomCorner":
				corner = new Point(this.app.window(0).x + this.app.window(0).w, this.app.window(0).y + this.app.window(0).h);
				break;
			default:
				corner = new Point(this.app.window(0).x, this.app.window(0).y);
				break;
		}
		
		return corner;
	}
	
	public void move(int x, int y) throws InterruptedException{
		int pointOffset = 10; // mouse clicks at 5 pix from corner
		
		Rectangle WindowRect = this.app.window(0).getRect();
		System.out.println("Window size is " + WindowRect.toString());
		Point leftUpperCorner = this.getCorner("leftUpperCorner");
		Point newLeftUpperCorner = new Point(x, y);
		
		mouseGlideDrag(new Point(leftUpperCorner.x + pointOffset, leftUpperCorner.y + pointOffset), new Point(newLeftUpperCorner.x + pointOffset, newLeftUpperCorner.y + pointOffset));
	}
	
	public void resize(int width, int height) throws InterruptedException{
		int pointOffset = 3; // mouse clicks at 2 pix from rightBottomcorner
		
		Rectangle WindowRect = this.app.window(0).getRect();
		System.out.println("Window size is " + WindowRect.toString());
		Point rightBottomCorner = this.getCorner("rightBottomCorner");
		System.out.println("Bottom corner is " + rightBottomCorner.toString());
		Point newRightBottomCorner = new Point( this.app.window(0).x + width, this.app.window(0).y + height );
		System.out.println("New Bottom corner is " + newRightBottomCorner.toString());
				
    	//robot.mouseMove(newRightBottomCorner.x - pointOffset, newRightBottomCorner.y - pointOffset);
    	this.mouseGlideDrag(new Point(rightBottomCorner.x - pointOffset , rightBottomCorner.y - pointOffset), new Point(newRightBottomCorner.x - pointOffset, newRightBottomCorner.y - pointOffset));

    	System.out.println("Window size is " + this.app.window(0).getRect().toString());
	}
	
	public void mouseGlide(Point fromPoint, Point toPoint){
		int x1 = fromPoint.x;
		int y1 = fromPoint.y;
		int x2 = toPoint.x;
		int y2 = toPoint.y;
		int t = 3000; //time 3 sec
		int n = 50; //inSteps in 50 steps
		    try {
		        Robot r = new Robot();
		        double dx = (x2 - x1) / ((double) n);
		        double dy = (y2 - y1) / ((double) n);
		        double dt = t / ((double) n);
		        for (int step = 1; step <= n; step++) {
		            Thread.sleep((int) dt);
		            r.mouseMove((int) (x1 + dx * step), (int) (y1 + dy * step));
		        }
		    } catch (AWTException e) {
		        e.printStackTrace();
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }		
	}
	
	public void mouseGlideDrag(Point fromPoint, Point toPoint) throws InterruptedException{
		robot.mouseMove(fromPoint.x, fromPoint.y);
		Thread.sleep(1000);
    	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    	
    	//robot.mouseMove(newRightBottomCorner.x - pointOffset, newRightBottomCorner.y - pointOffset);
    	this.mouseGlide(fromPoint, toPoint);
    	
    	Thread.sleep(1000);
    	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	public void moveNfit(Rectangle rect) throws InterruptedException{
		this.resize(rect.width, rect.height);
		this.move(rect.x, rect.y);
	}

}
