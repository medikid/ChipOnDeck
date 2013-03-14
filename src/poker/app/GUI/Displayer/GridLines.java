package poker.app.GUI.Displayer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.util.List;

public class GridLines {
	Color lineColor = Color.red;
    Graphics2D g2 = null;
    List<Rectangle> gridList;
	
	public GridLines(List<Rectangle> GridList){
		this.gridList = GridList;
	}
	  

    public void paint(Graphics g){
    	g2 = (Graphics2D) g.create();
    	Stroke brush = new BasicStroke(2);
        g2.setStroke(brush);
        g2.setColor(lineColor);
        
        for(Rectangle rect: gridList){
        	g2.drawLine(rect.x,  rect.y,  rect.width,  rect.height);
        }        
        
    }
}
