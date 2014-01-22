package com.stevesmith.solitaire.components;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import com.stevesmith.solitaire.datatype.Game;
import com.stevesmith.solitaire.datatype.GameSpot;
import com.stevesmith.solitaire.datatype.Pile;

public class GameRepositoryUnitTests {
	
	private static final String DEFAULT_GAME_ID = "0";
	
	@Test
	public void ensureGameRepositoryCanSaveAGame(){
		GameRepository gameRepository = newGameRepository();
		Game game = newGame();
		
		gameRepository.saveGame(game);
		
		assertEquals(1, gameRepository.getTotalGameCount());
	}
	
	@Test
	public void ensureGameRepositoryCanLoadAGame(){
		GameRepository gameRepository = newGameRepository();
		Game game = newGame();
		
		gameRepository.saveGame(game);
		Game loadedGame = gameRepository.loadGame(DEFAULT_GAME_ID);
		
		assertEquals(game, loadedGame);
		
	}
	
	@Test
	public void ensureGameRepositoryCanDeleteAGame(){
		GameRepository gameRepository = newGameRepository();
		Game game = newGame();
		
		gameRepository.deleteGame(DEFAULT_GAME_ID);
		
		assertEquals(0, gameRepository.getTotalGameCount());		
	}
	
	
	private Game newGame(){
		return new Game(DEFAULT_GAME_ID, new HashMap<GameSpot, Pile>());
	}
	
	private GameRepository newGameRepository(){
		return new GameRepository(new HashMap<String, Game>());
	}
}
