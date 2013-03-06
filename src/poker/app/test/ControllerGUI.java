package poker.app.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ScreenRegion;


public class ControllerGUI {
	public ControllerGUI(){
		final TablesDisplayPanel tdp = new TablesDisplayPanel();
		tdp.setSize(200, 50);
		final JButton
			addTable = new JButton("Add"),
			reArrangeTable = new JButton("Rearrange"),
			removeTable = new JButton("Remove"),
			clearTable = new JButton("Clear");
		
		ActionListener l = new ActionListener(){
			int tablesCount = 0;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton clickedButton = (JButton) e.getSource();
				
				switch(clickedButton.getText()){
				case "Add":
					JButton tableButton = new JButton("T" + ++tablesCount );
					tdp.addNext(tableButton);
					break;
				case "Rearrange":
					tdp.rearrange();
					break;
				case "Remove":
					tdp.removeLast();
					--tablesCount;
					break;					
				case "Clear":
					tdp.clear();
					tablesCount = 0;
					break;
				}
			}
		};
		addTable.addActionListener(l);  
        reArrangeTable.addActionListener(l);
        removeTable.addActionListener(l);
        clearTable.addActionListener(l); 
        
        JPanel north = new JPanel();  
        north.add(addTable);  
        north.add(reArrangeTable);  
        north.add(removeTable); 
        north.add(clearTable);
        
        JFrame f = new JFrame();  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.getContentPane().add(north, "North");
        tdp.setSize(f.getWidth(), (int)(f.getHeight() * 0.20));
        tdp.setLocation(f.getX(), f.getY() + (int)(f.getHeight() * 0.20));
        f.getContentPane().add(tdp);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle desktopSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

        f.setSize((int)(desktopSize.width / 3),(int)(desktopSize.height / 2));  
        f.setLocation( 
        		(int)(desktopSize.x + ((desktopSize.width / 3) * 2)),
        		(int)(desktopSize.y + ((desktopSize.height / 2)))
        		);  
        f.setVisible(true);  
		
		
	}
	
	public static void main(String[] args) {
		new ControllerGUI();

	}



public class TablesDisplayPanel extends JPanel {
	List componentList;
	int PAD = 10;
	int maxTablesPerRow = 4;
	int maxTablesPerCol = 2;
	
	public TablesDisplayPanel()  
    {  
		this.setBackground(Color.yellow);
        componentList = new ArrayList();          
      //  setLayout(null);
        setLayout(new BorderLayout());
    } 
	
