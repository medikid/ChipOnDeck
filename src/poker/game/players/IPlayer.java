package poker.game.players;

import org.sikuli.api.ScreenRegion;

import poker.app.game.TRound;
import poker.game.tools.tables.Table;

public interface IPlayer {	
	
	public void setTable(Table TableObj);
	public Table getTable();
	
	public void setTableTag();		
	public String getTableTag();
	
	public void setSeatNumber(int SeatNumber);	
	public int getSeatNumber();
	
	public void setPrevPlayer(Player prevPlayer);
	public Player getPrevPlayer();
	
	public void setNextPlayer(Player nextPlayer);
	public Player getNextPlayer();
	
	public void setTag(String Tag);
	public String getTag();
	
	public void setName(String Name);
	public String getName();
	
	public void setCash(double Cash);
	public double getCash();
	
	public void setStatus(EPlayerStatusType PlayerStatus);
	public EPlayerStatusType getStatus();
	
	public void startStatusObserver();
	public void stopStatusObserver();
	
	public void passActionRequest();
	public void actionRequestReceived();	
	public void actionRequestPassed();
	public void setAction(PlayerAction pAction);
	public void doAction();
	public void didAction(PlayerAction pAction);
	public void cancelAction();
	public void updateActionTrend(TRound gRound, PlayerAction pAction);
	public PlayerAction getLastAction(TRound gRound);
	public void removeActionTrend(TRound gRound);
	public void resetActionTrend();
	
	public void startActionObserver();
	public void stopActionObserver();
	
	public void addActionEventListener(PlayerActionEventListener ActionEventListener);
	public void removeActionEventListener(PlayerActionEventListener ActionEventListener);
	
	public void playerActionEventHandler(PlayerAction pAction);
	
}
