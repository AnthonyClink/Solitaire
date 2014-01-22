package com.stevensmith.solitaire.exceptions;

import com.stevesmith.solitaire.datatype.Game;

public class DuplicateGameException extends RuntimeException{

	private static final long serialVersionUID = -3861211361557013340L;
	
	public DuplicateGameException(Game game){
		super("Game: " + game.getId() + " already exists, try updating the game instead of saving it!");
	}
}
