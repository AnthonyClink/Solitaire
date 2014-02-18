package com.clinkworks.solitaire.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.clinkworks.solitaire.datatype.Game;
import com.clinkworks.solitaire.exceptions.DuplicateGameException;
import com.clinkworks.solitaire.exceptions.GameNotCreatedException;
import com.clinkworks.solitaire.exceptions.InvalidOrBlankGameIdProvidedException;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class GameRepository {
	
	private final Map<String, Game> gameRegistry;

	@Inject
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
		
		if(StringUtils.isBlank(game.getId()) || savedGame != null){
			throw new InvalidOrBlankGameIdProvidedException();
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

	public List<Game> getAllGames() {
		List<Game> games = new ArrayList<Game>();
		games.addAll(gameRegistry.values());
		Collections.sort(games, new SortById());
		return games;
	}
	
	public static class SortById implements Comparator<Game>{

		@Override
		public int compare(Game first, Game second) {
			return first.getId().compareTo(second.getId());
		}
		
	}
}
