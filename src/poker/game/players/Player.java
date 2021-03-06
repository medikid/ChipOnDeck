package poker.game.players;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.sikuli.api.ScreenRegion;

import poker.app.game.TRound;
import poker.game.players.TPlayerAction;
import poker.game.tools.tables.Table;

public class Player implements IPlayer {
	private Table table;
	public String tableTag;
	public int seatNumber;
	public String name;
	public String tag;
	public Player prevPlayer;
	public Player nextPlayer;
	public double cash;
	
	public ScreenRegion DashRegion = null;
	
	public EPlayerStatusType status=null;
	
	public boolean isStatusObserverActive = false;	
	public StatusObserver statusObserver = null;
	
	public ActionTrend actionTrend=null;
	public TPlayerAction action=null;
	public double actionCash ;
	
	public boolean isActionPending = false;
	
	public boolean isActionObserverActive = false;	
	public ActionObserver actionObserver = null;
	
	private List<PlayerActionEventListener> _ActionEventListeners = new ArrayList<PlayerActionEventListener>();
	
	public Player(){		
	}
	
	public void INIT(){
		this.actionTrend = new ActionTrend();
	}
	
//	#region 
	
	@Override
	public void setTable(Table TableObj) {
		this.table = TableObj;
		this.setTableTag();
	}

	@Override
	public Table getTable() {		
		return this.table;
	}
	
	@Override
	public void setTableTag() {
		this.tableTag = this.table.tag;
	}

	@Override
	public String getTableTag() {		
		return this.tableTag;
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
	public void setTag(String Tag){
		this.tag = Tag;
	}

	@Override
	public String getTag(){
		return this.tag;
	}
	
	//no need to call this as this is being taken care at the level of setting next player
	@Override
	public void setPrevPlayer(Player PrevPlayer) {
		this.prevPlayer = PrevPlayer;
		
	}

	@Override
	public Player getPrevPlayer() {		
		return this.prevPlayer;
	}

	// will also set the prevPlayer for the next player
	@Override
	public void setNextPlayer(Player NextPlayer) {
		this.nextPlayer = NextPlayer;
		NextPlayer.setPrevPlayer(this);
		
	}

	@Override
	public Player getNextPlayer() {
		return this.nextPlayer;
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
	public void setStatus(EPlayerStatusType PlayerStatus) {
		this.status = PlayerStatus;		
	}

	@Override
	public EPlayerStatusType getStatus() {
		return this.status;		
	}

	@Override
	public void startStatusObserver() {
		if(this.isStatusObserverActive == false){
			this.isStatusObserverActive = true;
			this.statusObserver = new StatusObserver(this);
			this.statusObserver.start();
		}
		
	}

	@Override
	public void stopStatusObserver() {
		if(this.isStatusObserverActive == true){
			this.isStatusObserverActive = false;
			this.statusObserver.stop();
		}
		
	}

	@Override
	public void setAction(PlayerAction pAction) {
		this.action = pAction.actionType;
		this.actionCash = pAction.actionCash;
		this.isActionPending = true;
		
	}

	@Override
	public void doAction() {
		if (this.isActionPending){
			
		}
		
	}
	

	@Override
	public void didAction(PlayerAction pAction) {
		this.setAction(pAction);		
		this.setActionPending(false);
		
		
		
		this.passActionRequest();
		
		this.playerActionEventHandler(pAction);		
	}
	
	
	public void setActionPending(boolean isActionPending){
		this.isActionPending = isActionPending;		
	}
	
	public boolean getActionPending(){
		return this.isActionPending;
	}

	@Override
	public void passActionRequest(){
		this.nextPlayer.actionRequestReceived();
	}

	@Override
	public void actionRequestReceived() {
		this.setActionPending(true);
		
	}

	@Override
	public void actionRequestPassed() {
				
	}

	@Override
	public void cancelAction() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateActionTrend(TRound gRound, PlayerAction pAction) {
		this.actionTrend.add(gRound, pAction);
		
	}
	@Override
	public  PlayerAction getLastAction(TRound gRound) {
		return this.actionTrend.getLastAction(gRound);
	}

	@Override
	public void removeActionTrend(TRound gRound) {
		this.actionTrend.removeLastAction(gRound);
		
	}

	@Override
	public void resetActionTrend() {
		this.actionTrend.reset();
	}
	
	@Override
	public void startActionObserver() {
		if(this.isActionObserverActive == false){
			this.isActionObserverActive = true;
		}
		
		this.actionObserver = new ActionObserver(this);
		this.actionObserver.run();
		
	}

	@Override
	public void stopActionObserver() {
		if (this.isActionObserverActive = true){
			this.isActionObserverActive = false;
		}
		
		this.actionObserver.stop();
		
	}



	@Override
	public void addActionEventListener(	PlayerActionEventListener ActionEventListener) {
		this._ActionEventListeners.add(ActionEventListener);
		
	}

	@Override
	public void removeActionEventListener(PlayerActionEventListener ActionEventListener) {
		this._ActionEventListeners.remove(ActionEventListener);
		
	}

	@Override
	public void playerActionEventHandler(PlayerAction pAction) {
		PlayerActionEvent e = new PlayerActionEvent(this, pAction);
		
		Iterator<PlayerActionEventListener> i = this._ActionEventListeners.iterator();
		while(i.hasNext()){
			((PlayerActionEventListener) i.next()).onAction(e);
		}
	}


}
