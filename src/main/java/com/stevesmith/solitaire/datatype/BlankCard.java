package com.stevesmith.solitaire.datatype;

public class BlankCard extends Card{

	public BlankCard() {
		super(Rank.TWO, Suit.SPADE, true);
		
	}

	@Override
	public String getCssName(){
		return "cardBack";
	}
	
	@Override
	public String getImageUrl(){
		return "images/nocards.png";
	}
	
}
