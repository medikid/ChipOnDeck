package poker.app;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.sikuli.api.robot.desktop.DesktopScreen;

@SuppressWarnings("serial")
public class ScreenShotViewer extends JComponent implements MouseListener, MouseMotionListener {
	    private Image background;
	    int rule = AlphaComposite.SRC_OVER;
	    float alpha = 0.85F;
		public  Point pointStart;
		public Point pointEnd;

	    public static void main(String[] args){
	    	JFrame frame = new JFrame();	    	
	    	ScreenShotViewer ssv = new ScreenShotViewer();
	    	frame.add(ssv);
	    	frame.setVisible(true);
	    }
	
	public ScreenShotViewer() {
//	    JLabel label = new JLabel(screenLabel);
//	    frame.add("Center", label);
	      
		 
	    addMouseListener(this);
		addMouseMotionListener(this);
	    updateBackground( );
	    
	}
	
	public void updateBackground( ) {
	    try {
	        Robot rbt = new Robot( );
	        Toolkit tk = Toolkit.getDefaultToolkit( );
	        Dimension dim = tk.getScreenSize( );
	        background = rbt.createScreenCapture(
	        new Rectangle(0,0,(int)dim.getWidth( ),
	                          (int)dim.getHeight( )));
	    } catch (Exception ex) {
	        System.out.println(ex.toString( ));
	        ex.printStackTrace( );
	    }
	}
	
	public void paintComponent(Graphics g) {
	    Point pos = this.getLocationOnScreen( );
	    Point offset = new Point(-pos.x,-pos.y);
	    g.drawImage(background,offset.x,offset.y,null);
	}

	
	public void Close(){
		this.setVisible(false);
		System.exit(0);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}