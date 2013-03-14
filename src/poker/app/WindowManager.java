package poker.app;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.sikuli.api.robot.desktop.DesktopScreen;

import poker.API.User32;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinDef.UINT_PTR;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;

public class WindowManager {
	public Map<String, Window> Windows;
	public List<String> Tables;
	public List<String> Lobby;
	public List<String> VMware;
	private final User32 user32;
	Map<WindowType, String> keywordList;
	public enum WindowType{ WINDOW, APP, LOBBY, TABLE, VMWARE, MISC}
	
	public WindowManager(){
		Windows = new HashMap<String, Window>();
		Tables = new ArrayList<String>();
		Lobby = new ArrayList<String>();
		VMware = new ArrayList<String>();
		keywordList = new HashMap<WindowType, String>();
		this.setDefaultKeywordList();
		user32 = User32.INSTANCE; 
	}
	
	public void setDefaultKeywordList(){
		this.keywordList.put(WindowType.LOBBY, "Poker | PlayNow.com");
		this.keywordList.put(WindowType.VMWARE, "VMware");
		this.keywordList.put(WindowType.TABLE, "Table:");
	}
	
	public void setCustomKeywordList(Map<WindowType, String> kwList){
		this.keywordList = kwList;
	}
	
	public void addCustomKeyword(WindowType winType, String keyWord){
		this.keywordList.put(winType, keyWord);		
	}
	
