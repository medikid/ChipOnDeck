package poker.app.GUI.Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import poker.app.Window;
import poker.app.WindowManager;

@SuppressWarnings("serial")
public class TablesDisplayPanel extends JPanel implements ActionListener {
	List<JButton> componentList;
	int PAD = 10;
	GridBagConstraints gbc;
	WindowManager wManager;
	
	public TablesDisplayPanel()  
    {  		
        componentList = new ArrayList<JButton>();
    	this.setLayout(new GridBagLayout());
    	gbc = new GridBagConstraints();
    }
	
	public void setWindowManager(WindowManager winManager){
		this.wManager = winManager;
	}
	
	public void GBL_rearrange(){
		int n  = componentList.size();
		Component c = null;
		int i;
		this.removeAll(); //remove all components from displaypanel before rearranging
		switch(n){
			case 1:
				i=0;
				c = (Component) componentList.get(i);
				gbc.fill = GridBagConstraints.HORIZONTAL;
				gbc.ipady = 40;      //make this component tall
				gbc.weightx = 0.5;
				gbc.gridwidth = 1;
				gbc.gridx = 0;
				gbc.gridy = 0;
				
				this.add(c, gbc);
				break;
			case 2:
				i = 0;
				while(i < n){
					c = (Component) componentList.get(i);
					gbc.fill = GridBagConstraints.HORIZONTAL;
					gbc.ipady = 40;      //make this component tall
					gbc.weightx = 0.5;
					gbc.gridwidth = 1;
					gbc.gridx = i;
					gbc.gridy = 0;
					
					this.add(c, gbc);
					i++;
				}
				break;
			case 3:
				i = 0;
				while(i < n){
					c = (Component) componentList.get(i);
					gbc.fill = GridBagConstraints.HORIZONTAL;
					gbc.ipady = 40;      //make this component tall
					gbc.weightx = 0.5;
					gbc.gridwidth = 1;
					if (i == 0){ gbc.gridx = i; gbc.gridy = i; }
					else if (i == 1) { gbc.gridx = i; gbc.gridy = 0; }
					else if (i == 2) { gbc.gridx = 0; gbc.gridy = 1; }
					
					this.add(c, gbc);
					i++;
				}
				break;
			case 4:
				i = 0;
				while(i < n){
					c = (Component) componentList.get(i);
					gbc.fill = GridBagConstraints.HORIZONTAL;
					gbc.ipady = 40;      //make this component tall
					gbc.weightx = 0.5;
					gbc.gridwidth = 1;
					if (i == 0){ gbc.gridx = i; gbc.gridy = i; }
					else if (i == 1) { gbc.gridx = i; gbc.gridy = 0; }
					else if (i == 2) { gbc.gridx = 0; gbc.gridy = 1; }
					else if (i == 3) { gbc.gridx = 1; gbc.gridy = 1; }
					
					this.add(c, gbc);
					i++;
				}
				break;
			case 5:
				i = 0;
				while(i < n){
					c = (Component) componentList.get(i);
					gbc.fill = GridBagConstraints.HORIZONTAL;
					gbc.ipady = 40;      //make this component tall
					gbc.weightx = 0.5;
					gbc.gridwidth = 1;
					if (i == 0){ gbc.gridx = i; gbc.gridy = i; }
					else if (i == 1) { gbc.gridx = i; gbc.gridy = 0; }
					else if (i == 2) { gbc.gridx = 2; gbc.gridy = 0; }
					else if (i == 3) { gbc.gridx = 0; gbc.gridy = 1; }
					else if (i == 4) { gbc.gridx = 1; gbc.gridy = 1; }
					
					this.add(c, gbc);
					i++;
				}
				break;
			case 6:
				i = 0;
				while(i < n){
					c = (Component) componentList.get(i);
					gbc.fill = GridBagConstraints.HORIZONTAL;
					gbc.ipady = 40;      //make this component tall
					gbc.weightx = 0.5;
					gbc.gridwidth = 1;
					if (i == 0){ gbc.gridx = i; gbc.gridy = i; }
					else if (i == 1) { gbc.gridx = i; gbc.gridy = 0; }
					else if (i == 2) { gbc.gridx = 2; gbc.gridy = 0; }
					else if (i == 3) { gbc.gridx = 0; gbc.gridy = 1; }
					else if (i == 4) { gbc.gridx = 1; gbc.gridy = 1; }
					else if (i == 5) { gbc.gridx = 2; gbc.gridy = 1; }
					
					this.add(c, gbc);
					i++;
				}
				break;
			case 7:
				i = 0;
				while(i < n){
					c = (Component) componentList.get(i);
					gbc.fill = GridBagConstraints.HORIZONTAL;
					gbc.ipady = 40;      //make this component tall
					gbc.weightx = 0.5;
					gbc.gridwidth = 1;
					if (i == 0){ gbc.gridx = i; gbc.gridy = i; }
					else if (i == 1) { gbc.gridx = i; gbc.gridy = 0; }
					else if (i == 2) { gbc.gridx = 2; gbc.gridy = 0; }
					else if (i == 3) { gbc.gridx = 3; gbc.gridy = 0; }
					else if (i == 4) { gbc.gridx = 0; gbc.gridy = 1; }
					else if (i == 5) { gbc.gridx = 1; gbc.gridy = 1; }
					else if (i == 6) { gbc.gridx = 2; gbc.gridy = 1; }
					this.add(c, gbc);
					i++;
				}
				break;
			case 8:
				i = 0;
				while(i < n){
					c = (Component) componentList.get(i);
					gbc.fill = GridBagConstraints.HORIZONTAL;
					gbc.ipady = 40;      //make this component tall
					gbc.weightx = 0.5;
					gbc.gridwidth = 1;
					if (i == 0){ gbc.gridx = i; gbc.gridy = i; }
					else if (i == 1) { gbc.gridx = i; gbc.gridy = 0; }
					else if (i == 2) { gbc.gridx = 2; gbc.gridy = 0; }
					else if (i == 3) { gbc.gridx = 3; gbc.gridy = 0; }
					else if (i == 4) { gbc.gridx = 0; gbc.gridy = 1; }
					else if (i == 5) { gbc.gridx = 1; gbc.gridy = 1; }
					else if (i == 6) { gbc.gridx = 2; gbc.gridy = 1; }
					else if (i == 7) { gbc.gridx = 3; gbc.gridy = 1; }
					this.add(c, gbc);
					i++;
				}
				break;
		}
		this.revalidate();
		this.repaint();
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
		this.revalidate();
		this.repaint();
	}

