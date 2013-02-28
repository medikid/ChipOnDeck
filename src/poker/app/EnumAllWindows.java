package poker.app;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;
import com.sun.jna.win32.StdCallLibrary;
//http://msdn.microsoft.com/en-us/library/windows/desktop/ms633534%28v=vs.85%29.aspx
public class EnumAllWindows {
   public interface User32 extends StdCallLibrary {
      User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);
      boolean EnumWindows(WinUser.WNDENUMPROC lpEnumFunc, Pointer arg);
      int GetWindowTextA(HWND hWnd, byte[] lpString, int nMaxCount);
      boolean BringWindowToTop( HWND hWnd );
      boolean SetForegroundWindow( HWND hWnd );
      boolean MoveWindow(HWND hWnd, int X, int Y, int nWidth, int nHeight, boolean bRepaint);
      boolean SetWindowPos(HWND hWnd, Pointer hWndInsertAfter, int X, int Y, int cx, int cy, int uFlags);
   }

   public static void main(String[] args) {
      final User32 user32 = User32.INSTANCE;
      user32.EnumWindows(new WNDENUMPROC() {
         int count = 0;
         @Override
         public boolean callback(HWND hWnd, Pointer arg1) {
            byte[] windowText = new byte[512];
            user32.GetWindowTextA(hWnd, windowText, 512);
            String wText = Native.toString(windowText);

            // get rid of this if block if you want all windows regardless of whether
            // or not they have text
            if (wText.isEmpty()) {
               return true;
            }
            
            if(wText.contains("Poker | PlayNow.com")){
            	user32.INSTANCE.SetForegroundWindow(hWnd);
            	user32.INSTANCE.BringWindowToTop(hWnd);
           // 	user32.INSTANCE.MoveWindow(hWnd, 500, 100, 500, 500, true);
            	user32.SetWindowPos(hWnd, Pointer.createConstant(0), 0, 0, 500, 500, 0x0040);
            	System.out.println("Brought window on top with text " + hWnd + ", total " + ++count
                        + " Text: " + wText);
            }

        //    System.out.println("Found window with text " + hWnd + ", total " + ++count + " Text: " + wText);
            return true;
         }
      }, null);
   }
}
