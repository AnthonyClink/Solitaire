package com.stevesmith.solitaire.datatype;

import java.util.Collections;
import java.util.List;

import com.google.inject.Inject;

public class Deck {
	
	private List<Card> cards;
	private static final Card NO_CARD = new BlankCard();
	
	@Inject
	public Deck(List<Card> cards){
		this.cards = cards;
	}

	public Deck addCard(Card card) {
		cards.add(card);
		return this;		
	}
	
	public Deck shuffle(){
		Collections.shuffle(this.getCards());
		return this;
	}

	public List<Card> getCards(){
		return cards;
	}

	public Card drawCard() {
		Card card = removeTopCard();
		return card;
	}
	
	public int getSize(){
		return cards.size();
	}

	public void removeCard(Card card) {
		cards.remove(card);
		
	}

	public Card getTopCard() {
		try{
			Card card = cards.get(getSize() - 1);
			return card;
		}catch(ArrayIndexOutOfBoundsException e){
			return NO_CARD;
		}
	}
	
	private Card removeTopCard(){
		try{
			Card card = getTopCard();
			cards.remove(card);
			return card;
		}catch(ArrayIndexOutOfBoundsException e){
			return NO_CARD;
		}
	}
	
	public Card showTopCard(){
		Card card = cards.get(getSize() - 1);
		Card copyCard = copyCard(card);
		
		return copyCard;
	}
	
	public Card copyCard(Card card){
		Card cardCopy = new Card(card.getRank(), card.getSuit(), card.isFaceUp());
		return cardCopy;
	}
	
	@Override
	public String toString(){
		String retval = "";
		
		for(Card card : cards){
			if(card.isFaceUp()){
				retval += "{" + card.toString() + "}\n";
			}else{
				retval += "{DWN}\n";
			}
		}
		
		return retval;
	}

	public void removeCards(Deck fromCards) {
		cards.removeAll(fromCards.getCards());
		
	}
}