	public void GBL_addNext(JButton tableButton) {
		tableButton.addActionListener(this);
		componentList.add(tableButton);
        this.GBL_rearrange();
        System.out.println("Added table display panel " + tableButton.getText());
	}
	
	public void addNext(JButton tableButton){
		componentList.add(tableButton);
		this.add(tableButton);
		Dimension d = tableButton.getPreferredSize();  
        Point p = getNextLocation(d);  
        tableButton.setBounds(p.x, p.y, d.width, d.height);
        this.rearrange();
        this.revalidate();
        this.repaint();
        System.out.println("Added table display panel " + tableButton.getText());
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
	
	public void GBL_removeLast() {
		int noOfTables = this.componentList.size();
		this.remove(noOfTables - 1);
		componentList.remove(noOfTables - 1);
		this.GBL_rearrange();
		this.revalidate();
		this.repaint();
		
	}	

	public void removeLast() {
		int noOfTables = this.componentList.size();
		this.remove(noOfTables - 1);
		componentList.remove(noOfTables - 1);
		rearrange();
		repaint();
		
	}
	
	public void focusTableSelected(){
		for(Component comp: this.componentList){
			JButton clickedTableButton = (JButton) comp;
			if(clickedTableButton.isSelected()){
				Window win = wManager.Windows.get(clickedTableButton.getText());				
				wManager.setWindowActive(win.getWindowHandle());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		for(Component comp: this.componentList){
			if(clickedButton == (JButton)comp){
				comp.setBackground(Color.green);
				clickedButton.setSelected(true);
			} else {
				comp.setBackground(Color.LIGHT_GRAY);
				clickedButton.setSelected(false);
			}
		}
		
		this.focusTableSelected();
		System.out.println(clickedButton.getText() + " Button clicked");
		
	}
	

}
