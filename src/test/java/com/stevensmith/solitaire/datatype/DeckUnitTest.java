package com.stevensmith.solitaire.datatype;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.stevensmith.solitaire.exceptions.NoMoreCardsException;
import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.CardState;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.Suit;
import com.stevesmith.solitaire.datatype.Rank;

public class DeckUnitTest {

	@Test(expected = NoMoreCardsException.class)
	public void ensureDrawCardThrowsNoMoreCardsException(){
		Deck deck = getNewEmptyDeck();
		deck.drawCard();
	}
	
	@Test
	public void ensureDrawCardRemovesCardDoesNotChangeCardState(){
		
		Deck deck = getDeckWithTwoCards();
		
		Card beforeDraw = deck.getCards().get(deck.getSize()-1);
		
		Card card = deck.drawCard();
		assertTrue(card.isFaceDown());
		Card nextCard = deck.drawCard();
		assertFalse(card == nextCard);
		assertTrue(beforeDraw == card);
		
	}
	
	@Test
	public void ensureThatTheShuffleMethodChangesTheOrderOfTheCards(){
		List<Card> cards = Lists.newArrayList();
		for(Rank rank : Rank.standardRanks()){
			for(Suit suit : Suit.standardSuits()){
				cards.add(new Card(rank, suit, CardState.FACE_DOWN));
			}
		}
		
		boolean allElementsAreTheSame = true;
		
		Deck deck = new Deck(cards);
		List<Card> currentCardState = deck.getCards();
		
		deck.shuffle();
		
		for(int i = 0; i < cards.size(); i++){
			if(cards.get(i) != currentCardState.get(i)){
				allElementsAreTheSame = false;
				break;
			}
		}
		
		assertFalse(allElementsAreTheSame);
		
	}
	private Deck getNewEmptyDeck(){
		List<Card> cards = Lists.newArrayList();
		return new Deck(cards);
	}
	
	
	private Deck getDeckWithTwoCards(){
		List<Card> cards = Lists.newArrayList();
		cards.add(newAceOfSpades());
		cards.add(newAceOfHearts());
		return new Deck(cards);
	}
	
	private Card newAceOfSpades(){
		return new Card(Rank.ACE, Suit.SPADE, CardState.FACE_DOWN);
	}
	
	private Card newAceOfHearts(){
		return new Card(Rank.ACE, Suit.HEART, CardState.FACE_DOWN);
	}
	
}
