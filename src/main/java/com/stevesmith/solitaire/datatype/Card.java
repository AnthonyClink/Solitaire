package com.stevesmith.solitaire.datatype;

public class Card {

	private static final Card FACE_DOWN_CARD = new Card(Rank.FACE, Suit.DOWN, true);
	private Rank rank;
	private Suit suit;
	private boolean faceUp;
	
	public Card(Rank rank, Suit suit, boolean faceUp){
		this.rank = rank;
		this.suit = suit;
		this.faceUp = faceUp;
	}
	
	public String getShortName() {
		if(isFaceDown()){
			return FACE_DOWN_CARD.getShortName();
		}
		return getRank().getShortName().toLowerCase() + "-" + getSuit().getShortName().toLowerCase();
	}
	
	public String getLongName(){
		if(isFaceDown()){
			return FACE_DOWN_CARD.getLongName();
		}
		return getRank().getFullName() + " of " + getSuit().getFullName();
	}

	public Rank getRank() {
		if(isFaceDown()){
			return FACE_DOWN_CARD.getRank();
		}
		return rank;
	
	}
	
	public Suit getSuit(){
		if(isFaceDown()){
			return FACE_DOWN_CARD.getSuit();
		}
		return suit;
	}

	public boolean isFaceUp() {
		return faceUp;		
	}

	private boolean isFaceDown() {
		return !isFaceUp();
	}

	
	public boolean isRed(){
		if(suit == Suit.HEART || suit == Suit.DIAMOND){
			return true;
		} else {
			return false;
		}
	}

	public void turnFaceUp() {
		faceUp = true;	
	}
	
	public void turnFaceDown(){
		faceUp = false;
	}
	
	@Override
	public String toString(){
		if(isFaceDown()){
			return FACE_DOWN_CARD.toString();
		}
		return rank.getShortName() + "-" + suit.getShortName();
	}

}
