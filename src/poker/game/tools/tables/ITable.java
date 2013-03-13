package poker.game.tools.tables;

import org.sikuli.api.ScreenRegion;

import poker.app.Window;
import poker.app.game.TGame;
import poker.game.players.Player;

public interface ITable {
		
	public void setGameType(TGame GameType);
	public TGame getGameTable();
	
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
	
	public void grabTableWindow(String titleKeyWord);
	public void setTableWindow(Window TableWindow);
	public Window getTableWindow();
	
	public void setTableFrame(ScreenRegion TableFrame);
	public ScreenRegion getTableFrame();
	
	public void deriveAllTableRegions();
	public void deriveNsetTableFrame();
	public void deriveNsetPlayerDashes();
	public void highlightTableRegions();
	
	public void addPlayer(int SeatNumber, Player player);
	public void removePlayer(int SeatNumber);	
	public Player getPlayer(int SeatNumber);
	
	public void resetTotalPlayers(int noPlayers);
	public int getTotalPlayers();
	
	
}
