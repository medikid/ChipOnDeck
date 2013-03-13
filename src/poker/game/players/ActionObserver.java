package poker.game.players;

import java.awt.print.Paper;

import org.sikuli.api.ImageTarget;
import org.sikuli.api.Relative;
import org.sikuli.api.ScreenLocation;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.event.StateChangeEvent;
import org.sikuli.api.event.StateChangeListener;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;

import poker.resources.Images;

public class ActionObserver implements Runnable, StateChangeListener {
	Player p = null;
	ScreenRegion pDash = null;
	Thread ActionObserverThread = null;
	StateChangeListener scl = null;
	Canvas canvas = new DesktopCanvas();
	
	public ActionObserver(Player player){
		this.p = player;		
	}
	
	@Override
	public void run() {
		Thread myThread = Thread.currentThread();
		ScreenRegion pDash = p.DashRegion;
		while (ActionObserverThread == myThread){
			
			pDash.addState(new ImageTarget(Images.PlayerActionFold), TPlayerAction.FOLD );
			pDash.addState(new ImageTarget(Images.PlayerActionCheck), TPlayerAction.CHECK );
			pDash.addState(new ImageTarget(Images.PlayerActionCall), TPlayerAction.CALL );
			pDash.addState(new ImageTarget(Images.PlayerActionBet), TPlayerAction.BET);
			pDash.addState(new ImageTarget(Images.PlayerActionRaise), TPlayerAction.RAISE);
			pDash.addState(new ImageTarget(Images.PlayerActionReraise), TPlayerAction.RERAISE);
			
			pDash.addStateChangeEventListener(this);
		}
		
	}
	
	public void start(){
		if (this.ActionObserverThread == null){
			this.ActionObserverThread = new Thread(this, this.p.tableTag + "-" + this.p.tag + ": ActionObserver Started");
			this.ActionObserverThread.start();
		}
	}
	
	public void stop(){
		this.ActionObserverThread = null;
	}

	@Override
	public void stateChanged(StateChangeEvent e) {
		TPlayerAction sAction = (TPlayerAction) e.getNewState();
		System.out.println( p.tableTag + "-" + p.tag + ": Action = " + sAction.toString() );		
		p.didAction(new PlayerAction(sAction) );
		this.stop();
		
	}
}
