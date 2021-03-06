package com.clinkworks.solitaire.datatype;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.clinkworks.solitaire.datatype.Card;
import com.clinkworks.solitaire.datatype.CardState;
import com.clinkworks.solitaire.datatype.Pile;
import com.clinkworks.solitaire.datatype.Rank;
import com.clinkworks.solitaire.datatype.Suit;
import com.clinkworks.solitaire.exceptions.CardDuplicationException;
import com.google.common.collect.Lists;

public class PileUnitTest {
	
	@Test
	public void ensureThatWeCanAddTwoCardsThatAreIdenticalToThePile(){
		
		Pile pile = newEmptyPile();
		
		pile.addCard(newAceOfSpades()).addCard(newAceOfSpades());
		
		assertEquals(2, pile.getSize());
		
	}
	
	@Test(expected = CardDuplicationException.class)
	public void ensureThatTwoExactCardsCannotBeAddedToThePile(){
		Card ace = newAceOfSpades();
		
		Pile pile = newEmptyPile();
		
		pile.addCard(ace).addCard(ace);
	}
	

	@Test
	public void ensureGetTopCardDoesNotChangeState(){
		Pile pile = pileWithOneAceOfSpades();
		
		Card card = pile.getTopCard();
		assertTrue(card.isFaceDown());
		Card nextCard = pile.getTopCard();
		assertTrue(card == nextCard);
		
	}
	
	@Test
	public void assureThatCardsCanBeProperlyRemovedByObjectReference(){
		Pile pile = pileWithOneAceOfSpades();
		
		Card aceOfSpades = pile.getCards().get(0);
		Card aceOfClubs = new Card(Rank.ACE, Suit.SPADES,CardState.FACE_UP);
		
		pile.addCard(aceOfClubs);
		
		assertEquals(2, pile.getSize());
		
		pile.removeCard(aceOfSpades);
		
		
		assertEquals(1, pile.getSize());
		assertTrue(aceOfClubs == pile.getCards().get(0));
		
		
	}
	
	private Pile newEmptyPile(){
		return new Pile(new ArrayList<Card>());
	}
	
	private Card newAceOfSpades(){
		return new Card(Rank.ACE, Suit.SPADES, CardState.FACE_DOWN);
	}
	
	private Pile pileWithOneAceOfSpades(){
		List<Card> cards = Lists.newArrayList();
		cards.add(newAceOfSpades());
		Pile pile = new Pile(cards);
		return pile;
	}
	
	
}
