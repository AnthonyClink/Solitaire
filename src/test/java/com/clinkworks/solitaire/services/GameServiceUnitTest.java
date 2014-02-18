package com.clinkworks.solitaire.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.clinkworks.solitaire.components.GameRepository;
import com.clinkworks.solitaire.datatype.Card;
import com.clinkworks.solitaire.datatype.CardState;
import com.clinkworks.solitaire.datatype.Deck;
import com.clinkworks.solitaire.datatype.Game;
import com.clinkworks.solitaire.datatype.GameSpot;
import com.clinkworks.solitaire.datatype.GameType;
import com.clinkworks.solitaire.datatype.Pile;
import com.clinkworks.solitaire.datatype.Rank;
import com.clinkworks.solitaire.datatype.Suit;
import com.clinkworks.solitaire.exceptions.PileNotInitializedException;
import com.clinkworks.solitaire.services.DeckService;
import com.clinkworks.solitaire.services.GameService;
import com.google.common.collect.Lists;

public class GameServiceUnitTest {
	
	@Test
	 public void ensureGameServiceCanDealStandardSolitaireGame() throws PileNotInitializedException{
		 GameService gameService = createNewGameService();
		 Game game = gameService.dealNewGame(GameType.STANDARD_SOLITAIRE);
		 
		 Pile pile5 = game.getPile(GameSpot.REGULAR_5);
		 
		 assertEquals(1, game.getPile(GameSpot.REGULAR_1).getSize());
		 assertEquals(5,  game.getPile(GameSpot.REGULAR_5).getSize());
		 assertEquals(24, game.getPile(GameSpot.DRAW).getSize());
		 assertTrue(pile5.getTopCard().isFaceUp());
		 assertTrue(pile5.getCards().get(3).isFaceDown());
	 }
	
	@Test
	public void ensureGameServiceCanCreateSolitaireGameBoard() throws PileNotInitializedException{
		Game gameBoard = createNewGameService().createGame();
		
		assertEquals("0", gameBoard.getId());
				
		for(GameSpot gameSpot : GameSpot.values()){
			Pile pile = gameBoard.getPile(gameSpot);
			assertNotNull(pile);
			assertEquals(0, pile.getSize());
		}

	}

	@Test
	public void endusreGameServiceCanRetrieveGameBoardsById(){
		
		Map<String, Game> gameData = new HashMap<String, Game>();
		GameRepository gameRepo = new GameRepository(gameData);
		
		Game game = new Game("0", null);
		gameData.put("0",	game);
		
		GameService gameService = new GameService(null,  null, gameRepo);
		
		assertTrue(game == gameService.getGameBoard("0"));
	}
	
	@Test
	public void endusreGameServiceCanDeleteGameBoardsById(){
		GameService gameService = createNewGameService();
		
		gameService.createGame();
		gameService.deleteGameBoard("0");
		
		assertNull(gameService.getGameBoard("0"));
	}
		
	@Test
	public void endusreGameServiceCanCreateUniqueGameBoards(){
		GameService gameService = createNewGameService();
		
		Game gameBoard1 = gameService.createGame();
		Game gameBoard2 = gameService.createGame();
		
		assertEquals("0", gameBoard1.getId());
		assertEquals("1", gameBoard2.getId());
	}
	
	private GameService createNewGameService(){
		return new GameService(null, new DeckService(), new GameRepository(new HashMap<String, Game>()));
	}
}
