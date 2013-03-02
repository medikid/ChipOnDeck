package poker.app.table;

import org.sikuli.api.ScreenRegion;

import poker.app.Window;
import poker.app.game.EGameType;
import poker.app.player.Player;

public interface ITable {
		
	public void setGameType(EGameType GameType);
	public EGameType getGameTable();
	
	public void setTableType(ETableType TableType);
	public ETableType getTableType();
	
	public void setTableSize(int TableSize);
	public int getTableSize();
	
	public void setTableNumber(int TableNumber);
	public int getTableNumber();
	
	public void setTableName(String Name);
	public String getTableName();
	
	public void setTableTag(String TableTag);
	public String getTableTag();
	
	public void setTableWindow(Window TableWindow);
	public Window getTableWindow();
	
	public void setTableFrame(ScreenRegion TableFrame);
	public ScreenRegion getTableFrame();
	
	public void deriveAllTableRegions();
	public void deriveTableFrame();
	public void derivePlayerDashes();
	public void highlightTableRegions();
	
	public void addPlayer(int SeatNumber, Player player);
	public void removePlayer(int SeatNumber);	
	public Player getPlayer(int SeatNumber);
	
	public void updateTotalPlayers(int noPlayers);
	public int getTotalPlayers();
	
	public void updateTotalActivePlayers(int noActivePlayers);
	public int getTotalActivePlayers();
	
	public void passActionRequest(int passerSeatNumber);
	
}
