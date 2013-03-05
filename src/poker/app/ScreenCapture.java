package poker.app;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ScreenCapture {
	String defaultSaveFolder = "E:\\ScreenCaps\\";
	String defaultImageFormat = "png";
	
	public ScreenCapture(){		
	}
	
	public BufferedImage captureScreen(){
		BufferedImage screenCap = null;
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        
        try {
			screenCap = new Robot().createScreenCapture(screenRect);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return screenCap;
	}
	
	public BufferedImage captureScreenRegion(Rectangle screenRect){
		BufferedImage screenCap = null;
		try {
			screenCap = new Robot().createScreenCapture(screenRect);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
        return screenCap;
	}
	
	public void captureImageFromScreenRegion(Rectangle screenRect){
		BufferedImage screenCap = this.captureScreenRegion(screenRect);
		String dateTimeStamp = new java.text.SimpleDateFormat("yyyyMMdd-HHmmss").format(new java.util.Date()); //(epoch*1000));
    	String imgPath = this.defaultSaveFolder + dateTimeStamp.toString() + ".png";
		
		this.writeToFile(screenCap, imgPath);
	}
	
	public boolean writeToFile(BufferedImage buff, String savePath) {
		Boolean isSuccess = false;
        try {
        	System.out.println(buff.toString());
            ImageIO.write(buff, this.defaultImageFormat, new File(savePath) );
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return isSuccess; 		
   }

}
