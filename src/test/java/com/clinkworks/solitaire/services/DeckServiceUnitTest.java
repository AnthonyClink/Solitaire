package com.clinkworks.solitaire.services;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.clinkworks.solitaire.datatype.Card;
import com.clinkworks.solitaire.datatype.Deck;
import com.clinkworks.solitaire.datatype.Pile;
import com.clinkworks.solitaire.datatype.Suit;
import com.clinkworks.solitaire.services.DeckService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

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
