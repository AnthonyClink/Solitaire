package com.stevesmith.solitaire.datatype;

import java.util.List;

public class Deck extends Pile{

	private List<Card> cards;
	
	
	
	public Deck(List<Card> cards) {
		super(cards);
		this.cards = cards;
	}

	public Card drawCard() {
		Card card = cards.get(cards.size()-1); 
		card.turnFaceUp();
		cards.remove(card);
		return card;
	}
}
