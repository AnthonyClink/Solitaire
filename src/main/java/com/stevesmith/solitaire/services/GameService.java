package com.stevesmith.solitaire.services;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Maps;
import com.stevesmith.solitaire.components.GameRepository;
import com.stevesmith.solitaire.datatype.Game;
import com.stevesmith.solitaire.datatype.GameSpot;
import com.stevesmith.solitaire.datatype.Pile;




public class GameService {

	private final DeckService deckService;
	private final RuleService ruleService;
	private final GameRepository gameRespository;
	private int nextGameId;
	

	public GameService(RuleService	 ruleService, DeckService deckService, GameRepository gameRespository) {
		this.ruleService = ruleService;
		this.deckService = deckService;
		this.gameRespository = gameRespository;
		nextGameId = 0;
	}
	
	
	public Game createGame(){
		Game game = new Game(String.valueOf(nextGameId++), createSolitaireGameMap());
		gameRespository.saveGame(game);
		return game;
	}


	private Map<GameSpot, Pile> createSolitaireGameMap() {
		Map<GameSpot, Pile> map = Maps.newHashMap();
		for(GameSpot gameSpot : GameSpot.values()){
			map.put(gameSpot, deckService.createNewEmptyPile());
		}
		return map;
	}


	public Game getGameBoard(String gameId) {
		
		return gameRespository.loadGame(gameId);
	}


	public void deleteGameBoard(String gameId) {
		gameRespository.deleteGame(gameId);
		
	}
	
	
	
}
