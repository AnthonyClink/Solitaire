package com.stevesmith.solitaire.services;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;
import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.CardState;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.GameSpot;
import com.stevesmith.solitaire.datatype.Pile;
import com.stevesmith.solitaire.datatype.Rank;
import com.stevesmith.solitaire.datatype.Suit;

@Singleton
public class DeckService {

	public Pile createNewEmptyPile() {
		return new Pile(new ArrayList<Card>());
	}

	public Deck getStandard52CardDeck() {
		List<Card> cards = Lists.newArrayList();
		for(Suit suit : Suit.standardSuits()){
			for(Rank rank : Rank.standardRanks()){
				cards.add(new Card(rank, suit, CardState.FACE_DOWN));
			}
		}
		
		return new Deck(cards);
	}	
	
	public Deck shuffleDeck(Deck deck){
		return deck.shuffle();
	}
}
