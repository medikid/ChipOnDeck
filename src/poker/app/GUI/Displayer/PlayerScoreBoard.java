package poker.app.GUI.Displayer;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class PlayerScoreBoard {

	Rectangle playerDash = new Rectangle (100, 100, 100, 100);
	float alpha = 0.40f;
	int type = AlphaComposite.SRC_OVER; 
	AlphaComposite composite = AlphaComposite.getInstance(type, alpha);
	
	public PlayerScoreBoard(){
		
	}
	
	private AlphaComposite makeComposite(float alpha) {
		  int type = AlphaComposite.SRC_OVER;
		  return(AlphaComposite.getInstance(type, alpha));
		 }
	
	public void paintBackground(Graphics g){
		Graphics2D g2 = (Graphics2D) g.create();
		Composite originalComposite = g2.getComposite();
		g2.setComposite(makeComposite(alpha));
		g2.setColor(Color.BLACK);
		g2.fillRect(playerDash.x, playerDash.y + playerDash.height, playerDash.width, playerDash.height);
		g2.setComposite(originalComposite);
		g2.setColor(Color.white);
		g2.drawString("Hello World", playerDash.x + 25, playerDash.y + playerDash.height + 25);
		
		
		
		
	}
	
}
