package poker.app.player;

import java.util.EventObject;

public interface PlayerActionEventListener {
	public void onAction(EventObject e);
	public void onActionRequestReceived(EventObject e);
	public void onActionRequestPassed(EventObject e);
	public void onActionPerformed(EventObject e);
	public void onActionCancelled(EventObject e);
}
