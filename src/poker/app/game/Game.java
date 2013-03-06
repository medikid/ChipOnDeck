package poker.app.game;

import poker.app.game.card.Card;
import poker.app.game.card.hand.Flop;
import poker.app.game.card.hand.River;
import poker.app.game.card.hand.Turn;
import poker.app.player.Player;


public class Game {
	int EGameType;
	int GameNumber;
	
	double currentPot;
	double currentBet;
	TRound	currentRound;
	
	double	smallBlind;
	double	bigBlind;
	Player dealer;
	
	Flop	flop;
	Turn	turn;
	River	river;
	
	public Game(){
		
	}
	
	public void New(){
		
	}
	
	public void Reset(){
		
	}
	
	public void passActionRequest(int passerSeatNumber){
		
	}
	
	
}
