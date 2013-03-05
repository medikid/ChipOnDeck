package poker.app.game;

import java.util.List;

import poker.app.game.card.Card;


public interface IGame {
	
	public void startNewGame();
	public void discardGame();
	
	public void setGameType(EGameType GameType);
	public EGameType getGameType();
	
	public void setCurrentRound(EGameRoundType GameRound);
	public EGameRoundType getCurrentRound();
	
	public void nextRound();
	public void prevRound();
	
	public void setupGame();	
	public void finishGame();
	
	public void setPotSize(double potCash);
	public double getPotSize();
	
	public void setFlopCards(Card C1, Card C2, Card C3);
	public List<Card> getFlopCards();
	
	public void setTurnCard(Card C4);
	public List<Card> getTurnCard();
	
	public void setRiverCard(Card C5);
	public void getRiverCard();
	
}
