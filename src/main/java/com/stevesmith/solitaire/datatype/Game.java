package com.stevesmith.solitaire.datatype;

import java.util.Map;

public class Game {

	private final String gameId;
	private final Map<GameSpot, Pile> gameMap;

	public Game(String gameId, Map<GameSpot,Pile> gameMap){
		this.gameMap = gameMap;
		this.gameId = gameId;
	}
	
	
	public String getId() {
		
		return gameId;
	}

	public Pile getPile(GameSpot gameSpot) {
		return gameMap.get(gameSpot);
	}	
	
	
	

}
