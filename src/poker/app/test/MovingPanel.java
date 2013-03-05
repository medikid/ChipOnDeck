package poker.app.test;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MovingPanel extends JPanel implements MouseListener,
		MouseMotionListener {
	HashSet movables = new HashSet(10);
	private Dimension dims;

	public MovingPanel(int width, int height) {
		this.setLayout(null);
		this.dims = new Dimension(width, height);
	}

	public void addComponent(JComponent comp, int x, int y) {
		movables.add(comp);
		comp.addMouseMotionListener(this);
		comp.addMouseListener(this);
		super.add(comp);
		Insets insets = this.getInsets();
		comp.setBounds(x + insets.left, y + insets.top,
				comp.getMinimumSize().width, comp.getMinimumSize().height);
	}

	private int oldx, oldy;
	private boolean firstevent = true;
	private Object clickedComponent;

	public void mouseDragged(MouseEvent me) {
		JComponent o = (JComponent) me.getSource();
		if (movables.contains(o)) {
			if (clickedComponent == o) {
				int eventx = me.getX();
				int eventy = me.getY();

				if (Math.abs(eventx - oldx) > 5 || Math.abs(eventy - oldy) > 5) {
					Rectangle r = o.getBounds();
					int x = (int) r.getX();
					int y = (int) r.getY();
					o.setBounds(x + (eventx - oldx), y + (eventy - oldy),
							o.getMinimumSize().width, o.getMinimumSize().height);
					oldx = eventx;
					oldy = eventy;
				}
			}
		}
	}

	public void mouseMoved(MouseEvent me) {

	}

	public void mousePressed(MouseEvent e) {
		clickedComponent = e.getSource();
		oldx = e.getX();
		oldy = e.getY();
	}

	public void mouseReleased(MouseEvent e) {
		clickedComponent = null;
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public Dimension getMinimumSize() {
		return dims;
	}

	public Dimension getMaximumSize() {
		return dims;
	}

	public Dimension getPreferedSize() {
		return dims;
	}

	public static void main(String[] args) {
		JFrame jf = new JFrame("MovePanelTest");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(400, 400);
		MovingPanel mp = new MovingPanel(100, 200);
		JLabel lb = new JLabel("AAAAA AAAA AAA");
		jf.getContentPane().add(mp, BorderLayout.CENTER);
		mp.addComponent(lb, 50, 20);
		jf.setVisible(true);
	}
}
