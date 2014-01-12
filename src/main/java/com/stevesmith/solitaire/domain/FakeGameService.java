package com.stevesmith.solitaire.domain;

import java.util.ArrayList;

import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.Rank;
import com.stevesmith.solitaire.datatype.Suit;

public class FakeGameService extends GameService{
	
	public FakeGameService() {
		super(null, null, null);
	}
	
	@Override
	public Deck newFullDeck(){
		return new Deck(new ArrayList<Card>()).addCard(new Card(Rank.ACE, Suit.SPADE, false));
	}

}
