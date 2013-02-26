package poker.app;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClickThrough {
	private DisplayMode dispModeOld;
	private Boolean fullscreen;
	private static JFrame f;
	
    @SuppressWarnings("serial")
	public static void main(String[] args) {
    	JFrame.setDefaultLookAndFeelDecorated(true);
        f = new JFrame("Test");

        f.setAlwaysOnTop(true);
        Component c = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D)g.create();
                g2.setColor(Color.gray);
                int w = getWidth();
                int h = getHeight();
                g2.fillRect(0, 0, w,h);
                g2.setComposite(AlphaComposite.Clear);
                g2.fillRect(w/4, h/4, w-2*(w/4), h-2*(h/4));
            }
        };
        c.setPreferredSize(new Dimension(300, 300));
        f.getContentPane().add(c);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 //       f.setUndecorated(true); // Only required for Mac computers. remove this line if this cause problems
        f.pack();        
        f.setVisible(true);
        com.sun.awt.AWTUtilities.setWindowOpaque(f,false);
    }
    
    /**
     * Method allows changing whether this window is displayed in fullscreen or
     * windowed mode.
     * @param fullscreen true = change to fullscreen,
     *                   false = change to windowed
     */
    public void setFullscreen( boolean fullscreen ){
        //get a reference to the device.
        GraphicsDevice device  = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        DisplayMode dispMode = device.getDisplayMode();
        //save the old display mode before changing it.
        dispModeOld = device.getDisplayMode();

        if( this.fullscreen != fullscreen )
        { //are we actually changing modes.
            //change modes.
            this.fullscreen = fullscreen;
            // toggle fullscreen mode
            if( !fullscreen )
            {
                //change to windowed mode.
                //set the display mode back to the what it was when
                //the program was launched.
                device.setDisplayMode(dispModeOld);
                //hide the frame so we can change it.
               
                f.setVisible(false);
                //remove the frame from being displayable.
                f.dispose();
                //put the borders back on the frame.
                f.setUndecorated(false);
                //needed to unset this window as the fullscreen window.
                device.setFullScreenWindow(null);
                //recenter window
                f.setLocationRelativeTo(null);
                f.setResizable(true);

                //reset the display mode to what it was before
                //we changed it.
                f.setVisible(true);

            }
            else
            { //change to fullscreen.
                //hide everything
                f.setVisible(false);
                //remove the frame from being displayable.
                f.dispose();
                //remove borders around the frame
                f.setUndecorated(true);
                //make the window fullscreen.
//                device.setFullScreenWindow(this);
                device.setFullScreenWindow(ClickThrough.f);
                //attempt to change the screen resolution.
                device.setDisplayMode(dispMode);
                f.setResizable(false);
                f.setAlwaysOnTop(false);
                //show the frame
                f.setVisible(true);
            }
            //make sure that the screen is refreshed.
            f.repaint();
        }
    }

}
