package com.clinkworks.solitaire.exceptions;

import com.clinkworks.solitaire.datatype.Game;

public class GameNotCreatedException extends RuntimeException{

	private static final long serialVersionUID = -6923061838517004133L;
	
	public GameNotCreatedException(Game game){
		super("Cannot update a game that does not exist: " + game.getId());
	}
}
