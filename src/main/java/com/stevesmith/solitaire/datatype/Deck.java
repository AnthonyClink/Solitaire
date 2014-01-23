package com.stevesmith.solitaire.datatype;

import java.util.Collections;
import java.util.List;

public class Deck extends Pile{
	
	public Deck(List<Card> cards) {
		super(cards);
	}

	public Card drawCard() {
		return getInternalData().remove(getSize() - 1);
	}

	public Deck shuffle() {
		Collections.shuffle(getInternalData());
		return this;
	}
}
