package com.stevesmith.solitare.modules;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.GameSpot;

public class ProductionModule extends AbstractModule{

	@Override
	protected void configure() {
		install(new RestModule());
	}
	
	@Provides
	public Map<GameSpot, Deck> gameBoardMap(){
		Map<GameSpot, Deck> gameMap = Maps.newHashMap();
		return gameMap;
	}
	
	@Provides
	public List<Card> cards(){
		return Lists.newArrayList();
	}

}
