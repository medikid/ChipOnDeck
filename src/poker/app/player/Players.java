package poker.app.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import poker.app.table.Table;

public class Players {
	public int playersCount = 0;
	public Map<Integer, Player> pool;
	public List<Integer> playersPool;
	Table table;

	public Players(Table tableObj){
		this.pool = new HashMap<Integer, Player>();
		this.playersPool = new ArrayList<Integer>();
		this.setTable(tableObj);
	}
	
	public void setTable(Table tableObj){
		this.table = tableObj;
	}
	
	public Table getTable(){
		return this.table;
	}
	
	public void Add(Player player){
		int seatNo = player.getSeatNumber();
		this.pool.put(seatNo, player);
		this.playersPool.add(seatNo);
		this.playersCount++;
	}
	
	public void Remove(int seatNumber){
		this.pool.remove(seatNumber);
		this.playersPool.remove(seatNumber);
		this.playersCount--;
	}
	
	public Player Get(int seatNumber){
		return this.pool.get(seatNumber);
	}
	
	public Player inSeat(int seatNumber){
		return this.pool.get(seatNumber);
	}
	public void setPlayer(int mySeatNumber){
		this.pool.put(0, this.pool.get(mySeatNumber) );
	}
	
	public int nextPlayer(int seatNumber){
		int tableSize = this.table.tableSize;
		int nextPlayer = seatNumber;
		boolean isNextAvailable = false;
		
		while(isNextAvailable == false){
			nextPlayer++;			
			if (nextPlayer > tableSize){
				nextPlayer = 1;
				if (this.pool.containsKey(nextPlayer)){
					isNextAvailable = true;
				}
			} else if (this.pool.containsKey(nextPlayer)){
				isNextAvailable = true;
			}
		}
		
		return nextPlayer;
	}
	
	public int prevPlayer(int seatNumber){
		int tableSize = this.table.tableSize;
		int prevPlayer = seatNumber;
		boolean isPrevAvailable = false;
		
		while(isPrevAvailable == false){
			prevPlayer--;			
			if (prevPlayer < 1 ){
				prevPlayer = tableSize;
				if (this.pool.containsKey(prevPlayer)){
					isPrevAvailable = true;
				}
			} else if (this.pool.containsKey(prevPlayer)){
				isPrevAvailable = true;
			}
		}
		
		return prevPlayer;
	}
	
	public void linkChains(){
		int tableSize = this.table.tableSize;
		for(Map.Entry<Integer, Player> currentPlayer: this.pool.entrySet()){
			int currentPIndex = currentPlayer.getValue().seatNumber;			
			int nextPIndex = nextPlayer(currentPIndex);
			
			currentPlayer.getValue().setNextPlayer(this.pool.get(nextPIndex));
		}
		
	}
	

}
