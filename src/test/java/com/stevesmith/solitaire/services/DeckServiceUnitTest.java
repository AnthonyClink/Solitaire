package com.stevesmith.solitaire.services;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.Pile;
import com.stevesmith.solitaire.datatype.Suit;

public class DeckServiceUnitTest {
	
	@Test
	public void ensureDeckServiceCanCreateANewEmptyPile(){
		DeckService deckService = newDeckService();
		
		Pile pile = deckService.createNewEmptyPile();
		assertNotNull(pile);
	}
	
	@Test
	public void ensureDeckServiceCanDeliverAStandardDeck(){
		DeckService deckService = newDeckService();
		
		Deck deck = deckService.getStandard52CardDeck();
		
		
		assertEquals(52, deck.getSize());
		
		Map<Suit, List<Card>> suitToCards = Maps.newHashMap();
		
		for(Card card : deck.getCards()){
			List<Card> cardsInASuit = suitToCards.get(card.getSuit());
			if(cardsInASuit == null){
				cardsInASuit = Lists.newArrayList();
			}
			cardsInASuit.add(card);
			assertTrue(card.isFaceDown());
			suitToCards.put(card.getSuit(), cardsInASuit);
		}
		
		int suitCount = 0;
		
		for(Map.Entry<Suit, List<Card>> row : suitToCards.entrySet()){
			suitCount++;
			assertEquals(13, row.getValue().size());
		}
		
		assertEquals(4, suitCount);
	}
	
	private DeckService newDeckService(){
		return new DeckService();
	}
}
