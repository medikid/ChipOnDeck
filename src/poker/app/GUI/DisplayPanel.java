package poker.app.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.sikuli.api.DesktopScreenRegion;

import poker.app.player.Player;

class DisplayPanel extends JPanel {
	Player p;
	
    ActionTrendCircle redSquare;

    public DisplayPanel() {    	
    	redSquare = new ActionTrendCircle();
    }


    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }
    
    public void paintComponent(Graphics g) {
    	super.setOpaque(false);
       super.paintComponent(g);       
        g.drawString("This is my custom Panel!",10,20);
        
        if(this.redSquare != null){
        	this.redSquare.paintCircle(g);
        }
    }
    
    public void clearPaint(){
    	this.redSquare = null;
    	this.repaint(0, 0, 500, 500);
    }
}
