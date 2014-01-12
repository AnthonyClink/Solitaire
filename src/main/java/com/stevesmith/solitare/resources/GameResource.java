package com.stevesmith.solitare.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.GameBoard;
import com.stevesmith.solitaire.datatype.Rank;
import com.stevesmith.solitaire.datatype.Suit;
import com.stevesmith.solitaire.domain.GameService;

@Singleton
@Path("solitare")
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {

	private GameService gameService;

	
	@Inject
	public GameResource(GameService gameService){
		this.gameService = gameService;
		
	}
    
    @GET
    @Path("gameboard")
    @Produces(MediaType.APPLICATION_JSON)
    public GameBoard getGameBoard(){
    	gameService.newGame();
    	return gameService.getGameBoard();
    	
    }
    
}
