package poker.app.player;

import org.sikuli.api.ScreenRegion;

import poker.app.player.iPlayer.ACTION_TYPE;
import poker.app.table.Table;

public class Player implements iPlayer {
	public Table table = null;
	public int seatNumber = (Integer) null;
	public String name =  null;
	public String tag = null;
	public double cash = (Double) null;
	
	public ScreenRegion DashRegion = null;
	
	public ACTION_TYPE action=null;
	public double actionCash = (Double) null;
	public boolean actionPending = false;
	
//	#region 
	
	@Override
	public void setTable(Table TableObj) {
		this.table = TableObj;
	}

	@Override
	public Table getTable() {		
		return this.table;
	}

	@Override
	public void setSeatNumber(int SeatNumber) {
		this.seatNumber = SeatNumber;		
	}

	@Override
	public int getSeatNumber() {		
		return this.seatNumber;
	}

	@Override
	public void setTag(){
		this.tag = "P" + String.valueOf(this.seatNumber);
	}

	@Override
	public String getTag(){
		return this.tag;
	}
	

	@Override
	public void setName(String Name) {
		this.name = Name;		
	}

	@Override
	public String getName() {		
		return this.name;
	}

	@Override
	public void setCash(double Cash) {
		this.cash = Cash;		
	}

	@Override
	public double getCash() {		
		return this.cash;
	}

	@Override
	public void setAction(ACTION_TYPE Action, double[] ActionCash) {
		this.action = Action;
		if (ActionCash.length > 0){
			this.actionCash = ActionCash[0];
		} else this.actionCash = 0;
		
	}

	@Override
	public void doAction() {
		if (this.actionPending){
			
		}
		
	}
	
	public void setActionPending(boolean isActionPending){
		this.actionPending = isActionPending;		
	}
	
	public boolean getActionPending(){
		return this.actionPending;
	}
	

}
