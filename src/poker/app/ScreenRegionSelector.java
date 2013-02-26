package poker.app;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;


import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.robot.desktop.DesktopScreen;

import sun.management.counter.Counter;

@SuppressWarnings("serial")
public class ScreenRegionSelector extends ScreenShotViewer implements MouseListener, MouseMotionListener, WindowListener{
	    private Image background;
	    private Graphics2D g;
	    int rule = AlphaComposite.SRC_OVER;
	    float alpha = 0.85F;
		public  Point pointStart;
		public Point pointEnd;
		public DesktopScreenRegion selectedArea = null;
		public String promptText = null;
		public JLabel timerLabel;
		public ActionListener onTimerTick;

	    public static void main(String[] args){		    	
	    	ScreenRegionSelector srs = new ScreenRegionSelector("Select Area");
	    }
	
	public ScreenRegionSelector(String promptText) {
		DesktopScreen screen = new DesktopScreen(0);
		this.setOpaque(true);
		this.promptText = promptText;
		
		JFrame f = new JFrame();
		f.setSize(screen.getSize());		
		f.add(this);
		f.pack( );	    
		f.setExtendedState( Frame.MAXIMIZED_BOTH);	
		
	    addMouseListener(this);
		addMouseMotionListener(this);
		f.addWindowListener(this);
		
		timerLabel = new JLabel();
		timerLabel.setSize(200, 100);
		timerLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		timerLabel.setForeground(Color.RED);
		f.add("North", timerLabel);			
		
		f.setVisible(true);	
	}
	
	public void setSelectedArea(){
		this.selectedArea = new DesktopScreenRegion(this.pointStart.x, this.pointStart.y, Math.abs(this.pointEnd.x - this.pointStart.x), Math.abs(this.pointEnd.y - this.pointStart.y) );
	}
	
	public DesktopScreenRegion getSelectedArea(){
		return this.selectedArea;
	}	
	
	public void updateTimerLabel(int timeRemaining){
		timerLabel.setText("Time Remaining: " + String.valueOf(timeRemaining));
	}	
	
	public void updateBackground( ) {
	    try {
	        Robot rbt = new Robot( );
	        Toolkit tk = Toolkit.getDefaultToolkit( );
	        Dimension dim = tk.getScreenSize( );
	        background = rbt.createScreenCapture( new Rectangle(0,0,(int)dim.getWidth( ), (int)dim.getHeight( ))) ;
	        
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

	@Override
	public void mouseDragged(MouseEvent e) {
        if(this.pointStart != null){
			this.drawRectangleFromSelection( this.pointStart, e.getPoint());
			System.out.println("Mouse dragged at " + e.getPoint().toString());	
		}
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		this.pointStart = e.getPoint();
		System.out.println("Mouse clicked at " + e.getPoint().toString());	
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	//	System.out.println("Mouse Entered at " + e.getPoint().toString());		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

	//	System.out.println("Mouse exited at " + e.getPoint().toString());		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.pointStart = e.getPoint();
	        
		System.out.println("Mouse pressed at " + e.getPoint().toString());		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (pointStart != null){
			this.pointEnd = e.getPoint();
			this.setSelectedArea();
			
			System.out.println("Mouse released at " + e.getPoint().toString());	
		}
		
		this.pointStart = null;
		this.pointEnd = null;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (this.selectedArea != null){
			
			System.out.println("New Rectangle selected at " + this.selectedArea.toString());	
			
	//		this.close();		
		}

	//	System.out.println("Mouse moved at " + e.getPoint().toString());		
		
	}
	
	public void drawRectangleFromSelection(Point topLeftCorner, Point bottomRightCorner){		 
	        if (pointStart != null) {
	        	g =  (Graphics2D)getGraphics();
	            g.setColor(Color.RED);
	            g.fillRect(topLeftCorner.x, topLeftCorner.y, bottomRightCorner.x - topLeftCorner.x, bottomRightCorner.y - topLeftCorner.y);
	            
	            Rectangle2D prostokat = new Rectangle2D.Double();

	            prostokat.setFrameFromDiagonal(topLeftCorner.x, topLeftCorner.y, bottomRightCorner.x, bottomRightCorner.y);
	            g.setComposite(AlphaComposite.getInstance(rule, alpha));
	            g.draw(prostokat);
	            g.setColor(Color.BLUE);
	            g.fill(prostokat);
	            
	           
	            g.setColor(Color.white);
	            g.setStroke(new BasicStroke(2.0f)); // 2-pixel lines
	            g.setFont(new Font("Serif", Font.BOLD, 18)); // 18-point font
	            g.drawString(promptText, (int)(topLeftCorner.x + bottomRightCorner.x)/2 , (int)(topLeftCorner.y + bottomRightCorner.y)/2 );
	            
	            this.paintComponent(g);
	            g.dispose();
	        }
	}
	
	public void close(){
		this.setVisible(false);
		System.exit(0);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		System.out.println("ScreenRegionSelector: WindowClosing called");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}	
	
}
