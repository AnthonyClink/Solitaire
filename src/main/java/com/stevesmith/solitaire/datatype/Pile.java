package com.stevesmith.solitaire.datatype;

import java.util.List;

public class Pile {

	private  final List<Card> cards;
	
	public Pile(List<Card> cards) {
		this.cards = cards;
	}
	
	public List<Card> getCards(){
		return cards;
	}

	public int getSize(){
		return cards.size();
	}
}
