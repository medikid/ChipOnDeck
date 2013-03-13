package poker.game.tools.tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import poker.game.players.Player;

public class Tables {
	int tablesCount = 0;
	Map<Integer, Table> pool;
	List<Integer> tablesPool;
	List<Integer> activePool;
	

	public Tables(){
		this.pool = new HashMap<Integer, Table>();
		this.tablesPool = new ArrayList<Integer>();
		this.activePool = new ArrayList<Integer>();
	}
	
	public void Add(Table table){
		int tableNo = table.getTableNumber();
		this.pool.put(tableNo, table);
		this.tablesPool.add(tableNo);
		this.tablesCount++;
	}
	
	public void Remove(int tableNumber){
		this.pool.remove(tableNumber);
		this.tablesPool.remove(tableNumber);
		this.tablesCount--;
	}
	
	public Table Get(int tableNumber){
		return this.pool.get(tableNumber);
	}
	
	public Table inPosition(int tableNumber){
		return this.pool.get(tableNumber);
	}
	
}
