package poker.app.player;

import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.event.StateChangeEvent;
import org.sikuli.api.event.StateChangeListener;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;

import poker.Images;

public class StatusObserver implements Runnable, StateChangeListener {
	Player p = null;
	ScreenRegion pDash = null;
	Thread StatusObserverThread = null;
	
	public StatusObserver(Player player){
		this.p = player;
	}
	
	@Override
	public void run() {
		Thread myThread = Thread.currentThread();
		ScreenRegion pDash = p.DashRegion;
		while (StatusObserverThread == myThread){
			
			pDash.addState(new ImageTarget(Images.PlayerStatusPSmall), EPlayerStatusType.PSMALL );
			pDash.addState(new ImageTarget(Images.PlayerStatusPBig), EPlayerStatusType.PBIG );
			pDash.addState(new ImageTarget(Images.PlayerStatusWinner), EPlayerStatusType.WINNER );
			pDash.addState(new ImageTarget(Images.PlayerStatusMuck), EPlayerStatusType.MUCK);
			pDash.addState(new ImageTarget(Images.PlayerStatusSitout), EPlayerStatusType.SITOUT);
			pDash.addState(new ImageTarget(Images.PlayerStatusBuyin), EPlayerStatusType.BUYIN);
			
			pDash.addStateChangeEventListener(this);
		}
		
	}
	
	public void start(){
		if (this.StatusObserverThread == null){
			this.StatusObserverThread = new Thread(this, this.p.tableTag + "-" + this.p.tag + ": StatusObserver started.");
			this.StatusObserverThread.start();
		} else this.StatusObserverThread.start();
	}
	
	public void stop(){
		this.StatusObserverThread = null;
	}

	@Override
	public void stateChanged(StateChangeEvent e) {
		EPlayerStatusType sStatus = (EPlayerStatusType) e.getNewState();
		System.out.println( this.p.tableTag + "-" + this.p.tag + ": Status = " + sStatus.toString() );
		if (p.getStatus() != sStatus){
			p.setStatus(sStatus);
		}
		
		this.stop();
		
	}


}
