package com.clinkworks.solitaire.datatype;

import static org.junit.Assert.*;

import java.util.Map;
import org.junit.Test;

import com.clinkworks.solitaire.datatype.Card;
import com.clinkworks.solitaire.datatype.CardState;
import com.clinkworks.solitaire.datatype.Color;
import com.clinkworks.solitaire.datatype.Rank;
import com.clinkworks.solitaire.datatype.Suit;
import com.google.common.collect.Maps;

public class CardUnitTest {
	
	@Test
	public void basicMetaDataForACardIsSupported(){
		Card ace = newAceOfSpades();
		Card aceOfHearts = new Card(Rank.ACE, Suit.HEARTS, CardState.FACE_UP);
		
		assertEquals(Rank.ACE, ace.getRank());
		assertEquals(Suit.SPADES, ace.getSuit());
		assertEquals(Color.BLACK, ace.getColor());
		assertTrue(ace.isBlack());
		assertFalse(ace.isRed());
		assertTrue(ace.isOppositeColor(aceOfHearts));
		assertFalse(ace.isFaceDown());
	}
	
	@Test
	public void cardMaintainsEqualityBasedOnRankAndSuit(){
		Card ace1 = newAceOfSpades();
		Card ace2 = newAceOfSpades();
		
		assertEquals(ace1, ace2);
		assertFalse(ace1 == ace2);
	}
	
	@Test
	public void cardIsHashedInAWayToAllowCardsToBeUsedAsKeys(){

		Card ace1 = newAceOfSpades();
		Card ace2 = newAceOfSpades();
		
		Map<Card, Object> referenceTestMap = Maps.newHashMap();
		
		Object objectForReference = new Object();
		
		referenceTestMap.put(ace1, objectForReference);
		
		assertEquals(objectForReference, referenceTestMap.get(ace2));
	}
	
	private Card newAceOfSpades(){
		return new Card(Rank.ACE, Suit.SPADES, CardState.FACE_UP);
	}
}
