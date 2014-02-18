package com.clinkworks.solitaire.datatype;

import java.util.Map;

import com.clinkworks.solitaire.exceptions.ApiMisuseException;
import com.clinkworks.solitaire.exceptions.PileNotInitializedException;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

public class Game {

	private String id;
	private Map<GameSpot, Pile> piles;
	
	@JsonIgnore
	private boolean createdByExternalSystem = false;
	
	protected Game(){
		//this constructor is only intented to be called by jackson.
		createdByExternalSystem = true;
		piles = Maps.newHashMap();
	}
	
	@Inject
	public Game(String id, Map<GameSpot,Pile> gameMap){
		this.piles = gameMap;
		this.id = id;
	}
	
	
	public String getId() {
		
		return id;
	}

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
	public void setPile(String gameSpot, Pile pile) throws ApiMisuseException{
		if(!createdByExternalSystem){
			throw new ApiMisuseException("The Game.setPile method is intended to be called by Jackson only. Please inject your data properly using the guice modules. Thank you.");
		}
		piles.put(GameSpot.valueOf(gameSpot), pile);
	}
	
	

}
