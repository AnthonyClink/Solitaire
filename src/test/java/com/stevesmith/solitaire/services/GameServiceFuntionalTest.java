package com.stevesmith.solitaire.services;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.stevensmith.solitaire.exceptions.PileNotInitializedException;
import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Game;
import com.stevesmith.solitaire.datatype.GameSpot;
import com.stevesmith.solitaire.datatype.Pile;
import com.stevesmith.solitare.modules.ProductionModule;

public class GameServiceFuntionalTest {
	
	@Test
	public void testBasicGameServiceFunctionality() throws PileNotInitializedException{
		Injector injector = Guice.createInjector(new ProductionModule());
		GameService gameService = injector.getInstance(GameService.class);
		
		Game gameInit = gameService.createNewSolitaireGame();

		Card firstCard = gameInit.getPile(GameSpot.REGULAR_1).getTopCard();
		
		getRegPile1(gameInit).removeCard(firstCard);
		getRegPile2(gameInit).addCard(firstCard);
		
		assertTrue(firstCard == getRegPile2(gameInit).getTopCard());
		
		Game loadedGame = gameService.updateGame(gameInit);
		assertEquals(firstCard, getRegPile2(loadedGame).getTopCard());
		assertNull(getRegPile1(loadedGame).getTopCard());
		
		gameService.deleteGameBoard(loadedGame.getId());
		
		assertNull(gameService.getGameBoard(loadedGame.getId()));
	}
	
	private Pile getRegPile1(Game game) throws PileNotInitializedException{
		return game.getPile(GameSpot.REGULAR_1);
	}
	
	private Pile getRegPile2(Game game) throws PileNotInitializedException{
		return game.getPile(GameSpot.REGULAR_2);
	}
}
