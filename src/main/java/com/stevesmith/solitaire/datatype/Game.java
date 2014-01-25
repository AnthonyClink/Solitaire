package com.stevesmith.solitaire.datatype;

import java.util.Map;

import com.stevensmith.solitaire.exceptions.PileNotInitializedException;

public class Game {

	private String id;
	private Map<GameSpot, Pile> gameMap;

	protected Game(){
		
	}
	
	public Game(String id, Map<GameSpot,Pile> gameMap){
		this.gameMap = gameMap;
		this.id = id;
	}
	
	
	public String getId() {
		
		return id;
	}

    public Pile getDrawPile(){
        return gameMap.get(GameSpot.DRAW);
    }

	public void putDrawPile(Pile pile){
	        gameMap.put(GameSpot.DRAW, pile);
	}
	
	public void addCardToDrawPile(Card card){
	        gameMap.get(GameSpot.DRAW).addCard(card);
	}
	
	public void removeCardFromDrawPile(Card card){
	        gameMap.get(GameSpot.DRAW).removeCard(card);
	}
	
	public Pile getDiscardPile(){
	        return gameMap.get(GameSpot.DISCARD);
	}
	
	public void addCardToDiscardPile(Card card){
	        gameMap.get(GameSpot.DISCARD).addCard(card);
	}
	
	public void removeCardFromDiscardPile(Card card){
	        gameMap.get(GameSpot.DISCARD).removeCard(card);
	}
	
	public Pile getReg1Pile(){
	        return gameMap.get(GameSpot.REGULAR_1);
	}
	
	public void addCardToReg1Pile(Card card){
	        gameMap.get(GameSpot.REGULAR_1).addCard(card);
	}
	
	public void removeCardFromReg1Pile(Card card){
	        gameMap.get(GameSpot.REGULAR_1).removeCard(card);
	}
	
	public Pile getReg2Pile(){
	        return gameMap.get(GameSpot.REGULAR_2);
	}
	
	public void addCardToReg2Pile(Card card){
	        gameMap.get(GameSpot.REGULAR_2).addCard(card);
	}
	
	public void removeCardFromReg2Pile(Card card){
	        gameMap.get(GameSpot.REGULAR_2).removeCard(card);
	}
	
	public Pile getReg3Pile(){
	        return gameMap.get(GameSpot.REGULAR_3);
	}
	
	public void addCardReg3Pile(Card card){
	        gameMap.get(GameSpot.REGULAR_3).addCard(card);
	}
	
	public void removeCardFromReg3Pile(Card card){
	        gameMap.get(GameSpot.REGULAR_3).removeCard(card);
	}
	
	public Pile getReg4Pile(){
	        return gameMap.get(GameSpot.REGULAR_4);
	}
	
	public void addCardToReg4Pile(Card card){
	        gameMap.get(GameSpot.REGULAR_4).addCard(card);
	}
	
	public void removeCardFromReg4Pile(Card card){
	        gameMap.get(GameSpot.REGULAR_4).removeCard(card);
	}
	
	public Pile getReg5Pile(){
	        return gameMap.get(GameSpot.REGULAR_5);
	}
	
	public void addCardToReg5Pile(Card card){
	        gameMap.get(GameSpot.REGULAR_5).addCard(card);
	}
	
	public void removeCardFromReg5Pile(Card card){
	        gameMap.get(GameSpot.REGULAR_5).removeCard(card);
	}
	
	public Pile getReg6Pile(){
	        return gameMap.get(GameSpot.REGULAR_6);
	}
	
	public void addCardToReg6Pile(Card card){
	        gameMap.get(GameSpot.REGULAR_6).addCard(card);
	}
	
	public void removeCardFromReg6Pile(Card card){
	        gameMap.get(GameSpot.REGULAR_6).removeCard(card);
	}
	
	public Pile getReg7Pile(){
	        return gameMap.get(GameSpot.REGULAR_7);
	}
	
	public void addCardToReg7Pile(Card card){
	        gameMap.get(GameSpot.REGULAR_7).addCard(card);
	}
	
	public void removeCardFromReg7Pile(Card card){
	        gameMap.get(GameSpot.REGULAR_7).removeCard(card);
	}

	
	public Pile getHeartsPile(){
	        return gameMap.get(GameSpot.RESOLUTION_HEARTS);
	}
	
	public void addCardToHeartsPile(Card card){
	        gameMap.get(GameSpot.RESOLUTION_HEARTS).addCard(card);
	}
	
	public void removeCardFromHeartsPile(Card card){
	        gameMap.get(GameSpot.RESOLUTION_HEARTS).removeCard(card);
	}

	public Pile getDiamondsPile(){
	        return gameMap.get(GameSpot.RESOLUTION_DIAMONDS);
	}
	
	public void addCardToDiamondsPile(Card card){
	        gameMap.get(GameSpot.RESOLUTION_DIAMONDS).addCard(card);
	}
	
	public void removeCardFromDiamondsPile(Card card){
	        gameMap.get(GameSpot.RESOLUTION_DIAMONDS).removeCard(card);
	}
	
	public Pile getClubsPile(){
	        return gameMap.get(GameSpot.RESOLUTION_CLUB);
	}
	
	public void addCardToClubsPile(Card card){
	        gameMap.get(GameSpot.RESOLUTION_CLUB).addCard(card);
	}
	
	public void removeCardFromClubsPile(Card card){
	        gameMap.get(GameSpot.RESOLUTION_CLUB).removeCard(card);
	}
	
	public Pile getSpadesPile(){
	        return gameMap.get(GameSpot.RESOLUTION_SPADE);
	}
	
	public void addCardToSpadesPile(Card card){
	        gameMap.get(GameSpot.RESOLUTION_SPADE).addCard(card);
	}
	
	public void removeCardFromSpadesPile(Card card){
	        gameMap.get(GameSpot.RESOLUTION_SPADE).removeCard(card);
	}
	
	public Pile getGameSpot(GameSpot gameSpot){
	        return gameMap.get(gameSpot);
	}
	
	public void addCardToGameSpotPile(GameSpot gameSpot, Card card){
	        gameMap.get(gameSpot).addCard(card);
	}
	
	public void removeCardFromGameSpotPile(GameSpot gameSpot, Card card){
	        gameMap.get(gameSpot).removeCard(card);
	}
	
	public Pile getPile(GameSpot gameSpot) throws PileNotInitializedException  {
		Pile pile = gameMap.get(gameSpot);
		
		if(pile == null){
			throw new PileNotInitializedException();
		}
		
		return gameMap.get(gameSpot);
	}	
	
	
	

}
