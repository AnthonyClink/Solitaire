package com.stevesmith.solitaire.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.Rank;
import com.stevesmith.solitaire.datatype.Suit;
import com.stevesmith.solitaire.domain.RuleService;

public class RuleServiceTest {

	Card aceDiamond = new Card(Rank.ACE, Suit.DIAMOND, true);
	Card aceClub = new Card(Rank.ACE, Suit.CLUB, true);
	Card twoDiamond = new Card(Rank.TWO, Suit.DIAMOND, true);
	Card twoClub = new Card(Rank.TWO, Suit.CLUB, true);
	Card threeDiamond = new Card(Rank.THREE, Suit.DIAMOND, true);
	Card threeClub = new Card(Rank.THREE, Suit.CLUB, true);
	
	RuleService ruleService = new RuleService();
	
	@Test
	public void isGoingToResolutionPileTest(){
		
	}
	
	@Test
	public void colorTest(){
		assertTrue(ruleService.isRed(aceDiamond));
		assertFalse(ruleService.isRed(aceClub));
		assertTrue(ruleService.isBlack(aceClub));
		assertFalse(ruleService.isBlack(aceDiamond));
	}
	
	@Test
	public void rankTest(){
		assertTrue(ruleService.isOneAbove(threeDiamond, twoClub));
		assertTrue(ruleService.isOneBelow(twoClub, threeClub));
	}
	
	@Test
	public void oppositeColorTest(){
		assertTrue(ruleService.isOppositeColor(aceDiamond, aceClub));
		assertTrue(ruleService.isOppositeColor(threeClub, aceDiamond));
		assertFalse(ruleService.isOppositeColor(aceDiamond, threeDiamond));
		assertFalse(ruleService.isOppositeColor(threeClub, twoClub));
	}

}
