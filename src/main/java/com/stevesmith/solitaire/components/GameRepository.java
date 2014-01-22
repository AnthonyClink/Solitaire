package com.stevesmith.solitaire.components;

import java.util.Map;

import com.stevesmith.solitaire.datatype.Game;

public class GameRepository {
	
	private final Map<String, Game> gameRegistry;

	public GameRepository(Map<String, Game> gameRegistry){
		this.gameRegistry = gameRegistry;
	}

	public GameRepository saveGame(Game game) {
		gameRegistry.put(game.getId(), game);		
		return this;
	}

	public int getTotalGameCount() {
		return gameRegistry.keySet().size();
	}

	public Game loadGame(String gameId) {
		return gameRegistry.get(gameId);
	}

	public GameRepository deleteGame(String gameId) {
		gameRegistry.remove(gameId);
		return this;
	}
	
}
