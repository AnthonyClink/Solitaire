package com.stevesmith.solitaire.services;

import java.util.Map;

import com.google.common.collect.Maps;
import com.stevesmith.solitaire.components.GameRepository;
import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.Game;
import com.stevesmith.solitaire.datatype.GameSpot;
import com.stevesmith.solitaire.datatype.GameSpotType;
import com.stevesmith.solitaire.datatype.GameType;
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

	public Game dealNewGame(GameType gameType) {
		Game game = createGame();
		dealGame(game, gameType);
		return game;
	}

	private void dealGame(Game game, GameType gameType) {
		switch  (gameType){
			case STANDARD_SOLITAIRE:
				dealStandardSolitairGame(game);
		
		}
	
		
	}

	private Game dealStandardSolitairGame(Game game) {
		Deck deck = deckService.getStandard52CardDeck();
		for(int row = 0; row < 7; row++){
			for(int column = row; column < 7; column++){				
				GameSpot gameSpot = GameSpot.getGameSpotsByType(GameSpotType.REGULAR).get(column);
				Card card;
				if(column == row){
					card = deck.drawCard();
				}else{
					card = deck.getTopCard();
				}
				game.getPile(gameSpot).addCard(card);
			}
		}
		game.getPile(GameSpot.DRAW).addCards(deck.getCards());
		
		return game;
		
	}
	
}
