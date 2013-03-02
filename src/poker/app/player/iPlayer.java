package poker.app.player;

import org.sikuli.api.ScreenRegion;

import poker.app.table.Table;

public interface iPlayer {	
	public enum ACTION_TYPE { FOLD, CHECK, CALL, BET, RAISE, RERAISE }
	
	public void setTable(Table TableObj);		
	public Table getTable();
	
	public void setSeatNumber(int SeatNumber);	
	public int getSeatNumber();
	
	public void setTag();
	public String getTag();
	
	public void setName(String Name);
	public String getName();
	
	public void setCash(double Cash);
	public double getCash();
	
	public void setAction(ACTION_TYPE action, double[] ActionCash);
	public void doAction();
}
