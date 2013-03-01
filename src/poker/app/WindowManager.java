package poker.app;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import org.sikuli.api.robot.desktop.DesktopScreen;

import poker.User32;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.UINT_PTR;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;

public class WindowManager {
	List<Window> Windows;
	List<Integer> Tables;
	List<Integer> Lobby;
	List<Integer> VMware;
	final User32 user32;	
	public enum WindowType{ WINDOW, APP, LOBBY, TABLE, VMWARE, MISC}
	
	public WindowManager(){
		Windows = new ArrayList<Window>();
		Tables = new ArrayList<Integer>();
		Lobby = new ArrayList<Integer>();
		VMware = new ArrayList<Integer>();				
		user32 = User32.INSTANCE; 
	}
	
	public String toString(){		
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		
		int totalWindows = this.Windows.size();
		result.append("Window Manager currently following(" + String.valueOf(totalWindows ) + ") windows active:");
		result.append(newLine);
		if (totalWindows > 0){
			int i = 1;
			for(Window win: this.Windows){
				result.append( String.valueOf(i) + ". " + win.getWindowType().toString() + " - " + win.getWindowTitle());
				result.append(newLine);
				
				i++;
			}
		}
		return result.toString();
	}
	
	public List<Window> getWindows(WindowType WinType, String KeyWord){
		final String keyWord = KeyWord;
		final List<Window> windows = new ArrayList<Window>();
		final WindowType winType = WinType;
		
		user32.EnumWindows(new WNDENUMPROC(){
			@Override
			public boolean callback(HWND hWnd, Pointer arg1) {
				byte[] windowText = new byte[512];
	            user32.GetWindowTextA(hWnd, windowText, 512);
	            String wText = Native.toString(windowText);
	            
	            if (wText.contains(keyWord)){	            	
					try {
						Window 	window = new Window(winType, wText, hWnd);
						windows.add(window);
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	            }	            
				return true;
			} }, null);
		
		return windows;
	}
	
	public boolean isWindowOpen(WindowType WinType, String... optKeyWords){
		boolean windowOpen = false;
		WindowType winType = WinType;
		String keyWord;
		if (optKeyWords.length > 0){
			keyWord = optKeyWords[0];
		} else keyWord = this.getKeywordByWindowType(winType);
		
		List<Window> requestedWindows = this.getWindows(winType, keyWord);
		if (requestedWindows.size() > 0){
			windowOpen = true;
		}
		
		return windowOpen;
	}

	public void addWindows(List<Window> windows){
		for(Window win: windows){			
			if (this.Windows.contains(win)){
				System.out.println("Window " + win.getWindowTitle() + " is already in the Window Manager");
			} else {				
				WindowType winType = win.getWindowType();
				switch(winType){
					case LOBBY:
						this.Windows.add(win);
						Lobby.add(this.Windows.indexOf(win));
						break;
					case TABLE:
						this.Windows.add(win);
						Tables.add(this.Windows.indexOf(win));
						break;
					case VMWARE:
						this.Windows.add(win);
						VMware.add(this.Windows.indexOf(win));
				}
			}
			
		}
	}
	
	public String getKeywordByWindowType(WindowType WinType){
		final String keyWord;
		switch(WinType){
			case LOBBY:
				keyWord = "Poker | PlayNow.com";
				break;
			case TABLE:
				keyWord = "Table:";
				break;
			case VMWARE:
				keyWord = "VMware Player";
				break;
			default:
				keyWord = "Poker";
					break;
		}
		
		return keyWord;
	}
	
	public List<Window> getWindowsByType(WindowType WinType){
		final WindowType winType = WinType;
		final String keyWord = getKeywordByWindowType(WinType);
		final List<Window> windows = getWindows(winType, keyWord);
		return windows;
	}
	
	public void addWindowsByType(WindowType WinType){
		List<Window> windows = getWindowsByType(WinType);
		addWindows(windows);
	}
	
	
	public List<Window> findAllWindows() {
		final List<Window> windows = new ArrayList<Window>();
		
		user32.EnumWindows(new WNDENUMPROC(){
			WindowType winType = null;
			@Override
	         public boolean callback(HWND hWnd, Pointer arg1) {
	            byte[] windowText = new byte[512];
	            user32.GetWindowTextA(hWnd, windowText, 512);
	            String wText = Native.toString(windowText);

	            if (wText.isEmpty()) {
	               return true;
	            } else {
	            	try {	            		
	            		if (wText.contains("Poker | PlayNow.com")){
	            			if (wText.contains("Table:")){
	            				winType = WindowType.TABLE;
							} else {
								winType = WindowType.LOBBY;
							}
	            		} else if (wText.contains("VMware Player")){
	            			winType = WindowType.VMWARE;
	            		} else winType = WindowType.MISC;
	            		
	            		Window window = new Window( winType, wText, hWnd);
						windows.add(window);
	            	} catch (AWTException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	            	}
	            return true;
	        }
			
		}, null);
		
		return windows;
	}
	
	public void refresh(){
		this.Windows.clear();
		final List<Window> windows = findAllWindows();
		addWindows(windows);
	}
	
	 public int getWindowByHwnd(HWND hWnd){
		 int requestedWindow = 0;
		 for(Window win : this.Windows){
			 if (win.hWnd == hWnd){
				 requestedWindow = this.Windows.indexOf(win);
			 }
		 }
		return requestedWindow;
	 }
	 
	 public int getWindowByTitle(String title){
		 int requestedWindow = 0;
		 for(Window win : this.Windows){
			 if (win.windowTitle.contains(title)){
				 requestedWindow = this.Windows.indexOf(win);
			 }
		 }
		return requestedWindow;
	 }
	 
	 @SuppressWarnings({ "null", "rawtypes", "unchecked" })
	public List<Integer> getWindowsByKeyword(String keyword){
		 List<Integer> requestedWindows = null;
		 for(Window win : this.Windows){
			 if (win.windowTitle.contains(keyword)){
				 requestedWindows.add(this.Windows.indexOf(win));
			 }
		 }
		return requestedWindows;
	 }
	 
	 @SuppressWarnings("null")
	public List<Integer> getTables(){
		 List<Integer> Tables = new ArrayList<Integer>();
		 for(Window win : this.Windows){
			 if (win.windowType == WindowType.TABLE){
				 Tables.add(this.Windows.indexOf(win));
			 }
		 }
		return Tables;
	 }
	 
	 public void setWindowActive(HWND hWnd){
		user32.SetForegroundWindow(hWnd);
		user32.BringWindowToTop(hWnd);
	 }
	 
	 public void setWindowActive(WindowType WinType, String KeyWord){
		List<Window> wins = this.getWindows(WinType, KeyWord);
			for(Window win: wins){
				this.setWindowActive(win.getWindowHandle());
			}
	 }
	 
	 @SuppressWarnings({ "static-access", "static-access" })
	public void fitNmoveWindow(HWND hWnd, Rectangle windowRect, Boolean isRepaint ){
		 user32.MoveWindow(hWnd, windowRect.x, windowRect.y, windowRect.width, windowRect.height, isRepaint);		
	 }
	 
	 public void setWindowPos(HWND hWnd, Rectangle windowRect, Pointer user32_HWND, int user32_SWP){		 
		 user32.SetWindowPos(hWnd, user32_HWND, windowRect.x, windowRect.y, windowRect.width, windowRect.height, user32_SWP);
	 }
	 
	 public void tileWindows(boolean tablesFirst){
		int noOfWindows = this.Windows.size();
		if (noOfWindows > 0){
			List<Rectangle> winGrids = getDesktopGrid(noOfWindows);
				int ind = 0;
				if(tablesFirst){
					for(int winTableIndex: this.Tables){
						Window winTable = this.Windows.get(winTableIndex);
						setWindowActive(winTable.hWnd);
						fitNmoveWindow(winTable.hWnd, winGrids.get(ind), true);
						ind++;
						System.out.println("Window Table" + winTable.getWindowTitle() +" is tiled now ");
					}
					
					for(Window win: this.Windows){
						if (win.getWindowType() == WindowType.APP){
							setWindowActive(win.hWnd);
							fitNmoveWindow(win.hWnd, winGrids.get(ind), true);
							System.out.println("Window App" + win.getWindowTitle() +" is tiled now ");
						}
					}
					
					
				} else {
					for(Window win: this.Windows){
						setWindowActive(win.hWnd);
						fitNmoveWindow(win.hWnd, winGrids.get(ind), true);
						ind++;
						System.out.println("Window " + win.getWindowTitle() +" is tiled now ");
					}
				}
		}
	 }
	 
	 @SuppressWarnings("null")
	public List<Rectangle> getDesktopGrid(int numberOfWindows){
		 List<Rectangle> rects = new ArrayList<Rectangle>();
		 DesktopScreen desktop = new DesktopScreen(0);
		 int dWidth = desktop.getSize().width;
		 int dHeight = desktop.getSize().height;
		 	switch(numberOfWindows){
			 	case 1:
			 		Rectangle r = desktop.getBounds();
			 		rects.add(r);
			 		break;
			 	case 2:
			 		Rectangle r21 = new Rectangle(0, 0, (int)(dWidth/2), dHeight);
			 		Rectangle r22 = new Rectangle((int)(dWidth/2), 0, (int)(dWidth/2), dHeight);
			 		rects.add(r21); rects.add(r22);
			 		break;
			 	case 3:
			 		Rectangle r31 = new Rectangle(0, 0, (int)(dWidth/2), (int)(dHeight/2));
			 		Rectangle r32 = new Rectangle((int)(dWidth/2), 0, (int)(dWidth/2), (int)(dHeight/2));
			 		Rectangle r33 = new Rectangle(0, (int)(dHeight/2), (int)(dWidth/2), (int)(dHeight/2));
			 		rects.add(r31); rects.add(r32); rects.add(r33);
			 		break;
			 	case 4:
			 		Rectangle r41 = new Rectangle(0, 0, (int)(dWidth/2), (int)(dHeight/2));
			 		Rectangle r42 = new Rectangle((int)(dWidth/2), 0, (int)(dWidth/2), (int)(dHeight/2));
			 		Rectangle r43 = new Rectangle(0, (int)(dHeight/2), (int)(dWidth/2), (int)(dHeight/2));
			 		Rectangle r44 = new Rectangle((int)(dWidth/2), (int)(dHeight/2), (int)(dWidth/2), (int)(dHeight/2));
			 		rects.add(r41); rects.add(r42); rects.add(r43); rects.add(r44);
			 		break;
			 	case 5:
			 		Rectangle r51 = new Rectangle(0, 0, (int)(dWidth/3), (int)(dHeight/2));
			 		Rectangle r52 = new Rectangle((int)(dWidth/3), 0, (int)(dWidth/3), (int)(dHeight/2));
			 		Rectangle r53 = new Rectangle((int)(dWidth/3) * 2, 0, (int)(dWidth/3), (int)(dHeight/2));
			 		Rectangle r54 = new Rectangle(0, (int)(dHeight/2), (int)(dWidth/3), (int)(dHeight/2));
			 		Rectangle r55 = new Rectangle((int)(dWidth/3), (int)(dHeight/2), (int)(dWidth/3), (int)(dHeight/2));
			 		rects.add(r51); rects.add(r52); rects.add(r53); rects.add(r54);  rects.add(r55);
			 		break;
			 	case 6:
			 		Rectangle r61 = new Rectangle(0, 0, (int)(dWidth/3), (int)(dHeight/2));
			 		Rectangle r62 = new Rectangle((int)(dWidth/3), 0, (int)(dWidth/3), (int)(dHeight/2));
			 		Rectangle r63 = new Rectangle((int)(dWidth/3) * 2, 0, (int)(dWidth/3), (int)(dHeight/2));
			 		Rectangle r64 = new Rectangle(0, (int)(dHeight/2), (int)(dWidth/3), (int)(dHeight/2));
			 		Rectangle r65 = new Rectangle((int)(dWidth/3), (int)(dHeight/2), (int)(dWidth/3), (int)(dHeight/2));
			 		Rectangle r66 = new Rectangle((int)(dWidth/3) * 2, (int)(dHeight/2), (int)(dWidth/3), (int)(dHeight/2));
			 		rects.add(r61); rects.add(r62); rects.add(r63); rects.add(r64);  rects.add(r65);   rects.add(r66);
			 		break;
			 	case 7:
			 		Rectangle r71 = new Rectangle(0, 0, (int)(dWidth/4), (int)(dHeight/2));
			 		Rectangle r72 = new Rectangle((int)(dWidth/4), 0, (int)(dWidth/4), (int)(dHeight/2));
			 		Rectangle r73 = new Rectangle((int)(dWidth/4) * 2, 0, (int)(dWidth/4), (int)(dHeight/2));
			 		Rectangle r74 = new Rectangle((int)(dWidth/4) * 3, 0, (int)(dWidth/4), (int)(dHeight/2));
			 		Rectangle r75 = new Rectangle(0, (int)(dHeight/2), (int)(dWidth/4), (int)(dHeight/2));
			 		Rectangle r76 = new Rectangle((int)(dWidth/4), (int)(dHeight/2), (int)(dWidth/4), (int)(dHeight/2));
			 		Rectangle r77 = new Rectangle((int)(dWidth/4) * 2, (int)(dHeight/2), (int)(dWidth/4), (int)(dHeight/2));
			 		rects.add(r71); rects.add(r72); rects.add(r73); rects.add(r74);  rects.add(r75);   rects.add(r76);
			 		rects.add(r77);
			 		break;
			 	case 8:
			 		Rectangle r81 = new Rectangle(0, 0, (int)(dWidth/4), (int)(dHeight/2));
			 		Rectangle r82 = new Rectangle((int)(dWidth/4), 0, (int)(dWidth/4), (int)(dHeight/2));
			 		Rectangle r83 = new Rectangle((int)(dWidth/4) * 2, 0, (int)(dWidth/4), (int)(dHeight/2));
			 		Rectangle r84 = new Rectangle((int)(dWidth/4) * 3, 0, (int)(dWidth/4), (int)(dHeight/2));
			 		Rectangle r85 = new Rectangle(0, (int)(dHeight/2), (int)(dWidth/4), (int)(dHeight/2));
			 		Rectangle r86 = new Rectangle((int)(dWidth/4), (int)(dHeight/2), (int)(dWidth/4), (int)(dHeight/2));
			 		Rectangle r87 = new Rectangle((int)(dWidth/4) * 2, (int)(dHeight/2), (int)(dWidth/4), (int)(dHeight/2));
			 		Rectangle r88 = new Rectangle((int)(dWidth/4) * 3, (int)(dHeight/2), (int)(dWidth/4), (int)(dHeight/2));
			 		rects.add(r81); rects.add(r82); rects.add(r83); rects.add(r84);  rects.add(r85);   rects.add(r86);
			 		rects.add(r87); rects.add(r88);
			 		break;
			 	case 9:
			 		break;
			 	case 10:
			 		break;
			 	case 11:
			 		break;
			 	case 12:
			 		break;
		 		default:
		 			break;
		 		
		 	}
		 	System.out.println("Following desktop grids were created :" + rects.toString());
		 	return rects;
	 }

}
