package com.stevesmith.solitaire.services;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Game;
import com.stevesmith.solitare.modules.ProductionModule;

public class GameServiceFuntionalTest {
	
	@Test
	public void testBasicGameServiceFunctionality(){
		Injector injector = Guice.createInjector(new ProductionModule());
		GameService gameService = injector.getInstance(GameService.class);
		
		Game gameInit = gameService.createNewSolitaireGame();
		
		gameService.saveGame(gameInit);
		
		Card firstCard = gameInit.getReg1Pile().getTopCard();
		
		gameInit.getReg1Pile().removeCard(firstCard);
		gameInit.getReg2Pile().addCard(firstCard);
		
		assertTrue(firstCard == gameInit.getReg2Pile().getTopCard());
		
		Game loadedGame = gameService.updateGame(gameInit);
		assertEquals(firstCard, loadedGame.getReg2Pile().getTopCard());
		assertNull(loadedGame.getReg1Pile().getTopCard());
		
		gameService.deleteGameBoard(loadedGame.getId());
		
		assertNull(gameService.getGameBoard(loadedGame.getId()));
	}
}
