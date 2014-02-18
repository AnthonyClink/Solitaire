package com.clinkworks.solitaire.datatype;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.clinkworks.solitaire.datatype.Card;
import com.clinkworks.solitaire.datatype.Game;
import com.clinkworks.solitaire.datatype.GameSpot;
import com.clinkworks.solitaire.datatype.Pile;
import com.clinkworks.solitaire.exceptions.ApiMisuseException;
import com.clinkworks.solitaire.exceptions.PileNotInitializedException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class GameUnitTest {

	@Test
	public void canRetrieveAPileFromAGame() throws PileNotInitializedException{
		Map<GameSpot, Pile> pileMap = Maps.newHashMap();
		List<Card> cards = Lists.newArrayList();
		pileMap.put(GameSpot.DISCARD, new Pile(cards));
		Game game = new Game("1", pileMap);
		
		assertTrue(game.getPile(GameSpot.DISCARD) != null);
		
	}
	
	@Test(expected = PileNotInitializedException.class)
	public void anUninitalizedPileThrowsAPileNotInitializedExceptionWhenRetrieved() throws PileNotInitializedException{
		Map<GameSpot, Pile> pileMap = Maps.newHashMap();
		Game game = new Game("1", pileMap);
		game.getPile(GameSpot.DRAW);
	}
	
	@Test(expected=ApiMisuseException.class)
	public void guiceCreatedGameShouldNotBeAllowedCallTheSetPileMethodAsConstructorInjectionIsFavored() throws ApiMisuseException{
		Game game = new Game(null, null);
		game.setPile("DRAW", null);
	}
	
	@Test
	public void gameCanProperlyBeSeralizedAndDesearalizedByJackson() throws JsonGenerationException, JsonMappingException, IOException, PileNotInitializedException{
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String gameJson = objectMapper.writeValueAsString(standardGame());
		Game game = objectMapper.readValue(gameJson, Game.class);
		
		for(GameSpot gameSpot : GameSpot.values()){
			assertNotNull(game.getPile(gameSpot));
		}
		
		game.getPile(GameSpot.DRAW).addCard(Card.ACE_OF_SPADES);
		
		String jsonWithAceOfSpades = objectMapper.writeValueAsString(game);
		
		assertTrue(jsonWithAceOfSpades.contains("\"DRAW\":{\"cards\":[{\"rank\":\"ACE\""));
		
		game = objectMapper.readValue(jsonWithAceOfSpades, Game.class);
		assertEquals(Card.ACE_OF_SPADES, game.getPile(GameSpot.DRAW).getTopCard());
		
	}
	
	private Game standardGame(){
		Map<GameSpot, Pile> pileMap = Maps.newHashMap();
		for(GameSpot gameSpot : GameSpot.values()){
			List<Card> cards = Lists.newArrayList();
			pileMap.put(gameSpot, new Pile(cards));
		}
		return new Game("1", pileMap);
	}
}
