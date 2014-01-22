package com.stevesmith.solitaire.components;

import java.util.Map;

import com.stevensmith.solitaire.exceptions.DuplicateGameException;
import com.stevesmith.solitaire.datatype.Game;
import com.stevesmith.solitaire.expectations.GameNotCreatedException;

public class GameRepository {
	
	private final Map<String, Game> gameRegistry;

	public GameRepository(Map<String, Game> gameRegistry){
		this.gameRegistry = gameRegistry;
	}

	/**
	 * Saves a game to the database, this method currently
	 * does not support persistent storage when the server is offline.
	 * @param game to save
	 * @return this
	 */
	public GameRepository saveGame(Game game) {
		Game savedGame = gameRegistry.get(game.getId());
		
		if(savedGame != null){
			throw new DuplicateGameException(game);
		}
		
		gameRegistry.put(game.getId(), game);	
		return this;
	}

	public Game loadGame(String gameId) {
		return gameRegistry.get(gameId);
	}

	public GameRepository deleteGame(String gameId) {
		gameRegistry.remove(gameId);
		return this;
	}

	public Game updateGame(Game updateData) {
		Game currentGameState = gameRegistry.get(updateData.getId());
		
		if(currentGameState == null){
			throw new GameNotCreatedException(updateData);
		}
		
		gameRegistry.put(updateData.getId(), updateData);
		return loadGame(updateData.getId());
	}
	
}