	public String toString(){		
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		
		int totalWindows = this.Windows.size();
		result.append("Window Manager currently following(" + String.valueOf(totalWindows ) + ") windows active:");
		result.append(newLine);
		if (totalWindows > 0){
			Iterator it = this.Windows.entrySet().iterator();
			int i = 1;
			while (it.hasNext()) {
		        Map.Entry windowsEntry = (Map.Entry)it.next();
		        
				String winTitle = (String) windowsEntry.getKey();
				Window window = (Window) windowsEntry.getValue();
			
				result.append( String.valueOf(i) + ". " + window.getWindowType().toString() + " - " + winTitle);
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
	            RECT winRect = new RECT();
	            user32.GetWindowRect(hWnd, winRect);
	            
	            if (wText.contains(keyWord)){	            	
					try {
						Window 	window = new Window(winType, wText, hWnd, winRect.toRectangle());
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
			if (this.Windows.containsKey(win.getWindowTitle())){
				System.out.println("Window " + win.getWindowTitle() + " is already in the Window Manager");
			} else {				
				WindowType winType = win.getWindowType();
				switch(winType){
					case LOBBY:
						this.Windows.put(win.getWindowTitle(), win);
						this.Lobby.add(win.getWindowTitle());
						
						//if there is Table keyword in Lobby skip it
						String tableKeyword = this.keywordList.get(WindowType.TABLE);
						if (win.getWindowTitle().contains(tableKeyword)){
							this.Windows.remove(win.getWindowTitle());
							this.Lobby.remove(win.getWindowTitle());
							System.out.println("Removed duplicate Lobby with title " + win.getWindowTitle() );
							/* No need to do anything, because the entry wiht tableType will be added to table automatically
							win.setWindowType(WindowType.TABLE);
							this.Windows.put(win.getWindowTitle(),  win);
							this.Tables.add(win.getWindowTitle());
							*/
						}
						
						
						break;
					case TABLE:
						this.Windows.put(win.getWindowTitle(),  win);
						Tables.add(win.getWindowTitle());
						break;
					case VMWARE:
						this.Windows.put(win.getWindowTitle(),  win);
						VMware.add(win.getWindowTitle());
				}
			}
			
		}
	}
	
	public String getKeywordByWindowType(WindowType WinType){
		final String keyWord = this.keywordList.get(WinType);		
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
	
	public void grabWindowsByKeywordList(){
		Iterator it = this.keywordList.entrySet().iterator();
		final List<Window> grabbedWindows = new ArrayList<Window>();
		
		while (it.hasNext()) {
	        Map.Entry wintypeKeywordSet = (Map.Entry)it.next();
	        
			final String keyWord = (String) wintypeKeywordSet.getValue();
			final WindowType winType = (WindowType) wintypeKeywordSet.getKey();
			System.out.println("Now Grabbing Window by keyword" + keyWord);
			
			user32.EnumWindows(new WNDENUMPROC(){
				@Override
				public boolean callback(HWND hWnd, Pointer arg1) {
					byte[] windowText = new byte[512];
		            user32.GetWindowTextA(hWnd, windowText, 512);
		            RECT winRect = new RECT();
		            user32.GetWindowRect(hWnd, winRect);
		            String wText = Native.toString(windowText);
		            
		            if (wText.contains(keyWord)){	            	
						try {
							Window 	window = new Window(winType, wText, hWnd, winRect.toRectangle());
							grabbedWindows.add(window);
						} catch (AWTException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
		            }	            
					return true;
				} }, null);
		    }
		System.out.println("grabWindowsByKeywordlist adding " + String.valueOf( grabbedWindows.size() ) + "Windows ");
		this.addWindows(grabbedWindows);
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
	
	 public Window getWindowByHwnd(HWND hWnd){
		 Window requestedWindow = null;
		 
		 Iterator it = this.Windows.entrySet().iterator();
			while (it.hasNext()) {
		        Map.Entry requestedWindowEntry = (Map.Entry)it.next();
		        Window win = (Window) requestedWindowEntry.getValue();
		        if (win.getWindowHandle() == hWnd){
		        	requestedWindow = win;
		        }
		 }
		return requestedWindow;
	 }
	 
	 public Window getWindowByTitle(String title){
		return this.Windows.get(title);
	 }
	 
	public List<Window> getWindowsByKeyword(String keyword){
		 List<Window> requestedWindows = new ArrayList<Window>();
		 Iterator it = this.Windows.entrySet().iterator();
			while (it.hasNext()) {
		        Map.Entry requestedWindowEntry = (Map.Entry)it.next();
		        String winTitle = (String) requestedWindowEntry.getKey();
		        if (winTitle.contains(keyword)){
		        	requestedWindows.add((Window) requestedWindowEntry.getValue());
		        }
		 }
		return requestedWindows;
	 }
	 
	public List<Window> getTables(){
		 List<Window> TableWindows = new ArrayList<Window>();
		 for(String winTitle: this.Tables){
			 TableWindows.add(this.Windows.get(winTitle));
		 }
		return TableWindows;
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
	 
	 public Rectangle getWindowBounds(Window window){
		 RECT winRect = new RECT();
		 user32.GetWindowRect(window.getWindowHandle(), winRect);
		 return winRect.toRectangle();
	 }
	 
	 public void setWindowBounds(Window window){
		 RECT winRect = new RECT();		 
		 user32.GetWindowRect(window.hWnd, winRect);
		 window.setWindowRegion(winRect.toRectangle());
	 }
	 
	 @SuppressWarnings({ "static-access", "static-access" })
	public void fitNmoveWindow(HWND hWnd, Rectangle windowRect, Boolean isRepaint ){
		 user32.MoveWindow(hWnd, windowRect.x, windowRect.y, windowRect.width, windowRect.height, isRepaint);		
	 }
	 
	 public void setWindowPos(HWND hWnd, Rectangle windowRect, Pointer user32_HWND, int user32_SWP){		 
		 user32.SetWindowPos(hWnd, user32_HWND, windowRect.x, windowRect.y, windowRect.width, windowRect.height, user32_SWP);
	 }
	 
	 public void tileTables(){
		 int noOfTables = this.Tables.size();
			if (noOfTables > 0){
				List<Rectangle> winGrids = getDesktopGrid(noOfTables);
					int ind = 0;					
					for(String tableTitle: this.Tables){
						Window tableWindow = (Window) this.Windows.get(tableTitle);
						setWindowActive(tableWindow.hWnd);
						fitNmoveWindow(tableWindow.hWnd, winGrids.get(ind), true);
						System.out.println("Window App" + tableWindow.getWindowTitle() +" is tiled now ");
						ind++;
					}
			}
	 }
	 
	 public void tileWindows(boolean tablesFirst){
		int noOfWindows = this.Windows.size();
		if (noOfWindows > 0){
			List<Rectangle> winGrids = getDesktopGrid(noOfWindows);
				int ind = 0;
				if(tablesFirst){
					for(String winTableTitle: this.Tables){
						Window winTable = this.Windows.get(winTableTitle);
						setWindowActive(winTable.hWnd);
						fitNmoveWindow(winTable.hWnd, winGrids.get(ind), true);
						ind++;
						System.out.println("Window Table" + winTable.getWindowTitle() +" is tiled now ");
					}
					
				Iterator it = this.Windows.entrySet().iterator();
				while (it.hasNext()) {
				        Map.Entry windowEntry = (Map.Entry)it.next();
				        Window win = (Window) windowEntry.getValue();
				        if (win.getWindowType() == WindowType.APP){
							setWindowActive(win.hWnd);
							fitNmoveWindow(win.hWnd, winGrids.get(ind), true);
							System.out.println("Window App" + win.getWindowTitle() +" is tiled now ");
							ind++;
						}
				       
				 }
				
				} else {
					Iterator it = this.Windows.entrySet().iterator();
					while (it.hasNext()) {
					        Map.Entry windowEntry = (Map.Entry)it.next();
					        Window win = (Window) windowEntry.getValue();
								setWindowActive(win.hWnd);
								fitNmoveWindow(win.hWnd, winGrids.get(ind), true);
								System.out.println("Window App" + win.getWindowTitle() +" is tiled now ");
								ind++;
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
