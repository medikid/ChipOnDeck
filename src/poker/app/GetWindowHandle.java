package poker.app;
import com.sun.jna.*;
import com.sun.jna.platform.win32.WinDef.HWND;
//import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.*;
 
public class GetWindowHandle {
 
   public interface User32 extends StdCallLibrary {
      User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);
      
      HWND FindWindow(String lpClassName, String lpWindowName);
   }
 
   public static int findWindow(String className, String windowName) throws WindowNotFoundException {
      HWND hwnd = User32.INSTANCE.FindWindow(className, windowName);
      if (hwnd == null) {
         throw new WindowNotFoundException(className, windowName);
      }
      return hwnd.hashCode();
   }
    
   @SuppressWarnings("serial")
   public static class WindowNotFoundException extends Exception {
      public WindowNotFoundException(String className, String windowName) {
         super(String.format("Window null for className: %s; windowName: %s", className, windowName));
      }
   }
 
   public static void main(String[] args) {
      try {
         // for a JFrame with a title of "Fubars Forever!"
         int winHandle = findWindow("SunAwtFrame", "Fubars Forever!");
         System.out.printf("Window Handle: 0x%X%n", winHandle); // show hex representation of handle
      } catch (WindowNotFoundException e) {
         e.printStackTrace();
      }
   }
}
