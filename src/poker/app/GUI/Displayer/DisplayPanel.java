package poker.app.GUI.Displayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.sikuli.api.DesktopScreenRegion;

import poker.game.players.Player;

@SuppressWarnings("serial")
public class DisplayPanel extends JPanel {
	Player p;
	Graphics g;
	
    ActionTrendCircle redSquare;
    public PaintObject PaintObj;

    public DisplayPanel() {    	
    	this.redSquare = new ActionTrendCircle();
    	this.g = this.getGraphics();
    	this.PaintObj = new PaintObject(this.g);
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
    
    public void drawGrids(List<Rectangle> gridList){
    	GridLines gls = new GridLines(gridList);
    	gls.paint(this.getGraphics());
    }
}