	public void rearrange() {
		int n  = componentList.size();
		Rectangle panRect = this.getBounds();
		Component c = null;
		int i;
		switch(n){
			case 1:
				i = 0;
				c = (Component) componentList.get(i);
				c.setSize(panRect.width, panRect.height);
				c.setLocation(panRect.x, panRect.y);
				break;
			case 2:
				i = 0;
				while(i < n){
					c = (Component) componentList.get(i);
					c.setSize((int)(panRect.width / 2), panRect.height);
					if (i == 0){ c.setLocation(panRect.x, panRect.y); }
					else if (i == 1) { c.setLocation(panRect.x + (int)(panRect.width / 2), panRect.y); }
					i++;
				}
				break;
			case 3:
				i = 0;
				while(i < n){
					c = (Component) componentList.get(i);
					c.setSize((int)(panRect.width / 2), (int)(panRect.height /2));
					if (i == 0){ c.setLocation(panRect.x, panRect.y); }
					else if (i == 1) { c.setLocation(panRect.x + (int)(panRect.width / 2), panRect.y); }
					else if (i == 2) { c.setLocation(panRect.x, (panRect.y + (int)(panRect.height / 2)) ); }
					i++;
				}
				break;
			case 4:
				i = 0;
				while(i < n){
					c = (Component) componentList.get(i);
					c.setSize((int)(panRect.width / 2), (int)(panRect.height / 2));
					if (i == 0){ c.setLocation(panRect.x, panRect.y); }
					else if (i == 1) { c.setLocation(panRect.x + (int)(panRect.width / 2), panRect.y); }
					else if (i == 2) { c.setLocation(panRect.x, (panRect.y + (int)(panRect.height / 2)) ); }
					else if (i == 3) { c.setLocation(panRect.x + (int)(panRect.width / 2), (panRect.y + (int)(panRect.height / 2)) ); }
					i++;
				}
				break;
			case 5:
				i = 0;
				while(i < n){
					c = (Component) componentList.get(i);
					c.setSize((int)(panRect.width / 3), (int)(panRect.height /2));
					if (i == 0){ c.setLocation(panRect.x, panRect.y); }
					else if (i == 1) { c.setLocation(panRect.x + (int)(panRect.width / 3), panRect.y); }
					else if (i == 2) { c.setLocation(panRect.x + (int)((panRect.width / 3) * 2), panRect.y); }
					else if (i == 3) { c.setLocation(panRect.x, (panRect.y + (int)(panRect.height / 2)) ); }
					else if (i == 4) { c.setLocation(panRect.x + (int)((panRect.width / 3)), (panRect.y + (int)(panRect.height / 2))); }
					i++;
				}
				
				break;
			case 6:
				i = 0;
				while(i < n){
					c = (Component) componentList.get(i);
					c.setSize((int)(panRect.width / 3), (int)(panRect.height /2));
					if (i == 0){ c.setLocation(panRect.x, panRect.y); }
					else if (i == 1) { c.setLocation(panRect.x + (int)(panRect.width / 3), panRect.y); }
					else if (i == 2) { c.setLocation(panRect.x + (int)((panRect.width / 3) * 2), panRect.y); }
					else if (i == 3) { c.setLocation(panRect.x, (panRect.y + (int)(panRect.height / 2)) ); }
					else if (i == 4) { c.setLocation(panRect.x + (int)((panRect.width / 3)), (panRect.y + (int)(panRect.height / 2))); }
					else if (i == 5) { c.setLocation(panRect.x + (int)((panRect.width / 3) * 2), (panRect.y + (int)(panRect.height / 2))); }
					i++;
				}
				break;
			case 7:
				i = 0;
				while(i < n){
					c = (Component) componentList.get(i);
					c.setSize((int)(panRect.width / 4), (int)(panRect.height /2));
					if (i == 0){ c.setLocation(panRect.x, panRect.y); }
					else if (i == 1) { c.setLocation(panRect.x + (int)(panRect.width / 4), panRect.y); }
					else if (i == 2) { c.setLocation(panRect.x + (int)((panRect.width / 4) * 2), panRect.y); }
					else if (i == 3) { c.setLocation(panRect.x + (int)((panRect.width / 4) * 3), panRect.y); }
					else if (i == 4) { c.setLocation(panRect.x, (panRect.y + (int)(panRect.height / 2))); }
					else if (i == 5) { c.setLocation(panRect.x + (int)(panRect.width / 4), (panRect.y + (int)(panRect.height / 2))); }
					else if (i == 6) { c.setLocation(panRect.x + (int)((panRect.width / 4) * 2), (panRect.y + (int)(panRect.height / 2))); }
					i++;
				}
				break;
			case 8:
				i = 0;
				while(i < n){
					c = (Component) componentList.get(i);
					c.setSize((int)(panRect.width / 4), (int)(panRect.height /2));
					if (i == 0){ c.setLocation(panRect.x, panRect.y); }
					else if (i == 1) { c.setLocation(panRect.x + (int)(panRect.width / 4), panRect.y); }
					else if (i == 2) { c.setLocation(panRect.x + (int)((panRect.width / 4) * 2), panRect.y); }
					else if (i == 3) { c.setLocation(panRect.x + (int)((panRect.width / 4) * 3), panRect.y); }
					else if (i == 4) { c.setLocation(panRect.x, (panRect.y + (int)(panRect.height / 2))); }
					else if (i == 5) { c.setLocation(panRect.x + (int)(panRect.width / 4), (panRect.y + (int)(panRect.height / 2))); }
					else if (i == 6) { c.setLocation(panRect.x + (int)((panRect.width / 4) * 2), (panRect.y + (int)(panRect.height / 2))); }
					else if (i == 7) { c.setLocation(panRect.x + (int)((panRect.width / 4) * 3), (panRect.y + (int)(panRect.height / 2))); }
					i++;
				}
				break;
			
		}
		repaint();
	}

	public void addNext(JButton tableButton) {
		componentList.add(tableButton);
		add(tableButton);
		
		Dimension d = tableButton.getPreferredSize();  
        Point p = getNextLocation(d);  
        tableButton.setBounds(p.x, p.y, d.width, d.height);
        rearrange();
        repaint();
	}

	private Point getNextLocation(Dimension d) {
		int maxX = 0, maxY = 0;  
        Component c, last = null;  
        Rectangle r;  
        // find level of lowest component(s)  
        for(int j = 0; j < componentList.size(); j++)  
        {  
            c = (Component)componentList.get(j);  
            r = c.getBounds();  
            if(r.y + r.height > maxY)  
            {  
                maxY = r.y + r.height;  
                last = c;  
            }  
        }  
        // find last (in row) of lowest components  
        for(int j = 0; j < componentList.size(); j++)  
        {  
            c = (Component)componentList.get(j);  
            r = c.getBounds();  
            if(r.y + r.height == maxY && r.x + r.width > maxX)  
            {  
                maxX = r.x + r.width;  
                last = c;  
            }  
        }  
        // determine location of next component based on location of last  
        Point p = new Point();  
        if(last == null)                                // first component  
        {  
            p.x = PAD;  
            p.y = PAD;  
            return p;  
        }  
        r = last.getBounds();  
        int x, y;  
        if(r.x + r.width + PAD + d.width < getWidth())  // next in row  
        {  
            p.x = r.x + r.width + PAD;  
            p.y = r.y;  
        }  
        else                                            // skip to new row  
        {  
            p.x = PAD;  
            p.y = r.y + r.height + PAD;  
        }  
        return p;  
	}

	public void clear() {
		this.removeAll();
		componentList.clear();
		repaint();
		
	}

	public void removeLast() {
		int noOfTables = this.componentList.size();
		this.remove(noOfTables - 1);
		componentList.remove(noOfTables - 1);
		rearrange();
		repaint();
		
	}
	
}

}