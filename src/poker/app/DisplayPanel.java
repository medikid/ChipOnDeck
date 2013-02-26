package poker.app;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DisplayPanel extends JPanel {
	public PanelType panelType;
	
	public DisplayPanel(PanelType pnlType){
		this.panelType = pnlType;
	}
	
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g.create();
            switch(this.panelType){
            	case GLASS_BACKGROUND:
            		g2.setColor(Color.gray);
                    int w = getWidth();
                    int h = getHeight();
                    g2.fillRect(0, 0, w,h);
                    g2.setComposite(AlphaComposite.Clear);
                    g2.fillRect(0, 0, w, h);  
            		break;
            	case CIRCLE_OF_ACTION:
            		Stroke brush = new BasicStroke(10);
	                 g2.setStroke(brush);
	                 g2.setColor(Color.red);
	                 g2.drawArc(100, 100, 100, 100, 90, -90);
	                 g2.setColor(Color.yellow);
	                 g2.drawArc(100, 100, 100, 100, 180, -90);
	                 g2.setColor(Color.blue);
	                 g2.drawArc(100, 100, 100, 100, 270, -90);
	                 g2.setColor(Color.magenta);
	                 g2.drawArc(100, 100, 100, 100, 360, -90);
            		break;
            	case PLAYER_SCOREBOARD:
            		break;
            	case TABLE_DASHBOARD:
            		break;
            	default:
            		break;
            
            }
                          
           
        }
    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
