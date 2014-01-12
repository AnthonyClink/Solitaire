package com.stevensmith.solitaire.datatype;

import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Rank;
import com.stevesmith.solitaire.datatype.Suit;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

	Card card = new Card(Rank.ACE,Suit.CLUB,false);
	
	@Test
	public void hasRank(){
		Rank rank = card.getRank();
		assertNotNull(rank);
		
	}
	
	@Test
	public void hasSuit(){
		Suit suit = card.getSuit();
		assertNotNull(suit);
	}
	
	@Test
	public void isFaceUp(){
		boolean faceUp = card.isFaceUp();
		assertFalse(faceUp);
	}
	

	
}
