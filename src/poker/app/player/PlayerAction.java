package poker.app.player;

import poker.app.player.TPlayerAction;

public class PlayerAction {
	public TPlayerAction actionType = null;
	public double actionCash = (Double) null;
	
	public PlayerAction(TPlayerAction ActionType, double... ActionCash){
		this.actionType = ActionType;
		
		if (ActionCash.length > 0){
			this.actionCash = ActionCash[0];
		} else this.actionCash = 0;
	}
}
