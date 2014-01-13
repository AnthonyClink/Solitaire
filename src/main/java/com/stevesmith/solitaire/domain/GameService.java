package com.stevesmith.solitaire.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.stevesmith.solitaire.datatype.BlankCard;
import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.GameBoard;
import com.stevesmith.solitaire.datatype.GameSpot;
import com.stevesmith.solitaire.datatype.Rank;
import com.stevesmith.solitaire.datatype.Suit;
import com.stevesmith.solitare.exceptions.NoCardsOnPileException;

@Singleton
public class GameService {

	private static final String FACE_DOWN = "DWN";
	private static final int CELL_LENGTH = 8;
	
	
	private final RuleService ruleService;
	private GameBoard gameBoard;
	private Provider<Deck> deckProvider;
	private Provider<GameBoard> gameBoardProvider;

	@Inject
	public GameService(RuleService ruleService, Provider<Deck> deckProvider, Provider<GameBoard> gameBoardProvider){
		
		this.deckProvider = deckProvider;
		this.ruleService = ruleService;
		this.gameBoardProvider = gameBoardProvider;
		this.gameBoard = gameBoardProvider.get();
		
	}
	
	public void newGame(){
		creatGameMap();
		Deck deck = newFullDeck();
		dealGame(deck);
		gameBoard.putDrawDeck(deck);
	
	}

	public void drawCard(){
		try{
			Card drawCard = gameBoard.getDrawDeck().getTopCard();
			if(drawCard instanceof BlankCard){
				throw new NoCardsOnPileException();
			}
			drawCard.turnFaceUp();
			transferCard(drawCard, gameBoard.getDiscardDeck());
			gameBoard.getDrawDeck().removeCard(drawCard);
		}catch(NoCardsOnPileException e){
			for(Card card : gameBoard.getDiscardDeck().getCards()){
				card.turnFaceDown();
				gameBoard.getDrawDeck().getCards().add(0, card);
			}
			gameBoard.getDiscardDeck().getCards().clear();
		}
	}

	public void dealGame(Deck deck) {
		creatGameMap();
		List<GameSpot> gameSpotList = Lists.newArrayList();
		for(GameSpot gameSpot : GameSpot.values()){
			gameSpotList.add(gameSpot);
		}
		for(int row = 1; row < 8; row++){
			int columns = row;
			for(; columns < 8; columns++){
				GameSpot gameSpot = gameSpotList.get(columns + 1);
				Card card = deck.drawCard();
				Deck gameSpotDeck = gameBoard.getGameSpot(gameSpot);
				if(columns == row){
					card.turnFaceUp();
				}gameSpotDeck.addCard(card);
			}
		}
		
	}
	
	public Deck newFullDeck(){
		Deck deck = deckProvider.get();
		for(Suit suit : Suit.standardSuits()){
			for(Rank rank : Rank.standardRanks()){
				deck.addCard(new Card(rank, suit, false));
			}
		}return deck;
	}

	public void moveCard(GameSpot fromSpot, GameSpot toSpot, int numberOfCardsToMove) {
		Deck fromDeck = gameBoard.getGameSpot(fromSpot);
		Deck toDeck = gameBoard.getGameSpot(toSpot);
		if(ruleService.isGoingToResolutionPile(toSpot)){
			movingToResPile(fromSpot, toSpot, numberOfCardsToMove);
		}else{
			Deck fromCards = getFromCards(fromDeck,numberOfCardsToMove);
			Card fromCard =  getFromCard(fromCards, numberOfCardsToMove);
			if(ruleService.spotIsEmpty(toDeck)){
				if(fromCard.getRank() == Rank.KING){
					transferCards(fromCards, toDeck, fromDeck);
				}
			}else{
				Card toCard = toDeck.showTopCard();
				if(ruleService.isOppositeColor(fromCard, toCard)){
					if(ruleService.isOneBelow(fromCard, toCard)){
						transferCards(fromCards, toDeck, fromDeck);
						
					}
				}else{
					fromDeck.getCards().addAll(fromCards.getCards());
				}
			}	
		}
		Card card = fromDeck.getTopCard();
		try{
			if(!card.isFaceUp()){
				card.turnFaceUp();
			}fromDeck.addCard(card);
		}catch(NullPointerException e){
			
		}
	}

