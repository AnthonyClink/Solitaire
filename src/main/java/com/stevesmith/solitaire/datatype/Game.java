package com.stevesmith.solitaire.datatype;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stevensmith.solitaire.exceptions.PileNotInitializedException;

public class Game {

	private String id;
	private Map<GameSpot, Pile> piles;
	
	protected Game(){
		
	}
	
	public Game(String id, Map<GameSpot,Pile> gameMap){
		this.piles = gameMap;
		this.id = id;
	}
	
	
	public String getId() {
		
		return id;
	}


	@JsonIgnore
	public Pile getPile(GameSpot gameSpot) throws PileNotInitializedException  {
		Pile pile = piles.get(gameSpot);
		
		if(pile == null){
			throw new PileNotInitializedException();
		}
		
		return piles.get(gameSpot);
	}	
	
	@JsonAnyGetter
	public Map<GameSpot, Pile> getPiles(){
		return piles;
	}
	
	@JsonAnySetter
	public void setPiles(Map<GameSpot, Pile> piles){
		this.piles = piles;
	}
	
	

}
