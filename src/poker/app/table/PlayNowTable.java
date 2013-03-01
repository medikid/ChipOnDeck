package poker.app.table;


import java.awt.AWTException;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenLocation;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.ScreenRegionRecorder;
import org.sikuli.api.robot.desktop.DesktopScreen;
import org.sikuli.api.visual.DesktopCanvas;
import org.sikuli.script.*;
import org.sikuli.script.natives.*;

import poker.PokerAPI;

public class PlayNowTable extends PokerAPI {
	
	private DesktopScreenRegion table;
	private String tableTitle;
	private int TABLE_NUMBER;
	
	public PlayNowTable(int tableNumber) throws AWTException {
		desktopRegionCanvas.addBox(MAIN_SCREEN).display(10);		
		this.TABLE_NUMBER = tableNumber;
	}
	
	public void positionTableByTableNumber(){
		
	}
	
	public void _getScreenLocationByTableNumber(){
		
	}
	
	public void _adjustWindowSize(){
		ScreenRegion emptySeat = FindImageOnScreen("chinnu-acer", "empty-board", "png");
	}
	
	public void findAllEmptySeats(){
		ScreenRegion emptySeat = FindImageOnScreen("chinnu-acer", "empty-board", "png");
		ScreenLocation centerLoc = emptySeat.getCenter();
		desktopRegionCanvas.addCircle(centerLoc).display(8);
		mouse.click(centerLoc);
	//	this.imageBlink(emptySeat, "rectangle", 6 );
	}
	
	public void calibrateRegion(String regName){
		
	}
	
	public Region selectRegion(String regName){
		
		UnionScreen Us = new UnionScreen();
		Region sr = Us.selectRegion(regName);
		
		return sr;
	}
	
/*	
	static{
		 try{
		  System.loadLibrary("WFrame"); // load WFrame.dll
		 }catch (UnsatisfiedLinkError e){} // Just go on your merry way
		} 	
	
	public PlayNowTable(){
		
	}
	
	public native int getForegroundHwnd();
	
	public void getTopAppHwnd(){
		int _hwnd = getForegroundHwnd();
		System.out.println( "top window hwnd is " + String.valueOf(_hwnd) );
	}
	
	public focusTable(){
		//http://stackoverflow.com/questions/6662956/handle-external-windows-using-java
	}
	
	JNIEXPORT jint JNICALL Java_JavaHowTo_getHwnd(JNIEnv *env, jclass obj, jstring title){
			 HWND hwnd = NULL;
			 const char *str = NULL;
		
			 str = (*env)->GetStringUTFChars(env, title, 0);
			 hwnd = FindWindow(NULL,str);
			 (*env)->ReleaseStringUTFChars(env, title, str);
			 return (jint) hwnd;
	}*/
}

