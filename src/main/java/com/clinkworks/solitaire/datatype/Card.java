package com.clinkworks.solitaire.datatype;

import org.apache.commons.lang3.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Card {

	public static final Card ACE_OF_SPADES = new Card(Rank.ACE, Suit.SPADES, CardState.FACE_DOWN);
	public static final Card ACE_OF_HEARTS = new Card(Rank.ACE, Suit.HEARTS, CardState.FACE_DOWN);
	
	private final Rank rank;
	private final Suit suit;
	private int hashCode;
	private CardState cardState;
	
	public Card(@JsonProperty("rank") Rank rank, @JsonProperty("suit") Suit suit, @JsonProperty("cardState") CardState cardState){
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
	
	@JsonIgnore
	public boolean isBlack() {
		return getColor() == Color.BLACK;
	}
	
	@JsonIgnore
	public boolean isRed(){
		return !isBlack();
	}
	
	public boolean isOppositeColor(Card card){
		return this.getColor() != card.getColor();
	}
	
	public String getFullName(){
		return getRank().getFullName() + " Of " + getSuit().getFullName();
	}
	
	public String getShortName(){
		return getRank().getShortName() + "-" + getSuit().getShortName();
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

	@JsonIgnore
	public boolean isFaceDown() {
		return getCardState() == CardState.FACE_DOWN;			
	}
	
	public CardState getCardState() {
		return cardState;
	}
	
	@JsonIgnore
	public boolean isFaceUp(){
		return !isFaceDown();
	}
	
	@JsonIgnore
	public void turnFaceUp() {
		cardState = CardState.FACE_UP;
	}
	
	@Override
	public String toString(){
		return getRank().getShortName() + "-" + getSuit().getShortName();
	}

}
