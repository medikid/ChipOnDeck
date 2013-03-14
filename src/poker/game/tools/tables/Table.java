package poker.game.tools.tables;

import java.util.List;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ScreenRegion;

import poker.app.Window;
import poker.app.WindowManager;
import poker.app.WindowManager.WindowType;
import poker.app.game.*;
import poker.game.players.Player;
import poker.game.players.Players;
import poker.game.tools.tables.ETableType;

public class Table extends TableRegion implements ITable {
	public int tableNumber = 0;
	public String tableName = null;
	public String tag = null;
	public int tableSize = 0;
	public ETableType tableType =  null;
	public TGame gameType = null;
	
	public Window tableWindow = null;
	public ScreenRegion tableFrame = null;
	
	public Players players = null;
		
	public Game	Game = null;
	
	public Table(int TableSize){
		super();
		this.setTableSize(TableSize);
		this.setTableType(TableSize);
		this.INITtable();		
	}
	
	public Table(Window tableWindow){
		super(tableWindow);
		List<Player> pList = this.derivePlayerDash();
		this.setTableSize(pList.size());
		this.setTableType(pList.size());
		this.INITtable();
		
		for(Player p: pList){
			this.players.Add(p);
		}
		System.out.println("Table object initiated with total of " + String.valueOf(this.players.playersCount));
	}
	
	public void INITtable(){
		this.players = new Players(this);
		this.Game = new Game();
	}
	

	@Override
	public void setGameType(TGame GameType) {
		this.gameType = GameType;		
	}

	@Override
	public TGame getGameTable() {		
		return this.gameType;
	}

	@Override
	public void setTableType(ETableType TableType) {
		this.tableType = TableType;		
	}
	
	public void setTableType(int TableSize) {
		switch(TableSize){
		case 2:
			this.setTableType(ETableType.TWO);
			break;
		case 6:
			this.setTableType(ETableType.SIX);
			break;
		case 10:
			this.setTableType(ETableType.TEN);
			break;			
		}		
	}

	@Override
	public ETableType getTableType() {
		return this.tableType;
	}

	@Override
	public void setTableSize(int TableSize) {
		this.tableSize = TableSize;		
	}

	@Override
	public int getTableSize() {		
		return this.tableSize;
	}

	@Override
	public void setTableNumber(int TableNumber) {
		this.tableNumber = TableNumber;
	}

	@Override
	public int getTableNumber() {
		return this.tableNumber;
	}

	@Override
	public void setTableName(String Name) {
		this.tableName = Name;
	}

	@Override
	public String getTableName() {
		return this.tableName;
	}
	
	@Override
	public void setTableTag(String TableTag) {
		this.tag = TableTag;
		
	}

	@Override
	public String getTableTag() {
		return this.tag;
	}

	@Override
	public void setTableWindow(Window TableWindow) {
		this.tableWindow = TableWindow;
	}

	@Override
	public Window getTableWindow() {
		return this.tableWindow;
	}
	
	@Override
	public void grabTableWindow(String titleKeyWord){
		WindowManager wm = new WindowManager();
		List<Window> tables = wm.getWindows(WindowType.TABLE, titleKeyWord);
		this.setTableWindow(tables.get(0));
		wm = null;
	}
	

	@Override
	public void setTableFrame(ScreenRegion TableFrame) {
		this.tableFrame = TableFrame;
	}

	@Override
	public ScreenRegion getTableFrame() {
		return this.tableFrame;
	}
	
	public void addPlayer(int SeatNumber, Player player){		
		player.setTable(this);
		player.setSeatNumber(SeatNumber);
		player.setTag("P" + String.valueOf(SeatNumber));
		
		this.players.Add(player);
	}
	
	public void removePlayer(int SeatNumber){
		this.players.Remove(SeatNumber);
	}
	
	public Player getPlayer(int SeatNumber){
		return this.players.inSeat(SeatNumber);
	}

	@Override
	public void resetTotalPlayers(int noOfPlayers) {
		this.players.playersCount = noOfPlayers;
		
	}
	

	@Override
	public int getTotalPlayers() {
		return this.players.playersCount;
	}

	
	@Override
	public void deriveNsetTableFrame() {
		if (this.tableWindow == null){
			this.grabTableWindow("Table");
		}
		TableRegion tr = new TableRegion(this.tableWindow);
		this.tableFrame = tr.tableFrame;
	}

	

	@Override
	public void deriveNsetPlayerDashes() {
		TableRegion tr = new TableRegion(this.tableWindow);
		List<Player> Players = tr.derivePlayerDash();
		for (Player pl:Players){
			this.addPlayer(pl.seatNumber, pl);
		}
		this.tableFrame = tr.tableFrame;
		
	}
	
	@Override
	public void highlightTableRegions() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void deriveAllTableRegions() {
		
		
	}

}
