package poker.app.table;

import java.util.List;

import org.sikuli.api.ScreenRegion;

import poker.app.Window;
import poker.app.player.Player;
import poker.app.table.iTable.TABLE_TYPE;

public class Table {
	public int tableNumber = (Integer) null;
	public int tableName = (Integer) null;
	public int tableSize = (Integer) null;
	public TABLE_TYPE tableType =  null;
	
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
	
	public Table(TABLE_TYPE TableType, int TableSize){
		
	}
	
	
	
}
