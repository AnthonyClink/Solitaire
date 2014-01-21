package com.stevensmith.solitaire.datatype;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Pile;

public class PileUnitTests {
	
	@Test
	public void assureThatPilesHaveInjectableConstructors(){
		List<Card> cards = Lists.newArrayList();
		Pile pile = new Pile(cards);
		List<Card> storedCards = pile.getCards();
		assertTrue(cards == storedCards);
	}
}
