package poker.game.players;

import poker.game.players.TPlayerAction;

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
