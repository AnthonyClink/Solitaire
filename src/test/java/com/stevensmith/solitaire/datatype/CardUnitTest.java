package com.stevensmith.solitaire.datatype;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.crypto.interfaces.PBEKey;

import org.junit.Test;

import com.google.common.collect.Maps;
import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Color;
import com.stevesmith.solitaire.datatype.Rank;
import com.stevesmith.solitaire.datatype.Suit;

public class CardUnitTest {
	
	@Test
	public void basicMetaDataForACardIsSupported(){
		Card ace = newAceOfSpades();
		Card aceOfHearts = new Card(Rank.ACE, Suit.HEART);
		
		assertEquals(Rank.ACE, ace.getRank());
		assertEquals(Suit.SPADE, ace.getSuit());
		assertEquals(Color.BLACK, ace.getColor());
		assertTrue(ace.isBlack());
		assertFalse(ace.isRed());
		assertTrue(ace.isOppositeColor(aceOfHearts));

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
		Set<Card> cardSet = new HashSet<Card>();
		
		Card ace1 = newAceOfSpades();
		Card ace2 = newAceOfSpades();
		
		cardSet.add(ace1);
		assertTrue(cardSet.contains(ace2));
		
		Map<Card, Object> referenceTestMap = Maps.newHashMap();
		
		Object objectForReference = new Object();
		
		referenceTestMap.put(ace1, objectForReference);
		assertEquals(objectForReference, referenceTestMap.get(ace2));
	}
	
	private Card newAceOfSpades(){
		return new Card(Rank.ACE, Suit.SPADE);
	}
}
