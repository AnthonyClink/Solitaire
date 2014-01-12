package com.stevesmith.solitaire.datatype;

import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

public class GameBoard {	
	
	private Map<GameSpot, Deck> gameStackMap;

	@Inject
	public GameBoard(Map<GameSpot, Deck> gameStackMap, Provider<Deck> deckProvider){
		this.gameStackMap = gameStackMap;
		for(GameSpot gameSpot : GameSpot.values()){
			this.gameStackMap.put(gameSpot, deckProvider.get());
		}
	}
	
	public Deck getDrawDeck(){
		return gameStackMap.get(GameSpot.DRAW);
	}
	
	public void putDrawDeck(Deck deck){
		gameStackMap.put(GameSpot.DRAW, deck);
	}
	
	public void addCardToDrawDeck(Card card){
		gameStackMap.get(GameSpot.DRAW).addCard(card);
	}
	
	public void removeCardFromDrawDeck(Card card){
		gameStackMap.get(GameSpot.DRAW).removeCard(card);
	}
	
	public void removeCardsFromDrawDeck(Deck cards){
		gameStackMap.get(GameSpot.DRAW).removeCards(cards);
	}
	
	public Deck getDiscardDeck(){
		return gameStackMap.get(GameSpot.DISCARD);
	}
	
	public void addCardToDiscardDeck(Card card){
		gameStackMap.get(GameSpot.DISCARD).addCard(card);
	}
	
	public void removeCardFromDiscardDeck(Card card){
		gameStackMap.get(GameSpot.DISCARD).removeCard(card);
	}
	
	public void removeCardsFromDiscardDeck(Deck cards){
		gameStackMap.get(GameSpot.DISCARD).removeCards(cards);
	}
	
	public Deck getReg1Deck(){
		return gameStackMap.get(GameSpot.REGULAR_1);
	}
	
	public void addCardToReg1Deck(Card card){
		gameStackMap.get(GameSpot.REGULAR_1).addCard(card);
	}
	
	public void removeCardFromReg1Deck(Card card){
		gameStackMap.get(GameSpot.REGULAR_1).removeCard(card);
	}
	
	public void removeCardsFromReg1Deck(Deck cards){
		gameStackMap.get(GameSpot.REGULAR_1).removeCards(cards);
	}
	
	public Deck getReg2Deck(){
		return gameStackMap.get(GameSpot.REGULAR_2);
	}
	
	public void addCardToReg2Deck(Card card){
		gameStackMap.get(GameSpot.REGULAR_2).addCard(card);
	}
	
	public void removeCardFromReg2Deck(Card card){
		gameStackMap.get(GameSpot.REGULAR_2).removeCard(card);
	}
	
	public void removeCardsFromReg2Deck(Deck cards){
		gameStackMap.get(GameSpot.REGULAR_2).removeCards(cards);
	}
	
	public Deck getReg3Deck(){
		return gameStackMap.get(GameSpot.REGULAR_3);
	}
	
	public void addCardReg3Deck(Card card){
		gameStackMap.get(GameSpot.REGULAR_3).addCard(card);
	}
	
	public void removeCardFromReg3Deck(Card card){
		gameStackMap.get(GameSpot.REGULAR_3).removeCard(card);
	}
	
	public void removeCardsFromReg3Deck(Deck cards){
		gameStackMap.get(GameSpot.REGULAR_3).removeCards(cards);
	}
	
	public Deck getReg4Deck(){
		return gameStackMap.get(GameSpot.REGULAR_4);
	}
	
	public void addCardToReg4Deck(Card card){
		gameStackMap.get(GameSpot.REGULAR_4).addCard(card);
	}
	
	public void removeCardFromReg4Deck(Card card){
		gameStackMap.get(GameSpot.REGULAR_4).removeCard(card);
	}
	
	public void removeCardsFromReg4Deck(Deck cards){
		gameStackMap.get(GameSpot.REGULAR_4).removeCards(cards);
	}
	
	public Deck getReg5Deck(){
		return gameStackMap.get(GameSpot.REGULAR_5);
	}
	
	public void addCardToReg5Deck(Card card){
		gameStackMap.get(GameSpot.REGULAR_5).addCard(card);
	}
	
	public void removeCardFromReg5Deck(Card card){
		gameStackMap.get(GameSpot.REGULAR_5).removeCard(card);
	}
	
	public void removeCardsFromReg5Deck(Deck cards){
		gameStackMap.get(GameSpot.REGULAR_5).removeCards(cards);
	}
	
