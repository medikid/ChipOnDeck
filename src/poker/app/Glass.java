package poker.app;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.robot.desktop.DesktopScreen;

@SuppressWarnings("serial")
public class Glass extends JPanel{
	
	public static void main(String[] args){
		JFrame f = new JFrame();
		Glass g = new Glass();
//		g.setPreferredSize(f.getSize());
		
		f.getContentPane().add(g);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState( Frame.MAXIMIZED_BOTH);	//set full screen maximized to start
        f.setUndecorated(true); // Only required for Mac computers. remove this line if this cause problems
        f.pack();        
        f.setVisible(true);
        com.sun.awt.AWTUtilities.setWindowOpaque(f,false);
		
	}
	
	 @Override
     public void paintComponent(Graphics g) {
         Graphics2D g2 = (Graphics2D)g.create();
         g2.setColor(Color.gray);
         int w = getWidth();
         int h = getHeight();
         g2.fillRect(0, 0, w,h);
         g2.setComposite(AlphaComposite.Clear);
         g2.fillRect(0, 0, w,h);
         g2.setColor(Color.red);
         g2.drawString("HEllo test", 100,  100);
         g2.dispose();
     }
 
	 
	
	
	
	
}