package com.stevensmith.solitaire.datatype;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.stevensmith.solitaire.exceptions.PileNotInitializedException;
import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Game;
import com.stevesmith.solitaire.datatype.GameSpot;
import com.stevesmith.solitaire.datatype.Pile;

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
	
	private Game standardGame(){
		Map<GameSpot, Pile> pileMap = Maps.newHashMap();
		for(GameSpot gameSpot : GameSpot.values()){
			List<Card> cards = Lists.newArrayList();
			pileMap.put(gameSpot, new Pile(cards));
		}
		return new Game("1", pileMap);
	}
}
