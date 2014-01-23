package com.stevensmith.solitaire.exceptions;

public class NoCardsOnPileException extends Exception{

	private static final long serialVersionUID = 5301117598250952261L;

	public NoCardsOnPileException(){
		super("No cards left on the pile!");
	}
}
