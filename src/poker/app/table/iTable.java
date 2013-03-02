package poker.app.table;

import org.sikuli.api.ScreenRegion;

import poker.app.Window;
import poker.app.player.Player;

public interface iTable {
	public enum GAME_TYPE { POKER_LIMIT, POKER_NOLIMIT, OMAHA, STUD};
	public enum TABLE_TYPE { TEN, SIX }
		
	public void setGameType(GAME_TYPE GameType);
	public GAME_TYPE getGameTable();
	
	public void setTableType(TABLE_TYPE TableType);
	public TABLE_TYPE getTableType();
	
	public void setTableSize(int TableSize);
	public int getTableSize();
	
	public void setTableNumber(int TableNumber);
	public int getTableNumber();
	
	public void setTableName(String Name);
	public String getTableName();
	
	public void setTableWindow(Window TableWindow);
	public Window getTableWindow();
	
	public void setTableFrame(ScreenRegion TableFrame);
	public ScreenRegion getTableFrame();
	
	
	
}
