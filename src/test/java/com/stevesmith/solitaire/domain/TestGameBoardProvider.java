package com.stevesmith.solitaire.domain;

import java.util.Map;

import com.google.common.collect.Maps;
import com.google.inject.Provider;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.GameBoard;
import com.stevesmith.solitaire.datatype.GameSpot;

public class TestGameBoardProvider implements Provider<GameBoard>{

	private Provider<Deck> deckProvider;

	public TestGameBoardProvider(Provider<Deck> deckProvider){
		this.deckProvider = deckProvider;
	}
	
	@Override
	public GameBoard get() {
		Map<GameSpot, Deck> deckMap = Maps.newHashMap();
		
		for(GameSpot gameSpot : GameSpot.values()){
			deckMap.put(gameSpot, deckProvider.get());
		}
		
		return new GameBoard(deckMap, deckProvider);
	}

}
