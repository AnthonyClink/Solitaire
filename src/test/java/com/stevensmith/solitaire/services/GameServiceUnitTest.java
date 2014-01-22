package com.stevensmith.solitaire.services;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import com.stevesmith.solitaire.components.GameRepository;
import com.stevesmith.solitaire.datatype.Game;
import com.stevesmith.solitaire.datatype.GameSpot;
import com.stevesmith.solitaire.datatype.Pile;
import com.stevesmith.solitaire.services.DeckService;
import com.stevesmith.solitaire.services.GameService;

public class GameServiceUnitTest {

	
	@Test
	public void ensureGameServiceCanCreateSolitaireGameBoard(){
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
		GameService gameService = createNewGameService();
		
		Game gameBoard = gameService.createGame();
		
		assertTrue(gameBoard == gameService.getGameBoard("0"));
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