	public Deck getReg6Deck(){
		return gameStackMap.get(GameSpot.REGULAR_6);
	}
	
	public void addCardToReg6Deck(Card card){
		gameStackMap.get(GameSpot.REGULAR_6).addCard(card);
	}
	
	public void removeCardFromReg6Deck(Card card){
		gameStackMap.get(GameSpot.REGULAR_6).removeCard(card);
	}
	
	public void removeCardsFromReg6Deck(Deck cards){
		gameStackMap.get(GameSpot.REGULAR_6).removeCards(cards);
	}
	
	public Deck getReg7Deck(){
		return gameStackMap.get(GameSpot.REGULAR_7);
	}
	
	public void addCardToReg7Deck(Card card){
		gameStackMap.get(GameSpot.REGULAR_7).addCard(card);
	}
	
	public void removeCardFromReg7Deck(Card card){
		gameStackMap.get(GameSpot.REGULAR_7).removeCard(card);
	}
	
	public void removeCardsFromReg7Deck(Deck cards){
		gameStackMap.get(GameSpot.REGULAR_7).removeCards(cards);
	}
	
	public Deck getHeartsDeck(){
		return gameStackMap.get(GameSpot.RESOLUTION_HEARTS);
	}
	
	public void addCardToHeartsDeck(Card card){
		gameStackMap.get(GameSpot.RESOLUTION_HEARTS).addCard(card);
	}
	
	public void removeCardFromHeartsDeck(Card card){
		gameStackMap.get(GameSpot.RESOLUTION_HEARTS).removeCard(card);
	}
	
	public void removeCardsFromHeartsDeck(Deck cards){
		gameStackMap.get(GameSpot.RESOLUTION_HEARTS).removeCards(cards);
	}
	
	public Deck getDiamondsDeck(){
		return gameStackMap.get(GameSpot.RESOLUTION_DIAMONDS);
	}
	
	public void addCardToDiamondsDeck(Card card){
		gameStackMap.get(GameSpot.RESOLUTION_DIAMONDS).addCard(card);
	}
	
	public void removeCardFromDiamondsDeck(Card card){
		gameStackMap.get(GameSpot.RESOLUTION_DIAMONDS).removeCard(card);
	}
	
	public void removeCardsFromDiamondsDeck(Deck cards){
		gameStackMap.get(GameSpot.RESOLUTION_DIAMONDS).removeCards(cards);
	}
	
	public Deck getClubsDeck(){
		return gameStackMap.get(GameSpot.RESOLUTION_CLUB);
	}
	
	public void addCardToClubsDeck(Card card){
		gameStackMap.get(GameSpot.RESOLUTION_CLUB).addCard(card);
	}
	
	public void removeCardFromClubsDeck(Card card){
		gameStackMap.get(GameSpot.RESOLUTION_CLUB).removeCard(card);
	}
	
	public void removeCardsFromClubsDeck(Deck cards){
		gameStackMap.get(GameSpot.RESOLUTION_CLUB).removeCards(cards);
	}
	
	public Deck getSpadesDeck(){
		return gameStackMap.get(GameSpot.RESOLUTION_SPADE);
	}
	
	public void addCardToSpadesDeck(Card card){
		gameStackMap.get(GameSpot.RESOLUTION_SPADE).addCard(card);
	}
	
	public void removeCardFromSpadesDeck(Card card){
		gameStackMap.get(GameSpot.RESOLUTION_SPADE).removeCard(card);
	}
	
	public void removeCardsFromSpadesDeck(Deck cards){
		gameStackMap.get(GameSpot.RESOLUTION_SPADE).removeCards(cards);
	}
	
	public Deck getGameSpot(GameSpot gameSpot){
		return gameStackMap.get(gameSpot);
	}
	
	public void putDeckInGameSpot(Deck deck, GameSpot gameSpot){
		gameStackMap.put(gameSpot, deck);
	}
	
	public void addCardToGameSpotDeck(GameSpot gameSpot, Card card){
		gameStackMap.get(gameSpot).addCard(card);
	}
	
	public void removeCardFromGameSpotDeck(GameSpot gameSpot, Card card){
		gameStackMap.get(gameSpot).removeCard(card);
	}
	
	public void removeCardsFromGameSpotDeck(GameSpot gameSpot, Deck cards){
		gameStackMap.get(gameSpot).removeCards(cards);
	}
	
	

}
