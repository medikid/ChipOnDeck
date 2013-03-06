package poker.app.player;

import java.util.HashMap;
import java.util.Map;

import poker.app.game.TRound;

public class ActionTrend {
	Map<TRound, PlayerAction> trend;
	
	public ActionTrend(){
		this.trend = new HashMap<TRound, PlayerAction>();
	}
	
	public void reset(){
		this.trend.clear();
	}
	
	public void add(TRound gRound, PlayerAction pAction){
		this.trend.put(gRound, pAction);
	}
	
	public PlayerAction getLastAction(TRound gRound){
		PlayerAction lastAction = null;
		if (this.trend.containsKey(gRound)){
		lastAction = this.trend.get(gRound);
		}
		
		return lastAction;
	}
	
	public void removeLastAction(TRound gRound){
		this.trend.remove(gRound);
	}
	
	public void toDisplay(){
		
	}
}
