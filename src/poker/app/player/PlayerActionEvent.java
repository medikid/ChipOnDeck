package poker.app.player;

import java.util.EventObject;

import poker.app.player.TPlayerAction;

@SuppressWarnings("serial")
public class PlayerActionEvent extends EventObject {
	TPlayerAction Action;
	double ActionCash;
	String Player;
	String Table;
	int SeatNumber;
	
	
	public PlayerActionEvent(Object source, PlayerAction Action) {
		super(source);
		Player p = (Player)source;
		this.Action = Action.actionType;
		this.ActionCash = Action.actionCash;
		this.Player = p.getTag();
		this.Table = p.getTableTag();
		this.SeatNumber = p.seatNumber;
	}
	
	public String toString(){
		String result = null;
		
		return result;
	}

} 
