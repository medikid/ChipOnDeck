package poker.app.GUI.Displayer;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.util.List;

import poker.game.players.Player;
import poker.game.tools.tables.Table;

public class PaintObject {
	Graphics g;
	Color defaultColor = Color.red;
	Stroke brush = new BasicStroke(10);
	float alpha = 0.40f;
	int type = AlphaComposite.SRC_OVER; 
	AlphaComposite composite = AlphaComposite.getInstance(type, alpha);
	
	public PaintObject(Graphics graphics){
		setGraphics(graphics);
		setColor(defaultColor);
	}
	
	public void setGraphics(Graphics G){
		this.g = G;
	}
	
	public Graphics getGraphics(){
		return this.g;
	}
	
	public void disposeGraphics(){
		g.dispose();
	}
	
	public void setColor(Color c){
		this.g.setColor(c);
	}
	
	public void setBrushStroke(int stroke){
		this.brush = new BasicStroke(stroke);
	}
	
	public void line(Point startP, Point endP){
		g.drawLine(startP.x, startP.y, endP.x, endP.y);	
	}
	
	public void rectangle(Rectangle rect){
		g.drawRect(rect.x,  rect.y, rect.width, rect.height);
	}
	
	public void circle(Rectangle rect){
		g.drawOval(rect.x,  rect.y, rect.width, rect.height);
	}
	
	public void GridLines(Table table, int rows, int cols){
		List<Rectangle> gridlines = table.getGridLines(rows, cols);
		for(Rectangle gridline: gridlines){
			this.line(new Point(gridline.x, gridline.y), new Point(gridline.width, gridline.height));
		}
	}
	
	private AlphaComposite makeComposite(float alpha) {
		  int type = AlphaComposite.SRC_OVER;
		  return(AlphaComposite.getInstance(type, alpha));
		 }
	
	public void ActionTrendCircle(Player player){
		Rectangle pDash = player.DashRegion.getBounds();
		
		Graphics2D g2 = (Graphics2D) g.create();
		this.setBrushStroke(10);
		g2.setStroke(this.brush);
		
		g2.setColor(Color.white);
        g2.drawArc(pDash.x, pDash.y, pDash.width, pDash.height, 0, 90); // start at 3'OClock and go 90degree antiClockwise
        g2.setColor(Color.yellow);
        g2.drawArc(pDash.x, pDash.y, pDash.width, pDash.height, 0, -90); // start at 3'OClock and go 90degree Clockwise
        g2.setColor(Color.red);
        g2.drawArc(pDash.x, pDash.y, pDash.width, pDash.height, 180, 90);
        g2.setColor(Color.gray);
        g2.drawArc(pDash.x, pDash.y, pDash.width, pDash.height, 180, -90);
	}
	
	public void PlayerScoreBoard(Player player){
		Rectangle pDash = player.DashRegion.getBounds();
		
		Graphics2D g2 = (Graphics2D) g.create();
		Composite originalComposite = g2.getComposite();
		g2.setComposite(makeComposite(alpha));
		g2.setColor(Color.BLACK);
		g2.fillRect(pDash.x, pDash.y + pDash.height, pDash.width, pDash.height);
		g2.setComposite(originalComposite);
		g2.setColor(Color.white);
		g2.drawString("Hello World", pDash.x + 25, pDash.y + pDash.height + 25);
	}
	
	
	
}
