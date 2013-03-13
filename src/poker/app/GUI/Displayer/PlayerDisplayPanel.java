package poker.app.GUI.Displayer;

import java.awt.Graphics;
import java.awt.Rectangle;

import poker.game.players.Player;

public class PlayerDisplayPanel {
	Player p;
	Rectangle pDash;
	Integer pSeatNo;
	
	
	PlayerDisplayPanel(Player player){
		this.p = player;
		pDash = p.DashRegion.getBounds();
		pSeatNo = p.getSeatNumber();
	}
	
	public void drawPanel(Graphics g){
		
	}
	
}
