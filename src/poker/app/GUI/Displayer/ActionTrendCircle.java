package poker.app.GUI.Displayer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

import poker.game.players.Player;

public class ActionTrendCircle{
    public Rectangle dash = null;
    Graphics2D g2 = null;
    
    public ActionTrendCircle(){
    	this.dash = new Rectangle(200, 200, 200, 200);
    }

    public void paintCircle(Graphics g){
    	g2 = (Graphics2D)g.create();
    	Stroke brush = new BasicStroke(10);
        g2.setStroke(brush);
        g2.setColor(Color.white);
        g2.drawArc(100, 100, 100, 100, 0, 90);
        g2.setColor(Color.yellow);
        g2.drawArc(100, 100, 100, 100, 0, -90);
        g2.setColor(Color.red);
        g2.drawArc(100, 100, 100, 100, 180, 90);
        g2.setColor(Color.gray);
        g2.drawArc(100, 100, 100, 100, 180, -90);
        
        PlayerScoreBoard psb = new PlayerScoreBoard();
        psb.paintBackground(g);
    }
}