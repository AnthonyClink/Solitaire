package com.stevesmith.solitaire.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.google.inject.Provider;
import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.GameBoard;
import com.stevesmith.solitaire.datatype.GameSpot;
import com.stevesmith.solitaire.datatype.Rank;
import com.stevesmith.solitaire.datatype.Suit;
import com.stevesmith.solitare.exceptions.NoCardsOnPileException;

public class GameServiceTest {
	
	
	private Provider<Deck> deckProvider = new TestDeckProvider();
	private Provider<GameBoard> gameBoardProvider = new TestGameBoardProvider(deckProvider);
	private GameBoard gameBoard = gameBoardProvider.get();
	
	private GameService gameService = new GameService(new RuleService(), deckProvider, gameBoardProvider);
	
	@Test
	public void kingToEmptySpot(){
		gameService.newGame();
		gameService.getGameBoard().getReg1Deck().getCards().clear();
		gameService.getGameBoard().getReg3Deck().addCard(new Card(Rank.KING, Suit.CLUB, true));
		gameService.moveCard(GameSpot.REGULAR_3, GameSpot.REGULAR_1, 1);
		assertEquals(1, gameService.getGameBoard().getReg1Deck().getSize());
	}
	
	@Test
	public void threeToResPileTest(){
		gameService.newGame();
		gameService.moveCard(GameSpot.REGULAR_6, GameSpot.RESOLUTION_CLUB, 1);
		gameService.getGameBoard().getReg1Deck().addCard(new Card(Rank.TWO, Suit.CLUB, true));
		gameService.moveCard(GameSpot.REGULAR_1, GameSpot.RESOLUTION_CLUB, 1);
		gameService.getGameBoard().getReg1Deck().addCard(new Card(Rank.THREE, Suit.CLUB,true));
		gameService.moveCard(GameSpot.REGULAR_1, GameSpot.RESOLUTION_CLUB, 1);
		Deck resolutionDeck = gameService.getGameBoard().getClubsDeck();
		assertEquals(3, resolutionDeck.getSize());
		
	}
	
	@Test
	public void twoToResPileTest(){
		gameService.newGame();
		gameService.moveCard(GameSpot.REGULAR_6, GameSpot.RESOLUTION_CLUB, 1);
		gameService.getGameBoard().getReg1Deck().addCard(new Card(Rank.TWO, Suit.CLUB, true));
		gameService.moveCard(GameSpot.REGULAR_1, GameSpot.RESOLUTION_CLUB, 1);
		assertEquals(2, gameService.getGameBoard().getClubsDeck().getSize());
	}
	
	@Test
	public void aceToEmptyResPileTest(){
		gameService.newGame();
		gameService.moveCard(GameSpot.REGULAR_6, GameSpot.RESOLUTION_CLUB, 1);
		assertEquals(1, gameService.getGameBoard().getClubsDeck().getSize());
		
		
	}
	
	
	@Test
	public void canResetDrawDeck() throws NoCardsOnPileException{
		gameService.newGame();
		assertEquals(24, gameService.getGameBoard().getDrawDeck().getSize());
		for(int i = 0; i < 24; i++){
			gameService.drawCard();
		}
		assertEquals(0, gameService.getGameBoard().getDrawDeck().getSize());
		gameService.drawCard();
		assertEquals(24, gameService.getGameBoard().getDrawDeck().getSize());
	}
	
