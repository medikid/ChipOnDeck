package poker.app.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

import poker.app.Timer.TimerListener;

public class GlassOverlay implements Runnable {
	private Thread guiThread = null;
	public JFrame glassFrame = null;
	public DisplayPanel dPanel = null;
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new GlassOverlay().Start();
				}
			});
		
	}

	@Override
	public void run() {
		//Thread myThread = Thread.currentThread();
	//	while(this.guiThread == myThread){
			System.out.println("My Thread is running from run()");
		
		this.createAndShowGUI();
		
		try {
			Thread.sleep(2000);
			this.dPanel.clearPaint();
			Thread.sleep(2000);
			Graphics g = this.dPanel.getGraphics();
			this.dPanel.redSquare = new ActionTrendCircle();
			this.dPanel.redSquare.paintCircle(g);
			this.dPanel.repaint();
			Thread.sleep(2000);
			this.dPanel.clearPaint();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	}
	}
	

	private void createAndShowGUI() {
        this.glassFrame= new JFrame();
        
        this.glassFrame.setAlwaysOnTop(true);
        this.glassFrame.setUndecorated(true); // Only required for Mac computers. remove this line if this cause problems
	//	DisplayPanel c = new DisplayPanel(PanelType.GLASS_BACKGROUND);
	//	c.setLayout(new BorderLayout());
        
        this.addHotKey(this.createKeyStroke("ctrl shift released F1"), "Minimize", new AbstractAction(){
        	@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("You Minimizing with the hot key");
				MinimizeGUI();
			}
        });
        
        this.addHotKey(this.createKeyStroke("ctrl shift released F2"), "Maximize", new AbstractAction(){
        	@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("You Maximizing with the hot key");
				MaximizeGUI();
			}
        });
        
        this.addHotKey(this.createKeyStroke("ctrl shift released F3"), "Close", new AbstractAction(){
        	@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("You closing with the hot key");
				CloseGUI();
			}
        });
        
        this.dPanel = new DisplayPanel();
        this.glassFrame.add(this.dPanel);
        this.glassFrame.setPreferredSize(this.glassFrame.getSize());
     //   frame.getContentPane().add(jp);
        this.glassFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.glassFrame.setExtendedState( JFrame.MAXIMIZED_BOTH);	//set full screen maximized to start
        
        this.glassFrame.pack();        
        this.glassFrame.setVisible(true);
        com.sun.awt.AWTUtilities.setWindowOpaque(this.glassFrame, false);        
    } 
	
	public void Start(){
		if(this.guiThread == null){
			this.guiThread = new Thread(this, "gui Thread");
			guiThread.start();
		}
	}
	
	public void Stop(){
		if ( this.guiThread == Thread.currentThread()){
			this.guiThread.interrupt();
			this.guiThread = null;
		}
	}
	
	public void CloseGUI(){
		this.glassFrame.setVisible(false);
		this.glassFrame.dispose();
		this.Stop();
		System.out.println("Finished Close GUI, is WIndow closed now?");
	}
	
	public void MinimizeGUI(){
		if (this.glassFrame.getState() == JFrame.ICONIFIED){
			this.glassFrame.setState(JFrame.NORMAL);
		} else this.glassFrame.setState(JFrame.ICONIFIED);
	}
	
	public void MaximizeGUI(){
		if (this.glassFrame.getExtendedState() == JFrame.MAXIMIZED_BOTH){
			this.glassFrame.setExtendedState(JFrame.NORMAL);
		} else this.glassFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public void addCloseButton(){
		JButton closeBtn = new JButton("Close Now");
        closeBtn.setBounds(0, 0, 100, 20);
        closeBtn.setBackground(Color.green);
        closeBtn.setBorder(BorderFactory.createBevelBorder( BevelBorder.LOWERED));
                
        
        closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("You clicked the button");
                JButton jb = (JButton) e.getSource();
                jb.dispatchEvent(e);
               
            }
        });

        this.glassFrame.add(closeBtn);
	}
	
	public void addHotKey(KeyStroke kStroke, String kWord, AbstractAction actionListener){
		 JPanel content = (JPanel) this.glassFrame.getContentPane();
		InputMap inputMap = content.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(kStroke, kWord);
        content.getActionMap().put(kWord, actionListener);
	}
	
	public KeyStroke createKeyStroke(String keyStrokes){
		KeyStroke kStroke = KeyStroke.getKeyStroke(keyStrokes);
		return kStroke;
	}

}
