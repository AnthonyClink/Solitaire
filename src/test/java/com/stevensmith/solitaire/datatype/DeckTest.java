package com.stevensmith.solitaire.datatype;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
	public void createDivsTest(){
		
		
		Rank[] ranks = Rank.orderedRanks();
		Suit[] suits = new Suit[]{Suit.CLUB, Suit.SPADE, Suit.DIAMOND, Suit.HEART};
		
		String css = ".%s{\n" + 
		    "\tbackground-position: %spx  %spx;\n" + 
		"}";
		
		String[] extraCards = new String[]{"cardBack", "redJoker", "blackJoker"};
		
		int yPos = 480;
		int xPos = 0;
		
		int rankIndex = 0;
		int suitIndex = 0;
		int extraCardIndex = 0;
		
		for(int y = 0; y < 5; y++){
			for(int i = 0; i < 11; i++){
				
				String cssElementName = null;
				
				if(rankIndex <= ranks.length && suitIndex <= suits.length - 1){
					
					if(rankIndex == ranks.length){
						rankIndex = 0;
						suitIndex++;
					}
					
					String suitName = suits[suitIndex].getFullName().toLowerCase();
					suitName = StringUtils.capitalize(suitName);
					
					cssElementName = ranks[rankIndex].getFullName().toLowerCase() + "Of" + suitName;

				}else{
					if(extraCardIndex < extraCards.length){
						cssElementName = extraCards[extraCardIndex];
						extraCardIndex++;
					}
				}
					
				
				System.out.println(String.format(css, cssElementName, xPos, yPos));
				
				xPos = xPos - 68;
								
				rankIndex++;
			}
			
			yPos = yPos - 96;
			xPos = 0;
		}
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
