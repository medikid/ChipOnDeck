package poker.app.table;


import org.sikuli.api.ScreenRegion;

public class PlayNowTable {
	
	private ScreenRegion table;
	private String tableTitle;
	
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
	/*
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

