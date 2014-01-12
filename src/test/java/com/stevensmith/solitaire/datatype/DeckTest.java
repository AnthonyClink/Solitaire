package com.stevensmith.solitaire.datatype;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.Rank;
import com.stevesmith.solitaire.datatype.Suit;
import com.stevesmith.solitare.modules.ProductionModule;

public class DeckTest {

	private Deck deck = null;
	
	public void canShuffle(){
		
	}
	
	@Test
	public void addCardTest() {
		Card card = new Card(Rank.ACE, Suit.CLUB, false);
		int size1 = deck.getSize();
		deck.addCard(card);
		int size2 = deck.getSize();
		assertEquals(52, size1);
		assertEquals(53, size2);
	}
	
	@Before
	public void doSetup(){
		deck = createDeck();
	}
	
	@Test
	public void removeCardTest(){
		int deckSizeBefore = deck.getSize();
		Card card = deck.drawCard();
		deck.removeCard(card);
		int deckSizeAfter = deck.getSize();
		assertEquals(52, deckSizeBefore);
		assertEquals(51, deckSizeAfter);
		
	}
	
	@Test
	public void canCreateDeck(){
		Deck deck = createDeck();
		assertNotNull(deck);
	}
	
	@Test
	public void canDraw(){
		Deck deck = createDeck();
		Card card = deck.drawCard();
		assertNotNull(card);
	}
	
	private Deck createDeck(){
		Injector injector = Guice.createInjector(new ProductionModule());
		deck = injector.getInstance(Deck.class);
		for(Rank rank : Rank.values()){
			for(Suit suit : Suit.values()){
				Card card = new Card(rank, suit, false);
				deck.addCard(card);
			}
		}return deck;
	}
}
