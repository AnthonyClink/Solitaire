package com.stevesmith.solitaire.datatype;

import org.apache.commons.lang3.ObjectUtils;

public class Card {

	private final Rank rank;
	private final Suit suit;
	private int hashCode;
	private CardState cardState;
	
	public Card(Rank rank, Suit suit, CardState cardState){
			this.rank = rank;
			this.suit = suit;
			this.hashCode = 0;
			this.cardState = cardState;
	}
	
	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public Color getColor() {
		return getSuit().getColor();
	}

	public boolean isBlack() {
		return getColor() == Color.BLACK;
	}
	
	public boolean isRed(){
		return !isBlack();
	}
	
	public boolean isOppositeColor(Card card){
		return this.getColor() != card.getColor();
	}

	@Override
	public int hashCode(){
		if(hashCode == 0){
			hashCode = ObjectUtils.hashCodeMulti(this.getRank(), this.getSuit());
		}
		return hashCode;
	}
	
	@Override
	public boolean equals(Object obj){
		
		if(this == obj){
			return true;
		}
		
		if(!(obj instanceof Card)){
			return false;
		}
		
		Card card = (Card)obj;
		
		return this.getSuit() == card.getSuit() 
				&&
			this.getRank() == card.getRank();
	}

	public boolean isFaceDown() {
		return getCardState() == CardState.FACE_DOWN;			
	}
	
	public CardState getCardState() {
		return cardState;
	}

	public boolean isFaceUp(){
		return !isFaceDown();
	}
}
