package poker.app;

import org.sikuli.api.Relative;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.event.StateChangeEvent;
import org.sikuli.api.event.StateChangeListener;
import org.sikuli.api.event.TargetEvent;
import org.sikuli.api.event.TargetEventListener;
import org.sikuli.api.visual.ScreenPainter;

public class Observer implements TargetEventListener, StateChangeListener {	
	static ScreenPainter painter = new ScreenPainter();
	ScreenRegion _screenRegion;
	Target _target;
	
	public Observer(ScreenRegion screenRegion, Target target, Object stateTitle){
		this._screenRegion = screenRegion;
		this._target = target;
		this._screenRegion.addTargetEventListener(_target, this);
		
		this._screenRegion.addState(_target, stateTitle);
		this._screenRegion.addStateChangeEventListener(this);
	}
	
	public void addState(Target target, Object stateTitle){
		this._screenRegion.addState(target, stateTitle);
	}
	
	@Override
	public void targetAppeared(TargetEvent event) {
		System.out.println(event.getTarget() + " has appeared within " + event.getScreenRegion() + 
				" at " + Relative.to(event.getTargetRegion()).topLeft().getScreenLocation());	
		painter.box(event.getTargetRegion(), 1000);
		painter.label(event.getTargetRegion(), "appeared", 1000);
	}

	@Override
	public void targetVanished(TargetEvent event) {
		System.out.println(event.getTarget() + " has vanished from " + event.getScreenRegion());
		painter.box(event.getTargetRegion(), 1000);
		painter.label(event.getTargetRegion(), "vanished", 1000);
	}

	@Override
	public void targetMoved(TargetEvent event) {
		System.out.println(event.getTarget() + " has moved to " + 
				Relative.to(event.getTargetRegion()).topLeft().getScreenLocation());
		painter.box(event.getTargetRegion(), 1000);
		painter.label(event.getTargetRegion(), "moved", 1000);
	}


	@Override
	public void stateChanged(StateChangeEvent event) {
		System.out.println(event.getScreenRegion() + "'s state is changed " +
				"from {" + event.getOldState() + "} " +
				" to {" + event.getNewState() + "}");						
	}		
}
