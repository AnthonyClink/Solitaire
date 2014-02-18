package com.clinkworks.solitaire.modules;


import java.util.List;
import java.util.Map;

import com.clinkworks.solitaire.datatype.Card;
import com.clinkworks.solitaire.datatype.Deck;
import com.clinkworks.solitaire.datatype.Game;
import com.clinkworks.solitaire.datatype.GameSpot;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;


public class ProductionModule extends AbstractModule{

	@Override
	protected void configure() {
		install(new JacksonModule());
	}
	
	@Provides
	public Map<GameSpot, Deck> gameBoardMap(){
		Map<GameSpot, Deck> gameMap = Maps.newHashMap();
		return gameMap;
	}
	
	@Provides
	public Map<String, Game> gameData(){
		return Maps.newHashMap();
	}
	
	@Provides
	public List<Card> cards(){
		return Lists.newArrayList();
	}

}