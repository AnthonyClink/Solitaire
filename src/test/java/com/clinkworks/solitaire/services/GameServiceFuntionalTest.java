package com.clinkworks.solitaire.services;

import static org.junit.Assert.*;

import org.junit.Test;

import com.clinkworks.solitaire.datatype.Card;
import com.clinkworks.solitaire.datatype.Game;
import com.clinkworks.solitaire.datatype.GameSpot;
import com.clinkworks.solitaire.datatype.Pile;
import com.clinkworks.solitaire.exceptions.PileNotInitializedException;
import com.clinkworks.solitaire.modules.ProductionModule;
import com.clinkworks.solitaire.services.GameService;
import com.google.inject.Guice;
import com.google.inject.Injector;

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
