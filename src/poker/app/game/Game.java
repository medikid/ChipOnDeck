package poker.app.game;

import poker.game.tools.cards.*;
import poker.game.players.Player;
import poker.game.tools.cards.hand.Flop;
import poker.game.tools.cards.hand.River;
import poker.game.tools.cards.hand.Turn;


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
