package poker.app.game;

import java.util.List;

import poker.game.tools.cards.*;


public class TexasHoldem implements IGame {
	int EGameType;
	int GameNumber;
	TRound currentRound;
	
	double potSize;
	
	Card C1;
	Card C2;
	Card C3;
	Card C4;
	Card C5;
	
	public TexasHoldem(){
		
	}

	@Override
	public void startNewGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void discardGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGameType(poker.app.game.TGame GameType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public poker.app.game.TGame getGameType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrentRound(TRound GameRound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TRound getCurrentRound() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void nextRound() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prevRound() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setupGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finishGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPotSize(double potCash) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getPotSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFlopCards(Card C1, Card C2, Card C3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Card> getFlopCards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTurnCard(Card C4) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Card> getTurnCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRiverCard(Card C5) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getRiverCard() {
		// TODO Auto-generated method stub
		
	}
	
}
