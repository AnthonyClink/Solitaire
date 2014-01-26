package com.stevesmith.solitaire.datatype;

import java.util.Collections;
import java.util.List;

import com.stevensmith.solitaire.exceptions.NoMoreCardsException;

public class Deck extends Pile{
	
	public Deck(List<Card> cards) {
		super(GameSpotType.DRAW, cards);
	}

	public Card drawCard() {
		
		if(getSize() == 0){
			throw new NoMoreCardsException();
		}
		
		return getInternalData().remove(getSize() - 1);
	}

	public Deck shuffle() {
		Collections.shuffle(getInternalData());
		return this;
	}
}
