package com.stevesmith.solitaire.datatype;

public class DrawDiscardComposite {

	private final Deck discardDeck;
	private final Deck drawDeck;

	public DrawDiscardComposite(Deck drawDeck, Deck discardDeck){
		this.discardDeck = discardDeck;
		this.drawDeck = drawDeck;
	}

	public Deck getDiscardDeck() {
		return discardDeck;
	}

	public Deck getDrawDeck() {
		return drawDeck;
	}
	
	
	
}
