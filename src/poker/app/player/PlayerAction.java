package poker.app.player;

import poker.app.player.EPlayerActionType;

public class PlayerAction {
	public EPlayerActionType actionType = null;
	public double actionCash = (Double) null;
	
	public PlayerAction(EPlayerActionType ActionType, double... ActionCash){
		this.actionType = ActionType;
		
		if (ActionCash.length > 0){
			this.actionCash = ActionCash[0];
		} else this.actionCash = 0;
	}
}
