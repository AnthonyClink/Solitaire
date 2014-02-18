package com.clinkworks.solitaire.components;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.clinkworks.solitaire.components.GameRepository;
import com.clinkworks.solitaire.datatype.Card;
import com.clinkworks.solitaire.datatype.CardState;
import com.clinkworks.solitaire.datatype.Game;
import com.clinkworks.solitaire.datatype.GameSpot;
import com.clinkworks.solitaire.datatype.Pile;
import com.clinkworks.solitaire.datatype.Rank;
import com.clinkworks.solitaire.datatype.Suit;
import com.clinkworks.solitaire.exceptions.DuplicateGameException;
import com.clinkworks.solitaire.exceptions.GameNotCreatedException;
import com.clinkworks.solitaire.exceptions.InvalidOrBlankGameIdProvidedException;
import com.clinkworks.solitaire.exceptions.PileNotInitializedException;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class GameRepositoryUnitTest {
	
	private static final String DEFAULT_GAME_ID = "0";
	
	@Test
	public void ensureGameRepositoryCanSaveAGame(){
		
		Map<String, Game> gameData = Maps.newHashMap();
		GameRepository gameRepository = new GameRepository(gameData);
		
		Game game = newGame();
		
		gameRepository.saveGame(game);
		
		assertEquals(game, gameData.get(DEFAULT_GAME_ID));
	}
	
	@Test
	public void ensureGameRepositoryCanReturnAllSavedGames(){
		
		Map<String, Game> gameData = Maps.newHashMap();
		GameRepository gameRepository = new GameRepository(gameData);
		
		Game game = newGame();
		
		Game game2 = new Game("2", new HashMap<GameSpot, Pile>());
		
		gameData.put("1", game);
		gameData.put("2", game2);
		
		List<Game> savedGames = gameRepository.getAllGames();
		
		assertEquals(2, savedGames.size());
		assertEquals(game, savedGames.get(0));
		assertEquals(game2, savedGames.get(1));
	}
	
	@Test(expected = InvalidOrBlankGameIdProvidedException.class)
	public void ensureSaveActionDoesNotOverrideAPreviouslySavedGame(){
		GameRepository gameRepository = newGameRepository(newGame());
		Game possibleOverwrite = newGame();
		gameRepository.saveGame(possibleOverwrite);
	}
	
	@Test(expected = GameNotCreatedException.class)
	public void ensureAGameMustBeCreatedInOrderToUpdateIt(){
		GameRepository gameRepository = newGameRepository();
		gameRepository.updateGame(newGame());
	}
	
	@Test(expected = InvalidOrBlankGameIdProvidedException.class)
	public void ensureThatAGameToBeSavedHasAValidId(){
		GameRepository repo = newGameRepository();
		Game game = new Game(null, null);
		repo.saveGame(game);
	}
	
	@Test
	public void ensureGameRepositoryCanUpdateAGame() throws PileNotInitializedException{
		
		Game game = newGame();
		
		Map<String, Game> repoData = Maps.newHashMap();
		repoData.put(DEFAULT_GAME_ID, game);
		GameRepository gameRepository = new GameRepository(repoData);
		
		Map<GameSpot, Pile> gameData = Maps.newHashMap();
		
		Game updateData = new Game(DEFAULT_GAME_ID, gameData);
		
		Card aceOfSpades = new Card(Rank.ACE, Suit.SPADES, CardState.FACE_UP);
		
		Pile pile = newPile(aceOfSpades);
		
		gameData.put(GameSpot.REGULAR_1, pile);
		
		gameRepository.updateGame(updateData);
		
		Game gameInRepo = repoData.get(DEFAULT_GAME_ID);
		
		assertEquals(aceOfSpades, gameInRepo.getPile(GameSpot.REGULAR_1).getCards().get(0));
		
	}
	
	@Test
	public void ensureGameRepositoryCanLoadAGame(){
		
		Game game = newGame();
		GameRepository gameRepository = newGameRepository(game);
		
		Game loadedGame = gameRepository.loadGame(DEFAULT_GAME_ID);
		
		assertEquals(game, loadedGame);
		
	}
	
	@Test
	public void ensureGameRepositoryCanDeleteAGame(){
		Game game = newGame();
		
		Map<String, Game> gameData = Maps.newHashMap();
		gameData.put(DEFAULT_GAME_ID, game);
		
		GameRepository gameRepository = new GameRepository(gameData);
		
		gameRepository.deleteGame(DEFAULT_GAME_ID);
		
		assertEquals(0, gameData.keySet().size());
	}
	
	
	private Game newGame(){
		return new Game(DEFAULT_GAME_ID, new HashMap<GameSpot, Pile>());
	}
	
	private Pile newPile(Card... cards){
		List<Card> pileData = Lists.newArrayList();
		for(Card card : cards){
			pileData.add(card);
		}
		
		return new Pile(pileData);
	}
	
	private GameRepository newGameRepository(Game... startingGames){
		Map<String, Game> gameData = Maps.newHashMap();
		
		for(Game game : startingGames){
			gameData.put(game.getId(), game);
		}
		
		return new GameRepository(gameData);
	}
	
}
