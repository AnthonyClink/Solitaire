package com.stevesmith.solitaire.util;

import java.util.ArrayList;
import java.util.HashMap;

import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.GameSpot;
import com.stevesmith.solitaire.datatype.Rank;
import com.stevesmith.solitaire.datatype.Suit;

public class GameInilizer {
	

	
	
	private Deck createDeck(){
		Deck deck = new Deck(new ArrayList<Card>());
		for(Rank rank : Rank.values()){
			for(Suit suit : Suit.values()){
				Card card = new Card(rank, suit, false);
				deck.addCard(card);
			}
		}return deck;
	}
	
	
}
