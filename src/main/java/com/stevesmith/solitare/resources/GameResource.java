package com.stevesmith.solitare.resources;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.GameBoard;
import com.stevesmith.solitaire.datatype.GameSpot;
import com.stevesmith.solitaire.domain.GameService;

@Singleton
@Path("solitaire")
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {

	private static final Logger LOGGER = Logger.getLogger(GameResource.class);
	private GameService gameService;

	
	@Inject
	public GameResource(GameService gameService){
		this.gameService = gameService;
		
	}
    
    @GET
    @Path("helloworld")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHelloWorld(){
    	
    	return "hello world";
    }
    
  
    
  
    
    //http://localhost:8080/solitare/gameboard/04/moveCard/1/from/reg2/to/diamonds
    
    
    
    private void info(String message){
    	//LOGGER.info(message);
    	System.out.println(message);
    }
    
}
