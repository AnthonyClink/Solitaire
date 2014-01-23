package com.stevesmith.solitare.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.stevesmith.solitaire.datatype.Game;
import com.stevesmith.solitaire.services.GameService;

@Singleton
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {

	private static final Logger LOGGER = Logger.getLogger(GameResource.class);
	private GameService gameService;

	@Inject
	public GameResource(GameService gameService){
		this.gameService = gameService;		
	}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Game createNewSolitaireGame(){
    	return gameService.createNewSolitaireGame();
    }	
	
//    @GET
//    @Path("solitaire/{gameId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Game getSolitaireGame(String gameId){
//    	return gameService.getGameBoard(gameId);
//    }
    
    //http://localhost:8080/solitare/gameboard/04/moveCard/1/from/reg2/to/diamonds
}
