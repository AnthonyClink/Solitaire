package com.stevesmith.solitaire.datatype;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public enum GameSpot {
	
	DRAW(GameSpotType.DRAW),
	DISCARD(GameSpotType.DISCARDPILE),
	REGULAR_1(GameSpotType.REGULAR),
	REGULAR_2(GameSpotType.REGULAR),
	REGULAR_3(GameSpotType.REGULAR),
	REGULAR_4(GameSpotType.REGULAR),
	REGULAR_5(GameSpotType.REGULAR),
	REGULAR_6(GameSpotType.REGULAR),
	REGULAR_7(GameSpotType.REGULAR),
	RESOLUTION_HEARTS(GameSpotType.RESOLUTION),
	RESOLUTION_DIAMONDS(GameSpotType.RESOLUTION),
	RESOLUTION_SPADE(GameSpotType.RESOLUTION),
	RESOLUTION_CLUB(GameSpotType.RESOLUTION);
	
	private GameSpotType gameSpotType;
	
	private GameSpot(GameSpotType gameSpotType){
		this.gameSpotType = gameSpotType;
	}
	
	public GameSpotType getGameSpotType(){
		return gameSpotType;
	}

	public static List<GameSpot> getGameSpotsByType(GameSpotType gameSpotType){
		List<GameSpot> retval = Lists.newArrayList();
		
		return retval;
	}
	
	
	
}
