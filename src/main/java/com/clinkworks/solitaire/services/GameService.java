package com.clinkworks.solitaire.services;

import java.util.List;
import java.util.Map;

import com.clinkworks.solitaire.components.GameRepository;
import com.clinkworks.solitaire.datatype.Card;
import com.clinkworks.solitaire.datatype.Deck;
import com.clinkworks.solitaire.datatype.Game;
import com.clinkworks.solitaire.datatype.GameSpot;
import com.clinkworks.solitaire.datatype.GameSpotType;
import com.clinkworks.solitaire.datatype.GameType;
import com.clinkworks.solitaire.datatype.Pile;
import com.clinkworks.solitaire.exceptions.PileNotInitializedException;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class GameService {

	private final DeckService deckService;
	private final RuleService ruleService;
	private final GameRepository gameRespository;
	private int nextGameId;
	
	@Inject
	public GameService(RuleService	 ruleService, DeckService deckService, GameRepository gameRespository) {
		this.ruleService = ruleService;
		this.deckService = deckService;
		this.gameRespository = gameRespository;
		nextGameId = 0;
	}
	
	public Game createGame(){
		Game game = new Game(String.valueOf(nextGameId++), createSolitaireGameMap());
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
		try{
			dealGame(game, gameType);
		}catch(PileNotInitializedException e){
			throw new RuntimeException("Something really bad happened, somehow you passed me a solitaire game without solitaire piles", e);
		}
		return game;
	}

	private void dealGame(Game game, GameType gameType) throws PileNotInitializedException {
		
		switch  (gameType){
			case STANDARD_SOLITAIRE:
				dealStandardSolitaireGame(game);
				break;
			default: 
				dealStandardSolitaireGame(game);
		}
	
	}

	private Game dealStandardSolitaireGame(Game game) throws PileNotInitializedException  {
		Deck deck = deckService.getStandard52CardDeck();
		deckService.shuffleDeck(deck);
		
		for(int row = 0; row < 7; row++){
			for(int column = row; column < 7; column++){				
				GameSpot gameSpot = GameSpot.getGameSpotsByType(GameSpotType.REGULAR).get(column);
				
				Card card = deck.drawCard();
				
				if(column == row){
					card.turnFaceUp();
				}
				
				game.getPile(gameSpot).addCard(card);
			}
		}
		
		game.getPile(GameSpot.DRAW).addCards(deck.getCards());
		
		return game;
		
	}
	
	public Game createNewSolitaireGame() {
		Game game = dealNewGame(GameType.STANDARD_SOLITAIRE);
		saveGame(game);
		return game;
	}
	
	public Game saveGame(Game game){
		gameRespository.saveGame(game);
		return game;
	}

	public Game updateGame(Game game) {
		return gameRespository.updateGame(game);
	}

	public List<Game> getSavedGames() {
		return gameRespository.getAllGames();
	}
	
}
