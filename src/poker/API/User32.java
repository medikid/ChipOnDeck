package poker.API;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.BaseTSD.LONG_PTR;
import com.sun.jna.platform.win32.WinDef.UINT_PTR;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.StdCallLibrary;

public interface User32 extends StdCallLibrary {
    User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);
    
    boolean EnumWindows(WinUser.WNDENUMPROC lpEnumFunc, Pointer arg);
    
    int GetWindowTextA(HWND hWnd, byte[] lpString, int nMaxCount);
    
    boolean BringWindowToTop( HWND hWnd );
    
    boolean SetForegroundWindow( HWND hWnd );
    
    boolean MoveWindow(HWND hWnd, int X, int Y, int nWidth, int nHeight, boolean bRepaint);
        
    public static final Pointer HWND_TOP        = Pointer.createConstant(0);
    public static final Pointer HWND_BOTTOM     = Pointer.createConstant(1);
    public static final Pointer HWND_TOPMOST    = Pointer.createConstant(-1);
    public static final Pointer HWND_NOTOPMOST  = Pointer.createConstant(-2);
    
    public static final int SWP_NOSIZE          =0x0001;
    public static final int SWP_NOMOVE          =0x0002;
    public static final int SWP_NOZORDER        =0x0004;
    public static final int SWP_NOREDRAW        =0x0008;
    public static final int SWP_NOACTIVATE      =0x0010;
    public static final int SWP_FRAMECHANGED    =0x0020;  /* The frame changed: send WM_NCCALCSIZE */
    public static final int SWP_SHOWWINDOW      =0x0040;
    public static final int SWP_HIDEWINDOW      =0x0080;
    public static final int SWP_NOCOPYBITS      =0x0100;
    public static final int SWP_NOOWNERZORDER   =0x0200;  /* Don't do owner Z ordering */
    public static final int SWP_NOSENDCHANGING  =0x0400;  /* Don't send WM_WINDOWPOSCHANGING */

    public static final int SWP_DRAWFRAME       = SWP_FRAMECHANGED;
    public static final int SWP_NOREPOSITION    = SWP_NOOWNERZORDER;

    public static final int SWP_DEFERERASE      =0x2000;
    public static final int SWP_ASYNCWINDOWPOS  =0x4000;

    boolean SetWindowPos(HWND hWnd, Pointer hWndInsertAfter, int X, int Y, int cx, int cy, int uFlags);
    
    
 }