	@Test
	public void canMoveCards(){
		gameService.newGame();
		GameBoard gameBoard = gameService.getGameBoard();
		gameBoard.addCardToReg7Deck(new Card(Rank.JACK, Suit.CLUB,true));
		assertEquals(1, gameBoard.getReg1Deck().getSize());
		assertEquals(8, gameBoard.getReg7Deck().getSize());
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.REGULAR_1, 2);
		assertEquals(1, gameBoard.getReg1Deck().getSize());
		assertEquals(8, gameBoard.getReg7Deck().getSize());
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.REGULAR_3, 2);
		assertEquals(5, gameBoard.getReg3Deck().getSize());
		assertEquals(6, gameBoard.getReg7Deck().getSize());
	}
	
	@Test
	public void autoTurnUpTest(){
		gameService.newGame();
		GameBoard gameBoard = gameService.getGameBoard();
		this.gameBoard = gameService.getGameBoard();
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.REGULAR_1, 1);
		assertTrue(gameBoard.getReg7Deck().getTopCard().isFaceUp());
	}
	
	@Test
	public void canMoveACard(){
		gameService.newGame();
		this.gameBoard = gameService.getGameBoard();
		gameService.moveCard(GameSpot.REGULAR_7,GameSpot.REGULAR_3, 1);
		assertEquals(4, gameBoard.getReg3Deck().getSize());
		assertEquals(6, gameBoard.getReg7Deck().getSize());
	}
	@Test
	public void transferCardsTest(){
		gameService.newGame();
		Deck fromDeck = newEmptyDeck();
		Deck toDeck = newEmptyDeck();
		fromDeck.addCard(new Card(Rank.TWO, Suit.CLUB, true));
		toDeck.addCard(new Card(Rank.THREE, Suit.DIAMOND, true));
		assertEquals(1, fromDeck.getSize());
		assertEquals(1,toDeck.getSize());
		gameService.transferCards(fromDeck, toDeck, fromDeck);
		assertEquals(2,toDeck.getSize());
		
	}
	
	@Test
	public void getFromCardsTest(){
		gameService.newGame();
		Deck fromDeck = gameService.getGameBoard().getReg1Deck();
		Deck fromCards = gameService.getFromCards(fromDeck, 1);
		assertEquals(1, fromCards.getSize());
		Deck newFromDeck = newEmptyDeck().addCard(new Card(Rank.QUEEN, Suit.DIAMOND, true));
		newFromDeck.addCard(new Card(Rank.JACK, Suit.CLUB,true));
		fromCards = gameService.getFromCards(newFromDeck, 2);
		assertEquals(2, fromCards.getSize());
	}
	
	@Test
	public void newGameTest(){
		gameService.newGame();
		assertEquals(24, gameService.getGameBoard().getDrawDeck().getSize());
	}
	
	@Test
	public void dealGameTest(){
		
		Deck deck = gameService.newFullDeck();
		gameService.dealGame(deck);
		GameBoard gameBoard = gameService.getGameBoard();
		assertEquals(1, gameBoard.getReg1Deck().getSize());
		assertEquals(2, gameBoard.getReg2Deck().getSize());
		assertEquals(3, gameBoard.getReg3Deck().getSize());
		assertEquals(4, gameBoard.getReg4Deck().getSize());
		assertEquals(5, gameBoard.getReg5Deck().getSize());
		assertEquals(6, gameBoard.getReg6Deck().getSize());
		assertEquals(7, gameBoard.getReg7Deck().getSize());
		assertTrue(gameBoard.getReg1Deck().getTopCard().isFaceUp());
		assertTrue(gameBoard.getReg2Deck().getTopCard().isFaceUp());
		assertTrue(gameBoard.getReg3Deck().getTopCard().isFaceUp());
		assertTrue(gameBoard.getReg4Deck().getTopCard().isFaceUp());
		assertTrue(gameBoard.getReg5Deck().getTopCard().isFaceUp());
		assertTrue(gameBoard.getReg6Deck().getTopCard().isFaceUp());
		assertTrue(gameBoard.getReg7Deck().getTopCard().isFaceUp());
		assertFalse(gameBoard.getReg4Deck().getCards().get(2).isFaceUp());
	}
	
	@Test
	public void mapCreationAndGetDeckTest(){
		creatGameMap();
		Deck deck = gameBoard.getReg2Deck();
		assertNotNull(deck);
	}
	
	@Test
	public void newFullDeckTest(){
		Deck deck = gameService.newFullDeck();
		assertEquals(52,deck.getSize());
	}
	
	private void creatGameMap() {
		gameBoard = gameBoardProvider.get();
	}
	
	private Deck newEmptyDeck(){
		return new Deck(new ArrayList<Card>());
	}
}
