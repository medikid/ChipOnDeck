package poker.app.table;

import java.util.List;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ScreenRegion;

import poker.app.Window;
import poker.app.WindowManager;
import poker.app.WindowManager.WindowType;
import poker.app.game.EGameType;
import poker.app.player.Player;
import poker.app.table.ETableType;

public class Table extends TableRegion implements ITable {
	public int tableNumber = 0;
	public String tableName = null;
	public String tag = null;
	public int tableSize = 0;
	public ETableType tableType =  null;
	public EGameType gameType = null;
	
	public Window tableWindow = null;
	public ScreenRegion tableFrame = null;
	
	public Player P1 = null;
	public Player P2 = null;
	public Player P3 = null;
	public Player P4 = null;
	public Player P5 = null;
	public Player P6 = null;
	public Player P7 = null;
	public Player P8 = null;
	public Player P9 = null;
	public Player P10 = null;
	
	private int _totalPlayers = 0;
	private int _totalActivePlayers = 0;
	
	public Table(int TableSize){
		super();
		this.setTableSize(TableSize);
		this.setTableType(TableSize);			
	}
	

	@Override
	public void setGameType(EGameType GameType) {
		this.gameType = GameType;		
	}

	@Override
	public EGameType getGameTable() {		
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
	
	public void setNextAvailablePlayer(Player player){
		boolean nextPlayerAvailable = false;
		int checkingSeatNumber = player.seatNumber + 1;
		while( nextPlayerAvailable == false){
			if (checkingSeatNumber > this.tableSize){
				checkingSeatNumber = 1;
			}
			switch(checkingSeatNumber){
				case 1:
					if (this.P1 != null){
						player.setNextPlayer(this.P1);
						nextPlayerAvailable = true;
					} else checkingSeatNumber++;
					break;
				case 2:
					if (this.P2 != null){
						player.setNextPlayer(this.P2);
						nextPlayerAvailable = true;
					} else checkingSeatNumber++;
					break;
				case 3:
					if (this.P3 != null){
						player.setNextPlayer(this.P3);
						nextPlayerAvailable = true;
					} else checkingSeatNumber++;
					break;
				case 4:
					if (this.P4 != null){
						player.setNextPlayer(this.P4);
						nextPlayerAvailable = true;
					} else checkingSeatNumber++;
					break;
				case 5:
					if (this.P5 != null){
						player.setNextPlayer(this.P5);
						nextPlayerAvailable = true;
					} else checkingSeatNumber++;
					break;
				case 6:
					if (this.P6 != null){
						player.setNextPlayer(this.P6);
						nextPlayerAvailable = true;
					} else checkingSeatNumber++;
					break;
				case 7:
					if (this.P7 != null){
						player.setNextPlayer(this.P7);
						nextPlayerAvailable = true;
					} else checkingSeatNumber++;
					break;
				case 8:
					if (this.P8 != null){
						player.setNextPlayer(this.P8);
						nextPlayerAvailable = true;
					} else checkingSeatNumber++;
					break;
				case 9:
					if (this.P9 != null){
						player.setNextPlayer(this.P9);
						nextPlayerAvailable = true;
					} else checkingSeatNumber++;
					break;
				case 10:
					if (this.P10 != null){
						player.setNextPlayer(this.P10);
						nextPlayerAvailable = true;
					} else checkingSeatNumber++;
					break;
			}
		}
		
	}
	
	public void setPrevAvailablePlayer(Player player){
		boolean prevPlayerAvailable = false;
		int checkingSeatNumber = player.seatNumber - 1;
		while( prevPlayerAvailable == false){
			if (checkingSeatNumber < 1){
				checkingSeatNumber = this.tableSize;
			}
			switch(checkingSeatNumber){
				case 1:
					if (this.P1 != null){
						player.setPrevPlayer(this.P1);
						prevPlayerAvailable = true;
					} else checkingSeatNumber--;
					break;
				case 2:
					if (this.P2 != null){
						player.setPrevPlayer(this.P2);
						prevPlayerAvailable = true;
					} else checkingSeatNumber--;
					break;
				case 3:
					if (this.P3 != null){
						player.setPrevPlayer(this.P3);
						prevPlayerAvailable = true;
					} else checkingSeatNumber--;
					break;
				case 4:
					if (this.P4 != null){
						player.setPrevPlayer(this.P4);
						prevPlayerAvailable = true;
					} else checkingSeatNumber--;
					break;
				case 5:
					if (this.P5 != null){
						player.setPrevPlayer(this.P5);
						prevPlayerAvailable = true;
					} else checkingSeatNumber--;
					break;
				case 6:
					if (this.P6 != null){
						player.setPrevPlayer(this.P6);
						prevPlayerAvailable = true;
					} else checkingSeatNumber--;
					break;
				case 7:
					if (this.P7 != null){
						player.setPrevPlayer(this.P7);
						prevPlayerAvailable = true;
					} else checkingSeatNumber--;
					break;
				case 8:
					if (this.P8 != null){
						player.setPrevPlayer(this.P8);
						prevPlayerAvailable = true;
					} else checkingSeatNumber--;
					break;
				case 9:
					if (this.P9 != null){
						player.setPrevPlayer(this.P9);
						prevPlayerAvailable = true;
					} else checkingSeatNumber--;
					break;
				case 10:
					if (this.P10 != null){
						player.setPrevPlayer(this.P10);
						prevPlayerAvailable = true;
					} else checkingSeatNumber--;
					break;
			}
		}
		
	}
	
	public void addPlayer(int SeatNumber, Player player){
		switch(SeatNumber){
			case 1:
				this.P1 = player;
				this.P1.setTable(this);
				this.P1.setSeatNumber(SeatNumber);
				this.P1.setTag("P1");
				this.setNextAvailablePlayer(P1);
				this.setPrevAvailablePlayer(P1);
				break;
			case 2:
				this.P2 = player;
				this.P2.setTable(this);
				this.P2.setSeatNumber(SeatNumber);
				this.P2.setTag("P2");
				this.setNextAvailablePlayer(P2);
				this.setPrevAvailablePlayer(P2);
				break;
			case 3:
				this.P3 = player;
				this.P3.setTable(this);
				this.P3.setSeatNumber(SeatNumber);
				this.P3.setTag("P3");
				this.setNextAvailablePlayer(P3);
				this.setPrevAvailablePlayer(P3);
				break;
			case 4:
				this.P4 = player;
				this.P4.setTable(this);
				this.P4.setSeatNumber(SeatNumber);
				this.P4.setTag("P4");
				this.setNextAvailablePlayer(P4);
				this.setPrevAvailablePlayer(P4);
				break;
			case 5:
				this.P5 = player;
				this.P5.setTable(this);
				this.P5.setSeatNumber(SeatNumber);
				this.P5.setTag("P5");
				this.setNextAvailablePlayer(P5);
				this.setPrevAvailablePlayer(P5);
				break;
			case 6:
				this.P6 = player;
				this.P6.setTable(this);
				this.P6.setSeatNumber(SeatNumber);
				this.P6.setTag("P6");
				this.setNextAvailablePlayer(P6);
				this.setPrevAvailablePlayer(P6);
				break;
			case 7:
				this.P7 = player;
				this.P7.setTable(this);
				this.P7.setSeatNumber(SeatNumber);
				this.P7.setTag("P7");
				this.setNextAvailablePlayer(P7);
				this.setPrevAvailablePlayer(P7);
				break;
			case 8:
				this.P8 = player;
				this.P8.setTable(this);
				this.P8.setSeatNumber(SeatNumber);
				this.P8.setTag("P8");
				this.setNextAvailablePlayer(P8);
				this.setPrevAvailablePlayer(P8);
				break;
			case 9:
				this.P9 = player;
				this.P9.setTable(this);
				this.P9.setSeatNumber(SeatNumber);
				this.P9.setTag("P9");
				this.setNextAvailablePlayer(P9);
				this.setPrevAvailablePlayer(P9);
				break;
			case 10:
				this.P10 = player;
				this.P10.setTable(this);
				this.P10.setSeatNumber(SeatNumber);
				this.P10.setTag("P10");
				this.setNextAvailablePlayer(P10);
				this.setPrevAvailablePlayer(P10);
				break;		
		}
		this.updateTotalActivePlayers(1);
	}
	
	public void removePlayer(int SeatNumber){
		switch(SeatNumber){
		case 1:
			this.P1 = null;
			break;
		case 2:
			this.P2 = null;
			break;
		case 3:
			this.P3 = null;
			break;
		case 4:
			this.P4 = null;
			break;
		case 5:
			this.P5 = null;
			break;
		case 6:
			this.P6 = null;
			break;
		case 7:
			this.P7 = null;
			break;
		case 8:
			this.P8 = null;
			break;
		case 9:
			this.P9 = null;
			break;
		case 10:
			this.P10 = null;
			break;		
	}
		this.updateTotalActivePlayers(-1);
	}
	
	public Player getPlayer(int SeatNumber){
		Player P = null;
		switch(SeatNumber){
		case 1:
			P = this.P1;
			break;
		case 2:
			P = this.P2;
			break;
		case 3:
			P = this.P3;
			break;
		case 4:
			P = this.P4;
			break;
		case 5:
			P = this.P5;
			break;
		case 6:
			P = this.P6;
			break;
		case 7:
			P = this.P7;
			break;
		case 8:
			P = this.P8;
			break;
		case 9:
			P = this.P9;
			break;
		case 10:
			P = this.P10;
			break;		
	}
		return P;
}

	@Override
	public void updateTotalPlayers(int noOfPlayers) {
		this._totalPlayers += noOfPlayers;
		
	}
	

	@Override
	public int getTotalPlayers() {
		return this._totalPlayers;
	}

	@Override
	public void updateTotalActivePlayers(int noOfActivePlayers) {
		this._totalActivePlayers += noOfActivePlayers;
		
	}


	@Override
	public int getTotalActivePlayers() {
		return this._totalActivePlayers;
	}

	@Override
	public void passActionRequest(int passerSeatNumber) {
		if(passerSeatNumber == this.tableSize ){
			this.P1.actionRequestReceived();
		} else {
			switch(passerSeatNumber){
				case 1:
					this.P2.actionRequestReceived();
					break;
				case 2:
					this.P3.actionRequestReceived();
					break;
			}
		}
		
	}

	@Override
	public void deriveNsetTableFrame() {
		if (this.tableWindow == null){
			this.grabTableWindow("Table");
		}
		TableRegion tr = new TableRegion(this.tableWindow);
		tr.deriveTableFrame();
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
