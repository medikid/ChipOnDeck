package poker.app;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Stroke;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DisplaySystem {
	public JFrame frame;
	
	public DisplaySystem(){		
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame= new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setUndecorated(true); // Only required for Mac computers. remove this line if this cause problems
		DisplayPanel c = new DisplayPanel(PanelType.GLASS_BACKGROUND);
		c.setLayout(new BorderLayout());
        
        DisplayPanel jp = new DisplayPanel(PanelType.CIRCLE_OF_ACTION);
        c.add("Center", jp);
        c.setPreferredSize(frame.getSize());
        frame.getContentPane().add(c);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//.EXIT_ON_CLOSE);
        frame.setExtendedState( Frame.MAXIMIZED_BOTH);	//set full screen maximized to start
        
        frame.pack();        
        frame.setVisible(true);
        com.sun.awt.AWTUtilities.setWindowOpaque(frame, false);
	}
	
	
	   @SuppressWarnings("serial")
		public static void main(String[] args) {
	    	JFrame.setDefaultLookAndFeelDecorated(true);
	    	JFrame f = new JFrame();
//	        f = new JFrame("Test");

	        f.setAlwaysOnTop(true);
	        DisplayPanel c = new DisplayPanel(PanelType.GLASS_BACKGROUND);
	        /*{
	            @Override
	            public void paintComponent(Graphics g) {
	                Graphics2D g2 = (Graphics2D)g.create();
	                g2.setColor(Color.gray);
	                int w = getWidth();
	                int h = getHeight();
	                g2.fillRect(0, 0, w,h);
	                g2.setComposite(AlphaComposite.Clear);
	                g2.fillRect(0, 0, w, h);                
	               
	            }
	        }; */
	
	        
	        c.setLayout(new BorderLayout());
	        
	        DisplayPanel jp = new DisplayPanel(PanelType.CIRCLE_OF_ACTION);
	        c.add("Center", jp);
	        
	        
//	        c.setPreferredSize(new Dimension(300, 300));
	        c.setPreferredSize(f.getSize());
	        f.getContentPane().add(c);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setExtendedState( Frame.MAXIMIZED_BOTH);	//set full screen maximized to start
	 //       f.setUndecorated(true); // Only required for Mac computers. remove this line if this cause problems
	        f.pack();        
	        f.setVisible(true);
	        com.sun.awt.AWTUtilities.setWindowOpaque(f,false);
	        
	        try {
	        	DisplayPanel jp1 = new DisplayPanel(PanelType.PLAYER_SCOREBOARD);
				Thread.sleep(500);
				jp.removeAll();
				jp.updateUI();
		     //   c.remove(jp);
		        c.add("South", jp1);
				Thread.sleep(500);
		        
		        
		        f.repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				//jp.g2.clearRect(0,  0,  500,  500);
				//jp.clearRect(new Rectangle(0, 0, 500, 500));
				//jp.repaint(new Rectangle(0, 0, 500, 500));
				//f.setVisible(false);
				//f.dispose();
			
	    }
	    
}
