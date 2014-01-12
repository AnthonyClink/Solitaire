package com.stevesmith.solitaire.datatype;

public class Card {

	private Rank rank;
	private Suit suit;
	private boolean faceUp;
	
	public Card(Rank rank, Suit suit, boolean faceUp){
		this.rank = rank;
		this.suit = suit;
		this.faceUp = faceUp;
	}
	
	public String getImageUrl(){
		if(isFaceUp()){
			return "images/" + getShortName() + ".png";
		}else{
			return "images/facedown.png";
		}
	}	
	
	public String getShortName() {
		
		return getRank().getShortName().toLowerCase() + "-" + getSuit().getShortName().toLowerCase();
	}

	public Rank getRank() {
		return rank;
	
	}
	
	public Suit getSuit(){
		return suit;
	}

	public boolean isFaceUp() {
		return faceUp;		
	}
	
	public boolean isRed(){
		if(suit == Suit.HEART || suit == suit.DIAMOND){
			return true;
		} else {return false;}
	}

	public void turnFaceUp() {
		faceUp = true;	
	}
	
	public void turnFaceDown(){
		faceUp = false;
	}
	
	@Override
	public String toString(){
		return rank.getShortName() + "-" + suit.getShortName();
	}

}
