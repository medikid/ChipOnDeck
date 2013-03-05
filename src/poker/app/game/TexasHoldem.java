package poker.app.game;

import java.util.List;

import poker.app.game.card.Card;


public class TexasHoldem implements IGame {
	int EGameType;
	int GameNumber;
	EGameRoundType currentRound;
	
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
	public void setGameType(poker.app.game.EGameType GameType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public poker.app.game.EGameType getGameType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrentRound(EGameRoundType GameRound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EGameRoundType getCurrentRound() {
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