	private void movingToResPile(GameSpot fromSpot, GameSpot toSpot,
			int numberOfCardsToMove) {
		Deck fromDeck = gameBoard.getGameSpot(fromSpot);
		Card fromCard = fromDeck.showTopCard();
		switch(gameBoard.getGameSpot(fromSpot).getTopCard().getSuit()){
		case HEART: toSpot = GameSpot.RESOLUTION_HEARTS;
			break;
		case DIAMOND: toSpot = GameSpot.RESOLUTION_DIAMONDS;
			break;
		case SPADE: toSpot = GameSpot.RESOLUTION_SPADE;
			break;
		case CLUB: toSpot = GameSpot.RESOLUTION_CLUB;
			break;
		}
		Deck toDeck = gameBoard.getGameSpot(toSpot);
		
		if(ruleService.spotIsEmpty(toDeck))	{
			if(fromCard.getRank() == Rank.ACE){
				Deck fromCards = newEmptyDeck().addCard(fromCard);
				transferCards(fromCards, toDeck, fromDeck);
			}
		}else{
			Card toCard = toDeck.showTopCard();
			if(ruleService.isOneAbove(fromCard, toCard)){
				Deck fromCards = newEmptyDeck().addCard(fromCard);
				transferCards(fromCards, toDeck, fromDeck);
			}
		}
		
	}

	public void transferCards(Deck fromCards, Deck toDeck, Deck fromDeck) {
		toDeck.getCards().addAll(fromCards.getCards());
		fromDeck.getCards().removeAll(fromCards.getCards());
		
		
	}

	public Deck getFromCards(Deck fromDeck, int numberOfCardsToMove) {
		Deck fromCards = newEmptyDeck();
		for(int i = 0; i < numberOfCardsToMove; i++){
			Card card = fromDeck.getTopCard();
			fromCards.getCards().add(0, card);
		}
		return fromCards;
	}
	
	@Override
	public String toString(){
		
		StringBuffer header = new StringBuffer();
		StringBuffer table = new StringBuffer();
		
		GameSpot[] gameSpots = GameSpot.values();
		
		for(int y = 0; y < 20; y++){
			for(int i = 0; i < GameSpot.values().length ; i++){
				List<Card> cards = gameBoard.getGameSpot(gameSpots[i]).getCards();
				
				Card card = null;
				
				if(y >= cards.size()){
					card = null;
				}else{
					card = cards.get(y);
				}
				
				if(card == null){
					table.append(format(""));
					continue;
				}
				
				if(card.isFaceUp()){
					table.append(format(card.toString()));
				}else{
					table.append(format(FACE_DOWN));
				}
			}
			
			table.append("\n");
		}
		
		for(GameSpot gameSpot : gameSpots){
			header.append(createHeaderTitle(gameSpot));
		}
		
		header.append("\n");
		header.append(table);
		
		return header.toString();
	}
	
	private void transferCard(Card fromCard, Deck toDeck) {
		Deck fromDeck = newEmptyDeck();
		fromDeck.addCard(fromCard);
		transferCards(fromDeck, toDeck, fromDeck);
		
	}

	private void creatGameMap() {
		gameBoard = gameBoardProvider.get();
	}
	
	private Card getFromCard(Deck fromCards, int numberOfCardsToMove) {
		Card fromCard = fromCards.getCards().get(0);
		Card copyCard = fromCards.copyCard(fromCard);
		return copyCard;
		
	}
	
	public GameBoard getGameBoard(){
		return gameBoard;
	}

	private String createHeaderTitle(GameSpot gameSpot){
		
		String headerType[] = gameSpot.name().split("_"); 
		String displayName = null;
		
		if(headerType.length == 2){
			displayName = headerType[0].substring(0, 1) + " " + headerType[1].substring(0, 1);
		}else{
			displayName = headerType[0].substring(0, 3);
		}
		
		return format(displayName);
		
	}
	
	private Deck newEmptyDeck(){
		return deckProvider.get();
	}
	
	private String format(String str){
		return StringUtils.leftPad(str, CELL_LENGTH);
	}
}
