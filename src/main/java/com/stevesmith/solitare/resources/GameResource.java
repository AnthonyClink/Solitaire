package com.stevesmith.solitare.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.stevesmith.solitaire.datatype.Game;
import com.stevesmith.solitaire.services.GameService;

@Singleton
@Path("/games")
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {

	private static final Logger LOGGER = Logger.getLogger(GameResource.class);
	private GameService gameService;

	@Inject
	public GameResource(GameService gameService){
		this.gameService = gameService;		
	}

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Game createNewSolitaireGame(GameConfiguration config){
    	return gameService.createNewSolitaireGame();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Game> getAllSavedGames(){
    	return gameService.getSavedGames();
    }    
    
    @GET
    @Path("/{gameId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Game getSolitaireGame(@PathParam("gameId") String gameId){
    	return gameService.getGameBoard(gameId);
    }
    
    @PUT
    @Path("/{gameId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Game updateSolitaireGame(Game gameToUpdate){
    	return gameService.updateGame(gameToUpdate);
    }
    
    @DELETE
    @Path("/{gameId}")
    public void deleteGame(@PathParam("gameId") String gameId){
    	gameService.deleteGameBoard(gameId);
    }
    //http://localhost:8080/solitare/gameboard/04/moveCard/1/from/reg2/to/diamonds
}
