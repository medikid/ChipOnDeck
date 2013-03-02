package poker.app.player;

import org.sikuli.api.ScreenRegion;

import poker.app.table.Table;

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
	
	public void passActionRequest();
	public void actionRequestReceived();	
	public void actionRequestPassed();
	public void setAction(PlayerAction pAction);
	public void doAction();
	public void didAction(PlayerAction pAction);
	public void cancelAction();
	
	public void startActionObserver();
	public void stopActionObserver();
	
	public void addActionEventListener(PlayerActionEventListener ActionEventListener);
	public void removeActionEventListener(PlayerActionEventListener ActionEventListener);
	
	public void playerActionEventHandler(PlayerAction pAction);
}
