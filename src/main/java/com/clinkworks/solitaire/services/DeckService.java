package com.clinkworks.solitaire.services;

import java.util.ArrayList;
import java.util.List;

import com.clinkworks.solitaire.datatype.Card;
import com.clinkworks.solitaire.datatype.CardState;
import com.clinkworks.solitaire.datatype.Deck;
import com.clinkworks.solitaire.datatype.GameSpot;
import com.clinkworks.solitaire.datatype.Pile;
import com.clinkworks.solitaire.datatype.Rank;
import com.clinkworks.solitaire.datatype.Suit;
import com.google.common.collect.Lists;
import com.google.inject.Singleton;

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
